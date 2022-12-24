package com.i77251680.network.protocol.packet.unpack.tlv;

import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class ReadTlv {
    public static Map<Integer, ByteBuf> read(ByteBuf r) {
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
}
