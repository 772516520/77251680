package com.i77251680.network.protocol.packet;

public class Packet {
    public final String cmd;
    public final int seq;
    public final byte[] payload;

    public Packet(String cmd, int seq, byte[] payload) {
        this.cmd = cmd;
        this.seq = seq;
        this.payload = payload;
    }

}
