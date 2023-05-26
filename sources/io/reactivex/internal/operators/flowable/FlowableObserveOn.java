package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: h  reason: collision with root package name */
    final Scheduler f48002h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f48003i;

    /* renamed from: j  reason: collision with root package name */
    final int f48004j;

    /* loaded from: classes5.dex */
    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Scheduler.Worker f48005f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f48006g;

        /* renamed from: h  reason: collision with root package name */
        final int f48007h;

        /* renamed from: i  reason: collision with root package name */
        final int f48008i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicLong f48009j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        Subscription f48010k;

        /* renamed from: l  reason: collision with root package name */
        SimpleQueue<T> f48011l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48012m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48013n;

        /* renamed from: o  reason: collision with root package name */
        Throwable f48014o;

        /* renamed from: p  reason: collision with root package name */
        int f48015p;

        /* renamed from: q  reason: collision with root package name */
        long f48016q;

        /* renamed from: r  reason: collision with root package name */
        boolean f48017r;

        BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z7, int i8) {
            this.f48005f = worker;
            this.f48006g = z7;
            this.f48007h = i8;
            this.f48008i = i8 - (i8 >> 2);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int a(int i8) {
            if ((i8 & 2) != 0) {
                this.f48017r = true;
                return 2;
            }
            return 0;
        }

        final boolean b(boolean z7, boolean z8, Subscriber<?> subscriber) {
            if (this.f48012m) {
                clear();
                return true;
            } else if (z7) {
                if (this.f48006g) {
                    if (z8) {
                        this.f48012m = true;
                        Throwable th = this.f48014o;
                        if (th != null) {
                            subscriber.onError(th);
                        } else {
                            subscriber.onComplete();
                        }
                        this.f48005f.dispose();
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f48014o;
                if (th2 != null) {
                    this.f48012m = true;
                    clear();
                    subscriber.onError(th2);
                    this.f48005f.dispose();
                    return true;
                } else if (z8) {
                    this.f48012m = true;
                    subscriber.onComplete();
                    this.f48005f.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.f48012m) {
                return;
            }
            this.f48012m = true;
            this.f48010k.cancel();
            this.f48005f.dispose();
            if (!this.f48017r && getAndIncrement() == 0) {
                this.f48011l.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.f48011l.clear();
        }

        abstract void d();

        @Override // org.reactivestreams.Subscription
        public final void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this.f48009j, j8);
                j();
            }
        }

        abstract void g();

        abstract void i();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.f48011l.isEmpty();
        }

        final void j() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.f48005f.b(this);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (!this.f48013n) {
                this.f48013n = true;
                j();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.f48013n) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48014o = th;
            this.f48013n = true;
            j();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t7) {
            if (this.f48013n) {
                return;
            }
            if (this.f48015p == 2) {
                j();
                return;
            }
            if (!this.f48011l.offer(t7)) {
                this.f48010k.cancel();
                this.f48014o = new MissingBackpressureException("Queue is full?!");
                this.f48013n = true;
            }
            j();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f48017r) {
                g();
            } else if (this.f48015p == 1) {
                i();
            } else {
                d();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {

        /* renamed from: s  reason: collision with root package name */
        final ConditionalSubscriber<? super T> f48018s;

        /* renamed from: t  reason: collision with root package name */
        long f48019t;

        ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z7, int i8) {
            super(worker, z7, i8);
            this.f48018s = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48010k, subscription)) {
                this.f48010k = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a8 = queueSubscription.a(7);
                    if (a8 == 1) {
                        this.f48015p = 1;
                        this.f48011l = queueSubscription;
                        this.f48013n = true;
                        this.f48018s.c(this);
                        return;
                    } else if (a8 == 2) {
                        this.f48015p = 2;
                        this.f48011l = queueSubscription;
                        this.f48018s.c(this);
                        subscription.f(this.f48007h);
                        return;
                    }
                }
                this.f48011l = new SpscArrayQueue(this.f48007h);
                this.f48018s.c(this);
                subscription.f(this.f48007h);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void d() {
            int i8;
            boolean z7;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f48018s;
            SimpleQueue<T> simpleQueue = this.f48011l;
            long j8 = this.f48016q;
            long j9 = this.f48019t;
            int i9 = 1;
            while (true) {
                long j10 = this.f48009j.get();
                while (true) {
                    i8 = (j8 > j10 ? 1 : (j8 == j10 ? 0 : -1));
                    if (i8 == 0) {
                        break;
                    }
                    boolean z8 = this.f48013n;
                    try {
                        Object obj = (T) simpleQueue.poll();
                        if (obj == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (b(z8, z7, conditionalSubscriber)) {
                            return;
                        }
                        if (z7) {
                            break;
                        }
                        if (conditionalSubscriber.h(obj)) {
                            j8++;
                        }
                        j9++;
                        if (j9 == this.f48008i) {
                            this.f48010k.f(j9);
                            j9 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f48012m = true;
                        this.f48010k.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.f48005f.dispose();
                        return;
                    }
                }
                if (i8 == 0 && b(this.f48013n, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    return;
                }
                int i10 = get();
                if (i9 == i10) {
                    this.f48016q = j8;
                    this.f48019t = j9;
                    i9 = addAndGet(-i9);
                    if (i9 == 0) {
                        return;
                    }
                } else {
                    i9 = i10;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void g() {
            int i8 = 1;
            while (!this.f48012m) {
                boolean z7 = this.f48013n;
                this.f48018s.onNext(null);
                if (z7) {
                    this.f48012m = true;
                    Throwable th = this.f48014o;
                    if (th != null) {
                        this.f48018s.onError(th);
                    } else {
                        this.f48018s.onComplete();
                    }
                    this.f48005f.dispose();
                    return;
                }
                i8 = addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void i() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f48018s;
            SimpleQueue<T> simpleQueue = this.f48011l;
            long j8 = this.f48016q;
            int i8 = 1;
            while (true) {
                long j9 = this.f48009j.get();
                while (j8 != j9) {
                    try {
                        Object obj = (T) simpleQueue.poll();
                        if (this.f48012m) {
                            return;
                        }
                        if (obj == null) {
                            this.f48012m = true;
                            conditionalSubscriber.onComplete();
                            this.f48005f.dispose();
                            return;
                        } else if (conditionalSubscriber.h(obj)) {
                            j8++;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f48012m = true;
                        this.f48010k.cancel();
                        conditionalSubscriber.onError(th);
                        this.f48005f.dispose();
                        return;
                    }
                }
                if (this.f48012m) {
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    this.f48012m = true;
                    conditionalSubscriber.onComplete();
                    this.f48005f.dispose();
                    return;
                }
                int i9 = get();
                if (i8 == i9) {
                    this.f48016q = j8;
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    i8 = i9;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.f48011l.poll();
            if (poll != null && this.f48015p != 1) {
                long j8 = this.f48019t + 1;
                if (j8 == this.f48008i) {
                    this.f48019t = 0L;
                    this.f48010k.f(j8);
                } else {
                    this.f48019t = j8;
                }
            }
            return poll;
        }
    }

    /* loaded from: classes5.dex */
    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> {

        /* renamed from: s  reason: collision with root package name */
        final Subscriber<? super T> f48020s;

        ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z7, int i8) {
            super(worker, z7, i8);
            this.f48020s = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f48010k, subscription)) {
                this.f48010k = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a8 = queueSubscription.a(7);
                    if (a8 == 1) {
                        this.f48015p = 1;
                        this.f48011l = queueSubscription;
                        this.f48013n = true;
                        this.f48020s.c(this);
                        return;
                    } else if (a8 == 2) {
                        this.f48015p = 2;
                        this.f48011l = queueSubscription;
                        this.f48020s.c(this);
                        subscription.f(this.f48007h);
                        return;
                    }
                }
                this.f48011l = new SpscArrayQueue(this.f48007h);
                this.f48020s.c(this);
                subscription.f(this.f48007h);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void d() {
            int i8;
            boolean z7;
            Subscriber<? super T> subscriber = this.f48020s;
            SimpleQueue<T> simpleQueue = this.f48011l;
            long j8 = this.f48016q;
            int i9 = 1;
            while (true) {
                long j9 = this.f48009j.get();
                while (true) {
                    i8 = (j8 > j9 ? 1 : (j8 == j9 ? 0 : -1));
                    if (i8 == 0) {
                        break;
                    }
                    boolean z8 = this.f48013n;
                    try {
                        Object obj = (T) simpleQueue.poll();
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
                        j8++;
                        if (j8 == this.f48008i) {
                            if (j9 != Long.MAX_VALUE) {
                                j9 = this.f48009j.addAndGet(-j8);
                            }
                            this.f48010k.f(j8);
                            j8 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f48012m = true;
                        this.f48010k.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.f48005f.dispose();
                        return;
                    }
                }
                if (i8 == 0 && b(this.f48013n, simpleQueue.isEmpty(), subscriber)) {
                    return;
                }
                int i10 = get();
                if (i9 == i10) {
                    this.f48016q = j8;
                    i9 = addAndGet(-i9);
                    if (i9 == 0) {
                        return;
                    }
                } else {
                    i9 = i10;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void g() {
            int i8 = 1;
            while (!this.f48012m) {
                boolean z7 = this.f48013n;
                this.f48020s.onNext(null);
                if (z7) {
                    this.f48012m = true;
                    Throwable th = this.f48014o;
                    if (th != null) {
                        this.f48020s.onError(th);
                    } else {
                        this.f48020s.onComplete();
                    }
                    this.f48005f.dispose();
                    return;
                }
                i8 = addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void i() {
            Subscriber<? super T> subscriber = this.f48020s;
            SimpleQueue<T> simpleQueue = this.f48011l;
            long j8 = this.f48016q;
            int i8 = 1;
            while (true) {
                long j9 = this.f48009j.get();
                while (j8 != j9) {
                    try {
                        Object obj = (T) simpleQueue.poll();
                        if (this.f48012m) {
                            return;
                        }
                        if (obj == null) {
                            this.f48012m = true;
                            subscriber.onComplete();
                            this.f48005f.dispose();
                            return;
                        }
                        subscriber.onNext(obj);
                        j8++;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f48012m = true;
                        this.f48010k.cancel();
                        subscriber.onError(th);
                        this.f48005f.dispose();
                        return;
                    }
                }
                if (this.f48012m) {
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    this.f48012m = true;
                    subscriber.onComplete();
                    this.f48005f.dispose();
                    return;
                }
                int i9 = get();
                if (i8 == i9) {
                    this.f48016q = j8;
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    i8 = i9;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.f48011l.poll();
            if (poll != null && this.f48015p != 1) {
                long j8 = this.f48016q + 1;
                if (j8 == this.f48008i) {
                    this.f48016q = 0L;
                    this.f48010k.f(j8);
                } else {
                    this.f48016q = j8;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z7, int i8) {
        super(flowable);
        this.f48002h = scheduler;
        this.f48003i = z7;
        this.f48004j = i8;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super T> subscriber) {
        Scheduler.Worker b8 = this.f48002h.b();
        if (subscriber instanceof ConditionalSubscriber) {
            this.f47792g.Y(new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, b8, this.f48003i, this.f48004j));
        } else {
            this.f47792g.Y(new ObserveOnSubscriber(subscriber, b8, this.f48003i, this.f48004j));
        }
    }
}
