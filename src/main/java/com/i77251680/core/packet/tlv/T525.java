package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T525 {
    public static Writer writeT525() throws IOException {
        return new Writer()
                .writeShort(1)
                .writeShort(0x536)
                .writeTlv(new byte[]{0x1, 0x0});
    }
}
