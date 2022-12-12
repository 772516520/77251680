package com.i77251680.network.protocol.packet.login;

import com.i77251680.core.writer.Writer;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.network.protocol.packet.pack.PackTlv;
import com.i77251680.network.protocol.packet.tlv.*;

import java.io.IOException;

public class PasswordLogin {
    public static byte[] pack(
            long uin,
            int appid,
            int loginType,
            byte[] md5pass,
            byte[] tgtgt,
            int subid,
            int bitmap,
            int subSigMap,
            String id,
            FullDevice fullDevice,
            String ver,
            byte[] sign,
            int seq,
            int buildtime,
            String sdkver,
            int mainSigMap,
            int ssoVersion
    ) throws IOException {
        return new Writer()
                .writeShort(9)
                .writeShort(22)
                .writeBytes(PackTlv.pack(0x18, T18.writeT18(uin, appid)))
                .writeBytes(PackTlv.pack(0x01, T1.writeT1(uin)))
                .writeBytes(PackTlv.pack(0x106, T106.writeT106(uin, appid, loginType, md5pass, tgtgt, fullDevice.guid, subid, ssoVersion)))
                .writeBytes(PackTlv.pack(0x116, T116.writeT116(bitmap, subSigMap)))
                .writeBytes(PackTlv.pack(0x100, T100.writeT100(appid, subid, bitmap, mainSigMap, ssoVersion)))
                .writeBytes(PackTlv.pack(0x107, T107.writeT107()))
                .writeBytes(PackTlv.pack(0x142, T142.writeT142(id)))
                .writeBytes(PackTlv.pack(0x144, T144.writeT144(fullDevice, tgtgt)))
                .writeBytes(PackTlv.pack(0x145, T145.writeT145(fullDevice.guid)))
                .writeBytes(PackTlv.pack(0x147, T147.writeT147(appid, ver, sign)))
                .writeBytes(PackTlv.pack(0x154, T154.writeT154(seq)))
                .writeBytes(PackTlv.pack(0x141, T141.writeT141(fullDevice.sim, fullDevice.apn)))
                .writeBytes(PackTlv.pack(0x08, T8.writeT8()))
                .writeBytes(PackTlv.pack(0x511, T511.writeT511()))
                .writeBytes(PackTlv.pack(0x187, T187.writeT187(fullDevice.mac_address)))
                .writeBytes(PackTlv.pack(0x188, T188.writeT188(fullDevice.android_id)))
                .writeBytes(PackTlv.pack(0x191, T191.writeT191()))
                .writeBytes(PackTlv.pack(0x202, T202.writeT202(fullDevice.wifi_bssid, fullDevice.wifi_ssid)))
                .writeBytes(PackTlv.pack(0x177, T177.writeT177(buildtime, sdkver)))
                .writeBytes(PackTlv.pack(0x516, T516.writeT516()))
                .writeBytes(PackTlv.pack(0x521, T521.writeT521()))
                .writeBytes(PackTlv.pack(0x525, T525.writeT525()))
                .read();
    }

    public static byte[] pack(
            long uin,
            int appid,
            int loginType,
            byte[] md5pass,
            byte[] tgtgt,
            int subid,
            int mainSigMap,
            int ssoVersion,
            int bitmap,
            int subSigMap,
            String id,
            FullDevice fullDevice,
            String ver,
            byte[] sign,
            int seq,
            int buildtime,
            String sdkver,
            boolean allowSlider
    ) throws IOException {
        Writer body = new Writer()
                .writeShort(9)
                .writeShort(allowSlider ? 0x18 : 0x17)
                .writeBytes(PackTlv.pack(0x18, T18.writeT18(uin, appid)))
                .writeBytes(PackTlv.pack(0x01, T1.writeT1(uin)))
                .writeBytes(PackTlv.pack(0x106, T106.writeT106(uin, appid, loginType, md5pass, tgtgt, fullDevice.guid, subid, ssoVersion)))
                .writeBytes(PackTlv.pack(0x116, T116.writeT116(bitmap, subSigMap)))
                .writeBytes(PackTlv.pack(0x100, T100.writeT100(appid, subid, bitmap, mainSigMap, ssoVersion)))
                .writeBytes(PackTlv.pack(0x107, T107.writeT107()))
                .writeBytes(PackTlv.pack(0x108, T108.writeT108(fullDevice.imei))) // 不确定
                .writeBytes(PackTlv.pack(0x142, T142.writeT142(id)))
                .writeBytes(PackTlv.pack(0x144, T144.writeT144(fullDevice, tgtgt)))
                .writeBytes(PackTlv.pack(0x145, T145.writeT145(fullDevice.guid)))
                .writeBytes(PackTlv.pack(0x147, T147.writeT147(appid, ver, sign)))
                .writeBytes(PackTlv.pack(0x154, T154.writeT154(seq)))
                .writeBytes(PackTlv.pack(0x141, T141.writeT141(fullDevice.sim, fullDevice.apn)))
                .writeBytes(PackTlv.pack(0x08, T8.writeT8()))
                .writeBytes(PackTlv.pack(0x511, T511.writeT511()))
                .writeBytes(PackTlv.pack(0x187, T187.writeT187(fullDevice.mac_address)))
                .writeBytes(PackTlv.pack(0x188, T188.writeT188(fullDevice.android_id)))
                .writeBytes(PackTlv.pack(0x194, T194.writeT194(fullDevice.imsi)));
        if (allowSlider) {
            body.writeBytes(PackTlv.pack(0x191, T191.writeT191()));
        }
        body.writeBytes(PackTlv.pack(0x202, T202.writeT202(fullDevice.wifi_bssid, fullDevice.wifi_ssid)))
                .writeBytes(PackTlv.pack(0x177, T177.writeT177(buildtime, sdkver)))
                .writeBytes(PackTlv.pack(0x516, T516.writeT516()))
                .writeBytes(PackTlv.pack(0x521, T521.writeT521()))
                .writeBytes(PackTlv.pack(0x525, T525.writeT525()));
        return body.read();
    }
}
