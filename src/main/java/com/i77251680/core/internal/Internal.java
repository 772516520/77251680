package com.i77251680.core.internal;

import com.i77251680.App;
import com.i77251680.core.codec.jce.Jce;
import com.i77251680.core.codec.protobuf.D50;
import com.i77251680.network.protocol.packet.login.BuildLoginPacket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Internal {
    private static final byte[] d50;

    static {
        try {
            d50 = new D50().pack();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadFriendList(App app) {
        Set<Long> set = new HashSet<>();
        int start = 0, limit = 100;
        List<Object> FL = new ArrayList<>();
        List<Object> constantsList = new ArrayList<>();
        constantsList.add((short) 13580);
        constantsList.add((short) 13581);
        constantsList.add((short) 13582);
        FL.add((byte) 3);
        FL.add((byte) 1);
        FL.add(app.uin);
        FL.add(start);
        FL.add((byte) limit);
        FL.add(0);
        FL.add((byte) 1);
        FL.add(0);
        FL.add(0);
        FL.add(0);
        FL.add((byte) 1);
        FL.add((byte) 31);
        FL.add(null);
        FL.add(0);
        FL.add(0);
        FL.add(0);
        FL.add(d50);
        FL.add(null);
        FL.add(null);
        FL.add(constantsList);
        while (true) {
            try {
                byte[] FL_ = Jce.encodeStruct(FL);
                byte[] body = Jce.encodeWrapper(FL_, "mqq.IMService.FriendListServiceServantObj", "GetFriendListReq");
                byte[] pkt = BuildLoginPacket.build("StatSvc.register", body, app.uin, app.platform.subid, app.fullDevice.imei);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
