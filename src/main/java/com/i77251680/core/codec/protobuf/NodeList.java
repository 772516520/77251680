package com.i77251680.core.codec.protobuf;

import java.util.ArrayList;
import java.util.List;

public class NodeList<T> {
    private final List<T> list;

    private NodeList() {
        list = new ArrayList<>();
    }

    public static <E> NodeList<E> builder() {
        return new NodeList<>();
    }

    public NodeList<T> add(T val) {
        list.add(val);
        return this;
    }

    public List<T> build() {
        return list;
    }
}
