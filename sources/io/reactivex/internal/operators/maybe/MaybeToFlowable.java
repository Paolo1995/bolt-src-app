package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class MaybeToFlowable<T> extends Flowable<T> {

    /* renamed from: g  reason: collision with root package name */
    final MaybeSource<T> f48127g;

    /* loaded from: classes5.dex */
    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {

        /* renamed from: h  reason: collision with root package name */
        Disposable f48128h;

        MaybeToFlowableSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f48128h.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f49779f.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49779f.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48128h, disposable)) {
                this.f48128h = disposable;
                this.f49779f.c(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            b(t7);
        }
    }

    public MaybeToFlowable(MaybeSource<T> maybeSource) {
        this.f48127g = maybeSource;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f48127g.a(new MaybeToFlowableSubscriber(subscriber));
    }
}
