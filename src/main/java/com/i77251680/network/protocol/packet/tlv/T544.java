package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.utils.HexFormat;
import com.i77251680.utils.Random;

import java.io.IOException;

public class T544 {
    public static Writer writeT544() throws IOException {
        Writer stream = new Writer();
        byte[] body = stream
                .writeShort(1)
                .writeShort(8)
                .writeLong(System.currentTimeMillis())
                .writeShort(2)
                .writeTlv(Random.randomBytes(0x0a))
                .writeShort(3)
                .writeTlv(new byte[]{1, 0, 0, 1})
                .writeShort(5)
                .writeTlv(new byte[]{1, 0, 0, 1})
                .writeShort(4)
                .writeTlv(new byte[4])
                .writeShort(6)
                .writeTlv(new byte[]{0, 0, 0, 1})
                .writeShort(7)
                .writeTlv(new byte[]{1, 0, 0, 5})
                .writeShort(8)
                .writeTlv(new byte[]{1, 0, 0, 6})
                .writeShort(0x0c)
                .writeTlv(new byte[]{1, 0, 0, 1})
                .writeShort(0x0d)
                .writeTlv(new byte[]{0, 0, 0, 1})
                .read();


        return new Writer()
                .writeBytes(HexFormat.of().parseHex("68656861000000010100000000000000"))
                .writeByte(1)
                .writeByte(1)
                .writeByte(0)
                .writeByte(5)
                .writeByte(2)
                .writeByte(0)
                .writeByte(0)
                .writeByte(0)
                .writeByte(0)
                .writeBytes(Random.randomBytes())
                .writeInt(2)
                .writeShort(0)
                .writeTlv(body);
    }
}
