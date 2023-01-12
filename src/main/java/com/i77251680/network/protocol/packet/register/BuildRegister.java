package com.i77251680.network.protocol.packet.register;

import com.i77251680.core.codec.jce.Jce;
import com.i77251680.core.codec.protobuf.Register;
import com.i77251680.entity.device.FullDevice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuildRegister {
    private static final byte[] pb_buf = Register.pack;

    public static byte[] build(long uin, FullDevice d) {
        return pack(uin, d, false);
    }

    public static byte[] build(long uin, FullDevice d, boolean logout) {
        return pack(uin, d, logout);
    }

    private static byte[] pack(long uin, FullDevice d, boolean logout) {
        List<Object> list = new ArrayList<>();
        list.add(uin);
        list.add(logout ? 0 : (byte) 7);
        list.add(0); // kick pc
        list.add("");
        list.add(logout ? (byte) 21 : (byte) 11);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(logout ? (byte) 44 : 0);
        list.add((byte) d.version.sdk);
        list.add((byte) 1);
        list.add("");
        list.add(0);
        list.add(null);
        list.add(d.guid);
        list.add((byte) 2052);
        list.add(0);
        list.add(d.model);
        list.add(d.model);
        list.add(d.version.release);
        list.add((byte) 1);
        list.add(0);
        list.add(0);
        list.add(null);
        list.add(0);
        list.add(0);
        list.add("");
        list.add(0);
        list.add(d.brand);
        list.add(d.brand);
        list.add("");
        list.add(pb_buf);
        list.add(0);
        list.add(null);
        list.add(0);
        list.add(null);
        list.add((byte) 1000);
        list.add((byte) 98);
        try {
            byte[] bytes = Jce.encodeStruct(list);
            return Jce.encodeWrapper(bytes, "PushService", "SvcReqRegister");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
