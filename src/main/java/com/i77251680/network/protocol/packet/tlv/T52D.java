package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.codec.protobuf.T52d;
import com.i77251680.core.writer.Writer;
import com.i77251680.entity.device.FullDevice;

import java.io.IOException;

public class T52D {
    public static Writer writeT52D(FullDevice fullDevice) throws IOException {
        return new Writer()
                .writeBytes(new T52d(fullDevice).pack());
    }
}
