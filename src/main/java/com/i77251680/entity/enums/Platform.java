package com.i77251680.entity.enums;

public enum Platform {
    Android(
            "com.tencent.mobileqq",
            537138832,
            "8.9.33.10335",
            "6.0.0.2534",
            150470524,
            0x10400,
            16724722,
            new byte[]{-90, -73, 69, -65, 36, -94, -62, 119, 82, 119, 22, -10, -13, 110, -74, -115},
            1673599898,
            19,
            16,
            "Android"
    ),
    APad(
            "com.tencent.mobileqq",
            537151218,
            "8.9.33.10335",
            "6.0.0.2534",
            150470524,
            0x10400,
            16724722,
            new byte[]{-90, -73, 69, -65, 36, -94, -62, 119, 82, 119, 22, -10, -13, 110, -74, -115},
            1673599898,
            34869472,
            19,
            "aPad"
    ),
    Watch(
            "com.tencent.qqlite",
            537064446,
            "2.0.5",
            "6.0.0.236",
            16252796,
            0x10400,
            34869472,
            new byte[]{-90, -73, 69, -65, 36, -94, -62, 119, 82, 119, 22, -10, -13, 110, -74, -115},
            1559564731,
            5,
            16,
            "Watch"
    ),
    MAC(
            "com.tencent.qq",
            0x2003ca32,
            "6.7.9",
            "6.2.0.1023",
            0x7ffc,
            66560,
            1970400,
            "com.tencent.qq".getBytes(),
            0,
            7,
            16,
            "iMac"
    ),
    IPad(
            "com.tencent.minihd.qq",
            537065739,
            "5.8.9",
            "6.0.0.2433",
            150470524,
            66560,
            1970400,
            new byte[]{-86, 57, 120, -12, 31, -39, 111, -7, -111, 74, 102, -98, 24, 100, 116, -57},
            1595836208,
            12,
            16,
            "iPad"
    );

    public final String apkId;
    public final int subid;
    public final String ver;
    public final String sdkver;
    public final int bitmap;
    public final int subSigMap;
    public final int mainSigMap;
    public final byte[] sign;
    public final int buildtime;
    public final int ssoVersion;
    public final int appId; // constant 16
    public final String display;

    Platform(
            String apkId,
            int subid,
            String ver,
            String sdkver,
            int bitmap,
            int subSigMap,
            int mainSigMap,
            byte[] sign,
            int buildtime,
            int ssoVersion,
            int appId,
            String display
    ) {
        this.apkId = apkId;
        this.subid = subid;
        this.ver = ver;
        this.sdkver = sdkver;
        this.bitmap = bitmap;
        this.subSigMap = subSigMap;
        this.mainSigMap = mainSigMap;
        this.sign = sign;
        this.buildtime = buildtime;
        this.ssoVersion = ssoVersion;
        this.appId = appId;
        this.display = display;
    }
}