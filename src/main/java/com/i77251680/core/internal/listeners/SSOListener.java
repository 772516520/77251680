package com.i77251680.core.internal.listeners;

import com.i77251680.Client;
import com.i77251680.constants.Constants;
import com.i77251680.core.client.Sig;
import com.i77251680.core.codec.jce.Jce;
import com.i77251680.core.codec.protobuf.Pb;
import com.i77251680.core.codec.protobuf.Proto;
import com.i77251680.entity.packet.sso.SSO;
import com.i77251680.event.EventListener;
import com.i77251680.network.highway.BigData;
import com.i77251680.utils.IP;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SSOListener {
    private SSOListener(Client client) {
        EventListener.on("internal.sso", (SSO sso) -> {
            switch (sso.cmd) {
                case "StatSvc.ReqMSFOffline":
                case "MessageSvc.PushForceOffline": {
                    Map<Object, Object> nested = Jce.decodeWrapper(sso.payload);
                    String msg = nested.containsKey(4) ? "[" + nested.get(4) + "]" + nested.get(3) : "[" + nested.get(1) + "]" + nested.get(2);
                    EventListener.broadcastEvent("internal.kickoff", msg);
                    break;
                }
                case "QualityTest.PushList":
                case "OnlinePush.SidTicketExpired": {
                    client.writeUni(sso.cmd, Constants.BUF0, Sig.seq);
                    break;
                }
                case "ConfigPushSvc.PushReq": {
                    try {
                        byte[] payload = sso.payload;
                        if (payload[0] == 0)
                            payload = Arrays.copyOfRange(payload, 4, payload.length);
                        Map<Object, Object> nested = Jce.decodeWrapper(payload);
                        if (nested.get(1).equals(2) && nested.get(2) instanceof byte[]) {
                            byte[] buf = (byte[]) ((Map) Jce.decode((byte[]) nested.get(2)).get(5)).get(5);
                            Proto decoded = (Proto) Pb.decode(buf).get(1281);
                            BigData.sig_session = (byte[]) decoded.get(1);
                            BigData.session_key = (byte[]) decoded.get(2);
                            for (Object o : (List) decoded.get(3)) {
                                Proto v = (Proto) o;
                                if (v.get(1).equals(10L)) {
                                    BigData.port = ((Long) ((Proto) ((List) v.get(2)).get(0)).get(3)).intValue();
                                    BigData.ip = IP.convertIP((Long) ((Proto) ((List) v.get(2)).get(0)).get(2));
                                }
                            }
                        }
                    } catch (Exception exception) {
                        System.out.println("ahjhgajgbjabuhugyg");
                    }
                }
            }
        });
    }

    public static void listen(Client client) {
        new SSOListener(client);
    }
}