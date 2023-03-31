package com.i77251680.network.protocol.packet.uni;

import com.i77251680.core.client.BaseClient;
import com.i77251680.core.client.Sig;
import com.i77251680.core.writer.Writer;
import com.i77251680.crypto.tea.Tea;

import java.io.IOException;

public class BuildUniPkt {
    public static byte[] build(String cmd, byte[] body, long uin) {
        try {
            return pack(cmd, body, uin, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] build(String cmd, byte[] body, long uin, int seq) {
        try {
            return pack(cmd, body, uin, seq);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] pack(String cmd, byte[] body, long uin, int seq) throws IOException {
        seq = (seq == 0) ? BaseClient.next_seq() : seq;
        byte[] sso = new Writer()
                .writeInt(cmd.length() + 20)
                .writeWithLength(cmd)
                .writeInt(0x08)
                .writeBytes(Sig.session)
                .writeInt(0x0_4)
                .writeWithLength(body)
                .read();
        byte[] encrypted = new Tea().encrypt(sso, Sig.d2Key);
        String uin_ = String.valueOf(uin);
        return new Writer()
                .writeWithLength(
                        new Writer()
                                .writeInt(0x0B)
                                .writeByte(1)
                                .writeInt(seq)
                                .writeByte(0)
                                .writeWithLength(uin_)
                                .writeBytes(encrypted)
                                .read()
                )
                .read();
    }
}
