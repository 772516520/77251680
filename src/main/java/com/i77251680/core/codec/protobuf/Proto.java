package com.i77251680.core.codec.protobuf;

import java.util.Map;

public class Proto {
    public byte[] encoded;
    public Map node;

    public Proto(byte[] encoded) {
        this.encoded = encoded;
        this.node = Node.builder().build();
    }

    public Proto(byte[] encoded, Object proto) {
        this.encoded = encoded;
        if (proto == null) return;
        this.node = (Map) proto;
    }

    public Object get(int... v) {
        Object r = node.get(v[0]);
        int i = 0;
        while (i < v.length - 1) {
            ++i;
            r = ((Proto) r).get(v[i]);
        }
        return r;
    }

    public byte[] getEncoded(int... v) {
        byte[] r = ((Proto) node.get(v[0])).encoded;
        int i = 0;
        while (i < v.length - 1) {
            ++i;
            r = ((Proto) node.get(i)).encoded;
        }
        return r;
    }

    public void put(int k, Object v) {
        node.put(k, v);
    }
}
