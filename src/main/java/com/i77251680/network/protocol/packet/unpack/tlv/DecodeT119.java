package com.i77251680.network.protocol.packet.unpack.tlv;

import com.i77251680.core.client.Sig;
import com.i77251680.crypto.md5.Md5Crypto;
import com.i77251680.crypto.tea.Tea;
import com.i77251680.entity.packet.sso.T119;
import com.i77251680.utils.ArrayUtils;
import io.netty.buffer.ByteBuf;

import java.util.Arrays;
import java.util.Map;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class DecodeT119 {
    public static T119 decode(ByteBuf t119) {
        ByteBuf r = wrappedBuffer(new Tea().decrypt(t119.array(), Sig.tgtgt));
        r.readShort();
        Map<Integer, ByteBuf> t = ReadTlv.read(r);
        Sig.tgt = t.get(0x10a).array();
        Sig.sKey = t.get(0x120).array();
        Sig.d2 = t.get(0x143).array();
        Sig.d2Key = t.get(0x305).array();
        Sig.tgtgt = Md5Crypto.encrypt(Sig.d2Key);
        byte[] token = ArrayUtils.concat(Sig.d2Key, Sig.d2, Sig.tgt);
        ByteBuf t11a = t.get(0x11a);
        byte[] t11a_ = t11a.array();
        t11a.readShort();
        int age = t11a.readByte();
        int gender = t11a.readByte();
        String nickname = new String(Arrays.copyOfRange(t11a_, 5, t11a_.length));
        return T119.set(age, gender, nickname);
    }
}
