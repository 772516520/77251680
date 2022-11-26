package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T177 {
    public static Writer writeT177(int buildtime, String sdkver) throws IOException {
        return new Writer()
                .writeByte(1)
                .writeInt(buildtime)
                .writeTlv(sdkver);
    }
}
