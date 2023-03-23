package com.i77251680.event.base;

public interface ISubscriber<T> {
    void onReceive(String eventName, T data);
}
