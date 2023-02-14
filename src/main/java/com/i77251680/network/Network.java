package com.i77251680.network;

import com.i77251680.constants.Constants;
import com.i77251680.core.client.Sig;
import com.i77251680.core.codec.protobuf.Heartbeat;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.entity.enums.Platform;
import com.i77251680.entity.packet.sso.SSO;
import com.i77251680.event.GlobalEventListener;
import com.i77251680.exceptions.PacketException;
import com.i77251680.exceptions.SSOException;
import com.i77251680.network.protocol.packet.register.Register;
import com.i77251680.network.protocol.packet.uni.BuildUniPkt;
import com.i77251680.network.protocol.packet.unpack.login.DecodeLoginResponse;
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
    private final Platform platform;
    private Timer timer;
    private static final String default_host = "msfwifi.3g.qq.com";
    private static final int default_port = 8080;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean isOnline = false;
    private final int hb480_interval;
    private final Map<Integer, Handlers> Handle = new HashMap<>();

    public Network(long uin, FullDevice fullDevice, Platform platform, int hb480_interval) throws IOException {
        buf = new byte[7168];
        this.socket = new Socket(default_host, default_port);
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
        this.uin = uin;
        this.fullDevice = fullDevice;
        this.platform = platform;
        this.hb480_interval = hb480_interval;
        this.timer = new Timer();
    }

    public void sendPkt(byte[] pkt) {
        try {
            if (!socket.isClosed())
                outputStream.write(pkt);
            else {
                log.warn("closed");
                log.warn("尝试重连");
                timer.cancel();
                timer = new Timer();
                socket = new Socket(default_host, default_port);
                this.inputStream = socket.getInputStream();
                this.outputStream = socket.getOutputStream();
                log.info("connected");
                outputStream.write(pkt);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            int type = DecodeLoginResponse.decode(payload, fullDevice);
            if (type == 0)
                register();
            else
                System.out.println(type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void register() {
        byte[] pkt = Register.r(uin, fullDevice, platform);
        sendPkt(pkt);
        GlobalEventListener.getGlobalPublisher().broadcast("system.online", "online");
        isOnline = true;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                new Thread(() -> {
                try {
                    byte[] body = new Heartbeat(uin).pack();
                    byte[] heartbeat = BuildUniPkt.build("OidbSvc.0x480_9_IMCore", body, uin);
//                    byte[] heartbeat = Heartbeat.build(uin, subid, fullDevice.imei);
                    sendUni(heartbeat);
                    System.out.println("[发送] 心跳");
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                }).start();
            }
        }, hb480_interval, hb480_interval);

//        new Thread(() -> {
        while (!socket.isClosed()) {
            try {
                int len = inputStream.read(buf);
                byte[] buf_ = Arrays.copyOf(buf, len);
                long len_ = wrappedBuffer(buf_).readUnsignedInt();
                if (len >= len_)
                    response(buf_);
                System.out.println(len_);
                Arrays.fill(buf, (byte) 0);
            } catch (Exception e) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                register();
                isOnline = false;
                e.printStackTrace();
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

    public Socket getSocket() {
        return this.socket;
    }
}
