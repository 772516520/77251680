package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.utils.Random;
import com.i77251680.utils.Time;

import java.io.IOException;

public class T1 {
    public static Writer writeT1(long uin) throws IOException {
        return new Writer()
                .writeShort(1)
                .writeBytes(Random.randomBytes())
                .writeInt(uin)
                .writeInt(Time.timestamp())
                .writeBytes(new byte[4])
                .writeShort(0);
    }
}
