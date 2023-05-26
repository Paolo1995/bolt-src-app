package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final long f48093h;

    /* loaded from: classes5.dex */
    static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f48094f;

        /* renamed from: g  reason: collision with root package name */
        final long f48095g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48096h;

        /* renamed from: i  reason: collision with root package name */
        Subscription f48097i;

        /* renamed from: j  reason: collision with root package name */
        long f48098j;

        TakeSubscriber(Subscriber<? super T> subscriber, long j8) {
            this.f48094f = subscriber;
            this.f48095g = j8;
            this.f48098j = j8;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48097i, subscription)) {
                this.f48097i = subscription;
                if (this.f48095g == 0) {
                    subscription.cancel();
                    this.f48096h = true;
                    EmptySubscription.c(this.f48094f);
                    return;
                }
                this.f48094f.c(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f48097i.cancel();
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (!SubscriptionHelper.m(j8)) {
                return;
            }
            if (!get() && compareAndSet(false, true) && j8 >= this.f48095g) {
                this.f48097i.f(Long.MAX_VALUE);
            } else {
                this.f48097i.f(j8);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f48096h) {
                this.f48096h = true;
                this.f48094f.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f48096h) {
                this.f48096h = true;
                this.f48097i.cancel();
                this.f48094f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            boolean z7;
            if (!this.f48096h) {
                long j8 = this.f48098j;
                long j9 = j8 - 1;
                this.f48098j = j9;
                if (j8 > 0) {
                    if (j9 == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    this.f48094f.onNext(t7);
                    if (z7) {
                        this.f48097i.cancel();
                        onComplete();
                    }
                }
            }
        }
    }

    public FlowableTake(Flowable<T> flowable, long j8) {
        super(flowable);
        this.f48093h = j8;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new TakeSubscriber(subscriber, this.f48093h));
    }
}
