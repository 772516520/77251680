package com.i77251680.network.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class AsyncTask<T> extends AbstractAsyncTask<T> implements Task<T> {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static final String PENDING = "PENDING";
    private static final String FULFILLED = "FULFILLED";
    private static final String REJECTED = "REJECTED";
    private String state = PENDING;
    private T value;
    private CompletableFuture<T> completableFuture;
    private List<Callback<T>> onFulfilledList = new ArrayList<>();
    private Exception err;

    public interface Callback<U> {
        void run(U v);
    }

    public interface Executor<R> {
        void executor(Callback<R> resolve, Callback<R> reject);
    }

    public AsyncTask(Executor<T> executor) {
        Callback<T> resolve = r -> {
            completableFuture = CompletableFuture.supplyAsync(() -> {
                onFulfilledList.forEach(a -> a.run(CompletableFuture.supplyAsync(() -> r, executorService).join()));
                this.value = r;
                state = FULFILLED;
                return r;
            }, executorService);
            synchronized (this) {
                this.notify();
            }
        };
        Callback<T> reject = r -> {
            state = REJECTED;
            err = new RuntimeException((String) r);
            synchronized (this) {
                this.notify();
            }
        };
        executor.executor(resolve, reject);
    }

    public synchronized byte[] get() {
        try {
            if (completableFuture == null)
                this.wait();
            if (state.equals(REJECTED)) throw new RuntimeException(err);
            return (byte[]) completableFuture.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T get(T t) {
        return null;
    }

    @Override
    public <R> Task<R> then(Function<T, R> action) {
        return new AsyncTask<>(((resolve, reject) -> {
            if (state.equals(PENDING))
                onFulfilledList.add((T r) -> resolve.run(action.apply(r)));
        }));
    }

    @Override
    public void catchException(Callback cb) throws Exception {
        cb.run(err);
    }
}
