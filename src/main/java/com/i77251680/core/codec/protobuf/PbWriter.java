package com.i77251680.core.codec.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class PbWriter {
    private ByteBuffer buffer;
    private final ByteArrayOutputStream b;

    public PbWriter() {
        b = new ByteArrayOutputStream();
    }

    public PbWriter writeVarint(long value) {
        try {
            write(PbConverter.toVarint(value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public PbWriter writeVarint(long fieldNumber, Long value) {
        try {
            writeTag(fieldNumber, WriteType.VARINT);
            write(PbConverter.toVarint(value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public <T> PbWriter writeWithLength(long fieldNumber, T val) {
        try {
            writeTag(fieldNumber, WriteType.BYTES);
            if (val instanceof String)
                writeVarint(((String) val).length()).write(((String) val).getBytes());
            else
                writeVarint(((byte[]) val).length).write((byte[]) val);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public PbWriter writeTag(long fieldNumber, int type) throws IOException {
        b.write(PbConverter.toVarint(fieldNumber << 3 | type));
        return this;
    }

    public PbWriter write(byte[] bytes) throws IOException {
        b.write(bytes);
        return this;
    }

    public byte[] array() {
        return b.toByteArray();
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
