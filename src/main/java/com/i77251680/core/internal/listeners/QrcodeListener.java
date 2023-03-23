package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.event.EventListener;
import com.i77251680.event.Listener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QrcodeListener {
    private QrcodeListener(Client client) {
        EventListener.addListener("internal.qrcode", (Listener<byte[]>) img -> {
            try {
                File file = new File(client.config.data_dir + "qrcode.png");
                FileOutputStream out = new FileOutputStream(file);
                out.write(img);
                out.close();
                System.out.println("二维码已保存到" + file.getAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            EventListener.broadcastEvent("system.login.qrcode", img);
        });
    }

    public static void listen(Client client) {
        new QrcodeListener(client);
    }
}