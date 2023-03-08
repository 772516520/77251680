package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.entity.enums.Platform;

import java.io.IOException;

public class T16 {
    public static Writer writeT16(FullDevice device) throws IOException {
        Platform apk = Platform.Watch;
        return new Writer()
                .writeInt(7)
                .writeInt(apk.appId)
                .writeInt(apk.subid)
                .writeBytes(device.guid)
                .writeTlv(apk.apkId)
                .writeTlv(apk.ver)
                .writeTlv(apk.sign);
    }
}
