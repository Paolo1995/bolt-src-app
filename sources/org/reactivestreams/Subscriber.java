package org.reactivestreams;

/* loaded from: classes5.dex */
public interface Subscriber<T> {
    void c(Subscription subscription);

    void onComplete();

    void onError(Throwable th);

    void onNext(T t7);
}
