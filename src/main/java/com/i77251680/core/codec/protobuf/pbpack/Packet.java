package com.i77251680.core.codec.protobuf.pbpack;

import java.io.IOException;

abstract public class Packet implements PackProtobuf, UnpackProtobuf {
    @Override
    abstract public byte[] pack() throws IOException;

    @Override
    abstract public byte[] build() throws IOException;

    @Override
    abstract public void unpack(byte[] packet);
}
