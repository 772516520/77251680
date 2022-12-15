package com.i77251680.event.base;

public interface ISubscriber {
    void onReceive(String eventName, Object data);
}
