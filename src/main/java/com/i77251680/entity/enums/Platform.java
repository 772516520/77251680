package com.i77251680.entity.enums;

public class Platform {
    public static Platform Android = new Platform(
            "com.tencent.mobileqq",
            "8.9.15.9425",
            new byte[]{-90, -73, 69, -65, 36, -94, -62, 119, 82, 119, 22, -10, -13, 110, -74, -115},
            16,
            1640921786,
            537138832,
            150470524,
            "6.0.0.2494",
            0x10400,
            16724722,
            16,
            "Android"
    );
    public static Platform APad = new Platform(
            "com.tencent.mobileqq",
            "8.4.18",
            new byte[]{-90, -73, 69, -65, 36, -94, -62, 119, 82, 119, 22, -10, -13, 110, -74, -115},
            16,
            1637427966,
            537062409,
            184024956,
            "6.0.0.2454",
            0x10400,
            34869472,
            15,
            "aPad"
    );

    public static Platform MAC = new Platform(
            "com.tencent.qq",
            "6.7.9",
            "com.tencent.qq".getBytes(),
            16,
            0,
            0x2003ca32,
            0x7ffc,
            "6.2.0.1023",
            66560,
            1970400,
            7,
            "iMac"
    );
    public static Platform IPad = new Platform(
            "com.tencent.minihd.qq",
            "5.8.9",
            new byte[]{-86, 57, 120, -12, 31, -39, 111, -7, -111, 74, 102, -98, 24, 100, 116, -57},
            16,
            1595836208,
            537065739,
            150470524,
            "6.0.0.2433",
            66560,
            1970400,
            12,
            "iPad"
    );
    public final String apkId;
    public final String ver;
    public final byte[] sign;
    public final int appId;
    public final int buildtime;
    public final int subid;
    public final int bitmap;
    public final String sdkver;
    public final int subSigMap;
    public final int mainSigMap;
    public final int ssoVersion;
    public final String display;

    public Platform(
            String apkId_,
            String ver_,
            byte[] sign_,
            int appId_,
            int buildtime_,
            int subid_,
            int bitmap_,
            String sdkver_,
            int subSigMap_,
            int mainSigMap_,
            int ssoVersion_,
            String display_
    ) {
        this.apkId = apkId_;
        this.ver = ver_;
        this.sign = sign_;
        this.appId = appId_;
        this.buildtime = buildtime_;
        this.subid = subid_;
        this.bitmap = bitmap_;
        this.mainSigMap = mainSigMap_;
        this.sdkver = sdkver_;
        this.subSigMap = subSigMap_;
        this.ssoVersion = ssoVersion_;
        this.display = display_;
    }

}