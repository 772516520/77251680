package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T174 {
    public static Writer writeT174(byte[] t174) throws IOException {
        return new Writer()
                .writeBytes(t174);
    }
}