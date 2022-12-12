package com.i77251680.network.protocol.packet.tlv;

import com.i77251680.constants.Constants;
import com.i77251680.core.writer.Writer;

import java.io.IOException;

public class T197 {
    public static Writer writeT197() throws IOException {
        return new Writer()
                .writeTlv(Constants.BUF1);
    }
}
