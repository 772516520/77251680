package com.i77251680.event;

public class Listeners<T> {
    private String name;
    private Listener<T> listener;
    private boolean isOnce;

    private Listeners(String name, Listener<T> listener, boolean isOnce) {
        this.name = name;
        this.listener = listener;
        this.isOnce = isOnce;
    }

    public static <V> Listeners<V> add(String name, Listener<V> listener) {
        return new Listeners<>(name, listener, false);
    }

    public static <V> Listeners<V> once(String name, Listener<V> listener) {
        return new Listeners<>(name, listener, true);
    }

    public String getName() {
        return name;
    }

    public boolean isOnce() {
        return isOnce;
    }

    public Listener<T> getListener() {
        return listener;
    }
}
