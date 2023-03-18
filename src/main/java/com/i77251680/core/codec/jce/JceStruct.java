package com.i77251680.core.codec.jce;

import com.i77251680.exceptions.JceException;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.JudgeType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JceStruct {
    public static byte[] createHead(byte type, byte tag) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        if ((int) tag < 15) {
            b.write(tag << 4 | type);
            return b.toByteArray();
        } else if ((int) tag < 256) {
            b.write(0xf0 | type);
            return ArrayUtils.addAll(b.toByteArray(), tag);
        } else
            throw new JceException("Tag must be less than 256, received: " + tag);
    }

    public static byte[] createBody(byte type, Object value) {
        switch (type) {
            case JceConstants.TYPE_BYTE:
                return new JceWriter(value).writeByte();
            case JceConstants.TYPE_SHORT:
                return new JceWriter(value).writeShort();
            case JceConstants.TYPE_INT:
                return new JceWriter(value).writeInt();
            case JceConstants.TYPE_LONG:
                return new JceWriter(value).writeLong();
            case JceConstants.TYPE_FLOAT:
                return new JceWriter(value).writeFloat();
            case JceConstants.TYPE_DOUBLE:
                return new JceWriter(value).writeDouble();
            case JceConstants.TYPE_STRING1:
                return new JceWriter(value).writeString();
            case JceConstants.TYPE_STRING4:
                return new JceWriter(value).writeString4();
            case JceConstants.TYPE_MAP:
                return new JceWriter(value).writeMap();
            case JceConstants.TYPE_LIST:
                return new JceWriter(value).writeList();
            case JceConstants.TYPE_ZERO:
                return new JceWriter(value).writeZero();
            case JceConstants.TYPE_SIMPLE_LIST:
                return new JceWriter(value).writeSimpleList();
        }
        throw new JceException("Type must be 0 ~ 13, received: " + type);
    }

    public static byte[] createElement(byte tag, Object value) {
        if (value instanceof NestedStruct) {
            byte[] begin = createHead(JceConstants.TYPE_STRUCT_BEGIN, tag);
            byte[] end = createHead(JceConstants.TYPE_STRUCT_END, JceConstants.TAG_STRUCT_END);
            return ArrayUtils.concat(begin, ((NestedStruct) value).data, end);
        }
        byte type;
        String valueType = JudgeType.getType(value);
        switch (Objects.requireNonNull(valueType)) {
            case Type.JceString:
                if (String.valueOf(value).equals("")) {
                    type = JceConstants.TYPE_STRING1;
                } else {
                    value = String.valueOf(value);
                    type = ((String) value).length() <= 0xff ? JceConstants.TYPE_STRING1 : JceConstants.TYPE_STRING4;
                }
                break;
            case Type.byteArray:
                type = JceConstants.TYPE_SIMPLE_LIST;
                break;
            case Type.JceList:
                type = JceConstants.TYPE_LIST;
                break;
            case Type.JceMap:
                type = JceConstants.TYPE_MAP;
                break;
            case Type.Zero:
                type = JceConstants.TYPE_ZERO;
                break;
            case Type.BYTE:
            case Type.SHORT:
            case Type.INT:
            case Type.LONG:
                long number = value instanceof Integer ? (Integer) value : (Long) value;
                if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE) {
                    type = JceConstants.TYPE_BYTE;
                    value = new Integer((int) number).byteValue();
                } else if (number >= Short.MIN_VALUE && number <= Short.MAX_VALUE) {
                    type = JceConstants.TYPE_SHORT;
                    value = new Integer((int) number).shortValue();
                } else if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE)
                    type = JceConstants.TYPE_INT;
                else if (number >= Long.MIN_VALUE && number <= Long.MAX_VALUE)
                    type = JceConstants.TYPE_LONG;
                else
                    throw new JceException("Unsupported integer range: " + value);
                break;
            case Type.FLOAT:
            case Type.DOUBLE:
                type = JceConstants.TYPE_DOUBLE;
                break;
            default:
                throw new JceException("Unsupported type: " + valueType);
        }
        byte[] head = createHead(type, tag);
        byte[] body = createBody(type, value);
        return ArrayUtils.addAll(head, body);
    }

    public static byte[] encode(List<?> list) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte tag = 0;
        for (Object o : list) {
            if (o == null) {
                ++tag;
                continue;
            }
            try {
                b.write(createElement(tag, o));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ++tag;
        }
        return b.toByteArray();
    }

    public static byte[] encode(Map<Byte, Object> jceStructMap) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte tag = 0;
        for (Map.Entry<Byte, Object> entry : jceStructMap.entrySet()) {
            if (entry.getValue() == null) {
                ++tag;
                continue;
            }
            try {
                b.write(createElement(tag, entry.getValue()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ++tag;
        }
        return b.toByteArray();
    }

    /**
     * create NestedStruct
     *
     * @return NestedStruct
     */
    public static NestedStruct encodeNested(List<Object> list) {
        return new NestedStruct(encode(list));
    }

    /**
     * create NestedStruct
     *
     * @return NestedStruct
     */
    public static NestedStruct encodeNested(Map<Byte, Object> jceStructMap) {
        return new NestedStruct(encode(jceStructMap));
    }
}
