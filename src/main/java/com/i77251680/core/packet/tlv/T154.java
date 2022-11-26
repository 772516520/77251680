package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T154 {
    public static Writer writeT154(int seq) throws IOException {
        return new Writer()
                .writeInt(seq);
    }
}
