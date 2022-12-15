package com.i77251680.event;

import com.i77251680.event.base.IPublisher;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements IPublisher {
    private String publisherName;
    private final List<Subscriber> subscriberList = new ArrayList<>();

    public Publisher() {

    }

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public void add(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void broadcast(String eventName, Object data) {
        for (Subscriber subscriber : subscriberList) {
            if (eventName == subscriber.getEventName())
                subscriber.onReceive(eventName, data);
        }
    }
}
