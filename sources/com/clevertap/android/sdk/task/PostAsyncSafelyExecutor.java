package com.clevertap.android.sdk.task;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class PostAsyncSafelyExecutor implements ExecutorService {

    /* renamed from: f  reason: collision with root package name */
    private long f11792f = 0;

    /* renamed from: g  reason: collision with root package name */
    ExecutorService f11793g = Executors.newSingleThreadExecutor();

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j8, TimeUnit timeUnit) throws InterruptedException {
        return this.f11793g.awaitTermination(j8, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        boolean z7;
        if (runnable != null) {
            if (Thread.currentThread().getId() == this.f11792f) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                runnable.run();
                return;
            } else {
                this.f11793g.execute(new Runnable() { // from class: com.clevertap.android.sdk.task.PostAsyncSafelyExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PostAsyncSafelyExecutor.this.f11792f = Thread.currentThread().getId();
                        runnable.run();
                    }
                });
                return;
            }
        }
        throw new NullPointerException("PostAsyncSafelyExecutor#execute: task can't ne null");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAll: This method is not supported");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAny: This method is not supported");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f11793g.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f11793g.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f11793g.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f11793g.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(final Callable<T> callable) {
        if (callable != null) {
            if (Thread.currentThread().getId() == this.f11792f) {
                try {
                    callable.call();
                    return null;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return null;
                }
            }
            return this.f11793g.submit(new Callable<T>() { // from class: com.clevertap.android.sdk.task.PostAsyncSafelyExecutor.2
                @Override // java.util.concurrent.Callable
                public T call() throws Exception {
                    PostAsyncSafelyExecutor.this.f11792f = Thread.currentThread().getId();
                    return (T) callable.call();
                }
            });
        }
        throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j8, TimeUnit timeUnit) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAll: This method is not supported");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j8, TimeUnit timeUnit) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("PostAsyncSafelyExecutor#invokeAny: This method is not supported");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t7) {
        if (runnable != null) {
            FutureTask futureTask = new FutureTask(runnable, t7);
            execute(futureTask);
            return futureTask;
        }
        throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable != null) {
            FutureTask futureTask = new FutureTask(runnable, null);
            execute(futureTask);
            return futureTask;
        }
        throw new NullPointerException("PostAsyncSafelyExecutor#submit: task can't ne null");
    }
}
