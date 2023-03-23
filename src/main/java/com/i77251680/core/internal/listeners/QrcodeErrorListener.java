package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.event.EventListener;
import com.i77251680.event.events.QrcodeErrorEvent;

public class QrcodeErrorListener {
    private QrcodeErrorListener(Client client) {
        EventListener.addListener("internal.error.qrcode", (QrcodeErrorEvent qrcodeErrorEvent) -> {
            System.out.println("二维码扫码遇到错误: " + qrcodeErrorEvent.retcode + " (" + qrcodeErrorEvent.msg + ")");
            System.out.println("二维码已更新");
            client.login();
        });
    }

    public static void listen(Client client) {
        new QrcodeErrorListener(client);
    }
}
