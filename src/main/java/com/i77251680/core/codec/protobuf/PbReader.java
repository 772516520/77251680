package com.i77251680.core.codec.protobuf;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class PbReader {
    private static final ByteArrayOutputStream b = new ByteArrayOutputStream();

    public static long readVarint(ByteBuffer buf) {
        b.reset();
        byte i;
        do {
            i = buf.get();
            b.write(i);
        } while ((i & 0x80) == 0x80);
        return PbConverter.convertVarint(b.toByteArray());
    }

    public static byte[] readBytes(ByteBuffer buf) {
        b.reset();
        int len = buf.get() & 0x7f;
        byte[] r = new byte[len];
        buf.get(r);
        return r;
    }
}
