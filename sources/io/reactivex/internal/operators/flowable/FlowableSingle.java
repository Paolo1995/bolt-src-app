package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final T f48070h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f48071i;

    /* loaded from: classes5.dex */
    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {

        /* renamed from: h  reason: collision with root package name */
        final T f48072h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f48073i;

        /* renamed from: j  reason: collision with root package name */
        Subscription f48074j;

        /* renamed from: k  reason: collision with root package name */
        boolean f48075k;

        SingleElementSubscriber(Subscriber<? super T> subscriber, T t7, boolean z7) {
            super(subscriber);
            this.f48072h = t7;
            this.f48073i = z7;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48074j, subscription)) {
                this.f48074j = subscription;
                this.f49779f.c(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f48074j.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f48075k) {
                return;
            }
            this.f48075k = true;
            T t7 = this.f49780g;
            this.f49780g = null;
            if (t7 == null) {
                t7 = this.f48072h;
            }
            if (t7 == null) {
                if (this.f48073i) {
                    this.f49779f.onError(new NoSuchElementException());
                    return;
                } else {
                    this.f49779f.onComplete();
                    return;
                }
            }
            b(t7);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f48075k) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48075k = true;
            this.f49779f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f48075k) {
                return;
            }
            if (this.f49780g != null) {
                this.f48075k = true;
                this.f48074j.cancel();
                this.f49779f.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f49780g = t7;
        }
    }

    public FlowableSingle(Flowable<T> flowable, T t7, boolean z7) {
        super(flowable);
        this.f48070h = t7;
        this.f48071i = z7;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new SingleElementSubscriber(subscriber, this.f48070h, this.f48071i));
    }
}
