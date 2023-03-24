package com.i77251680.network.async;

import java.util.function.Function;

public interface Task<T> {
    byte[] get();

    T get(T v);

    <R> Task<R> then(Function<T, R> action);

    void catchException(AsyncTask.Callback cb) throws Exception;
}
