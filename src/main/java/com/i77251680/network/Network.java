package com.i77251680.network;

import com.i77251680.constants.Constants;
import com.i77251680.core.client.Sig;
import com.i77251680.core.client.Statistics;
import com.i77251680.core.codec.jce.Jce;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.event.EventListener;
import com.i77251680.exceptions.PacketException;
import com.i77251680.network.async.AsyncTask;
import com.i77251680.network.async.Task;
import com.i77251680.network.protocol.packet.Packet;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.HexFormat;
import com.i77251680.utils.Time;
import com.i77251680.utils.Zlib;
import com.i77251680.utils.timer.TimerTask;
import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.*;

import static io.netty.buffer.Unpooled.wrappedBuffer;

@Slf4j
public class Network {
    private static byte[] buf;
    private static byte[] buf1 = new byte[0];
    private TimerTask timeoutTimer;
    public boolean auto_search = true;
    public boolean searching = false;
    private static String host = "msfwifi.3g.qq.com";
    private static int port = 8080;
    private long update_time;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Thread thread;
    private Statistics statistics;
    private final Map<String, Integer> host_port = new HashMap<>();
    private final Map<Integer, AsyncTask.Callback<Object>> handle = new HashMap<>();

    public Network(Statistics statistics) {
        buf = new byte[7168];
        this.statistics = statistics;
        connect();
        EventListener.broadcastEvent("connect", socket);
    }

    private void connect() {
        try {
            this.socket = new Socket(host, port);
            this.inputStream = socket.getInputStream();
            this.outputStream = socket.getOutputStream();
            System.err.println(socket.getInetAddress() + " connected");
            thread = new Thread(() -> {
                while (!socket.isClosed()) {
                    try {
                        int len = inputStream.read(buf);
                        byte[] bytes = Arrays.copyOfRange(buf, 0, len);
                        buf1 = buf1.length == 0 ? bytes : ArrayUtils.concat(buf1, bytes);
                        while (buf1.length > 4) {
                            int len1 = ByteBuffer.wrap(buf1).getInt() & Integer.MAX_VALUE;
                            if (buf1.length >= len1) {
                                byte[] pkt = Arrays.copyOfRange(buf1, 4, len1);
                                buf1 = new byte[0];
                                response(pkt);
                            } else break;
                        }
                    } catch (Exception e) {
                        try {
                            socket.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                host_port.remove(host);
                System.err.println(socket.getRemoteSocketAddress() + " closed");
                EventListener.broadcastEvent("lost", null);
            });
            thread.start();
            setServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void send(byte[] packet) {
        try {
            outputStream.write(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Task<?> sendPkt(byte[] pkt, int timeout) {
        int seq = Sig.seq;
        if (!socket.isClosed()) {
            return new AsyncTask<>((res, rej) -> {
                try {
                    outputStream.write(pkt);
                    handle.put(seq, (payload) -> {
                        handle.remove(seq);
                        timeoutTimer.cancel();
                        res.run(payload);
                    });
                    ++statistics.sent_pkt_cnt;
                    timeoutTimer = new TimerTask(() -> {
                        handle.remove(seq);
                        timeoutTimer.cancel();
                        ++statistics.lost_pkt_cnt;
                        rej.run("packet time out" + seq);
                    });
                    timeoutTimer.start(timeout * 1000L);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } else {
            try {
                socket.close();
                connect();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new AsyncTask<>((res, rej) -> {
                try {
                    outputStream.write(pkt);
                    handle.put(seq, (payload) -> {
                        handle.remove(seq);
                        res.run(payload);
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    protected void response(byte[] chunk) {
        UnpackPacket(chunk);
    }

    private Packet parsePacket(byte[] pkt) {
        ByteBuffer buf = ByteBuffer.wrap(pkt);
        final int headlen = buf.getInt();
        final int seq = buf.getInt();
        int retcode = buf.getInt();
        if (retcode != 0) {
            EventListener.broadcastEvent("internal.error.login", null);
            throw new PacketException("unsuccessful retcode" + retcode);
        }
        int offset = buf.getInt() + 12;
        buf.rewind();
        buf.get(new byte[offset]);
        int len = buf.getInt();
        String cmd = new String(Arrays.copyOfRange(pkt, offset + 4, offset + len));
        offset += len;
        buf.rewind();
        buf.get(new byte[offset]);
        len = buf.getInt();
        buf.rewind();
        offset += len;
        buf.get(new byte[offset]);
        final int flag = buf.getInt();
        byte[] payload;
        if (flag == 0) {
            payload = Arrays.copyOfRange(pkt, headlen + 4, pkt.length);
        } else if (flag == 1) {
            payload = Zlib.unzip(Arrays.copyOfRange(pkt, headlen + 4, pkt.length));
        } else if (flag == 8) {
            payload = Arrays.copyOfRange(pkt, headlen, pkt.length);
        } else throw new PacketException("unKnow flag" + flag);
        return new Packet(cmd, seq, payload);
    }

    private void UnpackPacket(byte[] pkt) {
        ++statistics.recv_pkt_cnt;
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
                decrypted = new Tea().decrypt(encrypted, Sig.d2Key);
                break;
            case 2:
                decrypted = new Tea().decrypt(encrypted, Constants.BUF16);
                break;
            default:
                EventListener.broadcastEvent("internal.error.login", null);
                throw new PacketException("unKnow flag" + flag);
        }
        Packet packet = parsePacket(decrypted);
        System.out.println("[recv] " + packet.cmd);
        if (handle.containsKey(packet.seq))
            handle.get(packet.seq).run(packet.payload);
        else
            EventListener.broadcastPacket(packet);
    }

    public void terminate() {
        try {
            socket.close();
            timeoutTimer.cancel();
            inputStream.close();
            outputStream.close();
            System.exit(10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void setServer() {
        if (!auto_search) return;
        Set<String> ipList = host_port.keySet();
        if (ipList.size() > 0) {
            host = ipList.iterator().next();
            port = host_port.get(host);
        }
        if (Time.timestamp() - update_time > 3600 && !searching) {
            searching = true;
            Map<String, Integer> serverList = fetchServerList();
            Set<String> ip_list = serverList.keySet();
            update_time = Time.timestamp();
            host_port.clear();
            Iterator<String> it = ip_list.iterator();
            String ip = it.next();
            host_port.put(ip, serverList.get(ip));
            it.next();
            host_port.put(ip, serverList.get(ip));
            searching = false;
        }
    }

    public Map<String, Integer> fetchServerList() {
        byte[] key = HexFormat.of().parseHex("F0441F5FF42DA58FDCF7949ABA62D411");
        List<Object> list = new ArrayList<>();
        list.add(null);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add("00000");
        list.add(100);
        list.add(537064989);
        list.add("356235088634151");
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(1);
        byte[] HttpServerListReq = Jce.encodeStruct(list);
        byte[] body = Jce.encodeWrapper(HttpServerListReq, "HttpServerListReq", "ConfigHttp", "HttpServerListReq");
        ByteBuffer len = ByteBuffer.wrap(new byte[4]);
        len.putInt(body.length + 4);
        body = ArrayUtils.concat(len.array(), body);
        body = new Tea().encrypt(body, key);
        try {
            URL url = new URL("https://configsvr.msf.3g.qq.com/configsvr/serverlist.jsp?mType=getssolist");
            URLConnection connection = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) connection;
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            OutputStream out = http.getOutputStream();
            out.write(body);
            int code = http.getResponseCode();
            InputStream in = http.getInputStream();
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            int i;
            while ((i = in.read()) != -1) {
                b.write(i);
            }
            byte[] decoded = new Tea().decrypt(b.toByteArray(), key);
            byte[] data = Arrays.copyOfRange(decoded, 4, decoded.length);
            Map nested = Jce.decodeWrapper(data);
            Map<String, Integer> ret = new HashMap<>();
            for (Map map : (List<Map>) nested.get(2)) {
                ret.put((String) map.get(1), (int) map.get(2));
            }
            return ret;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
