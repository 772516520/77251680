package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.md5.Md5Crypto;

import java.io.IOException;

public class T188 {
    public static Writer writeT188(String android_id) throws IOException {
        return new Writer()
                .writeBytes(Md5Crypto.encrypt(android_id));
    }
}
