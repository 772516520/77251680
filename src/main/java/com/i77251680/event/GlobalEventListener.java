package com.i77251680.event;

import com.i77251680.event.base.Receive;

public class GlobalEventListener {
    private static final Publisher globalPublisher = new Publisher();

    public static void addEventListener(Subscriber subscriber) {
        globalPublisher.add(subscriber);
    }

    public static Publisher getGlobalPublisher() {
        return globalPublisher;
    }

    public static void getGlobalEvent(String eventName, Receive receive) {
        addEventListener(new Subscriber(eventName, receive));
    }
}
