package io.reactivex;

import io.reactivex.functions.Cancellable;

/* loaded from: classes5.dex */
public interface CompletableEmitter {
    boolean a(Throwable th);

    void b(Cancellable cancellable);

    boolean isDisposed();

    void onComplete();

    void onError(Throwable th);
}
