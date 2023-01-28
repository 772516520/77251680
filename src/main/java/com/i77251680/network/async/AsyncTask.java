package com.i77251680.network.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncTask<T> extends AbstractAsyncTask<T> {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static final String PENDING = "PENDING";
    private static final String FULFILLED = "FULFILLED";
    private static final String REJECTED = "REJECTED";
    private String state = PENDING;
    private T value;
    private CompletableFuture<T> completableFuture;
    private List<Callback<T>> onFulfilledList = new ArrayList<>();

    public interface Callback<U> {
        void run(U v);
    }

    public interface Executor<R> {
        void executor(Callback<R> resolve, Callback<R> reject);
    }

    public AsyncTask(Executor<T> executor) {
        Callback<T> resolve = r -> {
            completableFuture = CompletableFuture.supplyAsync(() -> {
                onFulfilledList.forEach((a) -> {
                    a.run(CompletableFuture.supplyAsync(() -> r, executorService).join());
                });
                this.value = r;
                return r;
            }, executorService);
        };
        Callback<T> reject = r -> {
        };
        executor.executor(resolve, reject);
    }

    @Override
    public T get(T t) {
        return null;
    }

    @Override
    public Task<T> then(Callback<T> action) {
        return new AsyncTask<>((res, rej) -> {
            if (this.state.equals(PENDING)) {
                onFulfilledList.add((v) -> {
                    action.run(v);
                    System.out.println("then->" + v);
                });
            }
            if (this.state.equals(FULFILLED)) {
                System.out.println("state->" + FULFILLED);
                action.run(value);
            }
        });
    }

    @Override
    public void catchException() throws Exception {

    }
}
