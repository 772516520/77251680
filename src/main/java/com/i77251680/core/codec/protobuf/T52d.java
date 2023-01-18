package com.i77251680.core.codec.protobuf;

import com.i77251680.core.codec.protobuf.pbpack.Packet;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.entity.proto.Tlv52D;

import java.io.IOException;

public class T52d extends Packet {
    private final String bootloader;
    private final String proc_version;
    private final String version_codename;
    private final long version_incremental;
    private final String fingerprint;
    private final String boot_id;
    private final String android_id;
    private final String baseband;

    public T52d(FullDevice d) {
        bootloader = d.bootloader;
        proc_version = d.proc_version;
        version_codename = d.version.codename;
        version_incremental = d.version.incremental;
        fingerprint = d.fingerprint;
        boot_id = d.boot_id;
        android_id = d.android_id;
        baseband = d.baseband;
    }

    @Override
    public byte[] pack() throws IOException {
        return this.build();
    }

    @Override
    public byte[] build() throws IOException {
        Tlv52D.buf.Builder builder = Tlv52D.buf.newBuilder();
        Tlv52D.buf buf = builder
                .setBootloader(bootloader)
                .setProcVersion(proc_version)
                .setVersionCodename(version_codename)
                .setVersionIncremental4(version_incremental)
                .setFingerprint(fingerprint)
                .setBootId(boot_id)
                .setAndroidId(android_id)
                .setBaseband(baseband)
                .setVersionIncremental9(version_incremental)
                .build();
        return buf.toByteArray();
    }

    @Override
    public void unpack(byte[] packet) {

    }
}
