package com.i77251680.network.protocol.sync;

import com.i77251680.core.codec.protobuf.Node;
import com.i77251680.core.codec.protobuf.Pb;
import com.i77251680.utils.Time;

import java.util.Random;

public class BuildSyncCookie {
    public static byte[] build() {
        int time = Time.timestamp();
        return Pb.encode(Node.builder()
                .put(1, time)
                .put(2, time)
                .put(3, Integer.toUnsignedLong(new Random().nextInt()))
                .put(4, Integer.toUnsignedLong(new Random().nextInt()))
                .put(5, Integer.toUnsignedLong(new Random().nextInt()))
                .put(11, Integer.toUnsignedLong(new Random().nextInt()))
                .put(12, 0x1D)
                .put(13, time)
                .put(14, 0)
                .build());
    }
}
