package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.event.EventListener;

public class SliderListener {
    private SliderListener(Client client) {
        EventListener.addListener("internal.slider", (String url) -> {
            System.out.println("收到滑动验证码，请访问以下地址完成滑动，并从网络响应中取出ticket输入: " + url);
            EventListener.broadcastEvent("system.login.slider", url);
        });
    }

    public static void listen(Client client) {
        new SliderListener(client);
    }
}
