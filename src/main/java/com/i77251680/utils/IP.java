package com.i77251680.utils;

public class IP {
    public static String convertIP(long ip) {
        StringBuilder s = new StringBuilder();
        s.append(ip >> 24)
                .append(".")
                .append(ip >> 16 & 0xff)
                .append(".")
                .append(ip >> 8 & 0xff)
                .append(".")
                .append(ip & 0xff);
        return s.toString();
    }

    public static long convertIP(String ip) {
        String[] s = ip.split("\\.");
        long _ip = Long.parseLong(s[0]) << 24;
        _ip |= Long.parseLong(s[1]) << 16;
        _ip |= Long.parseLong(s[2]) << 8;
        _ip |= Long.parseLong(s[3]);
        return _ip;
    }
}
