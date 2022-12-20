package com.i77251680.utils;

import java.util.List;
import java.util.Map;

public class JudgeType {
    public static String getType(Object value) {
        if (value.equals(0)) {
            return "Zero";
        }
        if (value instanceof Byte) {
            return "Byte";
        }
        if (value instanceof Short) {
            return "Short";
        }
        if (value instanceof Integer) {
            return "Integer";
        }
        if (value instanceof Long) {
            return "Long";
        }
        if (value instanceof Float) {
            return "Float";
        }
        if (value instanceof Double) {
            return "Double";
        }
        if (value instanceof Boolean) {
            return "Boolean";
        }
        if (value instanceof Character) {
            return "Character";
        }
        if (value instanceof String) {
            return "String";
        }
        if (value instanceof List) {
            return "List";
        }
        if (value instanceof Map) {
            return "Map";
        }
        if (value instanceof byte[]) {
            return "byteArray";
        }
        if (value instanceof short[]) {
            return "shortArray";
        }
        if (value instanceof int[]) {
            return "intArray";
        }
        if (value instanceof long[]) {
            return "longArray";
        }
        if (value instanceof float[]) {
            return "floatArray";
        }
        if (value instanceof double[]) {
            return "doubleArray";
        }
        if (value instanceof boolean[]) {
            return "booleanArray";
        }
        if (value instanceof char[]) {
            return "charArray";
        }
        return null;
    }
}
