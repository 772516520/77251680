package com.i77251680.core.codec.jce;

import com.i77251680.entity.Jce.JceElement;
import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class Jce {
    public static byte[] encodeWrapper(byte[] v, String serverPush, String cmd) throws IOException {
        List<Object> list = new ArrayList<>();
        List<Object> list_ = new ArrayList<>();
        Map<Object, Object> JceMap = new HashMap<>();
        JceMap.put(cmd, v);
        list_.add(JceMap);
        list.add(null);
        list.add((byte) 3);
        list.add(0);
        list.add(0);
        list.add((byte) 0);
        list.add(serverPush);
        list.add(cmd);
        list.add(JceStruct.encode(list_));
        list.add(0);
        list.add(new HashMap<>());
        list.add(new HashMap<>());
        return JceStruct.encode(list);
    }

    public static byte[] encodeWrapper(byte[] v, String serverPush, String cmd, byte reqid) throws IOException {
        List<Object> list = new ArrayList();
        List<Object> list_ = new ArrayList();
        Map<Object, Object> JceMap = new HashMap<>();
        JceMap.put(cmd, v);
        list_.add(JceMap);
        list.add(null);
        list.add((byte) 3);
        list.add(0);
        list.add(0);
        list.add(reqid);
        list.add(serverPush);
        list.add(cmd);
        list.add(JceStruct.encode(list_));
        list.add(0);
        list.add(new HashMap<>());
        list.add(new HashMap<>());
        return JceStruct.encode(list);
    }

    public static byte[] encodeStruct(List list) throws IOException {
        List<NestedStruct> encodeList = new ArrayList<>();
        encodeList.add(JceStruct.encodeNested(list));
        return JceStruct.encode(encodeList);
    }

    public static void decodeWrapper(byte[] encoded) {
        ByteBuf buf = wrappedBuffer(encoded);
    }

    public static Map<Object, Object> decode(byte[] encoded) {
        Map<Object, Object> decoded = new HashMap<>();
        ByteBuf buf = wrappedBuffer(encoded);
        while (buf.isReadable()) {
            JceElement jceElement = JceReader.readElement(buf);
            decoded.put(jceElement.tag, jceElement.value);
        }
        return decoded;
    }
}
