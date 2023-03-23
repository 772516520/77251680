package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.codec.protobuf.Node;
import com.i77251680.core.codec.protobuf.Pb;
import com.i77251680.core.writer.Writer;
import com.i77251680.entity.device.FullDevice;

import java.io.IOException;

public class T52D {
    public static Writer writeT52D(FullDevice fullDevice) throws IOException {
        return new Writer()
                .writeBytes(Pb.encode(
                        Node.builder()
                                .put(1, fullDevice.bootloader)
                                .put(2, fullDevice.bootloader)
                                .put(3, fullDevice.proc_version)
                                .put(4, fullDevice.version.codename)
                                .put(5, fullDevice.version.incremental)
                                .put(6, fullDevice.fingerprint)
                                .put(7, fullDevice.boot_id)
                                .put(8, fullDevice.android_id)
                                .put(9, fullDevice.baseband)
                                .build()
                ));
    }
}
