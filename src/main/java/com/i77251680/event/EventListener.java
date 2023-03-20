package com.i77251680.event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EventListener {
    private static final ExecutorService pool = new ThreadPoolExecutor(10, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
    private static List<Listener> groupMsgListener = new ArrayList<>();
    private static List<Listener> privateMsgListener = new ArrayList<>();
    private static List<Listeners> listeners = new ArrayList<>();

    public static <T extends Event> void addGroupListener(Listener<T> listener) {
        groupMsgListener.add(listener);
    }

    static <T extends Event> void addPrivateMsgListener(Listener<T> listener) {
        privateMsgListener.add(listener);
    }

    public static void broadcastGroupMsg(Event event) {
        groupMsgListener.forEach(listener -> {
            pool.execute(() -> listener.accept(event));
        });
    }

    public static void broadcastPrivateMsg(Event event) {
        privateMsgListener.forEach(listener -> {
            pool.execute(() -> listener.accept(event));
        });
    }

    public static <T> void addListener(String name, Listener<T> listener) {
        listeners.add(Listeners.add(name, listener));
    }

    public static <T> void broadcastEvent(String name, T event) {
        listeners.forEach(e -> {
            if (e.getName().equals(name)) pool.execute(() -> e.getListener().accept(event));
        });
    }
}
