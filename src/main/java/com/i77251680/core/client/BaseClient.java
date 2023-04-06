package com.i77251680.core.client;

import com.i77251680.constants.Constants;
import com.i77251680.core.client.base.BaseClientImpl;
import com.i77251680.core.codec.jce.Jce;
import com.i77251680.core.codec.protobuf.Node;
import com.i77251680.core.codec.protobuf.Pb;
import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.config.Config;
import com.i77251680.entity.enums.LoginType;
import com.i77251680.entity.enums.Platform;
import com.i77251680.entity.enums.QrcodeRetCode;
import com.i77251680.event.EventListener;
import com.i77251680.event.events.QrcodeErrorEvent;
import com.i77251680.network.Network;
import com.i77251680.network.async.Task;
import com.i77251680.network.protocol.device.FullDevice;
import com.i77251680.network.protocol.packet.login.BuildLoginPacket;
import com.i77251680.network.protocol.packet.login.PasswordLogin;
import com.i77251680.network.protocol.packet.login.qrcode.BuildQrcodeLogin;
import com.i77251680.network.protocol.packet.login.qrcode.BuildQrcodePacket;
import com.i77251680.network.protocol.packet.login.qrcode.QrcodeResult;
import com.i77251680.network.protocol.packet.login.verify.slider.BuildSubmitSlider;
import com.i77251680.network.protocol.packet.login.verify.sms.BuildSendSmsCode;
import com.i77251680.network.protocol.packet.login.verify.sms.BuildSubmitSmsCode;
import com.i77251680.network.protocol.packet.pack.PackTlv;
import com.i77251680.network.protocol.packet.register.Register;
import com.i77251680.network.protocol.packet.tlv.*;
import com.i77251680.network.protocol.packet.uni.BuildUniPkt;
import com.i77251680.network.protocol.packet.unpack.login.DecodeLoginResponse;
import com.i77251680.network.protocol.packet.unpack.login.T119;
import com.i77251680.network.protocol.packet.unpack.tlv.ReadTlv;
import com.i77251680.utils.Time;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class BaseClient extends BaseClientImpl {
    protected long uin;
    protected Network network;
    public FullDevice fullDevice;
    public Platform platform;
    public Config config;
    private Timer timer;
    private boolean isOnline = false;
    private boolean Login_Lock = false;
    private Statistics statistics = Statistics.get();

    public BaseClient(long uin, Config config) {
        this.uin = uin;
        this.config = config;
        this.platform = config.platform;
        this.fullDevice = new FullDevice(uin);
        network = new Network(statistics);
        EventListener.on("connect", (Socket socket) -> {
            statistics.remote_ip = socket.getInetAddress().getHostAddress();
            statistics.remote_port = socket.getPort();
        });
        EventListener.on("lost", (__) -> {
            try {
                timer.cancel();
            } catch (Exception e) {
            }
            register(false);
        });
    }

    /**
     * 获取二维码
     */
    protected void fetchQrcode() {
        try {
            byte[] body = new Writer()
                    .writeShort(0)
                    .writeInt(16)
                    .writeLong(0)
                    .writeByte(8)
                    .writeTlv(Constants.BUF0)
                    .writeShort(6)
                    .writeBytes(PackTlv.pack(0x16, T16.writeT16(fullDevice)))
                    .writeBytes(PackTlv.pack(0x1B, T1B.writeT1B()))
                    .writeBytes(PackTlv.pack(0x1D, T1D.writeT1D()))
                    .writeBytes(PackTlv.pack(0x1F, T1F.writeT1F()))
                    .writeBytes(PackTlv.pack(0x33, T33.writeT33(fullDevice)))
                    .writeBytes(PackTlv.pack(0x35, T35.writeT35()))
                    .read();
            byte[] pkt = BuildQrcodePacket.build(
                    0x31,
                    0x11100,
                    body,
                    uin,
                    platform.subid,
                    fullDevice.imei);
            byte[] payload = network.sendPkt(pkt, 5).get();
            payload = new Tea().decrypt(Arrays.copyOfRange(payload, 16, payload.length - 1), Sig.shareKey);
            ByteBuf buf = wrappedBuffer(payload);
            buf.readBytes(54);
            int retcode = buf.readByte();
            int len = 2;
            byte[] bytes = new byte[len];
            buf.readBytes(bytes);
            len = wrappedBuffer(bytes).readShort();
            bytes = new byte[len];
            buf.readBytes(bytes);
            byte[] qrsig = bytes;
            buf.readBytes(2);
            Map<Integer, ByteBuf> t = ReadTlv.read(buf);
            if (retcode == 0 && t.containsKey(0x17)) {
                Sig.qrsig = qrsig;
                byte[] data = t.get(0x17).array();
                EventListener.broadcastEvent("internal.qrcode", data);
            } else {
                EventListener.broadcastEvent("internal.error.qrcode", QrcodeErrorEvent.set(retcode, "获取二维码失败, 请重试"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取扫码结果 (retcode为0调用qrcodeLogin登录)
     */
    protected void qrcodeLogin() {
        QrcodeResult qrcodeResult = queryQrcodeResult();
        if (qrcodeResult.retcode < 0) {
            System.out.println("server is busy"); // retcode不为0
        } else if (
                qrcodeResult.retcode == 0 &&
                        qrcodeResult.t106.length != 0 &&
                        qrcodeResult.t16a.length != 0 &&
                        qrcodeResult.t318.length != 0 &&
                        qrcodeResult.tgtgt.length != 0
        ) {
            Sig.qrsig = Constants.BUF0;
            if (qrcodeResult.uin != uin) {
                System.out.println("扫码账号" + qrcodeResult.uin + "与登录账号" + uin + "不一致");
                return;
            }
            Sig.tgtgt = qrcodeResult.tgtgt;
            byte[] body = BuildQrcodeLogin.build(
                    uin,
                    platform.appId,
                    platform.subid,
                    platform.bitmap,
                    platform.subSigMap,
                    platform.buildTime,
                    platform.apkId,
                    platform.ver,
                    platform.sdkVer,
                    fullDevice,
                    qrcodeResult.t106,
                    qrcodeResult.t16a,
                    qrcodeResult.t318,
                    Sig.tgtgt,
                    platform.sign,
                    platform.mainSigMap,
                    platform.ssoVersion
            );
            sendLogin("wtlogin.login", body);
        } else {
            String message;
            switch (qrcodeResult.retcode) {
                case QrcodeRetCode.Timeout:
                    message = "二维码超时, 请重新获取";
                    break;
                case QrcodeRetCode.WaitingForScan:
                    message = "二维码尚未扫描";
                    break;
                case QrcodeRetCode.WaitingForConfirm:
                    message = "二维码被取消, 请重新获取";
                    break;
                case QrcodeRetCode.Canceled:
                    message = "二维码超时，请重新获取";
                    break;
                default:
                    message = "扫码未知错误, 请重新获取";
            }
            Sig.qrsig = Constants.BUF0;
            EventListener.broadcastEvent("internal.error.qrcode", QrcodeErrorEvent.set(qrcodeResult.retcode, message));
        }
    }

    /**
     * 查询扫码结果 retcode为0调用qrcodeLogin登录
     */
    private QrcodeResult queryQrcodeResult() {
        int retcode = -1;
        byte[] t106 = Constants.BUF0, t16a = Constants.BUF0, t318 = Constants.BUF0, tgtgt = Constants.BUF0;
        if (Sig.qrsig.length == 0) {
            return new QrcodeResult(retcode, uin, t106, t16a, t318, tgtgt);
        }
        try {
            byte[] body = new Writer()
                    .writeShort(5)
                    .writeByte(1)
                    .writeInt(8)
                    .writeInt(16)
                    .writeTlv(Sig.qrsig)
                    .writeLong(0)
                    .writeByte(8)
                    .writeTlv(Constants.BUF0)
                    .writeShort(0)
                    .read();
            byte[] pkt = BuildQrcodePacket.build(0x12, 0x6200, body, uin, platform.subid, fullDevice.imei); // 查询扫码结果
            byte[] payload = sendPkt(pkt, 5).get();
            payload = new Tea().decrypt(Arrays.copyOfRange(payload, 16, payload.length - 1), Sig.shareKey);
            ByteBuf buf = wrappedBuffer(payload);
            buf.readBytes(48);
            int len = buf.readShort();
            if (len > 0) {
                len--;
                if (buf.readByte() == 2) {
                    buf.readBytes(8);
                    len -= 8;
                }
                if (len > 0)
                    buf.readBytes(len);
            }
            buf.readBytes(4);
            retcode = buf.readByte();
            if (retcode == 0) {
                buf.readBytes(4);
                uin = buf.readUnsignedInt();
                buf.readBytes(6);
                Map<Integer, ByteBuf> t = ReadTlv.read(buf);
                t106 = t.get(0x18).array();
                t16a = t.get(0x19).array();
                t318 = t.get(0x65).array();
                tgtgt = t.get(0x1e).array();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new QrcodeResult(retcode, uin, t106, t16a, t318, tgtgt);
    }

    /**
     * 密码登录
     *
     * @param md5pass 密码的md5
     */
    protected void passwordLogin(byte[] md5pass) {
        try {
            byte[] body = PasswordLogin.pack(
                    uin,
                    platform.appId,
                    LoginType.PASSWORD,
                    md5pass,
                    Sig.tgtgt,
                    platform.subid,
                    platform.bitmap,
                    platform.subSigMap,
                    platform.apkId,
                    fullDevice,
                    platform.ver,
                    platform.sign,
                    Sig.seq,
                    platform.buildTime,
                    platform.sdkVer,
                    platform.mainSigMap,
                    platform.ssoVersion
            );
            sendLogin("wtlogin.login", body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void passwordLogin(byte[] md5pass, boolean allowSlider) {
        try {
            byte[] body = PasswordLogin.pack(
                    uin,
                    platform.appId,
                    LoginType.PASSWORD,
                    md5pass,
                    Sig.tgtgt,
                    platform.subid,
                    platform.mainSigMap,
                    platform.ssoVersion,
                    platform.bitmap,
                    platform.subSigMap,
                    platform.apkId,
                    fullDevice,
                    platform.ver,
                    platform.sign,
                    Sig.seq,
                    platform.buildTime,
                    platform.sdkVer,
                    allowSlider
            );
            sendLogin("wtlogin.login", body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * token登录
     */
    protected void tokenLogin(byte[] token) {

    }

    /**
     * 发送短信验证码
     */
    protected void sendSMSCode() {
        try {
            byte[] pkt = BuildSendSmsCode.build(Sig.t104, platform.bitmap, platform.subSigMap, Sig.t174);
            sendLogin("wtlogin.login", pkt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交短信验证码
     *
     * @param code 6位验证码
     */
    protected void submitSmsCode(String code) {
        try {
            byte[] pkt = BuildSubmitSmsCode.build(Sig.t104, platform.bitmap, platform.subSigMap, Sig.t174, code, Sig.g);
            sendLogin("wtlogin.login", pkt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交滑动验证码
     */
    protected void submitSlider(String ticket) {
        try {
            byte[] body = BuildSubmitSlider.build(ticket, Sig.t104, platform.bitmap, platform.subSigMap);
            sendLogin("wtlogin.login", body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int next_seq() {
        if (++Sig.seq > 0x8000) {
            Sig.seq = 1;
        }
        return Sig.seq;
    }

    @Override
    public Task<?> sendPkt(byte[] pkt, int timeout) {
        return network.sendPkt(pkt, timeout);
    }

    public Task<?> sendUni(String cmd, byte[] body) {
        byte[] pkt = BuildUniPkt.build(cmd, body, uin);
        return sendPkt(pkt, 5);
    }

    public Task<?> sendUni(String cmd, byte[] body, int timeout) {
        byte[] pkt = BuildUniPkt.build(cmd, body, uin);
        return sendPkt(pkt, timeout);
    }

    public void writeUni(String cmd, byte[] body) {
        network.send(BuildUniPkt.build(cmd, body, uin));
    }

    public void writeUni(String cmd, byte[] body, int seq) {
        network.send(BuildUniPkt.build(cmd, body, uin, seq));
    }

    public void sendLogin(String cmd, byte[] body) {
        if (isOnline || Login_Lock)
            return;
        byte[] pkt = BuildLoginPacket.build(cmd, body, uin, platform.subid, fullDevice.imei);
        byte[] payload = sendPkt(pkt, 5).get();
        Login_Lock = true;
        T119 t119 = DecodeLoginResponse.decode(payload, fullDevice);
        if (t119 != null) {
            register(false);
            EventListener.broadcastEvent("internal.login", t119);
        }
        Login_Lock = false;
    }

    private void register(boolean logout) {
        byte[] pkt = Register.r(uin, logout, fullDevice, platform);
        byte[] payload = sendPkt(pkt, 10).get();
        if (logout) return;
        Map<Object, Object> rsp = Jce.decodeWrapper(payload);
        boolean result = (int) rsp.get(9) == 1;
        if (!result) {
            EventListener.broadcastEvent("internal.error.login", null);
            return;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    byte[] body = Pb.encode(
                            Node.builder()
                                    .put(1, 1152)
                                    .put(2, 9)
                                    .put(4, new Writer().writeInt(uin).writeByte(0).writeInt(0x19e39).read())
                                    .build()
                    );
                    syncTimeDiff();
                    sendUni("OidbSvc.0x480_9_IMCore", body);
                    System.out.println("[发送] 心跳");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, config.hb480_interval, config.hb480_interval);

    }

    public void syncTimeDiff() {
        byte[] pkt = BuildLoginPacket.build("Client.CorrectTime", Constants.BUF4, uin, platform.subid, fullDevice.imei, 0);
        try {
            sendPkt(pkt, 5)
                    .then((buf) -> {
                        ByteBuffer b = ByteBuffer.wrap((byte[]) buf);
                        Sig.timeDiff = b.getInt() - Time.timestamp();
                        return null;
                    }).catchException((e) -> {
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void logout() {
        register(true);
        terminate();
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void terminate() {
        network.terminate();
        isOnline = false;
    }

    public Statistics setStat() {
        return statistics;
    }
}
