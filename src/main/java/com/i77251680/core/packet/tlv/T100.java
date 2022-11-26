package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T100 {
    public static Writer writeT100(int appid, int subid, int sigmap) throws IOException {
        return new Writer()
                .writeShort(1)
                .writeInt(7)
                .writeInt(appid)
                .writeInt(subid)
                .writeInt(0)
                .writeInt(sigmap);
    }
}
