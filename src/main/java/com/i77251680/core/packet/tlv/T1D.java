package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T1D {
    public static Writer writeT1D() throws IOException {
        return new Writer()
                .writeByte(1)
                .writeInt(184024956)
                .writeInt(0)
                .writeByte(0)
                .writeInt(0);
    }
}
