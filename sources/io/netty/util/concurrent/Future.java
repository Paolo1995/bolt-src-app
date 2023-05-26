package io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public interface Future<V> extends java.util.concurrent.Future<V> {
    Future<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Future<V> await() throws InterruptedException;

    boolean await(long j8, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.concurrent.Future
    boolean cancel(boolean z7);

    Throwable cause();

    V getNow();

    boolean isSuccess();

    Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);
}
