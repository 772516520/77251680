//package com.i77251680.entity.enums;
//
//public enum Platform {
//    Android(
//            "com.tencent.mobileqq",
//            "A8.8.80.7400",
//            "A8.8.90.83e6c009",
//            "8.8.80",
//            new byte[]{-90, -73, 45, -65, 24, -94, -62, 77, 52, 16, -10, -13, 110, -74, -115},
//            1652271523,
//            16,
//            537119623,
//            184024956,
//            "6.0.0.2508",
//            34869472,
//            "Android"
//    ),
//    APad(
//            "com.tencent.minihd.qq",
//            "A8.8.80.7400",
//            "A8.8.90.83e6c009",
//            "8.8.80",
//            new byte[]{-86, 57, 120, -12, 31, -39, 111, -7, -111, 74, 102, -98, 24, 100, 116, -57},
//            1637427966,
//            16,
//            537067382,
//            150470524,
//            "6.0.0.2508",
//            1970400,
//            "aPad"
//    ),
//    IPad(
//            "com.tencent.minihd.qq",
//            "A8.8.80.7400",
//            "A8.8.90.83e6c009",
//            "8.8.80",
//            new byte[]{-86, 57, 120, -12, 31, -39, 111, -7, -111, 74, 102, -98, 24, 100, 116, -57},
//            1637427966,
//            16,
//            537118796,
//            150470524,
//            "6.0.0.2508",
//            1970400,
//            "iPad"
//    );
//    public String id = getId();
//    private final String id_;
//    public final String name = getName();
//    private final String name_;
//    public final String version = getVersion();
//    private final String version_;
//    public final String ver = getVer();
//    private final String ver_;
//    public final byte[] sign = getSign();
//    private final byte[] sign_;
//    public final int buildtime = getBuildtime();
//    private final int buildtime_;
//    public final int appid = getAppid();
//    private final int appid_;
//    public final int subid = getSubid();
//    private final int subid_;
//    public final int bitmap = getBitmap();
//    private final int bitmap_;
//    public final String sdkver = getSdkver();
//    private final String sdkver_;
//    public final int sigmap = getSigmap();
//    private final int sigmap_;
//    public final String display = getDisplay();
//    private final String display_;
//
//    private Platform(
//            String id_,
//            String name_,
//            String version_,
//            String ver_,
//            byte[] sign_,
//            int buildtime_,
//            int appid_,
//            int subid_,
//            int bitmap_,
//            String sdkver_,
//            int sigmap_,
//            String display_
//    ) {
//        this.id_ = id_;
//        this.name_ = name_;
//        this.version_ = version_;
//        this.ver_ = ver_;
//        this.sign_ = sign_;
//        this.buildtime_ = buildtime_;
//        this.appid_ = appid_;
//        this.subid_ = subid_;
//        this.bitmap_ = bitmap_;
//        this.sdkver_ = sdkver_;
//        this.sigmap_ = sigmap_;
//        this.display_ = display_;
//    }
//
//    public String getId() {
//        return id_;
//    }
//
//    public String getName() {
//        return name_;
//    }
//
//    public String getVersion() {
//        return version_;
//    }
//
//    public String getVer() {
//        return ver_;
//    }
//
//    public byte[] getSign() {
//        return sign_;
//    }
//
//    public int getBuildtime() {
//        return buildtime_;
//    }
//
//    public int getAppid() {
//        return appid_;
//    }
//
//    public int getSubid() {
//        return subid_;
//    }
//
//    public int getBitmap() {
//        return bitmap_;
//    }
//
//    public String getSdkver() {
//        return sdkver_;
//    }
//
//    public int getSigmap() {
//        return sigmap_;
//    }
//
//    public String getDisplay() {
//        return display_;
//    }
//}


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