package com.i77251680.core.writer;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static io.netty.buffer.Unpooled.buffer;

public class Writer {
    private final ByteArrayOutputStream byteArrayOutputStream;

    public Writer() {
        this.byteArrayOutputStream = new ByteArrayOutputStream();
    }

    public Writer writeU8(int v) throws IOException {
        ByteBuf byteBuf = buffer(1);
        byteBuf.writeByte(v);
        this.byteArrayOutputStream.write(byteBuf.array());
        return this;
    }

    public Writer writeU16(int v) throws IOException {
        ByteBuf byteBuf = buffer(2);
        byteBuf.writeShort(v);
        this.byteArrayOutputStream.write(byteBuf.array());
        return this;
    }

    public Writer writeU32(int v) throws IOException {
        ByteBuf byteBuf = buffer(4);
        byteBuf.writeInt(v);
        this.byteArrayOutputStream.write(byteBuf.array());
        return this;
    }

    public Writer writeU64(int v) throws IOException {
        ByteBuf byteBuf = buffer(8);
        byteBuf.writeLong(v);
        this.byteArrayOutputStream.write(byteBuf.array());
        return this;
    }

    public Writer writeLong(long v) throws IOException {
        ByteBuf byteBuf = buffer(4);
        byteBuf.writeInt(new Long(v).intValue());
        this.byteArrayOutputStream.write(byteBuf.array());
        return this;
    }

    public <T> Writer writeBytes(T v) throws IOException {
        byte[] buf;
        if (v instanceof String)
            buf = ((String) v).getBytes();
        else
            buf = (byte[]) v;
        this.byteArrayOutputStream.write(buf);
        return this;
    }

    public <T> Writer writeTlv(T v) throws IOException {
        if (v instanceof String)
            this.writeU16(((String) v).length()).writeBytes(v);
        else
            this.writeU16(((byte[]) v).length).writeBytes(v);
        return this;
    }

    public <T> Writer writeWithLength(T v) throws IOException {
        if (v instanceof String)
            this.writeU32(((String) v).length() + 4).writeBytes(v);
        else
            this.writeU32(((byte[]) v).length + 4).writeBytes(v);
        return this;
    }

    public byte[] read() {
        return this.byteArrayOutputStream.toByteArray();
    }
}
