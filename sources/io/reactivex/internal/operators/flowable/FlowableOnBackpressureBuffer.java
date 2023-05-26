package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final int f48021h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f48022i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f48023j;

    /* renamed from: k  reason: collision with root package name */
    final Action f48024k;

    /* loaded from: classes5.dex */
    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f48025f;

        /* renamed from: g  reason: collision with root package name */
        final SimplePlainQueue<T> f48026g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f48027h;

        /* renamed from: i  reason: collision with root package name */
        final Action f48028i;

        /* renamed from: j  reason: collision with root package name */
        Subscription f48029j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f48030k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48031l;

        /* renamed from: m  reason: collision with root package name */
        Throwable f48032m;

        /* renamed from: n  reason: collision with root package name */
        final AtomicLong f48033n = new AtomicLong();

        /* renamed from: o  reason: collision with root package name */
        boolean f48034o;

        BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i8, boolean z7, boolean z8, Action action) {
            SimplePlainQueue<T> spscArrayQueue;
            this.f48025f = subscriber;
            this.f48028i = action;
            this.f48027h = z8;
            if (z7) {
                spscArrayQueue = new SpscLinkedArrayQueue<>(i8);
            } else {
                spscArrayQueue = new SpscArrayQueue<>(i8);
            }
            this.f48026g = spscArrayQueue;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 2) != 0) {
                this.f48034o = true;
                return 2;
            }
            return 0;
        }

        boolean b(boolean z7, boolean z8, Subscriber<? super T> subscriber) {
            if (this.f48030k) {
                this.f48026g.clear();
                return true;
            } else if (z7) {
                if (this.f48027h) {
                    if (z8) {
                        Throwable th = this.f48032m;
                        if (th != null) {
                            subscriber.onError(th);
                        } else {
                            subscriber.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f48032m;
                if (th2 != null) {
                    this.f48026g.clear();
                    subscriber.onError(th2);
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

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48029j, subscription)) {
                this.f48029j = subscription;
                this.f48025f.c(this);
                subscription.f(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.f48030k) {
                this.f48030k = true;
                this.f48029j.cancel();
                if (!this.f48034o && getAndIncrement() == 0) {
                    this.f48026g.clear();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f48026g.clear();
        }

        void d() {
            int i8;
            boolean z7;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.f48026g;
                Subscriber<? super T> subscriber = this.f48025f;
                int i9 = 1;
                while (!b(this.f48031l, simplePlainQueue.isEmpty(), subscriber)) {
                    long j8 = this.f48033n.get();
                    long j9 = 0;
                    while (true) {
                        i8 = (j9 > j8 ? 1 : (j9 == j8 ? 0 : -1));
                        if (i8 == 0) {
                            break;
                        }
                        boolean z8 = this.f48031l;
                        Object obj = (T) simplePlainQueue.poll();
                        if (obj == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (b(z8, z7, subscriber)) {
                            return;
                        }
                        if (z7) {
                            break;
                        }
                        subscriber.onNext(obj);
                        j9++;
                    }
                    if (i8 == 0 && b(this.f48031l, simplePlainQueue.isEmpty(), subscriber)) {
                        return;
                    }
                    if (j9 != 0 && j8 != Long.MAX_VALUE) {
                        this.f48033n.addAndGet(-j9);
                    }
                    i9 = addAndGet(-i9);
                    if (i9 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (!this.f48034o && SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this.f48033n, j8);
                d();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f48026g.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f48031l = true;
            if (this.f48034o) {
                this.f48025f.onComplete();
            } else {
                d();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f48032m = th;
            this.f48031l = true;
            if (this.f48034o) {
                this.f48025f.onError(th);
            } else {
                d();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (!this.f48026g.offer(t7)) {
                this.f48029j.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.f48028i.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    missingBackpressureException.initCause(th);
                }
                onError(missingBackpressureException);
            } else if (this.f48034o) {
                this.f48025f.onNext(null);
            } else {
                d();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.f48026g.poll();
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i8, boolean z7, boolean z8, Action action) {
        super(flowable);
        this.f48021h = i8;
        this.f48022i = z7;
        this.f48023j = z8;
        this.f48024k = action;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        this.f47792g.Y(new BackpressureBufferSubscriber(subscriber, this.f48021h, this.f48022i, this.f48023j, this.f48024k));
    }
}
