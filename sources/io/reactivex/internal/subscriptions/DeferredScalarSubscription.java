package io.reactivex.internal.subscriptions;

import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {

    /* renamed from: f  reason: collision with root package name */
    protected final Subscriber<? super T> f49779f;

    /* renamed from: g  reason: collision with root package name */
    protected T f49780g;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.f49779f = subscriber;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int a(int i8) {
        if ((i8 & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final void b(T t7) {
        int i8 = get();
        while (i8 != 8) {
            if ((i8 & (-3)) != 0) {
                return;
            }
            if (i8 == 2) {
                lazySet(3);
                Subscriber<? super T> subscriber = this.f49779f;
                subscriber.onNext(t7);
                if (get() != 4) {
                    subscriber.onComplete();
                    return;
                }
                return;
            }
            this.f49780g = t7;
            if (compareAndSet(0, 1)) {
                return;
            }
            i8 = get();
            if (i8 == 4) {
                this.f49780g = null;
                return;
            }
        }
        this.f49780g = t7;
        lazySet(16);
        Subscriber<? super T> subscriber2 = this.f49779f;
        subscriber2.onNext(t7);
        if (get() != 4) {
            subscriber2.onComplete();
        }
    }

    public void cancel() {
        set(4);
        this.f49780g = null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.f49780g = null;
    }

    public final boolean d() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public final void f(long j8) {
        T t7;
        if (SubscriptionHelper.m(j8)) {
            do {
                int i8 = get();
                if ((i8 & (-2)) != 0) {
                    return;
                }
                if (i8 == 1) {
                    if (compareAndSet(1, 3) && (t7 = this.f49780g) != null) {
                        this.f49780g = null;
                        Subscriber<? super T> subscriber = this.f49779f;
                        subscriber.onNext(t7);
                        if (get() != 4) {
                            subscriber.onComplete();
                            return;
                        }
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t7 = this.f49780g;
        this.f49780g = null;
        return t7;
    }
}
