package com.i77251680.core.codec.protobuf;

import com.i77251680.utils.JudgeType;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pb {
    public static byte[] encode(Map<Integer, Object> map) {
        PbWriter writer = new PbWriter();
        map.forEach((fieldNumber, value) -> {
            if (value instanceof List)
                for (Object v : (List<?>) value) {
                    _encode(writer, fieldNumber, v);
                }
            else
                _encode(writer, fieldNumber, value);
        });
        return writer.array();
    }

    private static void _encode(PbWriter writer, long fieldNumber, Object value) {
        switch (Objects.requireNonNull(JudgeType.getType(value))) {
            case "Zero":
            case "Byte":
            case "Short":
            case "Integer":
                writer.writeVarint(fieldNumber, ((Integer) value).longValue());
                break;
            case "Long":
                writer.writeVarint(fieldNumber, (Long) value);
                break;
            case "byteArray":
            case "String":
                writer.writeWithLength(fieldNumber, value);
                break;
            case "Map":
                writer.writeWithLength(fieldNumber, encode((Map<Integer, Object>) value));
                break;
            case "List":
                break;
        }
    }

    public static Map<Integer, Object> decode(byte[] encoded) {
        Node node = Node.builder();
        ByteBuffer buf = ByteBuffer.wrap(encoded);
        while (buf.position() < buf.limit()) {
            _decode(buf, node);
        }
        return node.build();
    }

    public static void _decode(ByteBuffer buf, Node node) {
        int k = (int) PbReader.readVarint(buf);
        int fieldNumber = k >> 3, type = k & 0b111;
        Object value = null, decoded = null;
        switch (type) {
            case WriteType.VARINT:
                value = PbReader.readVarint(buf);
                break;
            case WriteType.BYTES:
                value = PbReader.readBytes(buf);
                try {
                    decoded = decode((byte[]) value);
                } catch (Exception e) {
                }
                value = new Proto((byte[]) value, decoded);
                break;
            case WriteType.FIXED32:
                value = PbReader.readFixed32(buf);
        }
        node.put(fieldNumber, value);
    }
}
