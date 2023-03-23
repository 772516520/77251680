package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T143 {
    public static byte[] write(byte[] d2) throws IOException {
        return new Writer().writeBytes(d2).read();
    }
}
