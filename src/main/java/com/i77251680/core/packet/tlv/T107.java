package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T107 {
    public static Writer writeT107() throws IOException {
        return new Writer()
                .writeShort(0)
                .writeByte(0)
                .writeShort(0)
                .writeByte(1);
    }
}
