package com.i77251680;

import com.i77251680.core.client.BaseClient;
import com.i77251680.core.client.Sig;
import com.i77251680.core.codec.protobuf.Node;
import com.i77251680.core.codec.protobuf.Pb;
import com.i77251680.core.internal.Internal;
import com.i77251680.core.internal.listeners.RegisterListeners;
import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.entity.config.Config;
import com.i77251680.entity.contacts.StrangerInfo;
import com.i77251680.entity.contacts.friend.FriendInfo;
import com.i77251680.entity.contacts.group.GroupInfo;
import com.i77251680.entity.contacts.group.MemberInfo;
import com.i77251680.entity.enums.Gender;
import com.i77251680.entity.enums.OnlineStatus;
import com.i77251680.event.EventListener;
import com.i77251680.event.Listener;
import com.i77251680.event.events.InternalVerify;
import com.i77251680.event.events.LoginError;
import com.i77251680.message.Message;
import com.i77251680.network.async.Task;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Client extends BaseClient {
    public final Long uin;
    public int age;
    public Gender sex = Gender.unknown;
    public String nickname = null;
    public OnlineStatus onlineStatus = OnlineStatus.EMPTY;
    private byte[] md5pass = null;
    public byte[] sync_cookie;
    /**
     * FriendList
     */
    public final Map<Long, FriendInfo> fl = new HashMap<>();
    /**
     * StrangerList
     */
    public final Map<Long, StrangerInfo> sl = new HashMap<>();
    /**
     * GroupList
     */
    public final Map<Long, GroupInfo> gl = new HashMap<>();
    /**
     * GroupMemberCache
     */
    public final Map<Long, Map<Long, MemberInfo>> gml = new HashMap<>();
    /**
     * blackList
     */
    public final Set<Long> blackList = new HashSet<>();
    /**
     * FriendClasses
     */
    public final Map<Integer, String> classes = new HashMap<>();

    public Client(Long uin, Config config) {
        super(uin, config);
        this.uin = uin;
        RegisterListeners.register(this);
    }

    /**
     * 扫码登录
     */
    public void login() {
        if (!(md5pass == null)) {
            passwordLogin(md5pass);
            return;
        }
        if (Sig.qrsig.length > 0) {
            qrcodeLogin();
        } else {
            fetchQrcode();
        }
    }

    /**
     * 密码登录
     *
     * @param password 密码
     */
    public void login(String password) {
        if (md5pass == null) {
            md5pass = Md5Crypto.encrypt(password);
        }
        passwordLogin(md5pass);
    }

    public void login(String password, boolean allowSlider) {
        byte[] md5pass = Md5Crypto.encrypt(password);
        passwordLogin(md5pass, allowSlider);
    }

    public void login(byte[] password) {
        passwordLogin(password);
    }

    private void tokenLogin() {
        File file = new File("");
        tokenLogin(new byte[]{});
    }

    /**
     * 发送短信验证码
     */
    public void sendSMSCode() {
        super.sendSMSCode();
    }

    /**
     * 提交短信验证码
     *
     * @param code 短信验证码
     */
    public void submitSMSCode(String code) {
        submitSmsCode(code);
    }

    public void submitSlider(String ticket) {
        super.submitSlider(ticket);
    }

    public boolean setOnlineStatus(OnlineStatus onlineStatus) {
        return Internal.setStatus(this, onlineStatus);
    }

    public void reloadFriendList() {
        Internal.loadFL(this);
    }

    public void reloadGroupList() {
        Internal.loadGL(this);
    }

    public void reloadStrangerList() {
        Internal.loadSL(this);
    }

    public void reloadBlackList() {
        Internal.loadBL(this);
    }

    public Task<?> sendOidb(String cmd, byte[] pkt) {
        String[] sp = cmd.replace("OidbSvc.", "")
                .replace("oidb_", "")
                .split("_");
        int type1 = Integer.parseInt(sp[0].replace("0x", ""), 16);
        int type2;
        try {
            type2 = Integer.parseInt(sp[1].replace("0x", ""));
        } catch (Exception e) {
            type2 = 1;
        }
        pkt = Pb.encode(Node.builder()
                .put(1, type1)
                .put(2, type2)
                .put(3, 0)
                .put(4, pkt)
                .put(6, "android" + this.platform.ver)
                .build()
        );
        return this.sendUni(cmd, pkt);
    }

    public <T> Client on(String name, Listener<T> listener) {
        EventListener.addListener(name, listener);
        return this;
    }

    public <T> Client off(String name, Listener<T> listener) {
        EventListener.removeListener(name, listener);
        return this;
    }

    public <T> Client broadcast(String name, T event) {
        EventListener.broadcastEvent(name, event);
        return this;
    }

    public Client onOline(Listener<Void> listener) {
        EventListener.addListener("system.online", listener);
        return this;
    }

    public Client onCaptcha(Listener<String> listener) {
        EventListener.addListener("system.login.slider", listener);
        return this;
    }

    public Client onQRCode(Listener<?> listener) {
        EventListener.addListener("system.login.qrcode", listener);
        return this;
    }

    public Client onDeviceLock(Listener<InternalVerify> listener) {
        EventListener.addListener("system.login.device", listener);
        return this;
    }

    public Client onLoginError(Listener<LoginError> listener) {
        EventListener.addListener("system.login.error", listener);
        return this;
    }

    public Client onGroupMsg(Listener<Message> listener) {
        EventListener.addGroupListener(listener);
        return this;
    }
}
