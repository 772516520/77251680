package com.i77251680.network.protocol.packet.unpack.login;

import com.i77251680.constants.Constants;
import com.i77251680.core.client.Sig;
import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.entity.packet.sso.T119;
import com.i77251680.event.EventListener;
import com.i77251680.event.events.InternalVerify;
import com.i77251680.event.events.LoginError;
import com.i77251680.network.protocol.packet.unpack.tlv.DecodeT119;
import com.i77251680.network.protocol.packet.unpack.tlv.ReadTlv;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.Random;
import io.netty.buffer.ByteBuf;

import java.util.Arrays;
import java.util.Map;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class DecodeLoginResponse {
    public static T119 decode(byte[] payload, FullDevice fullDevice) {
        payload = new Tea().decrypt(Arrays.copyOfRange(payload, 16, payload.length - 1), Sig.shareKey);
        ByteBuf buf = wrappedBuffer(payload);
        buf.readShort();
        int type = buf.readByte() & 0xff;
        buf.readShort();
        Map<Integer, ByteBuf> t = ReadTlv.read(buf);
        if (type == 0) {
            Sig.t104 = Constants.BUF0;
            Sig.t174 = Constants.BUF0;
            T119 t119 = DecodeT119.decode(t.get(0x119));
            return t119;
        }
        if (type == 15 || type == 16) {
            EventListener.broadcastEvent("internal.error.login", null);
            return null;
        }
        if (type == 2) {
            Sig.t104 = t.get(0x104).array();
            if (t.containsKey(0x192)) {
                EventListener.broadcastEvent("internal.slider", new String(t.get(0x192).array()));
                return null;
            }
            EventListener.broadcastEvent("internal.error.login", LoginError.set(type, "登录失败, 未知格式的验证码"));
            return null;
        }
        if (type == 160) {
            if (!t.containsKey(0x204) && !t.containsKey(0x174)) {
                System.out.println("已向密保手机发送短信验证码");
                return null;
            }
            if (t.containsKey(0x402)) {
                byte[] dpwd = Random.randomBytes(16);
                Sig.t402 = t.get(0x402).array();
                Sig.g = Md5Crypto.encrypt(ArrayUtils.concat(fullDevice.guid, dpwd, Sig.t402));
            }
            if (t.containsKey(0x403))
                Sig.t403 = t.get(0x403).array();
            String phone = null;
            if (t.containsKey(0x174) && t.containsKey(0x178)) {
                Sig.t104 = t.get(0x104).array();
                Sig.t174 = t.get(0x174).array();
                phone = new String(t.get(0x178).array());
            }
            EventListener.broadcastEvent("internal.verify", InternalVerify.set(t.containsKey(0x204) ? new String(t.get(0x204).array()) : "", phone));
            return null;
        }
        if (t.containsKey(0x149)) {
            ByteBuf r = t.get(0x149);
            r.readShort();
            byte[] title_ = new byte[r.readUnsignedShort()];
            r.readBytes(title_);
            String title = new String(title_);
            byte[] content_ = new byte[r.readUnsignedShort()];
            r.readBytes(content_);
            String content = new String(content_);
            EventListener.broadcastEvent("internal.error.login", LoginError.set(type, "[" + title + "] " + content));
            return null;
        }
        if (t.containsKey(0x146)) {
            ByteBuf r = t.get(0x146);
            int version = r.readInt();
            byte[] title_ = new byte[r.readUnsignedShort()];
            r.readBytes(title_);
            String title = new String(title_);
            byte[] content_ = new byte[r.readUnsignedShort()];
            r.readBytes(content_);
            String content = new String(content_);
            // 奇怪的登录失败原因
            EventListener.broadcastEvent("internal.error.login", LoginError.set(type, "[" + title + "] " + content));
            return null;
        }
        System.out.println(new String(payload));
        EventListener.broadcastEvent("internal.error.login", LoginError.set(type, "[登陆失败]未知错误"));
        return null;
    }
}
