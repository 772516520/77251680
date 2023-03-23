package com.i77251680.core.internal.listeners;

import com.i77251680.Client;

public class GroupMsgListener {

    public static void listen(Client client, byte[] payload, int seq) {
        ++client.setStat().recv_msg_cnt;
        if (client.sync_cookie == null) return;


    }
}
