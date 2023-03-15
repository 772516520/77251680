package com.i77251680.core.writer;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static io.netty.buffer.Unpooled.buffer;

public class Writer {
    private final ByteArrayOutputStream b;

    public Writer() {
        this.b = new ByteArrayOutputStream();
    }

    public Writer writeByte(int v) throws IOException {
        ByteBuf byteBuf = buffer(1);
        byteBuf.writeByte(v);
        this.b.write(byteBuf.array());
        return this;
    }

    public Writer writeShort(int v) throws IOException {
        ByteBuf byteBuf = buffer(2);
        byteBuf.writeShort(v);
        this.b.write(byteBuf.array());
        return this;
    }

    public Writer writeInt(int v) throws IOException {
        ByteBuf byteBuf = buffer(4);
        byteBuf.writeInt(v);
        this.b.write(byteBuf.array());
        return this;
    }

    public Writer writeInt(long v) throws IOException {
        ByteBuf byteBuf = buffer(4);
        byteBuf.writeInt(new Long(v).intValue());
        this.b.write(byteBuf.array());
        return this;
    }

    public Writer writeLong(int v) throws IOException {
        ByteBuf byteBuf = buffer(8);
        byteBuf.writeLong(v);
        this.b.write(byteBuf.array());
        return this;
    }

    public Writer writeLong(long v) throws IOException {
        ByteBuf byteBuf = buffer(8);
        byteBuf.writeLong(v);
        this.b.write(byteBuf.array());
        return this;
    }

    public <T> Writer writeBytes(T v) throws IOException {
        byte[] buf;
        if (v instanceof String)
            buf = ((String) v).getBytes();
        else
            buf = (byte[]) v;
        this.b.write(buf);
        return this;
    }

    public <T> Writer writeTlv(T v) throws IOException {
        if (v instanceof String)
            this.writeShort(((String) v).length()).writeBytes(v);
        else
            this.writeShort(((byte[]) v).length).writeBytes(v);
        return this;
    }

    public <T> Writer writeWithLength(T v) throws IOException {
        if (v instanceof String)
            this.writeInt(((String) v).length() + 4).writeBytes(v);
        else
            this.writeInt(((byte[]) v).length + 4).writeBytes(v);
        return this;
    }

    public byte[] read() {
        return this.b.toByteArray();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (byte b : b.toByteArray()) {
            if (Integer.toHexString(b & 0xff).length() < 2) s.append(0);
            s.append(Integer.toHexString(b & 0xff));
        }
        return s.toString();
    }
}
