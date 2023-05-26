package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {

    /* renamed from: h  reason: collision with root package name */
    final Consumer<? super T> f48035h;

    /* loaded from: classes5.dex */
    static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f48036f;

        /* renamed from: g  reason: collision with root package name */
        final Consumer<? super T> f48037g;

        /* renamed from: h  reason: collision with root package name */
        Subscription f48038h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48039i;

        BackpressureDropSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            this.f48036f = subscriber;
            this.f48037g = consumer;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48038h, subscription)) {
                this.f48038h = subscription;
                this.f48036f.c(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f48038h.cancel();
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this, j8);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f48039i) {
                return;
            }
            this.f48039i = true;
            this.f48036f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f48039i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48039i = true;
            this.f48036f.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f48039i) {
                return;
            }
            if (get() != 0) {
                this.f48036f.onNext(t7);
                BackpressureHelper.c(this, 1L);
                return;
            }
            try {
                this.f48037g.accept(t7);
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
            }
        }
    }

    public FlowableOnBackpressureDrop(Flowable<T> flowable) {
        super(flowable);
        this.f48035h = this;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new BackpressureDropSubscriber(subscriber, this.f48035h));
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(T t7) {
    }
}
