package com.i77251680.core.packet.tlv;

import com.i77251680.core.packet.pack.PackTlv;
import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.device.FullDevice;

import java.io.IOException;

public class T144 {
    public static Writer writeT144(
            String imei,
            FullDevice fullDevice,
            String os_type,
            String release,
            String sim,
            String apn,
            String device,
            byte[] guid,
            String brand,
            String model,
            byte[] tgtgt
    ) throws IOException {
        byte[] body = new Writer()
                .writeShort(5)
                .writeBytes(PackTlv.pack(0x109, T109.writeT109(imei)))
                .writeBytes(PackTlv.pack(0x52d, T52D.writeT52D(fullDevice)))
                .writeBytes(PackTlv.pack(0x124, T124.writeT124(os_type, release, sim, apn)))
                .writeBytes(PackTlv.pack(0x128, T128.writeT128(device, guid, brand)))
                .writeBytes(PackTlv.pack(0x16e, T16E.writeT16E(model)))
                .read();
        return new Writer()
                .writeBytes(new Tea().encrypt(body, tgtgt));
    }
}
