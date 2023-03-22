package com.i77251680.core.codec.jce;

import com.i77251680.utils.JudgeType;
import io.netty.buffer.ByteBuf;

import java.util.*;

public class JceReader {
    public static JceHead readHead(ByteBuf buf) {
        short head = buf.readUnsignedByte();
        int type = head & 0xf;
        int tag = (head & 0xf0) >> 4;
        if (tag == 0xf) {
            tag = buf.readUnsignedByte();
        }
        return new JceHead(tag, type);
    }

    public static Object readBody(ByteBuf buf, int type) {
        switch (type) {
            case JceConstants.TYPE_ZERO:
                return 0;
            case JceConstants.TYPE_BYTE:
                return readByte(buf);
            case JceConstants.TYPE_SHORT:
                return readShort(buf);
            case JceConstants.TYPE_INT:
                return readInt(buf);
            case JceConstants.TYPE_LONG:
                return readLong(buf);
            case JceConstants.TYPE_STRING1:
                return readString(buf);
            case JceConstants.TYPE_STRING4:
                return readString4(buf);
            case JceConstants.TYPE_SIMPLE_LIST:
                return readJceSimpleList(buf);
            case JceConstants.TYPE_LIST:
                return readJceList(buf);
            case JceConstants.TYPE_MAP:
                return readJceMap(buf);
            case JceConstants.TYPE_STRUCT_BEGIN:
                return readJceStruct(buf);
            case JceConstants.TYPE_STRUCT_END:
                return JceConstants.FLAG_STRUCT_END;
            case JceConstants.TYPE_FLOAT:
                return readFloat(buf);
            case JceConstants.TYPE_DOUBLE:
                return readDouble(buf);
            default:
                throw new JceException("unknown jce type: " + type);
        }
    }

    public static JceElement readElement(ByteBuf buf) {
        JceHead head = readHead(buf);
        Object value = readBody(buf, (Integer) head.type);
        return new JceElement(head.tag, value);
    }

    public static int readByte(ByteBuf buf) {
        return buf.readByte();
    }

    public static int readShort(ByteBuf buf) {
        return buf.readShort();
    }

    public static int readInt(ByteBuf buf) {
        return buf.readInt();
    }

    public static long readLong(ByteBuf buf) {
        return buf.readLong();
    }

    public static float readFloat(ByteBuf buf) {
        return buf.readFloat();
    }

    public static double readDouble(ByteBuf buf) {
        return buf.readDouble();
    }

    public static String readString(ByteBuf buf) {
        int len = buf.readByte() & 0xff;
        byte[] buffer = new byte[len];
        buf.readBytes(buffer);
        return len > 0 ? new String(buffer) : "";
    }

    public static String readString4(ByteBuf buf) {
        int len = buf.readInt();
        byte[] buffer = new byte[len];
        buf.readBytes(buffer);
        return len > 0 ? new String(buffer) : "";
    }

    public static List<Object> readJceList(ByteBuf buf) {
        int len_;
        Object len = readElement(buf).value;
        if (Objects.equals(JudgeType.getType(len), "Byte"))
            len_ = (Byte) len;
        else if (Objects.equals(JudgeType.getType(len), "Short"))
            len_ = (Short) len;
        else
            len_ = (int) len;
        List<Object> list = new ArrayList<>();
        while (len_ > 0) {
            list.add(readElement(buf).value);
            --len_;
        }
        return list;
    }

    public static Map<Object, Object> readJceMap(ByteBuf buf) {
        int len_;
        Object len = readElement(buf).value;
        if (Objects.equals(JudgeType.getType(len), "Byte"))
            len_ = (Byte) len;
        else if (Objects.equals(JudgeType.getType(len), "Short"))
            len_ = (Short) len;
        else
            len_ = (int) len;
        Map<Object, Object> map = new HashMap<>();
        while (len_ > 0) {
            map.put(readElement(buf).value, readElement(buf).value);
            --len_;
        }
        return map;
    }

    public static Map<Object, Object> readJceStruct(ByteBuf buf) {
        Map<Object, Object> struct = new HashMap<>();
        while (buf.isReadable()) {
            JceElement jceElement = readElement(buf);
            Object tag = jceElement.tag;
            Object value = jceElement.value;
            if (value.equals(JceConstants.FLAG_STRUCT_END)) {
                break;
            } else {
                struct.put(tag, value);
            }
        }
        return struct;
    }

    public static byte[] readJceSimpleList(ByteBuf buf) {
        readHead(buf);
        byte[] buffer;
        Object len = readElement(buf).value;
        if (Objects.equals(JudgeType.getType(len), "Byte"))
            buffer = new byte[(Byte) len];
        else if (Objects.equals(JudgeType.getType(len), "Short"))
            buffer = new byte[(Short) len];
        else
            buffer = new byte[(int) len];
        buf.readBytes(buffer);
        return buffer;
    }
}
