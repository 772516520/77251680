package com.i77251680.event.base;


import com.i77251680.event.Subscriber;

public interface IPublisher {
    void add(Subscriber subscriber);

    void broadcast(String eventName, Object data);

}
