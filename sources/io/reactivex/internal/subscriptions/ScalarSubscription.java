package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {

    /* renamed from: f  reason: collision with root package name */
    final T f49783f;

    /* renamed from: g  reason: collision with root package name */
    final Subscriber<? super T> f49784g;

    public ScalarSubscription(Subscriber<? super T> subscriber, T t7) {
        this.f49784g = subscriber;
        this.f49783f = t7;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int a(int i8) {
        return i8 & 1;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(2);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        lazySet(1);
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        if (SubscriptionHelper.m(j8) && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber = this.f49784g;
            subscriber.onNext((T) this.f49783f);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (get() != 0) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t7) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.f49783f;
        }
        return null;
    }
}
