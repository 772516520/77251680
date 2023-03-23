package com.i77251680.network.protocol.packet.register;

import com.i77251680.core.codec.jce.Jce;
import com.i77251680.core.codec.protobuf.Node;
import com.i77251680.core.codec.protobuf.NodeList;
import com.i77251680.core.codec.protobuf.Pb;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.utils.Time;

import java.util.ArrayList;
import java.util.List;

public class BuildRegister {
    private static final byte[] pb_buf;

    static {
        pb_buf = Pb.encode(
                Node.builder()
                        .put(1, NodeList
                                .builder()
                                .add(Node.builder().put(1, 46).put(2, Time.timestamp()).build())
                                .add(Node.builder().put(1, 283).put(2, 0).build())
                                .build()
                        ).build()
        );
    }

    public static byte[] build(long uin, FullDevice d) {
        return pack(uin, false, d);
    }

    public static byte[] build(long uin, boolean logout, FullDevice d) {
        return pack(uin, logout, d);
    }

    private static byte[] pack(long uin, boolean logout, FullDevice d) {
        List<Object> list = new ArrayList<>();
        list.add(uin);
        list.add(logout ? 0 : 7);
        list.add(0); // kick pc
        list.add("");
        list.add(logout ? 21 : 11);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(logout ? 44 : 0);
        list.add(d.version.sdk);
        list.add(1);
        list.add("");
        list.add(0);
        list.add(null);
        list.add(d.guid);
        list.add(2052);
        list.add(0);
        list.add(d.model);
        list.add(d.model);
        list.add(d.version.release);
        list.add(1);
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
        list.add(1000);
        list.add(98);
        byte[] bytes = Jce.encodeStruct(list);
        return Jce.encodeWrapper(bytes, "SvcReqRegister", "PushService", "SvcReqRegister");
    }
}
