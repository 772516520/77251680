package com.i77251680.core.codec.protobuf.pbpack;

import java.io.IOException;

public interface PackProtobuf {
    byte[] pack() throws IOException;

    byte[] build() throws IOException;
}
