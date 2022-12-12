package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T100 {
    public static Writer writeT100(int appid, int subid, int sigmap, int mainSigMap, int ssoVersion) throws IOException {
        return new Writer()
                .writeShort(1)
                .writeInt(ssoVersion)
                .writeInt(appid)
                .writeInt(subid)
                .writeInt(0)
                .writeInt(mainSigMap);
    }
}
