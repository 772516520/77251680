package com.i77251680.core.client.base;

public interface BaseClient {
    void sendPkt(byte[] pkt);

    void sendLogin(String cmd, byte[] body);

    void sendLogin(String cmd, byte[] body, int type);
}
