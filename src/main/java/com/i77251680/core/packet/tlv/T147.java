package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T147 {
    public static Writer writeT147(int appid, String ver, byte[] sign) throws IOException {
        return new Writer()
                .writeInt(appid)
                .writeTlv(ver.substring(0, 5))
                .writeTlv(sign);
    }
}
