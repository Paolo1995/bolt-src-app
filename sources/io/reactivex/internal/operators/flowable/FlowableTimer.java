package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableTimer extends Flowable<Long> {

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f48099g;

    /* renamed from: h  reason: collision with root package name */
    final long f48100h;

    /* renamed from: i  reason: collision with root package name */
    final TimeUnit f48101i;

    /* loaded from: classes5.dex */
    static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super Long> f48102f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f48103g;

        TimerSubscriber(Subscriber<? super Long> subscriber) {
            this.f48102f = subscriber;
        }

        public void a(Disposable disposable) {
            DisposableHelper.k(this, disposable);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.a(this);
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                this.f48103g = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                if (this.f48103g) {
                    this.f48102f.onNext(0L);
                    lazySet(EmptyDisposable.INSTANCE);
                    this.f48102f.onComplete();
                    return;
                }
                lazySet(EmptyDisposable.INSTANCE);
                this.f48102f.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            }
        }
    }

    public FlowableTimer(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        this.f48100h = j8;
        this.f48101i = timeUnit;
        this.f48099g = scheduler;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super Long> subscriber) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.c(timerSubscriber);
        timerSubscriber.a(this.f48099g.e(timerSubscriber, this.f48100h, this.f48101i));
    }
}
