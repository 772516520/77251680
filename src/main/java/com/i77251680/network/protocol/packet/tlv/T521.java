package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T521 {
    public static Writer writeT521() throws IOException {
        return new Writer()
                .writeInt(0)
                .writeShort(0);
    }
}
