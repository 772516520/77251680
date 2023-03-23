package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.event.EventListener;

public class KickoffListener {
    private KickoffListener(Client client) {
        EventListener.on("internal.kickoff", (String msg) -> {
            System.err.println(msg);
            client.terminate();
            client.setOnline(false);
            EventListener.broadcastEvent("system.offline.kickoff", msg);
        });
    }

    public static void listen(Client client) {
        new KickoffListener(client);
    }
}
