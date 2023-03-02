package com.i77251680.network.protocol.packet.pack;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class PackTlv {
    public static byte[] pack(int tag, Writer buf) throws IOException {
        byte[] bytes = buf.read();
        return new Writer()
                .writeShort(tag)
                .writeTlv(bytes)
                .read();
    }

    public static byte[] pack(int tag, byte[] buf) throws IOException {
        return new Writer()
                .writeShort(tag)
                .writeTlv(buf)
                .read();
    }
}
