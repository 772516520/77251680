package com.i77251680.entity.device;

import com.i77251680.core.device.Device;
import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.utils.HexFormat;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Arrays;

public class ShortDevice {
    @Override
    public String toString() {
        return "ShortDevice{" + '\n' +
                "uin=" + uin + '\n' +
                "hex='" + hex + '\n' +
                "hash=" + hash +
                "product='" + product + '\n' +
                "device='" + device + '\n' +
                "board='" + board + '\n' +
                "brand='" + brand + '\n' +
                "model='" + model + '\n' +
                "wifi_ssid='" + wifi_ssid + '\n' +
                "bootloader='" + bootloader + '\n' +
                "android_id='" + android_id + '\n' +
                "boot_id='" + boot_id + '\n' +
                "proc_version='" + proc_version + '\n' +
                "mac_address='" + mac_address + '\n' +
                "ip_address='" + ip_address + '\n' +
                "imei='" + imei + '\n' +
                "incremental='" + incremental + '\n' +
                '}';
    }

    public final Long uin;
    public final String hex;
    public final ByteBuf hash;
    public String product = "CMC520";
    public String device = "LOVEWYC520";
    public String board = "WYC-YYDS";
    public String brand;
    public String model;
    public String wifi_ssid;
    public String bootloader;
    public String android_id;
    public String boot_id;
    public String proc_version;
    public String mac_address;
    public String ip_address;
    public String imei;
    public long incremental;

    public ShortDevice(Long uin) {
        this.uin = uin;
        this.hash = Unpooled.wrappedBuffer(Md5Crypto.encrypt(String.valueOf(uin)));
        this.hex = HexFormat.of().formatHex(hash.array());
        device = "LOVEWYC520";
        board = "WYC-YYDS";
        brand = "CMC";
        model = "ILOVE WYC";
        wifi_ssid = "TP-LINK-" + Long.toString(uin, 16);
        bootloader = "U-boot";
        android_id = "CMC." + hash.readUnsignedShort() + hash.readUnsignedByte() + "." + hash.readUnsignedByte() + Integer.parseInt(String.valueOf(uin).substring(0, 3));
        hash.resetReaderIndex();
        boot_id = hex.substring(0, 8) + "-" + hex.substring(8, 8 + 4) + "-" + hex.substring(12, 12 + 4) + "-" + hex.substring(16, 16 + 4) + "-" + hex.substring(20);
        proc_version = "Linux version 4.19.71-" + hash.readUnsignedShort() + "(77251677.github.com)";
        hash.resetReaderIndex();
        mac_address = "00:50:"
                + HexFormat.of().formatHex(Arrays.copyOfRange(hash.array(), 6, 6 + 1)).toUpperCase() + ":"
                + HexFormat.of().formatHex(Arrays.copyOfRange(hash.array(), 7, 7 + 1)).toUpperCase() + ":"
                + HexFormat.of().formatHex(Arrays.copyOfRange(hash.array(), 8, 8 + 1)).toUpperCase() + ":"
                + HexFormat.of().formatHex(Arrays.copyOfRange(hash.array(), 9, 9 + 1)).toUpperCase();
        hash.readBytes(9);
        hash.resetReaderIndex();
        ip_address = "10.0" + "." + Math.abs(hash.readByte()) + "." + hash.readUnsignedByte();
        imei = new Device().generateImei(uin);
        hash.readBytes(8);
        incremental = hash.readUnsignedInt();
    }
}
