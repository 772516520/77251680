package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T8 {
    public static Writer writeT8() throws IOException {
        return new Writer()
                .writeShort(0)
                .writeInt(2502)
                .writeShort(0);
    }
}
