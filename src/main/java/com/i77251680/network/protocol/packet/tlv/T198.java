package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T198 {
    public static Writer writeT198() throws IOException {
        return new Writer()
                .writeBytes(new byte[]{0, 1, 0});
    }
}
