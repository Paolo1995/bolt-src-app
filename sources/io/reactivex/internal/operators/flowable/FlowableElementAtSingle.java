package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Flowable<T> f47885f;

    /* renamed from: g  reason: collision with root package name */
    final long f47886g;

    /* renamed from: h  reason: collision with root package name */
    final T f47887h;

    /* loaded from: classes5.dex */
    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f47888f;

        /* renamed from: g  reason: collision with root package name */
        final long f47889g;

        /* renamed from: h  reason: collision with root package name */
        final T f47890h;

        /* renamed from: i  reason: collision with root package name */
        Subscription f47891i;

        /* renamed from: j  reason: collision with root package name */
        long f47892j;

        /* renamed from: k  reason: collision with root package name */
        boolean f47893k;

        ElementAtSubscriber(SingleObserver<? super T> singleObserver, long j8, T t7) {
            this.f47888f = singleObserver;
            this.f47889g = j8;
            this.f47890h = t7;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f47891i, subscription)) {
                this.f47891i = subscription;
                this.f47888f.onSubscribe(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47891i.cancel();
            this.f47891i = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f47891i == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f47891i = SubscriptionHelper.CANCELLED;
            if (!this.f47893k) {
                this.f47893k = true;
                T t7 = this.f47890h;
                if (t7 != null) {
                    this.f47888f.onSuccess(t7);
                } else {
                    this.f47888f.onError(new NoSuchElementException());
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f47893k) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f47893k = true;
            this.f47891i = SubscriptionHelper.CANCELLED;
            this.f47888f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f47893k) {
                return;
            }
            long j8 = this.f47892j;
            if (j8 == this.f47889g) {
                this.f47893k = true;
                this.f47891i.cancel();
                this.f47891i = SubscriptionHelper.CANCELLED;
                this.f47888f.onSuccess(t7);
                return;
            }
            this.f47892j = j8 + 1;
        }
    }

    public FlowableElementAtSingle(Flowable<T> flowable, long j8, T t7) {
        this.f47885f = flowable;
        this.f47886g = j8;
        this.f47887h = t7;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f47885f.Y(new ElementAtSubscriber(singleObserver, this.f47886g, this.f47887h));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> c() {
        return RxJavaPlugins.l(new FlowableElementAt(this.f47885f, this.f47886g, this.f47887h, true));
    }
}
