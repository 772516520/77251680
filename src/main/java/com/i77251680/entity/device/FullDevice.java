package com.i77251680.entity.device;

import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.Random;

import java.util.Arrays;

public class FullDevice {
    public String display;
    public String product;
    public String device;
    public String board;
    public String brand;
    public String model;
    public String bootloader;
    public String fingerprint;
    public String boot_id;
    public String proc_version;
    public String baseband;
    public String sim;
    public String os_type;
    public String mac_address;
    public String ip_address;
    public String wifi_bssid;
    public String wifi_ssid;
    public String imei;
    public String android_id;
    public String apn;
    public Version version;
    public byte[] imsi;
    public byte[] guid;

    @Override
    public String toString() {
        return "FullDevice{" + '\n' +
                "display=" + display + '\n' +
                "product=" + product + '\n' +
                "device=" + device + '\n' +
                "board=" + board + '\n' +
                "brand=" + brand + '\n' +
                "model=" + model + '\n' +
                "bootloader=" + bootloader + '\n' +
                "fingerprint=" + fingerprint + '\n' +
                "boot_id=" + boot_id + '\n' +
                "proc_version=" + proc_version + '\n' +
                "baseband=" + baseband + '\n' +
                "sim=" + sim + '\n' +
                "os_type=" + os_type + '\n' +
                "mac_address=" + mac_address + '\n' +
                "ip_address=" + ip_address + '\n' +
                "wifi_bssid=" + wifi_bssid + '\n' +
                "wifi_ssid=" + wifi_ssid + '\n' +
                "imei=" + imei + '\n' +
                "android_id=" + android_id + '\n' +
                "apn=" + apn + '\n' +
                "version=" + version.toString() + '\n' +
                "imsi=" + Arrays.toString(imsi) + '\n' +
                "guid=" + Arrays.toString(guid) + '\n' +
                '}';
    }

    private final ShortDevice d;

    public FullDevice(Long uin) {
        d = new ShortDevice(uin);
        display = d.android_id;
        product = d.product;
        device = d.device;
        board = d.board;
        brand = d.brand;
        model = d.model;
        bootloader = d.bootloader;
        fingerprint = d.brand + "/" + d.product + "/" + d.device + ":10" + "/" + d.android_id + "/" + d.incremental + ":user" + "/" + "release-keys";
        boot_id = d.boot_id;
        proc_version = d.proc_version;
        baseband = "";
        sim = "T-Mobile";
        os_type = "android";
//        mac_address = d.mac_address;
        mac_address = "02:00:00:00:00:00";
        ip_address = d.ip_address;
//        wifi_bssid = d.mac_address;
        wifi_bssid = "02:00:00:00:00:00";
//        wifi_ssid = d.wifi_ssid;
        wifi_ssid = "<unknown ssid>";
        imei = d.imei;
        android_id = d.android_id;
        apn = "wifi";
        version = new Version(d);
        imsi = Random.randomBytes(16);
        guid = Md5Crypto.encrypt(
                ArrayUtils.addAll(d.imei.getBytes(), d.mac_address.getBytes()));
//        guid = HexFormat.of().parseHex("e1970ccb91dfddadd9f22cf6933ce9fe");
//        guid = HexFormat.of().parseHex("e1970ccb91dfd8adf9f22cf6933ce9fe");
    }
}
