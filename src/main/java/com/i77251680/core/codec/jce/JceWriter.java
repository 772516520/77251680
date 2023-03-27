package com.i77251680.core.codec.jce;

import com.i77251680.constants.Constants;
import com.i77251680.utils.ArrayUtils;
import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.netty.buffer.Unpooled.buffer;

public class JceWriter {
    private ByteBuf body, len;
    private final Object value;
    private final ByteArrayOutputStream b;

    public JceWriter(Object value) {
        this.value = value;
        b = new ByteArrayOutputStream();
    }

    public byte[] writeByte() {
        body = buffer(1);
        body.writeByte((Byte) value);
        return body.array();
    }

    public byte[] writeShort() {
        body = buffer(2);
        body.writeShort((Short) value);
        return body.array();
    }

    public byte[] writeInt() {
        body = buffer(4);
        body.writeInt(value instanceof Integer ? (int) value : ((Long) value).intValue());
        return body.array();
    }

    public byte[] writeLong() {
        body = buffer(8);
        body.writeLong((Long) value);
        return body.array();
    }

    public byte[] writeFloat() {
        body = buffer(4);
        body.writeFloat((Float) value);
        return body.array();
    }

    public byte[] writeDouble() {
        body = buffer(8);
        body.writeDouble((Double) value);
        return body.array();
    }

    public byte[] writeString() {
        b.write(String.valueOf(value).length());
        try {
            b.write(String.valueOf(value).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return b.toByteArray();
    }

    public byte[] writeString4() {
        b.write(String.valueOf(value).length());
        try {
            b.write(String.valueOf(value).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return b.toByteArray();
    }

    public byte[] writeMap() {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        Map<Byte, Object> map = (Map<Byte, Object>) value;
        byte[] length = JceStruct.createElement(JceConstants.TAG_LENGTH, map.size());
        try {
            b.write(length);
            for (Map.Entry<Byte, Object> entry : map.entrySet()) {
                b.write(ArrayUtils.concat(JceStruct.createElement(JceConstants.TAG_MAP_K, entry.getKey())));
                b.write(ArrayUtils.concat(JceStruct.createElement(JceConstants.TAG_MAP_V, entry.getValue())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b.toByteArray();
    }

    public byte[] writeList() {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        List<Object> list = (List<Object>) value;
        try {
            b.write(JceStruct.createElement(JceConstants.TAG_LENGTH, list.size()));
            for (Object o : list) {
                b.write(JceStruct.createElement(JceConstants.TAG_LIST_E, o));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b.toByteArray();
    }

    public byte[] writeSimpleList() {
        return ArrayUtils.concat(JceStruct.createHead((byte) 0, JceConstants.TAG_BYTES),
                JceStruct.createElement(JceConstants.TAG_LENGTH, ((byte[]) value).length),
                (byte[]) value);
    }

    public byte[] writeZero() {
        return Constants.BUF0;
    }
}
