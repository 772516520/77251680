package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T193 {
    public static Writer writeT193(Object ticket) throws IOException {
        return new Writer()
                .writeBytes(ticket);
    }
}
