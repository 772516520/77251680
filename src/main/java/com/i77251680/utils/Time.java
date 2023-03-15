package com.i77251680.utils;

public class Time {
    /**
     * ten-digit timestamp
     *
     * @see java.lang.System
     */
    public static int timestamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
