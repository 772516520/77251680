package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T147 {
    public static Writer writeT147(int appId, String ver, byte[] sign) throws IOException {
        return new Writer()
                .writeInt(appId)
                .writeTlv(ver.substring(0, 5))
                .writeTlv(sign);
    }
}
