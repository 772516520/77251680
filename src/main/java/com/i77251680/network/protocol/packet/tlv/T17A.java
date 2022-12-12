package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T17A {
    public static Writer writeT17A() throws IOException {
        return new Writer()
                .writeInt(9);
    }
}
