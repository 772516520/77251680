package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T187 {
    public static Writer writeT187(String mac_address) throws IOException {
        return new Writer()
                .writeBytes(mac_address);
    }
}
