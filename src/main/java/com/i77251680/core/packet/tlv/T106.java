package com.i77251680.core.packet.tlv;

import com.i77251680.constants.Constants;
import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.Utils;

import java.io.IOException;

public class T106 {
    public static Writer writeT106(
            long uin,
            int appid,
            byte[] md5pass,
            byte[] tgtgt,
            byte[] guid,
            int subid) throws IOException {
        byte[] body = new Writer()
                .writeShort(4)
                .writeBytes(Utils.randomBytes())
                .writeInt(7)
                .writeInt(appid)
                .writeInt(0)
                .writeLong(uin)
                .writeInt(Utils.DATE & 0xffffffff)
                .writeInt(0)
                .writeByte(1)
                .writeBytes(md5pass)
                .writeBytes(tgtgt)
                .writeInt(0)
                .writeByte(1)
                .writeBytes(guid)
                .writeInt(subid)
                .writeInt(1)
                .writeTlv(String.valueOf(uin))
                .writeShort(0)
                .read();
        byte[] uin_buf = new Writer().writeInt(uin).read();
        byte[] key = Md5Crypto.encryptbuf(ArrayUtils.concat(md5pass, Constants.BUF4, uin_buf));
        return new Writer()
                .writeBytes(new Tea().encrypt(body, key));
    }
}
