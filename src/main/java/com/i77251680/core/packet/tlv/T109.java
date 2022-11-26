package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.md5.Md5Crypto;

import java.io.IOException;

public class T109 {
    public static Writer writeT109(String imei) throws IOException {
        return new Writer()
                .writeBytes(Md5Crypto.encrypt(imei));
    }
}
