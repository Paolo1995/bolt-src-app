package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableOnBackpressureError<T> extends AbstractFlowableWithUpstream<T, T> {

    /* loaded from: classes5.dex */
    static final class BackpressureErrorSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f48040f;

        /* renamed from: g  reason: collision with root package name */
        Subscription f48041g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48042h;

        BackpressureErrorSubscriber(Subscriber<? super T> subscriber) {
            this.f48040f = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48041g, subscription)) {
                this.f48041g = subscription;
                this.f48040f.c(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f48041g.cancel();
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this, j8);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f48042h) {
                return;
            }
            this.f48042h = true;
            this.f48040f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f48042h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48042h = true;
            this.f48040f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f48042h) {
                return;
            }
            if (get() != 0) {
                this.f48040f.onNext(t7);
                BackpressureHelper.c(this, 1L);
                return;
            }
            this.f48041g.cancel();
            onError(new MissingBackpressureException("could not emit value due to lack of requests"));
        }
    }

    public FlowableOnBackpressureError(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new BackpressureErrorSubscriber(subscriber));
    }
}
