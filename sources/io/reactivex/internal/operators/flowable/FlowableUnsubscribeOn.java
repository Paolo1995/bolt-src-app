package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Scheduler f48104h;

    /* loaded from: classes5.dex */
    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f48105f;

        /* renamed from: g  reason: collision with root package name */
        final Scheduler f48106g;

        /* renamed from: h  reason: collision with root package name */
        Subscription f48107h;

        /* loaded from: classes5.dex */
        final class Cancellation implements Runnable {
            Cancellation() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeSubscriber.this.f48107h.cancel();
            }
        }

        UnsubscribeSubscriber(Subscriber<? super T> subscriber, Scheduler scheduler) {
            this.f48105f = subscriber;
            this.f48106g = scheduler;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48107h, subscription)) {
                this.f48107h = subscription;
                this.f48105f.c(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.f48106g.d(new Cancellation());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            this.f48107h.f(j8);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!get()) {
                this.f48105f.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f48105f.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (!get()) {
                this.f48105f.onNext(t7);
            }
        }
    }

    public FlowableUnsubscribeOn(Flowable<T> flowable, Scheduler scheduler) {
        super(flowable);
        this.f48104h = scheduler;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new UnsubscribeSubscriber(subscriber, this.f48104h));
    }
}
