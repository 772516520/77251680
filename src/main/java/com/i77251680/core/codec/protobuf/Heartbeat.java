package com.i77251680.core.codec.protobuf;

import com.google.protobuf.ByteString;
import com.i77251680.core.codec.protobuf.pbpack.Packet;
import com.i77251680.core.writer.Writer;
import com.i77251680.entity.proto.OidbSvc_0x480_9_IMCore;

import java.io.IOException;

public class Heartbeat extends Packet {
    private final long uin;

    public Heartbeat(Long uin) {
        this.uin = uin;
    }

    @Override
    public byte[] pack() throws IOException {
        return this.build();
    }

    @Override
    public byte[] build() throws IOException {
        byte[] buf = new Writer()
                .writeInt(uin)
                .writeByte(0)
                .writeInt(0x19e39)
                .read();
        OidbSvc_0x480_9_IMCore.hb480.Builder builder = OidbSvc_0x480_9_IMCore.hb480.newBuilder();
        OidbSvc_0x480_9_IMCore.hb480 res = builder
                .setConst1152(1152)
                .setConst9(9)
                .setBuf(ByteString.copyFrom(buf))
                .build();
        return res.toByteArray();
    }

    @Override
    public void unpack(byte[] packet) {

    }
}
