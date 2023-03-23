package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T142 {
    public static Writer writeT142(String apkId) throws IOException {
        return new Writer()
                .writeShort(0)
                .writeTlv(apkId);
    }
}
