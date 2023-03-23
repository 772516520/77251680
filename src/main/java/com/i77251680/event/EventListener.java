package com.i77251680.event;

import com.i77251680.entity.packet.sso.SSO;
import com.i77251680.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EventListener {
    private static final ExecutorService pool = new ThreadPoolExecutor(10, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
    private static List<Listeners> ssoListener = new ArrayList<>();
    private static List<Listeners> groupMsgListener = new ArrayList<>();
    private static List<Listeners> privateMsgListener = new ArrayList<>();
    private static List<Listeners> listeners = new ArrayList<>();

    public static <T extends Message> void addGroupListener(Listener<T> listener) {
        groupMsgListener.add(Listeners.add("message.group", listener));
    }

    static <T extends Event> void addPrivateMsgListener(Listener<T> listener) {
        privateMsgListener.add(Listeners.add("message.private", listener));
    }

    public static void broadcastSSO(SSO event) {
        ssoListener.forEach(l -> {
            l.getListener().accept(event);
            checkOnce("internal.sso", l);
        });
    }

    public static void broadcastGroupMsg(Message event) {
        groupMsgListener.forEach(l -> {
            pool.execute(() -> {
                l.getListener().accept(event);
                checkOnce("message.group", l);
            });
        });
    }

    public static void broadcastPrivateMsg(Message event) {
        privateMsgListener.forEach(l -> {
            pool.execute(() -> {
                l.getListener().accept(event);
                checkOnce("message.private", l);
            });
        });
    }

    public static <T> void on(String name, Listener<T> listener) {
        if (name.equals("message.group"))
            groupMsgListener.add(Listeners.add(name, listener));
        else if (name.equals("message.private"))
            privateMsgListener.add(Listeners.add(name, listener));
        else if (name.equals("internal.sso"))
            ssoListener.add(Listeners.add(name, listener));
        else
            addListener(name, listener);
    }

    public static <T> void once(String name, Listener<T> listener) {
        if (name.equals("message.group"))
            groupMsgListener.add(Listeners.once(name, listener));
        else if (name.equals("message.private"))
            privateMsgListener.add(Listeners.once(name, listener));
        else if (name.equals("internal.sso"))
            ssoListener.add(Listeners.once(name, listener));
        else
            listeners.add(Listeners.once(name, listener));

    }

    public static <T> void off(String name, Listener<T> listener) {
        removeListener(name, listener);
    }

    public static <T> void addListener(String name, Listener<T> listener) {
        listeners.add(Listeners.add(name, listener));
    }

    public static <T> void broadcastEvent(String name, T event) {
        listeners.forEach(l -> {
            if (l.getName().equals(name)) pool.execute(() -> {
                l.getListener().accept(event);
                checkOnce(name, l);
            });
        });
    }

    private static void checkOnce(String name, Listeners l) {
        if (l.isOnce()) removeListener(name, l.getListener());
    }

    public static void removeListener(String name, Listener listener) {
        if (name.equals("message.group"))
            groupMsgListener.forEach(ls -> {
                if (ls.getListener().equals(listener))
                    groupMsgListener.remove(listener);
            });
        else if (name.equals("message.private"))
            privateMsgListener.forEach(ls -> {
                if (ls.getListener().equals(listener))
                    privateMsgListener.remove(listener);
            });
        else if (name.equals("internal.sso"))
            ssoListener.forEach(ls -> {
                if (ls.getListener().equals(listener))
                    ssoListener.remove(listener);
            });
        else
            listeners.forEach(ls -> {
                if (ls.getListener().equals(listener))
                    listeners.remove(ls);
            });
    }

}
