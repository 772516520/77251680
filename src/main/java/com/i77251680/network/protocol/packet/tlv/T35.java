package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T35 {
    public static Writer writeT35() throws IOException {
        return new Writer()
                .writeInt(8);
    }
}
