package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T116 {
    public static Writer writeT116(int bitmap) throws IOException {
        return new Writer()
                .writeByte(0)
                .writeInt(bitmap)
                .writeInt(0x10400)
                .writeByte(1)
                .writeInt(1600000226);
    }
}
