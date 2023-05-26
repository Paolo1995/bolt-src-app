package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public interface ListenableFuture<V> extends Future<V> {
    void f(Runnable runnable, Executor executor);
}
