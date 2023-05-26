package io.netty.util.concurrent;

/* loaded from: classes5.dex */
public interface Promise<V> extends Future<V> {
    @Override // io.netty.util.concurrent.Future
    Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Promise<V> setFailure(Throwable th);

    Promise<V> setSuccess(V v7);

    boolean setUncancellable();

    boolean tryFailure(Throwable th);

    boolean trySuccess(V v7);
}
