package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/* loaded from: classes5.dex */
public interface ObservableEmitter<T> extends Emitter<T> {
    boolean a(Throwable th);

    void b(Cancellable cancellable);

    void c(Disposable disposable);

    boolean isDisposed();
}
