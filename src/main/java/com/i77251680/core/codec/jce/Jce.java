package com.i77251680.core.codec.jce;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.*;

import static io.netty.buffer.Unpooled.wrappedBuffer;

public class Jce {
    public static byte[] encodeWrapper(byte[] v, String serverPush, String fun) throws IOException {
        List<Object> list = new ArrayList<>();
        List<Object> list_ = new ArrayList<>();
        Map<Object, Object> JceMap = new HashMap<>();
        JceMap.put(fun, v);
        list_.add(JceMap);
        list.add(null);
        list.add((byte) 3);
        list.add(0);
        list.add(0);
        list.add((byte) 0);
        list.add(serverPush);
        list.add(fun);
        list.add(JceStruct.encode(list_));
        list.add(0);
        list.add(new HashMap<>());
        list.add(new HashMap<>());
        return JceStruct.encode(list);
    }

    public static byte[] encodeWrapper(byte[] v, String serverPush, String fun, byte reqid) throws IOException {
        List<Object> list = new ArrayList();
        List<Object> list_ = new ArrayList();
        Map<Object, Object> JceMap = new HashMap<>();
        JceMap.put(fun, v);
        list_.add(JceMap);
        list.add(null);
        list.add((byte) 3);
        list.add(0);
        list.add(0);
        list.add(reqid);
        list.add(serverPush);
        list.add(fun);
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

    public static Map<Object, Object> decodeWrapper(byte[] encoded) {
        Map<Object, Object> wrapper = decode(encoded);
        Map<Object, Object> map = (Map) decode((byte[]) wrapper.get(7)).get(0);
        Set<Object> keys = map.keySet();
        Object nested = map.get(keys.iterator().next());
        if (!(nested instanceof byte[])) {
            keys = ((Map) nested).keySet();
            nested = ((Map) nested).get(keys.iterator().next());
        }
        return (Map) decode((byte[]) nested).get(0);
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
