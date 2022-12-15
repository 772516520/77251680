package com.i77251680.event;

import com.i77251680.event.base.ISubscriber;
import com.i77251680.event.base.Receive;

public class Subscriber implements ISubscriber {
    private final String eventName;
    private final Receive receive;

    public Subscriber(String eventName, Receive receive) {
        this.eventName = eventName;
        this.receive = receive;
    }

    @Override
    public void onReceive(String eventName, Object data) {
        receive.receive(data);
    }

    public String getEventName() {
        return eventName;
    }
}
