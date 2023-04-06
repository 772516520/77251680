package com.i77251680.core.internal;

import com.i77251680.Client;
import com.i77251680.constants.Constants;
import com.i77251680.core.client.Sig;
import com.i77251680.core.codec.jce.Jce;
import com.i77251680.core.codec.protobuf.Node;
import com.i77251680.core.codec.protobuf.Pb;
import com.i77251680.core.codec.protobuf.Proto;
import com.i77251680.entity.contacts.friend.FriendInfo;
import com.i77251680.entity.contacts.group.GroupInfo;
import com.i77251680.entity.enums.Gender;
import com.i77251680.entity.enums.OnlineStatus;
import com.i77251680.entity.enums.Platform;
import com.i77251680.network.protocol.device.FullDevice;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.Time;

import java.nio.ByteBuffer;
import java.util.*;

public class Internal {
    private static final byte[] d50;

    static {
        d50 = Pb.encode(
                Node.builder()
                        .put(1, 10002)
                        .put(91001, 1)
                        .put(101001, 1)
                        .put(151001, 1)
                        .put(181001, 1)
                        .put(251001, 1)
                        .build()
        );
    }

    public static boolean setStatus(Client client, OnlineStatus status) {
        if (client.platform.equals(Platform.Watch) || client.platform.equals(Platform.APad))
            return false;
        FullDevice d = client.fullDevice;
        List<Object> list = new ArrayList<>();
        list.add(client.uin);
        list.add(7);
        list.add(0);
        list.add("");
        list.add(status.getStatus());
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(46); // 46 ? [10]
        list.add(d.version.sdk);
        list.add(0);
        list.add("");
        list.add(0);
        list.add(null);
        list.add(d.guid);
        list.add(2052);
        list.add(0);
        list.add(d.model);
        list.add(d.model);
        list.add(d.version.release);
        list.add(1);
        list.add(177); // 177? [23]
        list.add(0);
        list.add(null);
        list.add(0);
        list.add(0);
        list.add("");
        list.add(0);
        list.add("");
        list.add("");
        list.add("");
        list.add(null);
        list.add(1);
        list.add(null);
        list.add(0);
        list.add(null);
        list.add(0);
        list.add(0);
        byte[] SvcReqRegister = Jce.encodeStruct(list);
        byte[] body = Jce.encodeWrapper(SvcReqRegister, "SvcReqRegister", "PushService", "SvcReqRegister");
        byte[] payload = client.sendUni("StatSvc.SetStatusFromClient", body).get();
        boolean ret = Jce.decodeWrapper(payload).get(9).equals(0);
        if (ret)
            client.onlineStatus = status;
        return ret;
    }

    public static void loadFL(Client client) {
        Set<Long> set = new HashSet<>();
        int start = 0, limit = 150;
        List<Object> FL = new ArrayList<>();
        List<Object> constantsList = new ArrayList<>();
        constantsList.add(13580);
        constantsList.add(13581);
        constantsList.add(13582);
        FL.add(3); // 0
        FL.add(1); // 1
        FL.add(client.uin); // 2
        FL.add(start); // 3
        FL.add(limit); // 4
        FL.add(0); // 5
        FL.add(1); // 6
        FL.add(0); // 7
//        FL.add(100); // 8
        FL.add(0); // 8
        FL.add(0); // 9
        FL.add(1); // 10
//        FL.add(33); // 11
        FL.add(31); // 11
        FL.add(null); // 12
        FL.add(0); // 13
        FL.add(0); // 14
        FL.add(0); // 15
        FL.add(d50); // 16
//        FL.add(new byte[0]); // 17
        FL.add(null); // 17
        FL.add(constantsList); // 18
        while (true) {
            byte[] FL_ = Jce.encodeStruct(FL);
            byte[] body = Jce.encodeWrapper(FL_, "FL", "mqq.IMService.FriendListServiceServantObj", "GetFriendListReq");
            byte[] payload = client.sendUni("friendlist.getFriendGroupList", body).get();
            Map<Object, Object> nested = Jce.decodeWrapper(payload);
            client.classes.clear();
            ((List) nested.get(14)).forEach((v) -> {
                Map<Object, Object> classes = (Map) v;
                client.classes.put(((int) classes.get(0)), (String) classes.get(1));
            });
            ((List) nested.get(7)).forEach((v) -> {
                Map<Integer, Object> fl = (Map) v;
                long uin = fl.get(0) instanceof Integer ? (Integer) fl.get(0) : (Long) fl.get(0);
                FriendInfo info = FriendInfo.set((int) fl.get(1), ((int) fl.get(31) == 1 ? Gender.male : Gender.female), (String) fl.get(3), (String) fl.get(14));
                client.fl.put(uin, info);
                set.add(uin);
            });
            start += limit;
            if (start > (int) nested.get(5)) break;
        }
        for (Map.Entry<Long, FriendInfo> entry : client.fl.entrySet()) {
            if (!set.contains(entry.getKey()))
                client.fl.remove(entry.getKey());
        }
    }

    public static void loadGL(Client client) {
        List<Object> list = new ArrayList<>();
        list.add(client.uin);
        list.add(0);
        list.add(null);
        list.add(new ArrayList<>());
        list.add(1);
        list.add(8);
        list.add(0);
        list.add(1);
        list.add(1);
        byte[] GetTroopListReqV2Simplify = Jce.encodeStruct(list);
        byte[] body = Jce.encodeWrapper(GetTroopListReqV2Simplify, "GetTroopListReqV2Simplify", "mqq.IMService.FriendListServiceServantObj", "GetTroopListReqV2Simplify");
        byte[] payload = client.sendUni("friendlist.GetTroopListReqV2", body).get();
        Map<Object, Object> nested = Jce.decodeWrapper(payload);
        Set<Long> set = new HashSet<>();
        ((List<Object>) nested.get(5)).forEach((v) -> {
            Map<Integer, Object> group = (Map) v;
            long gid = group.get(1) instanceof Long ? (Long) group.get(1) : (Integer) group.get(1);
            try {
                GroupInfo groupInfo = GroupInfo.setter()
                        .setGroup_id(gid)
                        .setGroup_name((String) group.get(4))
                        .setMember_count((int) group.get(19))
                        .setMax_member_count((int) group.get(29))
                        .setOwner_id(group.get(23) instanceof Long ? (Long) group.get(23) : (Integer) group.get(23))
                        .setLast_join_time(group.get(27) instanceof Long ? (Long) group.get(27) : (Integer) group.get(27))
                        .setShutUp_time_whole(group.get(9).equals(0) ? 0 : 0xffffffff)
                        .setShutUp_time_me((int) group.get(10) > Time.timestamp() ? (int) group.get(10) : 0)
                        .setAdmin_flag(group.get(11).equals(1))
                        .setUpdate_time(0);
                client.gl.put(gid, groupInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            set.add(gid);
        });
        for (Map.Entry<Long, GroupInfo> e : client.gl.entrySet()) {
            if (!set.contains(e.getKey())) {
                client.gl.remove(e.getKey());
            }
        }
    }

    public static void loadSL(Client client) {
        byte[] body = Pb.encode(Node.builder()
                .put(1, 1)
                .put(2, Node.builder()
                        .put(1, Sig.seq + 1)
                        .build()
                )
                .build()
        );
        byte[] payload = client.sendOidb("OidbSvc.0x5d2_0", body).get();
        Object pb = ((Proto) Pb.decode(payload).get(4)).get(2, 2);
        if (pb == null) return;
        throw new RuntimeException("SL not null");
    }

    public static void loadBL(Client client) {
        byte[] body = Pb.encode(Node.builder()
                .put(1, Node.builder()
                        .put(1, client.uin)
                        .put(3, 0)
                        .put(4, 1000)
                        .build())
                .build());
        ByteBuffer len = ByteBuffer.wrap(new byte[4]);
        len.putInt(body.length);
        body = ArrayUtils.concat(Constants.BUF4, len.array(), body);
        byte[] payload = client.sendUni("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList", body).get();
        List v = (List) ((Proto) Pb.decode(Arrays.copyOfRange(payload, 8, payload.length)).get(1)).get(6);
        client.blackList.clear();
        if (v == null) return;
        for (Proto _ : (List<Proto>) v) {
            client.blackList.add((Long) _.get(1));
        }
    }

}
