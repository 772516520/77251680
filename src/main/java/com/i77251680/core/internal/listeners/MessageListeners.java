package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.core.codec.jce.Jce;
import com.i77251680.entity.packet.sso.SSO;
import com.i77251680.event.EventListener;
import com.i77251680.handler.MessageHandler;

public class MessageListeners {
    private MessageListeners(Client client) {
        EventListener.on("internal.sso", (SSO sso) -> {
            String cmd = sso.cmd;
            int seq = sso.seq;
            byte[] payload = sso.payload;
            int type = (int) Jce.decodeWrapper(payload).get(5);
            switch (type) {
                case 33: //群员入群
                case 38: //建群
                case 85: //群申请被同意
                case 141: //陌生人
                case 166: //好友
                case 167: //单向好友
                case 208: //好友语音
                case 529: //离线文件
                    MessageHandler.handleMessage(client);
                case 84: //群请求
                case 87: //群邀请
                case 525: //群请求(来自群员的邀请)
                case 187: //好友请求
                case 191: //单向好友增加
                case 528: //黑名单同步
                    client.reloadBlackList();
            }
        });
    }

    public static void listen(Client client) {
        new MessageListeners(client);
    }

}
