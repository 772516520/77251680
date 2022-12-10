package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T401 {
    public static Writer writeT401(byte[] g) throws IOException {
        return new Writer()
                .writeTlv(g);
    }
}
