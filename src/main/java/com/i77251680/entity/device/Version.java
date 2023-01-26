package com.i77251680.entity.device;

public class Version {
    @Override
    public String toString() {
        return "Version{" + '\n' +
                "incremental=" + incremental + '\n' +
                "release=" + release + '\n' +
                "codename=" + codename + '\n' +
                "sdk=" + sdk + '\n' +
                '}';
    }

    public long incremental;
    public String release;
    public String codename;
    public int sdk;

    public Version(ShortDevice d) {
        incremental = d.incremental;
        release = "10";
        codename = "REL";
        sdk = 29;
    }
}
