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
            int subid,
            int ssoVersion
    ) throws IOException {
        byte[] body = new Writer()
                .writeShort(4)
                .writeBytes(Utils.randomBytes())
                .writeInt(ssoVersion)
                .writeInt(appid)
                .writeInt(0)
                .writeLong(uin)
                .writeInt(Utils.DATE)
                .writeBytes(Constants.BUF4)
                .writeByte(1) // isSavePassword
                .writeBytes(md5pass)
                .writeBytes(tgtgt)
                .writeInt(0)
                .writeByte(1)
                .writeBytes(guid)
                .writeInt(subid)
                .writeInt(1) // Login Type 1:pwd 3:SMS 4:微信一键登录
                .writeTlv(String.valueOf(uin))
                .writeShort(0)
                .read();
        byte[] uin_buf = new Writer().writeInt(uin).read();
        byte[] key = Md5Crypto.encrypt(ArrayUtils.concat(md5pass, Constants.BUF4, uin_buf));
        return new Writer()
                .writeBytes(new Tea().encrypt(body, key));
    }
}
