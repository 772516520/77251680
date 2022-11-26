package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T16E {
    public static Writer writeT16E(String model) throws IOException {
        return new Writer()
                .writeBytes(model);
    }
}
