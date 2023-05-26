package io.reactivex;

import io.reactivex.disposables.Disposable;

/* loaded from: classes5.dex */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t7);

    void onSubscribe(Disposable disposable);
}
