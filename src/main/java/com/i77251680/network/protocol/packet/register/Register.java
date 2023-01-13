package com.i77251680.network.protocol.packet.register;

import com.i77251680.core.client.BaseClient;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.entity.enums.Platform;
import com.i77251680.network.protocol.packet.login.BuildLoginPacket;

public class Register {
    public static byte[] r(long uin, FullDevice fullDevice, Platform platform) {
        BaseClient.next_seq();
        byte[] body = BuildRegister.build(uin, fullDevice);
        return BuildLoginPacket.build("StatSvc.register", body, uin, platform.subid, fullDevice.imei, 1);
    }
}
