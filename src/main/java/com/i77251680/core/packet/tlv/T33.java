package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.entity.device.FullDevice;

import java.io.IOException;

public class T33 {
    public static Writer writeT33(FullDevice device) throws IOException {
        return new Writer()
                .writeBytes(device.guid);
    }
}
