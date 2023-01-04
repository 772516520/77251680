package com.i77251680.core.codec.protobuf;

import com.i77251680.core.codec.protobuf.pbpack.Packet;
import com.i77251680.entity.proto.D50_;

import java.io.IOException;

public class D50 extends Packet {
    @Override
    public byte[] pack() throws IOException {
        return this.build();
    }

    @Override
    public byte[] build() throws IOException {
        D50_.d50.Builder builder = D50_.d50.newBuilder();
        D50_.d50 res = builder
                .setConst10002(10002)
                .setConst91001(1)
                .setConst101001(1)
                .setConst151001(1)
                .setConst181001(1)
                .setConst251001(1)
                .build();
        return res.toByteArray();
    }

    @Override
    public void unpack(byte[] packet) {

    }
}
