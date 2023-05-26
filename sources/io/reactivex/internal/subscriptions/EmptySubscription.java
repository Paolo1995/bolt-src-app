package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    public static void c(Subscriber<?> subscriber) {
        subscriber.c(INSTANCE);
        subscriber.onComplete();
    }

    public static void e(Throwable th, Subscriber<?> subscriber) {
        subscriber.c(INSTANCE);
        subscriber.onError(th);
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int a(int i8) {
        return i8 & 2;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        SubscriptionHelper.m(j8);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
