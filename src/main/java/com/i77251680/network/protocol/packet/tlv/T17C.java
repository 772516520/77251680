package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T17C {
    public static Writer writeT17C(String code) throws IOException {
        return new Writer()
                .writeTlv(code);
    }
}
