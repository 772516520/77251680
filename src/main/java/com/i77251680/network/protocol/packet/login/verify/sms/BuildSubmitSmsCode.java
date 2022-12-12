package com.i77251680.network.protocol.packet.login.verify.sms;

import com.i77251680.core.writer.Writer;
import com.i77251680.network.protocol.packet.pack.PackTlv;
import com.i77251680.network.protocol.packet.tlv.*;

import java.io.IOException;

public class BuildSubmitSmsCode {
    public static byte[] build(byte[] t104, int bitmap, int subSigMap, byte[] t174, String code, byte[] g) throws IOException {
        return pack(t104, bitmap, subSigMap, t174, code, g);
    }

    private static byte[] pack(byte[] t104, int bitmap, int subSigMap, byte[] t174, String code, byte[] g) throws IOException {
        return new Writer()
                .writeShort(7)
                .writeShort(7)
                .writeBytes(PackTlv.pack(0x08, T8.writeT8()))
                .writeBytes(PackTlv.pack(0x104, T104.writeT104(t104)))
                .writeBytes(PackTlv.pack(0x116, T116.writeT116(bitmap, subSigMap)))
                .writeBytes(PackTlv.pack(0x174, T174.writeT174(t174)))
                .writeBytes(PackTlv.pack(0x17c, T17C.writeT17C(code)))
                .writeBytes(PackTlv.pack(0x401, T401.writeT401(g)))
                .writeBytes(PackTlv.pack(0x198, T198.writeT198()))
                .read();
    }
}
