package com.i77251680.network.async;

public interface Task<V> {
    V get(V v);

    Task<V> then(AsyncTask.Callback<V> action);

    void catchException() throws Exception;
}
