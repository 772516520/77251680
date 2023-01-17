package com.i77251680.core.codec.protobuf;

import com.i77251680.core.codec.protobuf.pbpack.Packet;
import com.i77251680.entity.proto.RegisterBuf;
import com.i77251680.utils.Utils;

import java.io.IOException;

public class Register extends Packet {
    public static byte[] pack;

    static {
        try {
            pack = new Register().pack();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] pack() throws IOException {
        return this.build();
    }

    @Override
    public byte[] build() throws IOException {
        RegisterBuf.reg_buf.Builder builder = RegisterBuf.reg_buf.newBuilder();
        RegisterBuf.buf1.Builder buf1Builder = RegisterBuf.buf1.newBuilder();
        RegisterBuf.buf2.Builder buf2Builder = RegisterBuf.buf2.newBuilder();

        RegisterBuf.buf1 buf1 = buf1Builder
                .setConst46(46)
                .setDate(Utils.DATE)
                .build();
        RegisterBuf.buf2 buf2 = buf2Builder
                .setConst283(283)
                .setConst0(0)
                .build();
        RegisterBuf.reg_buf reg_buf = builder
                .setBuf1(buf1)
                .setBuf2(buf2)
                .build();
        return reg_buf.toByteArray();
    }

    @Override
    public void unpack(byte[] packet) {

    }
}
