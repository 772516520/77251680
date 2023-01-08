package com.i77251680.network.protocol.packet.unpack.login;

import com.i77251680.constants.Constants;
import com.i77251680.core.client.Sig;
import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.device.FullDevice;
import com.i77251680.event.GlobalEventListener;
import com.i77251680.network.protocol.packet.unpack.tlv.DecodeT119;
import com.i77251680.network.protocol.packet.unpack.tlv.ReadTlv;
import com.i77251680.utils.ArrayUtils;
import com.i77251680.utils.Utils;
import io.netty.buffer.ByteBuf;

import java.util.Arrays;
import java.util.Map;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class DecodeLoginResponse {
    public static int decode(byte[] payload, FullDevice fullDevice) {
        payload = new Tea().decrypt(Arrays.copyOfRange(payload, 16, payload.length - 1), Sig.shareKey);
        ByteBuf buf = wrappedBuffer(payload);
        buf.readShort();
        int type = buf.readByte() & 0xff;
        System.out.println("type - " + type);
        buf.readShort();
        Map<Integer, ByteBuf> t = ReadTlv.read(buf);
        if (type == 0) {
            Sig.t104 = Constants.BUF0;
            Sig.t174 = Constants.BUF0;
            DecodeT119.decode(t.get(0x119));
            return 0;
        }
        if (type == 15 || type == 16) {
            GlobalEventListener.getGlobalPublisher().broadcast("internal.error.token", "token失效");
        }
        if (type == 2) {
            Sig.t104 = t.get(0x104).array();
            if (t.containsKey(0x192)) {
                System.out.println("滑块验证");
                GlobalEventListener.getGlobalPublisher().broadcast("system.verify.slider", new String(t.get(0x192).array()));
            }
            GlobalEventListener.getGlobalPublisher().broadcast("internal.login.error", "[type " + type + "]" + "登录失败, 未知格式的验证码");
            return 2;
        }
        if (type == 160) {
            if (!t.containsKey(0x204) && !t.containsKey(0x174)) {
                System.out.println("已发送验证码");
                return 160;
            }
            if (t.containsKey(0x402)) {
                byte[] dpwd = Utils.randomBytes(16);
                Sig.t402 = t.get(0x402).array();
                Sig.G = Md5Crypto.encrypt(ArrayUtils.concat(fullDevice.guid, dpwd, Sig.t402));
            }
            if (t.containsKey(0x403))
                Sig.t403 = t.get(0x403).array();
            String phone;
            if (t.containsKey(0x174) && t.containsKey(0x178)) {
                Sig.t104 = t.get(0x104).array();
                Sig.t174 = t.get(0x174).array();
                phone = new String(t.get(0x178).array());
                System.out.println(phone);
            }
            GlobalEventListener.getGlobalPublisher().broadcast("system.verify", t.containsKey(0x204) ? new String(t.get(0x204).array()) : "");
            return 160;
        }
        if (t.containsKey(0x149)) {
            ByteBuf stream = t.get(0x149);
            stream.readShort();
            return -2;
        }
        if (t.containsKey(0x146)) {
            ByteBuf r = t.get(0x146);
            int version = r.readInt();
            int length;
            byte[] bytes = new byte[2];
            byte[] b;
            r.readBytes(bytes);
            length = wrappedBuffer(bytes).readShort();
            b = new byte[length];
            // 奇怪的登录失败原因
            System.out.println("[type: " + type + "]" + new String(r.readBytes(b).array()));
            return -1;
        }
        return -1;
    }
}
