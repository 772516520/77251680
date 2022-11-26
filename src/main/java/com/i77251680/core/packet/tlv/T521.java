package com.i77251680.core.packet.tlv;

import com.i77251680.core.writer.Writer;
import com.i77251680.constants.Constants;

import java.io.IOException;

public class T521 {
    public static Writer writeT521() throws IOException {
        return new Writer()
                .writeBytes(Constants.BUF6);
    }
}
