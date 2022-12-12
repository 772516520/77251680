package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T1B {
    public static Writer writeT1B() throws IOException {
        return new Writer()
                .writeInt(0)
                .writeInt(0)
                .writeInt(3)
                .writeInt(4)
                .writeInt(72)
                .writeInt(2)
                .writeInt(2)
                .writeShort(0);
    }
}
