package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class SingleToFlowable<T> extends Flowable<T> {

    /* renamed from: g  reason: collision with root package name */
    final SingleSource<? extends T> f49625g;

    /* loaded from: classes5.dex */
    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {

        /* renamed from: h  reason: collision with root package name */
        Disposable f49626h;

        SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f49626h.dispose();
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49779f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49626h, disposable)) {
                this.f49626h = disposable;
                this.f49779f.c(this);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            b(t7);
        }
    }

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.f49625g = singleSource;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super T> subscriber) {
        this.f49625g.a(new SingleToFlowableObserver(subscriber));
    }
}
