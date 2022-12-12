package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.constants.Constants;
import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T1F {
    public static Writer writeT1F() throws IOException {
        return new Writer()
                .writeByte(0)
                .writeTlv("android")
                .writeTlv("7.1.2")
                .writeShort(2)
                .writeTlv("China Mobile GSM")
                .writeTlv(Constants.BUF0)
                .writeTlv("wifi");
    }
}
