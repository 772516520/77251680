package com.i77251680.utils;

import java.util.Random;

public class Utils {
    /**
     * ten-digit timestamp
     *
     * @see java.lang.System
     */
    public static final int DATE = (int) (System.currentTimeMillis() / 1000);

    /**
     * random 4 bytes
     *
     * @return random 4 bytes byteArray
     * @see java.util.Random
     */
    public static byte[] randomBytes() {
        byte[] bytes = new byte[4];
        new Random().nextBytes(bytes);
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
        new Random().nextBytes(bytes);
        return bytes;
    }
}
