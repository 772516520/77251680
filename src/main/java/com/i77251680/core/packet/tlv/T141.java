package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T141 {
    public static Writer writeT141(String sim, String apn) throws IOException {
        return new Writer()
                .writeShort(1)
                .writeTlv(sim)
                .writeShort(2) // network Type 1:数据 2：wifi 0:any type
                .writeTlv(apn);
    }
}
