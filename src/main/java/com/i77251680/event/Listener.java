package com.i77251680.event;

public interface Listener<T> {
    void accept(T event);
}
