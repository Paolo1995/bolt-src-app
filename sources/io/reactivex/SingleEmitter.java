package io.reactivex;

import io.reactivex.functions.Cancellable;

/* loaded from: classes5.dex */
public interface SingleEmitter<T> {
    boolean a(Throwable th);

    void b(Cancellable cancellable);

    boolean isDisposed();

    void onError(Throwable th);

    void onSuccess(T t7);
}
