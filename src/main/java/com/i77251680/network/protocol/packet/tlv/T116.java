package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T116 {
    public static Writer writeT116(int bitmap, int subSigMap) throws IOException {
        return new Writer()
                .writeByte(0)
                .writeInt(bitmap)
                .writeInt(subSigMap)
                .writeByte(1)
                .writeInt(1600000226);
    }
}
