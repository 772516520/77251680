package com.i77251680.entity.config;

import com.i77251680.entity.enums.Platform;

import java.io.File;

public class Config {
    public Platform platform = Platform.Android;
    public boolean auto_server = true;
    public boolean ignore_self = true;
    public boolean resend = true;
    public boolean cache_group_member = true;
    public int reconn_interval = 5;
    public int hb480_interval = 30 * 1000;
    public File data_dir = new File(".");
    public static Config DEFAULT = new Config();

    private Config() {
    }

    public Config(Platform platform) {
        this.platform = platform;
    }
}
