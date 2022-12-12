package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T104 {
    public static Writer writeT104(byte[] t104) throws IOException {
        return new Writer()
                .writeBytes(t104);
    }
}
