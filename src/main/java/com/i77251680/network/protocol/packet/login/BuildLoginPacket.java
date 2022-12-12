package com.i77251680.network.protocol.packet.login;

import com.i77251680.constants.Constants;
import com.i77251680.core.client.BaseClient;
import com.i77251680.core.client.Sig;
import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.enums.Platforms;

import java.io.IOException;

public class BuildLoginPacket {
    public static byte[] build(String cmd, byte[] body, long uin, int subid, String imei) {
        try {
            return pack(cmd, body, uin, subid, imei, 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] build(String cmd, byte[] body, long uin, int subid, String imei, int type) {
        try {
            return pack(cmd, body, uin, subid, imei, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static byte[] pack(String cmd, byte[] body, long uin, int subid, String imei, int type) throws IOException {
        BaseClient.next_seq();
        int cmdid = 0x810;
        if (cmd.equals("wtlogin.trans_emp")) {
            uin = 0;
            cmdid = 0x812;
            subid = Platforms.watch.subid;
        }
        if (type == 2) {
            body = new Writer()
                    .writeByte(0x02)
                    .writeByte(0x01)
                    .writeBytes(Sig.randkey)
                    .writeShort(0x131)
                    .writeShort(1)
                    .writeTlv(Sig.publicKey)
                    .writeBytes(new Tea().encrypt(body, Sig.shareKey))
                    .read();
            body = new Writer()
                    .writeByte(0x02)
                    .writeShort(29 + body.length)
                    .writeShort(8001)
                    .writeShort(cmdid)
                    .writeShort(1)
                    .writeInt(uin)
                    .writeByte(3)
                    .writeByte(0x87)
                    .writeByte(0)
                    .writeInt(2)
                    .writeInt(0)
                    .writeInt(0)
                    .writeBytes(body)
                    .writeByte(0x03)
                    .read();
        }
        byte[] sso = new Writer()
                .writeWithLength(
                        new Writer()
                                .writeInt(Sig.seq)
                                .writeInt(subid)
                                .writeInt(subid)
                                .writeBytes(Constants.LoginBUF)
                                .writeWithLength(Sig.tgt)
                                .writeWithLength(cmd)
                                .writeWithLength(Sig.session)
                                .writeWithLength(imei)
                                .writeInt(4)
                                .writeShort(2)
                                .writeInt(4)
                                .read()
                )
                .writeWithLength(body)
                .read();
        if (type == 1) {
            sso = new Tea().encrypt(sso, Sig.d2key);
        } else if (type == 0) {
        } else {
            sso = new Tea().encrypt(sso, Constants.BUF16);
        }
        return new Writer()
                .writeWithLength(
                        new Writer()
                                .writeInt(0x0A)
                                .writeByte(type)
                                .writeWithLength(Sig.d2)
                                .writeByte(0)
                                .writeWithLength(String.valueOf(uin))
                                .writeBytes(sso)
                                .read()
                )
                .read();
    }
}
