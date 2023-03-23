package com.i77251680.network.protocol.packet.login.qrcode;

import com.i77251680.core.client.Sig;
import com.i77251680.core.writer.Writer;
import com.i77251680.network.protocol.packet.login.BuildLoginPacket;
import com.i77251680.utils.Time;

import java.io.IOException;

public class BuildQrcodePacket {
    public static byte[] build(
            int cmdid,
            int head,
            byte[] body,
            long uin,
            int subid,
            String imei
    ) throws IOException {
        return pack(cmdid, head, body, uin, subid, imei);
    }

    private static byte[] pack(
            int cmdid,
            int head,
            byte[] body,
            long uin,
            int subid,
            String imei
    ) throws IOException {
        byte[] pkt = new Writer()
                .writeInt(head)
                .writeInt(0x1000)
                .writeShort(0)
                .writeInt(0x72000000)
                .writeInt(Time.timestamp())
                .writeByte(2)
                .writeShort(44 + body.length)
                .writeShort(cmdid)
                .writeBytes(new byte[21])
                .writeByte(3)
                .writeShort(0)
                .writeShort(50)
                .writeInt(Sig.seq + 1)
                .writeLong(0)
                .writeBytes(body)
                .writeByte(3)
                .read();
        return BuildLoginPacket.build("wtlogin.trans_emp", pkt, uin, subid, imei);
    }
}
