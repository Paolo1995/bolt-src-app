package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {

    /* renamed from: g  reason: collision with root package name */
    private final Observable<T> f47992g;

    /* loaded from: classes5.dex */
    static final class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f47993f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f47994g;

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f47993f = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f47994g.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f47993f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f47993f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f47993f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f47994g = disposable;
            this.f47993f.c(this);
        }
    }

    public FlowableFromObservable(Observable<T> observable) {
        this.f47992g = observable;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47992g.subscribe(new SubscriberObserver(subscriber));
    }
}
