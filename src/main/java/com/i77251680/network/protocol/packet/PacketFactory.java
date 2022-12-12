package com.i77251680.network.protocol.packet;

import com.i77251680.constants.Constants;
import com.i77251680.core.client.Sig;
import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.tea.Tea;

import java.io.IOException;

public class PacketFactory {
    public static byte[] buildEncryptBody(int type, byte[] body) throws IOException {
        if (type == 2) {
            return new Writer()
                    .writeByte(0x02)
                    .writeByte(0x01)
                    .writeBytes(Sig.randkey)
                    .writeShort(0x131)
                    .writeShort(1)
                    .writeTlv(Sig.publicKey)
                    .writeBytes(new Tea().encrypt(body, Sig.shareKey))
                    .read();
        } else if (type == 1) {
            return new Tea().encrypt(body, Sig.d2key);
        } else {
            return new Tea().encrypt(body, Constants.BUF16);
        }
    }

    public static byte[] buildRequestPacket(long uin, int cmdid, byte[] body) throws IOException {
        return new Writer()
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

    public static byte[] buildSSO(String cmd, int subid, String imei, byte[] body) throws IOException {
        return new Writer()
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
    }

    public static byte[] buildLoginPacket(long uin, int type, byte[] body) throws IOException {
        return new Writer()
                .writeWithLength(
                        new Writer()
                                .writeInt(0x0A)
                                .writeByte(type)
                                .writeWithLength(Sig.d2)
                                .writeByte(0)
                                .writeWithLength(String.valueOf(uin))
                                .writeBytes(body)
                                .read()
                )
                .read();
    }
}
