package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T18 {
    public static Writer writeT18(long uin, int appid) throws IOException {
        return new Writer()
                .writeShort(1)
                .writeInt(1536)
                .writeInt(appid)
                .writeInt(0)
                .writeInt(uin)
                .writeShort(0)
                .writeShort(0);
    }
}
