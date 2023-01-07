package com.i77251680.core.device;

import com.i77251680.entity.device.FullDevice;
import com.i77251680.entity.device.ShortDevice;

public interface Platform {
    String generateImei(Long uin);

    ShortDevice generateShortDevice(Long uin);

    FullDevice generateFullDevice(Long uin);

    int calcSP(String imei);
}
