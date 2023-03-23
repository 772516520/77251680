package com.i77251680.event.base;

@FunctionalInterface
public interface Receive<T> {
    void receive(T data);
}
