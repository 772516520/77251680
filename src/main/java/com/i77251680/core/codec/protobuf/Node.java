package com.i77251680.core.codec.protobuf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private final Map<Integer, Object> map;
    private final List<Object> list;

    private Node() {
        map = new LinkedHashMap<>();
        list = new ArrayList<>();
    }

    public static Node builder() {
        return new Node();
    }

    public Map<Integer, Object> build() {
        return map;
    }

    public Node put(Integer k, Object v) {
        if (map.containsKey(k)) add(k, v);
        else map.put(k, v);
        return this;
    }

    private void add(Integer k, Object v) {
        if (!(map.get(k) instanceof List)) {
            Object value = map.get(k);
            map.replace(k, list);
            list.add(value);
        }
        list.add(v);
    }
}
