package com.i77251680.network;

import com.i77251680.Exceptions.PacketException;
import com.i77251680.Exceptions.SSOException;
import com.i77251680.constants.Constants;
import com.i77251680.core.client.BaseClient;
import com.i77251680.core.client.Sig;
import com.i77251680.core.codec.protobuf.Heartbeat;
import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.entity.packet.sso.SSO;
import com.i77251680.event.GlobalEventListener;
import com.i77251680.network.protocol.packet.Register.BuildRegister;
import com.i77251680.network.protocol.packet.login.BuildLoginPacket;
import com.i77251680.network.protocol.packet.uni.BuildUniPkt;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.Utils;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

import static io.netty.buffer.Unpooled.wrappedBuffer;

@Slf4j
public class Network {
    private static byte[] buf;
    private boolean Login_Lock = false;
    private final long uin;
    private final FullDevice fullDevice;
    private final int subid;
    private final Timer timer;
    private static final String default_host = "msfwifi.3g.qq.com";
    private static final int default_port = 8080;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean isConnected = false;
    private final int hb480_interval;
    private final Map<Integer, Handlers> Handle = new HashMap<>();

    public Network(long uin, FullDevice fullDevice, int subid, int hb480_interval) throws IOException {
        buf = new byte[7168];
        this.socket = new Socket(default_host, default_port);
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
        this.uin = uin;
        this.fullDevice = fullDevice;
        this.subid = subid;
        this.hb480_interval = hb480_interval;
        this.timer = new Timer();
        isConnected = true;
    }

    public void sendPkt(byte[] pkt) {
        try {
            if (isConnected)
                outputStream.write(pkt);
            else {
                log.warn("出玄学问题重连");
//                register();
                isConnected = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendUni(byte[] pkt) {
        sendPkt(pkt);
    }

    public byte[] sendQrcodePkt(byte[] pkt) {
        try {
            sendPkt(pkt);
            inputStream.read(buf);
            return response(buf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendLoginPacket(byte[] pkt) {
        if (Login_Lock)
            return;
        Login_Lock = true;
        try {
            sendPkt(pkt);
            inputStream.read(buf);
            byte[] payload = response(buf);
            decodeLoginResponse(payload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void register() {
        BaseClient.next_seq();
        byte[] body = BuildRegister.build(uin, fullDevice);
        byte[] pkt = BuildLoginPacket.build("StatSvc.register", body, uin, subid, fullDevice.imei, 1);
        sendPkt(pkt);
        GlobalEventListener.getGlobalPublisher().broadcast("system.online", "online");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                new Thread(() -> { // 多线程定时任务
                try {
                    byte[] body = new Heartbeat(uin).pack();
                    byte[] heartbeat = BuildUniPkt.build("OidbSvc.0x480_9_IMCore", body, uin);
//                    byte[] heartbeat = Heartbeat.build(uin, subid, fullDevice.imei);
                    sendUni(heartbeat);
                    System.out.println("[发送] 心跳");
                } catch (Exception e) {
                    e.printStackTrace();
                    timer.cancel();
                }
//                }).start();
            }
        }, hb480_interval, hb480_interval);

//        new Thread(() -> {
        while (isConnected) {
            try {
                int len = inputStream.read(buf);
                byte[] buf_ = Arrays.copyOf(buf, len);
                long len_ = wrappedBuffer(buf_).readUnsignedInt();
                if (len >= len_)
                    response(buf_);
                System.out.println(len_);
                Arrays.fill(buf, (byte) 0);
            } catch (Exception e) {
                log.warn(String.valueOf(isConnected));
                e.printStackTrace();
                isConnected = false;
                log.warn(String.valueOf(isConnected));
                register();
            }
        }
//        }).start();
    }

    protected byte[] response(byte[] chunk) {
        ByteBuf byteBuf = wrappedBuffer(chunk);
        int len = byteBuf.readInt();
        byte[] pkt = Arrays.copyOfRange(chunk, 4, len);
        return UnpackPacket(pkt);
    }

    private SSO parseSSO(byte[] pkt) {
        ByteBuf buf = wrappedBuffer(pkt);
        final int headlen = buf.readInt();
        final int seq = buf.readInt();
        int retcode = buf.readInt();
        if (retcode != 0) {
            throw new SSOException("unsuccessful retcode" + retcode);
        }
        int offset = buf.readInt() + 12;
        buf.resetReaderIndex();
        buf.readBytes(offset);
        int len = buf.readInt();
        String cmd = new String(Arrays.copyOfRange(pkt, offset + 4, offset + len));
        offset += len;
        buf.resetReaderIndex();
        buf.readBytes(offset);
        len = buf.readInt();
        buf.resetReaderIndex();
        buf.readBytes(offset + len);
        final int flag = buf.readInt();
        byte[] payload;
        if (flag == 0) {
            payload = Arrays.copyOfRange(pkt, headlen + 4, pkt.length);
        } else if (flag == 1) {
            payload = Constants.BUF8;
        } else if (flag == 8) {
            payload = Arrays.copyOfRange(pkt, headlen, pkt.length);
        } else throw new SSOException("unKnow flag" + flag);
        return new SSO(cmd, seq, payload);
    }

    private byte[] UnpackPacket(byte[] pkt) {
        Login_Lock = false;
        ByteBuf buf = wrappedBuffer(pkt);
        buf.readInt();
        int flag = buf.readByte();
        buf.readByte();
        int start = buf.readInt() + 6;
        byte[] encrypted = Arrays.copyOfRange(pkt, start, pkt.length);
        byte[] decrypted;
        switch (flag) {
            case 0:
                decrypted = encrypted;
                break;
            case 1:
                decrypted = new Tea().decrypt(encrypted, Sig.d2key);
                break;
            case 2:
                decrypted = new Tea().decrypt(encrypted, Constants.BUF16);
                break;
            default:
                throw new PacketException("unKnow flag" + flag);
        }
        SSO sso = parseSSO(decrypted);
        System.out.println("[recv] " + sso.cmd);
        if (Handle.containsKey(Sig.seq)) {
            Handle.get(Sig.seq).handle(sso.payload);
        }
        return sso.payload;
    }

    public Map<Integer, ByteBuf> readTlv(ByteBuf r) {
        Map<Integer, ByteBuf> t = new HashMap<>();
        while (r.readableBytes() > 2) {
            int tag = r.readShort();
            int len = r.readShort();
            byte[] buf = new byte[len];
            r.readBytes(buf);
            t.put(tag, wrappedBuffer(buf));
        }
        return t;
    }

    private void decodeT119(ByteBuf t119) {
        ByteBuf r = wrappedBuffer(new Tea().decrypt(t119.array(), Sig.tgtgt));
        r.readShort();
        Map<Integer, ByteBuf> t = readTlv(r);
        Sig.tgt = t.get(0x10a).array();
        Sig.skey = t.get(0x120).array();
        Sig.d2 = t.get(0x143).array();
        Sig.d2key = t.get(0x305).array();
        Sig.tgtgt = Md5Crypto.encrypt(Sig.d2key);
        byte[] token = ArrayUtils.concat(Sig.d2key, Sig.d2, Sig.tgt);
        ByteBuf t11a = t.get(0x11a);
        byte[] t11a_ = t11a.array();
        t11a.readShort();
        int age = t11a.readByte();
        int gender = t11a.readByte();
        String nickname = new String(Arrays.copyOfRange(t11a_, 5, t11a_.length));
        System.out.println(nickname);
    }

    private void decodeLoginResponse(byte[] payload) {
        payload = new Tea().decrypt(Arrays.copyOfRange(payload, 16, payload.length - 1), Sig.shareKey);
        ByteBuf buf = wrappedBuffer(payload);
        buf.readShort();
        int type = buf.readByte() & 0xff;
        System.out.println("type - " + type);
        buf.readShort();
        Map<Integer, ByteBuf> t = readTlv(buf);
        if (type == 0) {
            Sig.t104 = Constants.BUF0;
            Sig.t174 = Constants.BUF0;
            decodeT119(t.get(0x119));
            register();
        }
        if (type == 15 || type == 16) {
            GlobalEventListener.getGlobalPublisher().broadcast("internal.error.token", "token失效");
        }
        if (type == 2) {
            Sig.t104 = t.get(0x104).array();
            if (t.containsKey(0x192)) {
                System.out.println("滑块验证");
                GlobalEventListener.getGlobalPublisher().broadcast("system.verify.slider", new String(t.get(0x192).array()));
            }
            GlobalEventListener.getGlobalPublisher().broadcast("internal.login.error", "[type " + type + "]" + "登录失败, 未知格式的验证码");

        }
        if (type == 160) {
            if (!t.containsKey(0x204) && !t.containsKey(0x174)) {
                System.out.println("已发送验证码");
                return;
            }
            if (t.containsKey(0x402)) {
                byte[] dpwd = Utils.randomBytes(16);
                Sig.t402 = t.get(0x402).array();
                Sig.G = Md5Crypto.encrypt(ArrayUtils.concat(fullDevice.guid, dpwd, Sig.t402));
            }
            if (t.containsKey(0x403))
                Sig.t403 = t.get(0x403).array();
            String phone;
            if (t.containsKey(0x174) && t.containsKey(0x178)) {
                Sig.t104 = t.get(0x104).array();
                Sig.t174 = t.get(0x174).array();
                phone = new String(t.get(0x178).array());
                System.out.println(phone);
            }
            GlobalEventListener.getGlobalPublisher().broadcast("system.verify", t.containsKey(0x204) ? new String(t.get(0x204).array()) : "");
        }
        if (t.containsKey(0x149)) {
            ByteBuf stream = t.get(0x149);
            stream.readShort();

        }
        if (t.containsKey(0x146)) {
            ByteBuf r = t.get(0x146);
            int version = r.readInt();
            int length;
            byte[] bytes = new byte[2];
            byte[] b;
            r.readBytes(bytes);
            length = wrappedBuffer(bytes).readShort();
            b = new byte[length];
            // 奇怪的登录失败原因
            System.out.println("[type: " + type + "]" + new String(r.readBytes(b).array()));
        }
    }

    public Socket getSocket() {
        return this.socket;
    }

    public boolean isConnected() {
        return isConnected;
    }
}
