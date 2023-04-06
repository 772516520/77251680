package com.i77251680.network.protocol.packet.login.qrcode;

import com.i77251680.core.client.Sig;
import com.i77251680.core.writer.Writer;
import com.i77251680.network.protocol.device.FullDevice;
import com.i77251680.network.protocol.packet.pack.PackTlv;
import com.i77251680.network.protocol.packet.tlv.*;

import java.io.IOException;

public class BuildQrcodeLogin {
    public static byte[] build(
            long uin,
            int appid,
            int subid,
            int bimap,
            int subSigMap,
            int buildTime,
            String id,
            String ver,
            String sdkVer,
            FullDevice fullDevice,
            byte[] t106,
            byte[] t16a,
            byte[] t318,
            byte[] tgtgt,
            byte[] sign,
            int mainSigMap,
            int ssoVersion
    ) {
        try {
            return pack(
                    uin,
                    appid,
                    subid,
                    bimap,
                    subSigMap,
                    buildTime,
                    id,
                    ver,
                    sdkVer,
                    fullDevice,
                    t106,
                    t16a,
                    t318,
                    tgtgt,
                    sign,
                    mainSigMap,
                    ssoVersion
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] pack(
            long uin,
            int appId,
            int subid,
            int bimap,
            int subSigMap,
            int buildTime,
            String apkId,
            String ver,
            String sdkVer,
            FullDevice fullDevice,
            byte[] t106,
            byte[] t16a,
            byte[] t318,
            byte[] tgtgt,
            byte[] sign,
            int mainSigMap,
            int ssoVersion
    ) throws IOException {
        return new Writer()
                .writeShort(9)
                .writeShort(24)
                .writeBytes(PackTlv.pack(0x18, T18.writeT18(uin, appId)))
                .writeBytes(PackTlv.pack(0x01, T1.writeT1(uin)))
                .writeBytes(PackTlv.pack(0x106, t106))
                .writeBytes(PackTlv.pack(0x116, T116.writeT116(bimap, subSigMap)))
                .writeBytes(PackTlv.pack(0x100, T100.writeT100(appId, subid, mainSigMap, ssoVersion)))
                .writeBytes(PackTlv.pack(0x107, T107.writeT107()))
                .writeBytes(PackTlv.pack(0x142, T142.writeT142(apkId)))
                .writeBytes(PackTlv.pack(0x144, T144.writeT144(fullDevice, tgtgt)))
                .writeBytes(PackTlv.pack(0x145, T145.writeT145(fullDevice.guid)))
                .writeBytes(PackTlv.pack(0x147, T147.writeT147(appId, ver, sign)))
                .writeBytes(PackTlv.pack(0x16a, t16a))
                .writeBytes(PackTlv.pack(0x154, T154.writeT154(Sig.seq)))
                .writeBytes(PackTlv.pack(0x141, T141.writeT141(fullDevice.sim, fullDevice.apn)))
                .writeBytes(PackTlv.pack(0x08, T8.writeT8()))
                .writeBytes(PackTlv.pack(0x511, T511.writeT511()))
                .writeBytes(PackTlv.pack(0x187, T187.writeT187(fullDevice.mac_address)))
                .writeBytes(PackTlv.pack(0x188, T188.writeT188(fullDevice.android_id)))
                .writeBytes(PackTlv.pack(0x194, T194.writeT194(fullDevice.imsi)))
                .writeBytes(PackTlv.pack(0x191, T191.writeT191()))
                .writeBytes(PackTlv.pack(0x202, T202.writeT202(fullDevice.wifi_bssid, fullDevice.wifi_ssid)))
                .writeBytes(PackTlv.pack(0x177, T177.writeT177(buildTime, sdkVer)))
                .writeBytes(PackTlv.pack(0x516, T516.writeT516()))
                .writeBytes(PackTlv.pack(0x521, T521.writeT521()))
                .writeBytes(PackTlv.pack(0x318, t318))
                .read();
    }
}
