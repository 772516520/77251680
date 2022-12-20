package com.i77251680.utils;

public class ArrayUtils {
    public static byte[] addAll(byte[] array1, byte... array2) {
        if (array1 == null) {
            return clone(array2);
        } else if (array2 == null) {
            return clone(array1);
        } else {
            byte[] joinedArray = new byte[array1.length + array2.length];
            System.arraycopy(array1, 0, joinedArray, 0, array1.length);
            System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
            return joinedArray;
        }
    }

    public static byte[] concat(byte[]... arrays) {
        int i = 0, length = 0;
        for (byte[] arr : arrays) {
            length += arr.length;
        }
        byte[] joinedArray = new byte[length];
        for (byte[] arr : arrays) {
            System.arraycopy(arr, 0, joinedArray, i, arr.length);
            i += arr.length;
        }
        return joinedArray;
    }

    private static byte[] clone(byte[] array) {
        return array == null ? null : array.clone();
    }
}
