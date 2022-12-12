package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T202 {
    public static Writer writeT202(String wifi_bssid, String wifi_ssid) throws IOException {
        return new Writer()
                .writeTlv(wifi_bssid.substring(0, 16))
                .writeTlv(wifi_ssid.length() < 32 ? wifi_bssid : wifi_bssid.substring(0, 32));
    }
}
