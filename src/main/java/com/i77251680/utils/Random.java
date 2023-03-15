package com.i77251680.utils;

public class Random {
    /**
     * random 4 bytes
     *
     * @return random 4 bytes byteArray
     * @see java.util.Random
     */
    public static byte[] randomBytes() {
        byte[] bytes = new byte[4];
        new java.util.Random().nextBytes(bytes);
        return bytes;
    }

    /**
     * random any bytes
     *
     * @return random any bytes byteArray
     * @see java.util.Random
     */
    public static byte[] randomBytes(int len) {
        byte[] bytes = new byte[len];
        new java.util.Random().nextBytes(bytes);
        return bytes;
    }
}
