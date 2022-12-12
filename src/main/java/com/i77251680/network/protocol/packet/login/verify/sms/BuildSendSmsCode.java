package com.i77251680.network.protocol.packet.login.verify.sms;

import com.i77251680.core.writer.Writer;
import com.i77251680.network.protocol.packet.pack.PackTlv;
import com.i77251680.network.protocol.packet.tlv.*;

import java.io.IOException;

public class BuildSendSmsCode {
    public static byte[] build(byte[] t104, int bitmap, int subSigMap, byte[] t174) throws IOException {
        return pack(t104, bitmap, subSigMap, t174);
    }

    private static byte[] pack(byte[] t104, int bitmap, int subSigMap, byte[] t174) throws IOException {
        return new Writer()
                .writeShort(8)
                .writeShort(6)
                .writeBytes(PackTlv.pack(0x08, T8.writeT8()))
                .writeBytes(PackTlv.pack(0x104, T104.writeT104(t104)))
                .writeBytes(PackTlv.pack(0x116, T116.writeT116(bitmap, subSigMap)))
                .writeBytes(PackTlv.pack(0x174, T174.writeT174(t174)))
                .writeBytes(PackTlv.pack(0x17a, T17A.writeT17A()))
                .writeBytes(PackTlv.pack(0x197, T197.writeT197()))
                .read();
    }
}
