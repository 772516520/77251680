package com.i77251680.core.device;

import com.i77251680.entity.device.FullDevice;
import com.i77251680.entity.device.ShortDevice;
import com.i77251680.utils.ArrayUtils;
import io.netty.buffer.ByteBuf;

import java.util.Arrays;

import static io.netty.buffer.Unpooled.buffer;
import static io.netty.buffer.Unpooled.wrappedBuffer;

public class Device implements Platform {
    @Override
    public String generateImei(Long uin) {
        String imei = uin % 2 == 0 ? "86" : "35";
        ByteBuf buf = buffer(4);
        buf.writeInt(uin.intValue());
        byte[] arr = ArrayUtils.addAll(new byte[1], Arrays.copyOfRange(buf.array(), 1, buf.array().length));
        int a = buf.readUnsignedShort();
        int b = Math.abs(wrappedBuffer(arr).readInt());
        String aa = null;
        String bb = null;
        if (a > 9999)
            a = Math.round(a / 10);
        else if (a < 1000)
            aa = String.valueOf(uin).substring(2, 7);
        while (b > 9999999)
            b = b >>> 1;
        if (b < 1000000)
            bb = String.valueOf(uin).substring(1, 6);

        imei += (aa == null ? a : aa) + "0" + (bb == null ? b : bb);
        return imei.length() == 15 ? imei : imei + calcSP(imei);
    }

    @Override
    public ShortDevice generateShortDevice(Long uin) {
        return new ShortDevice(uin);
    }

    @Override
    public FullDevice generateFullDevice(Long uin) {
        return new FullDevice(uin);
    }

    @Override
    public int calcSP(String imei) {
        int sum = 0;
        for (int i = 0; i < imei.length(); ++i) {
            if (i % 2 == 0) {
                final int j = Integer.parseInt(String.valueOf(imei.charAt(i))) * 2;
                sum += j * 10 + Math.round(j / 10);
            } else
                sum += Integer.parseInt(String.valueOf(imei.charAt(i)));
        }
        return Math.abs((100 - sum) % 10);
    }
}
