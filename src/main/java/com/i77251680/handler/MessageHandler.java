package com.i77251680.handler;

import com.i77251680.Client;
import com.i77251680.core.codec.protobuf.Node;
import com.i77251680.core.codec.protobuf.Pb;
import com.i77251680.network.protocol.sync.BuildSyncCookie;

public class MessageHandler {
    public static void handleMessage(Client client) {
        if (client.sync_cookie == null)
            client.sync_cookie = BuildSyncCookie.build();
        byte[] body = Pb.encode(Node.builder()
                .put(1, 0)
                .put(2, client.sync_cookie)
                .put(3, 0)
                .put(4, 20)
                .put(5, 3)
                .put(6, 1)
                .put(7, 1)
                .put(9, 0)
                .build());
        byte[] payload = client.sendUni("MessageSvc.PbGetMsg", body).get();
        client.broadcast("PbGetMessage", payload);
    }
}
