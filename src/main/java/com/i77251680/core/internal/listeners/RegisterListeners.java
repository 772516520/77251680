package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.handler.PrivateMessageHandler;
import com.i77251680.network.protocol.packet.decoder.PbGetMsgResponse;

public class RegisterListeners {
    public static void register(Client client) {
        OnlineListener.listen(client);
        LoginErrorListener.listen(client);
        VerifyListener.listen(client);
        SliderListener.listen(client);
        QrcodeListener.listen(client);
        QrcodeErrorListener.listen(client);
        KickoffListener.listen(client);
        SSOListener.listen(client);
        MessageListeners.listen(client);
        PbGetMsgResponse.register(client);
        PrivateMessageHandler.handle(client);
    }
}
