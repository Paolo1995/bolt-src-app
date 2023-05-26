package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {

    /* renamed from: f  reason: collision with root package name */
    final Subscriber<? super T> f47709f;

    /* renamed from: g  reason: collision with root package name */
    Disposable f47710g;

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.f47709f = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f47710g.dispose();
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        this.f47709f.onComplete();
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        this.f47709f.onError(th);
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.l(this.f47710g, disposable)) {
            this.f47710g = disposable;
            this.f47709f.c(this);
        }
    }
}
