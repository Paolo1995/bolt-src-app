package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

    /* renamed from: f  reason: collision with root package name */
    final Subscriber<? super T> f49773f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicThrowable f49774g = new AtomicThrowable();

    /* renamed from: h  reason: collision with root package name */
    final AtomicLong f49775h = new AtomicLong();

    /* renamed from: i  reason: collision with root package name */
    final AtomicReference<Subscription> f49776i = new AtomicReference<>();

    /* renamed from: j  reason: collision with root package name */
    final AtomicBoolean f49777j = new AtomicBoolean();

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f49778k;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.f49773f = subscriber;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void c(Subscription subscription) {
        if (this.f49777j.compareAndSet(false, true)) {
            this.f49773f.c(this);
            SubscriptionHelper.e(this.f49776i, this.f49775h, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (!this.f49778k) {
            SubscriptionHelper.a(this.f49776i);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        if (j8 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j8));
            return;
        }
        SubscriptionHelper.c(this.f49776i, this.f49775h, j8);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f49778k = true;
        HalfSerializer.b(this.f49773f, this, this.f49774g);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f49778k = true;
        HalfSerializer.d(this.f49773f, th, this, this.f49774g);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t7) {
        HalfSerializer.f(this.f49773f, t7, this, this.f49774g);
    }
}
