package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.md5.Md5Crypto;

import java.io.IOException;

public class T187 {
    public static Writer writeT187(String mac_address) throws IOException {
        return new Writer()
                .writeTlv(Md5Crypto.encrypt(mac_address));
    }
}
