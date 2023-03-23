package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.event.EventListener;
import com.i77251680.event.events.InternalVerify;

public class VerifyListener {
    private VerifyListener(Client client) {
        EventListener.addListener("internal.verify", (InternalVerify __) -> {
            System.out.println("收到登录保护，只需验证一次便长期有效, 可以访问URL验证或发短信验证. 访问URL完成验证后调用login(password)可直接登录. 发短信验证需要调用sendSMSCode()和submitSMSCode()方法");
            System.out.println("登录保护验证URL：" + __.url.replace("verify", "qrcode"));
            System.out.println("密保手机号：" + __.phone);
            EventListener.broadcastEvent("system.login.device", __);
        });
    }

    public static void listen(Client client) {
        new VerifyListener(client);
    }
}
