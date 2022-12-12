//package com.i77251680.core.packet.heartbeat;
//
//import com.i77251680.constants.Constants;
//import com.i77251680.core.packet.login.BuildLoginPacket;
//
//public class Heartbeat {
//    public static byte[] build(long uin, int subid, String imei) {
//        return pack(uin, subid, imei);
//    }
//
//    private static byte[] pack(long uin, int subid, String imei) {
//        return BuildLoginPacket.build("Heartbeat.Alive", Constants.BUF0, uin, subid, imei, 0);
//    }
//}
