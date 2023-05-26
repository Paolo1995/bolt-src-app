package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    /* loaded from: classes5.dex */
    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f48043f;

        /* renamed from: g  reason: collision with root package name */
        Subscription f48044g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f48045h;

        /* renamed from: i  reason: collision with root package name */
        Throwable f48046i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f48047j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicLong f48048k = new AtomicLong();

        /* renamed from: l  reason: collision with root package name */
        final AtomicReference<T> f48049l = new AtomicReference<>();

        BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            this.f48043f = subscriber;
        }

        boolean a(boolean z7, boolean z8, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.f48047j) {
                atomicReference.lazySet(null);
                return true;
            } else if (z7) {
                Throwable th = this.f48046i;
                if (th != null) {
                    atomicReference.lazySet(null);
                    subscriber.onError(th);
                    return true;
                } else if (z8) {
                    subscriber.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            boolean z7;
            boolean z8;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.f48043f;
            AtomicLong atomicLong = this.f48048k;
            AtomicReference<T> atomicReference = this.f48049l;
            int i8 = 1;
            do {
                long j8 = 0;
                while (true) {
                    z7 = false;
                    if (j8 == atomicLong.get()) {
                        break;
                    }
                    boolean z9 = this.f48045h;
                    Object obj = (T) atomicReference.getAndSet(null);
                    if (obj == null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (a(z9, z8, subscriber, atomicReference)) {
                        return;
                    }
                    if (z8) {
                        break;
                    }
                    subscriber.onNext(obj);
                    j8++;
                }
                if (j8 == atomicLong.get()) {
                    boolean z10 = this.f48045h;
                    if (atomicReference.get() == null) {
                        z7 = true;
                    }
                    if (a(z10, z7, subscriber, atomicReference)) {
                        return;
                    }
                }
                if (j8 != 0) {
                    BackpressureHelper.c(atomicLong, j8);
                }
                i8 = addAndGet(-i8);
            } while (i8 != 0);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48044g, subscription)) {
                this.f48044g = subscription;
                this.f48043f.c(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.f48047j) {
                this.f48047j = true;
                this.f48044g.cancel();
                if (getAndIncrement() == 0) {
                    this.f48049l.lazySet(null);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this.f48048k, j8);
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f48045h = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f48046i = th;
            this.f48045h = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            this.f48049l.lazySet(t7);
            b();
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new BackpressureLatestSubscriber(subscriber));
    }
}
