package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;

import java.io.IOException;
import java.util.Arrays;

public class T128 {
    public static Writer writeT128(String model, byte[] guid, String brand) throws IOException {
        return new Writer()
                .writeShort(0)
                .writeByte(0)
                .writeByte(1)
                .writeByte(0)
                .writeInt(16777216)
                .writeTlv(model)
                .writeTlv(Arrays.copyOfRange(guid, 0, 16))
                .writeTlv(brand);
    }
}
