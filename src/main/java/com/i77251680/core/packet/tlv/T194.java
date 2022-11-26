package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T194 {
    public static Writer writeT194(byte[] imsi) throws IOException {
        return new Writer()
                .writeBytes(imsi);
    }
}
