package com.i77251680.entity.packet.sso;

public class SSO {
    public final String cmd;
    public final int seq;
    public final byte[] payload;

    public SSO(String cmd, int seq, byte[] payload) {
        this.cmd = cmd;
        this.seq = seq;
        this.payload = payload;
    }

}
