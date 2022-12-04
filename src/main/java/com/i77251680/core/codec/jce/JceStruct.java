package com.i77251680.core.codec.jce;

import com.i77251680.Exceptions.JceException;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.JudgeType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JceStruct {

    private final Map<Byte, Object> JceMap = new HashMap<Byte, Object>();

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
            case Type.JceMap:
                type = JceConstants.TYPE_MAP;
                break;
            case Type.BYTE:
                type = JceConstants.TYPE_BYTE;
                break;
            case Type.SHORT:
                type = JceConstants.TYPE_SHORT;
                break;
            case Type.INT:
                type = JceConstants.TYPE_INT;
                break;
            case Type.LONG:
                type = JceConstants.TYPE_LONG;
                break;
            case Type.FLOAT:
            case Type.DOUBLE:
                type = JceConstants.TYPE_DOUBLE;
                break;
            case Type.Zero:
                type = JceConstants.TYPE_ZERO;
                break;
            default:
                throw new JceException("Unsupported type: " + valueType);
        }
        byte[] head = createHead(type, tag);
        byte[] body = createBody(type, value);
        return ArrayUtils.addAll(head, body);
    }

    public static byte[] encode(List<?> list) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte tag = 0;
        for (Object o : list) {
            if (o == null) {
                ++tag;
                continue;
            }
            b.write(createElement(tag, o));
            ++tag;
        }
        return b.toByteArray();
    }

    public static byte[] encode(Map<Byte, Object> jceStructMap) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte tag = 0;
        for (Map.Entry<Byte, Object> entry : jceStructMap.entrySet()) {
            if (entry.getValue() == null) {
                ++tag;
                continue;
            }
            b.write(createElement(tag, entry.getValue()));
            ++tag;
        }
        return b.toByteArray();
    }

    /**
     * create NestedStruct
     *
     * @return NestedStruct
     */
    public static NestedStruct encodeNested(List<Object> list) throws IOException {
        return new NestedStruct(encode(list));
    }

    /**
     * create NestedStruct
     *
     * @return NestedStruct
     */
    public static NestedStruct encodeNested(Map<Byte, Object> jceStructMap) throws IOException {
        return new NestedStruct(encode(jceStructMap));
    }
}
