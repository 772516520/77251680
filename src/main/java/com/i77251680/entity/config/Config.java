package com.i77251680.entity.config;

import com.i77251680.entity.enums.Platform;

public class Config {
    public Platform platform;
    public int hb480_interval = 30000;

    public Config() {
        platform = Platform.Android;
    }

    public Config(Platform platform) {
        this.platform = platform;
    }

    public Config(int hb480_interval) {
        platform = Platform.Android;
        this.hb480_interval = hb480_interval * 1000;
    }

    public Config(Platform platform, int hb480_interval) {
        this.platform = platform;
        this.hb480_interval = hb480_interval * 1000;
    }
}
