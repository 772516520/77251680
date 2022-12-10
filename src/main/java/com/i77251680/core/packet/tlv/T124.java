package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T124 {
    public static Writer writeT124(String os_type, String release, String sim, String apn) throws IOException {
        return new Writer()
                .writeTlv(os_type)
                .writeTlv(release)
                .writeShort(2)
                .writeTlv(sim)
                .writeShort(0) // allays byte[0]
                .writeTlv(apn);
    }
}
