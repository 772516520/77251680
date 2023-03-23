package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.event.EventListener;
import com.i77251680.event.events.LoginError;
import com.i77251680.utils.timer.TimerTask;

public class LoginErrorListener {
    private LoginErrorListener(Client client) {
        EventListener.addListener("internal.error.login", (LoginError loginError) -> {
            if (loginError == null) {
                System.err.println("登录token过期");
                System.err.println("3秒后重新连接");
                new TimerTask(client::login).start(3000);
                return;
            }
            System.err.println(loginError.msg);
            EventListener.broadcastEvent("system.login.error", loginError);
        });
    }

    public static void listen(Client client) {
        new LoginErrorListener(client);
    }
}
