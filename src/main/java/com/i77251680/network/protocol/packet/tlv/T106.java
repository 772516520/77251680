package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.constants.Constants;
import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.Random;
import com.i77251680.utils.Time;

import java.io.IOException;

public class T106 {
    public static Writer writeT106(
            long uin,
            int appid,
            int loginType,
            byte[] md5pass,
            byte[] tgtgt,
            byte[] guid,
            int subid,
            int ssoVersion
    ) throws IOException {
        byte[] body = new Writer()
                .writeShort(4)
                .writeBytes(Random.randomBytes())
                .writeInt(ssoVersion)
                .writeInt(appid)
                .writeInt(0)
                .writeLong(uin)
                .writeInt(Time.timestamp())
                .writeBytes(Constants.BUF4)
                .writeByte(1) // isSavePassword
                .writeBytes(md5pass)
                .writeBytes(tgtgt)
                .writeInt(0)
                .writeByte(1)
                .writeBytes(guid)
                .writeInt(subid)
                .writeInt(loginType)
                .writeTlv(String.valueOf(uin))
                .writeShort(0)
                .read();
        byte[] uin_buf = new Writer().writeInt(uin).read();
        byte[] key = Md5Crypto.encrypt(ArrayUtils.concat(md5pass, Constants.BUF4, uin_buf));
        return new Writer()
                .writeBytes(new Tea().encrypt(body, key));
    }
}
