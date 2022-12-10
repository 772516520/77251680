package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.utils.Utils;

import java.io.IOException;

public class T1 {
    public static Writer writeT1(long uin) throws IOException {
        return new Writer()
                .writeShort(1)
                .writeBytes(Utils.randomBytes())
                .writeInt(uin)
                .writeInt(Utils.DATE)
                .writeBytes(new byte[4])
                .writeShort(0);
    }
}
