package com.i77251680.network.protocol.packet.login.verify.slider;

import com.i77251680.core.writer.Writer;
import com.i77251680.network.protocol.packet.pack.PackTlv;
import com.i77251680.network.protocol.packet.tlv.T104;
import com.i77251680.network.protocol.packet.tlv.T116;
import com.i77251680.network.protocol.packet.tlv.T193;
import com.i77251680.network.protocol.packet.tlv.T8;

import java.io.IOException;

public class BuildSubmitSlider {
    public static byte[] build(String ticket, byte[] t104, int bitmap, int subSigMap) throws IOException {
        return pack(ticket, t104, bitmap, subSigMap);
    }

    private static byte[] pack(String ticket, byte[] t104, int bitmap, int subSigMap) throws IOException {
        return new Writer()
                .writeShort(2)
                .writeShort(4)
                .writeBytes(PackTlv.pack(0x193, T193.writeT193(ticket)))
                .writeBytes(PackTlv.pack(0x08, T8.writeT8()))
                .writeBytes(PackTlv.pack(0x104, T104.writeT104(t104)))
                .writeBytes(PackTlv.pack(0x116, T116.writeT116(bitmap, subSigMap)))
                .read();
    }
}
