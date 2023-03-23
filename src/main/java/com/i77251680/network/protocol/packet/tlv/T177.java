package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T177 {
    public static Writer writeT177(int buildTime, String sdkVer) throws IOException {
        return new Writer()
                .writeByte(1)
                .writeInt(buildTime)
                .writeTlv(sdkVer);
    }
}
