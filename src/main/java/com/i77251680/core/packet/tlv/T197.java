package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.constants.Constants;

import java.io.IOException;

public class T197 {
    public static Writer writeT197() throws IOException {
        return new Writer()
                .writeTlv(Constants.BUF1);
    }
}
