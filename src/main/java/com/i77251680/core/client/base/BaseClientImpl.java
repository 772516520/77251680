package com.i77251680.core.client.base;

public abstract class BaseClientImpl implements BaseClient {
    @Override
    public abstract void sendPkt(byte[] pkt);

    @Override
    public abstract void sendLogin(String cmd, byte[] body);

    @Override
    public abstract void sendLogin(String cmd, byte[] body, int type);
}
