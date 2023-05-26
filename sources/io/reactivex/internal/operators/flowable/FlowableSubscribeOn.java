package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Scheduler f48083h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f48084i;

    /* loaded from: classes5.dex */
    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f48085f;

        /* renamed from: g  reason: collision with root package name */
        final Scheduler.Worker f48086g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<Subscription> f48087h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        final AtomicLong f48088i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        final boolean f48089j;

        /* renamed from: k  reason: collision with root package name */
        Publisher<T> f48090k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class Request implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            final Subscription f48091f;

            /* renamed from: g  reason: collision with root package name */
            final long f48092g;

            Request(Subscription subscription, long j8) {
                this.f48091f = subscription;
                this.f48092g = j8;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f48091f.f(this.f48092g);
            }
        }

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean z7) {
            this.f48085f = subscriber;
            this.f48086g = worker;
            this.f48090k = publisher;
            this.f48089j = !z7;
        }

        void a(long j8, Subscription subscription) {
            if (!this.f48089j && Thread.currentThread() != get()) {
                this.f48086g.b(new Request(subscription, j8));
            } else {
                subscription.f(j8);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.k(this.f48087h, subscription)) {
                long andSet = this.f48088i.getAndSet(0L);
                if (andSet != 0) {
                    a(andSet, subscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f48087h);
            this.f48086g.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                Subscription subscription = this.f48087h.get();
                if (subscription != null) {
                    a(j8, subscription);
                    return;
                }
                BackpressureHelper.a(this.f48088i, j8);
                Subscription subscription2 = this.f48087h.get();
                if (subscription2 != null) {
                    long andSet = this.f48088i.getAndSet(0L);
                    if (andSet != 0) {
                        a(andSet, subscription2);
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f48085f.onComplete();
            this.f48086g.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f48085f.onError(th);
            this.f48086g.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            this.f48085f.onNext(t7);
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.f48090k;
            this.f48090k = null;
            publisher.a(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z7) {
        super(flowable);
        this.f48083h = scheduler;
        this.f48084i = z7;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super T> subscriber) {
        Scheduler.Worker b8 = this.f48083h.b();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, b8, this.f47792g, this.f48084i);
        subscriber.c(subscribeOnSubscriber);
        b8.b(subscribeOnSubscriber);
    }
}
