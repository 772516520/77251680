package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.entity.enums.Gender;
import com.i77251680.entity.enums.OnlineStatus;
import com.i77251680.entity.packet.sso.T119;
import com.i77251680.event.EventListener;

public class OnlineListener {
    private OnlineListener(Client c) {
        EventListener.addListener("internal.login", (T119 __) -> {
            c.age = __.getAge();
            c.sex = Gender.getSex(__.getGender());
            c.nickname = __.getNickname();
            c.onlineStatus = c.onlineStatus.equals(OnlineStatus.EMPTY) ? OnlineStatus.Online : c.onlineStatus;
            c.setOnlineStatus(c.onlineStatus);
            System.out.printf("%s 正在加载资源...\n", c.nickname);
            try {
                c.reloadFriendList();
                c.reloadGroupList();
                c.reloadStrangerList();
                c.reloadBlackList();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.printf("加载了%d个好友 %d个群 %d个陌生人\n", c.fl.size(), c.gl.size(), c.sl.size());
            EventListener.broadcastEvent("system.online", null);
        });
    }

    public static void listen(Client client) {
        new OnlineListener(client);
    }
}
