package com.i77251680.core.client.base;

import com.i77251680.network.async.Task;

public interface BaseClient {
    Task<?> sendPkt(byte[] pkt);
}
