package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T10A {
    public static byte[] write(byte[] tgtgt) throws IOException {
        return new Writer().writeBytes(tgtgt).read();
    }
}
