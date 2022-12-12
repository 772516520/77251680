package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T145 {
    public static Writer writeT145(byte[] guid) throws IOException {
        return new Writer()
                .writeBytes(guid);
    }
}
