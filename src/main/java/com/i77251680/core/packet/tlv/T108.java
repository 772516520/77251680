package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T108 {
    public static Writer writeT108(String imei) throws IOException {
        return new Writer()
                .writeBytes(imei);
    }
}
