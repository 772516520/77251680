package com.i77251680.core.client.base;

import com.i77251680.network.async.Task;

public abstract class BaseClientImpl implements BaseClient {
    @Override
    public abstract Task<?> sendPkt(byte[] pkt);
}
