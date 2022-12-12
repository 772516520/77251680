package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.network.protocol.packet.pack.PackTlv;

import java.io.IOException;

public class T144 {
    public static Writer writeT144(
            FullDevice fullDevice,
            byte[] tgtgt
    ) throws IOException {
        byte[] body = new Writer()
                .writeShort(5)
                .writeBytes(PackTlv.pack(0x109, T109.writeT109(fullDevice.imei)))
                .writeBytes(PackTlv.pack(0x52d, T52D.writeT52D(fullDevice)))
                .writeBytes(PackTlv.pack(0x124, T124.writeT124(fullDevice.os_type, fullDevice.version.release, fullDevice.sim, fullDevice.apn)))
                .writeBytes(PackTlv.pack(0x128, T128.writeT128(fullDevice.model, fullDevice.guid, fullDevice.brand)))
                .writeBytes(PackTlv.pack(0x16e, T16E.writeT16E(fullDevice.model)))
                .read();
        return new Writer()
                .writeBytes(new Tea().encrypt(body, tgtgt));
    }
}
