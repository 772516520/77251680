package com.i77251680.event;

public class Listeners<T> {
    private String name;
    private Listener<T> listener;

    private Listeners(String name, Listener<T> listener) {
        this.name = name;
        this.listener = listener;
    }

    public static <V> Listeners<V> add(String name, Listener<V> listener) {
        return new Listeners<>(name, listener);
    }

    public String getName() {
        return name;
    }

    public Listener<T> getListener() {
        return listener;
    }
}
