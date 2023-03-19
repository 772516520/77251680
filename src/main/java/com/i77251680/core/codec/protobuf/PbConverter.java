package com.i77251680.core.codec.protobuf;

public class PbConverter {
    public static byte[] toVarint(long val) {
        byte[] b = new byte[calcLength(val)];
        for (int i = 0; i < b.length - 1; i++) {
            b[i] = (byte) (val & 0x7f | 0x80);
            val >>>= 7;
        }
        b[b.length - 1] = (byte) (val & 0x7f);
        return b;
    }

    public static long convertVarint(byte[] encoded) {
        long r = 0;
        int i = encoded.length - 1;
        while (i >= 0) {
            r <<= 7;
            r |= encoded[i] & 0x7f;
            --i;
        }
        return r;
    }

    private static int calcLength(long v) {
        if (v == 0) return 1;
        int len = 0;
        while (v != 0) {
            v = v >>> 7;
            ++len;
        }
        return len;
    }
}
