package com.i77251680.entity.enums;

public enum MusicPlatform {
    qq("qq", "com.tencent.qqmusic", "cbd27cd7c861227d013a25b2d10f0799", "qq音乐"),
    NetEase("163", "com.netease.cloudmusic", "da6b069da1e2982db3e386233f68d76d", "网易云音乐"),
    migu("migu", "cmccwm.mobilemusic", "6cdc72a439cef99a3418d2a78aa28c73", "咪咕音乐"),
    kugou("kugou", "com.kugou.android", "fe4a24d80fcf253a00676a808f62c2c6", "酷狗音乐"),
    kuwo("kuwo", "cn.kuwo.player", "bf9ff4ffb4c558a34ee3fd52c223ebf5", "酷我音乐");
    private String platform;
    private String appName;
    private String sign;
    private String remark;

    MusicPlatform(String platform, String appName, String sign, String remark) {
        this.platform = platform;
        this.appName = appName;
        this.sign = sign;
        this.remark = remark;
    }

    public String getPlatform() {
        return platform;
    }

    public String getAppName() {
        return appName;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return remark;
    }
}
