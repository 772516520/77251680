package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T191 {
    public static Writer writeT191() throws IOException {
        return new Writer()
                .writeByte(0x82);
    }
}
