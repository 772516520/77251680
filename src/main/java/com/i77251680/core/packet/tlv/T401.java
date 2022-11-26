package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.utils.Utils;

import java.io.IOException;

public class T401 {
    public static Writer writeT401() throws IOException {
        return new Writer()
                .writeTlv(Utils.randomBytes(16));
    }
}
