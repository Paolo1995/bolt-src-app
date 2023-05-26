package io.reactivex.internal.operators.flowable;

import androidx.camera.view.e;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: h  reason: collision with root package name */
    final Function<? super T, ? extends Publisher<? extends U>> f47899h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f47900i;

    /* renamed from: j  reason: collision with root package name */
    final int f47901j;

    /* renamed from: k  reason: collision with root package name */
    final int f47902k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final long f47903f;

        /* renamed from: g  reason: collision with root package name */
        final MergeSubscriber<T, U> f47904g;

        /* renamed from: h  reason: collision with root package name */
        final int f47905h;

        /* renamed from: i  reason: collision with root package name */
        final int f47906i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f47907j;

        /* renamed from: k  reason: collision with root package name */
        volatile SimpleQueue<U> f47908k;

        /* renamed from: l  reason: collision with root package name */
        long f47909l;

        /* renamed from: m  reason: collision with root package name */
        int f47910m;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j8) {
            this.f47903f = j8;
            this.f47904g = mergeSubscriber;
            int i8 = mergeSubscriber.f47917j;
            this.f47906i = i8;
            this.f47905h = i8 >> 2;
        }

        void a(long j8) {
            if (this.f47910m != 1) {
                long j9 = this.f47909l + j8;
                if (j9 >= this.f47905h) {
                    this.f47909l = 0L;
                    get().f(j9);
                    return;
                }
                this.f47909l = j9;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.k(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a8 = queueSubscription.a(7);
                    if (a8 == 1) {
                        this.f47910m = a8;
                        this.f47908k = queueSubscription;
                        this.f47907j = true;
                        this.f47904g.i();
                        return;
                    } else if (a8 == 2) {
                        this.f47910m = a8;
                        this.f47908k = queueSubscription;
                    }
                }
                subscription.f(this.f47906i);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == SubscriptionHelper.CANCELLED) {
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f47907j = true;
            this.f47904g.i();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.f47904g.m(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u7) {
            if (this.f47910m != 2) {
                this.f47904g.o(u7, this);
            } else {
                this.f47904g.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: w  reason: collision with root package name */
        static final InnerSubscriber<?, ?>[] f47911w = new InnerSubscriber[0];

        /* renamed from: x  reason: collision with root package name */
        static final InnerSubscriber<?, ?>[] f47912x = new InnerSubscriber[0];

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super U> f47913f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends Publisher<? extends U>> f47914g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f47915h;

        /* renamed from: i  reason: collision with root package name */
        final int f47916i;

        /* renamed from: j  reason: collision with root package name */
        final int f47917j;

        /* renamed from: k  reason: collision with root package name */
        volatile SimplePlainQueue<U> f47918k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f47919l;

        /* renamed from: m  reason: collision with root package name */
        final AtomicThrowable f47920m = new AtomicThrowable();

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f47921n;

        /* renamed from: o  reason: collision with root package name */
        final AtomicReference<InnerSubscriber<?, ?>[]> f47922o;

        /* renamed from: p  reason: collision with root package name */
        final AtomicLong f47923p;

        /* renamed from: q  reason: collision with root package name */
        Subscription f47924q;

        /* renamed from: r  reason: collision with root package name */
        long f47925r;

        /* renamed from: s  reason: collision with root package name */
        long f47926s;

        /* renamed from: t  reason: collision with root package name */
        int f47927t;

        /* renamed from: u  reason: collision with root package name */
        int f47928u;

        /* renamed from: v  reason: collision with root package name */
        final int f47929v;

        MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z7, int i8, int i9) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.f47922o = atomicReference;
            this.f47923p = new AtomicLong();
            this.f47913f = subscriber;
            this.f47914g = function;
            this.f47915h = z7;
            this.f47916i = i8;
            this.f47917j = i9;
            this.f47929v = Math.max(1, i8 >> 1);
            atomicReference.lazySet(f47911w);
        }

        boolean a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.f47922o.get();
                if (innerSubscriberArr == f47912x) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!e.a(this.f47922o, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        boolean b() {
            if (this.f47921n) {
                d();
                return true;
            } else if (!this.f47915h && this.f47920m.get() != null) {
                d();
                Throwable b8 = this.f47920m.b();
                if (b8 != ExceptionHelper.f49808a) {
                    this.f47913f.onError(b8);
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f47924q, subscription)) {
                this.f47924q = subscription;
                this.f47913f.c(this);
                if (!this.f47921n) {
                    int i8 = this.f47916i;
                    if (i8 == Integer.MAX_VALUE) {
                        subscription.f(Long.MAX_VALUE);
                    } else {
                        subscription.f(i8);
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            if (!this.f47921n) {
                this.f47921n = true;
                this.f47924q.cancel();
                g();
                if (getAndIncrement() == 0 && (simplePlainQueue = this.f47918k) != null) {
                    simplePlainQueue.clear();
                }
            }
        }

        void d() {
            SimplePlainQueue<U> simplePlainQueue = this.f47918k;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this.f47923p, j8);
                i();
            }
        }

        void g() {
            InnerSubscriber<?, ?>[] andSet;
            InnerSubscriber<?, ?>[] innerSubscriberArr = this.f47922o.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = f47912x;
            if (innerSubscriberArr != innerSubscriberArr2 && (andSet = this.f47922o.getAndSet(innerSubscriberArr2)) != innerSubscriberArr2) {
                for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                    innerSubscriber.dispose();
                }
                Throwable b8 = this.f47920m.b();
                if (b8 != null && b8 != ExceptionHelper.f49808a) {
                    RxJavaPlugins.s(b8);
                }
            }
        }

        void i() {
            if (getAndIncrement() == 0) {
                j();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:121:0x018f, code lost:
            r24.f47927t = r3;
            r24.f47926s = r13[r3].f47903f;
            r3 = r16;
            r5 = 0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void j() {
            /*
                Method dump skipped, instructions count: 446
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber.j():void");
        }

        SimpleQueue<U> k(InnerSubscriber<T, U> innerSubscriber) {
            SimpleQueue<U> simpleQueue = innerSubscriber.f47908k;
            if (simpleQueue == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f47917j);
                innerSubscriber.f47908k = spscArrayQueue;
                return spscArrayQueue;
            }
            return simpleQueue;
        }

        SimpleQueue<U> l() {
            SimplePlainQueue<U> simplePlainQueue = this.f47918k;
            if (simplePlainQueue == null) {
                if (this.f47916i == Integer.MAX_VALUE) {
                    simplePlainQueue = new SpscLinkedArrayQueue<>(this.f47917j);
                } else {
                    simplePlainQueue = new SpscArrayQueue<>(this.f47916i);
                }
                this.f47918k = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        void m(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (this.f47920m.a(th)) {
                innerSubscriber.f47907j = true;
                if (!this.f47915h) {
                    this.f47924q.cancel();
                    for (InnerSubscriber<?, ?> innerSubscriber2 : this.f47922o.getAndSet(f47912x)) {
                        innerSubscriber2.dispose();
                    }
                }
                i();
                return;
            }
            RxJavaPlugins.s(th);
        }

        void n(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.f47922o.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i8 = -1;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        break;
                    } else if (innerSubscriberArr[i9] == innerSubscriber) {
                        i8 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
                if (i8 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = f47911w;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i8);
                    System.arraycopy(innerSubscriberArr, i8 + 1, innerSubscriberArr3, i8, (length - i8) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!e.a(this.f47922o, innerSubscriberArr, innerSubscriberArr2));
        }

        void o(U u7, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j8 = this.f47923p.get();
                SimpleQueue<U> simpleQueue = innerSubscriber.f47908k;
                if (j8 != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    this.f47913f.onNext(u7);
                    if (j8 != Long.MAX_VALUE) {
                        this.f47923p.decrementAndGet();
                    }
                    innerSubscriber.a(1L);
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = k(innerSubscriber);
                    }
                    if (!simpleQueue.offer(u7)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue2 = innerSubscriber.f47908k;
                if (simpleQueue2 == null) {
                    simpleQueue2 = new SpscArrayQueue(this.f47917j);
                    innerSubscriber.f47908k = simpleQueue2;
                }
                if (!simpleQueue2.offer(u7)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            j();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f47919l) {
                return;
            }
            this.f47919l = true;
            i();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f47919l) {
                RxJavaPlugins.s(th);
            } else if (this.f47920m.a(th)) {
                this.f47919l = true;
                if (!this.f47915h) {
                    for (InnerSubscriber<?, ?> innerSubscriber : this.f47922o.getAndSet(f47912x)) {
                        innerSubscriber.dispose();
                    }
                }
                i();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            if (this.f47919l) {
                return;
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.e(this.f47914g.apply(t7), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call != null) {
                            p(call);
                            return;
                        } else if (this.f47916i != Integer.MAX_VALUE && !this.f47921n) {
                            int i8 = this.f47928u + 1;
                            this.f47928u = i8;
                            int i9 = this.f47929v;
                            if (i8 == i9) {
                                this.f47928u = 0;
                                this.f47924q.f(i9);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f47920m.a(th);
                        i();
                        return;
                    }
                }
                long j8 = this.f47925r;
                this.f47925r = 1 + j8;
                InnerSubscriber innerSubscriber = new InnerSubscriber(this, j8);
                if (a(innerSubscriber)) {
                    publisher.a(innerSubscriber);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f47924q.cancel();
                onError(th2);
            }
        }

        void p(U u7) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j8 = this.f47923p.get();
                SimpleQueue<U> simpleQueue = this.f47918k;
                if (j8 != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    this.f47913f.onNext(u7);
                    if (j8 != Long.MAX_VALUE) {
                        this.f47923p.decrementAndGet();
                    }
                    if (this.f47916i != Integer.MAX_VALUE && !this.f47921n) {
                        int i8 = this.f47928u + 1;
                        this.f47928u = i8;
                        int i9 = this.f47929v;
                        if (i8 == i9) {
                            this.f47928u = 0;
                            this.f47924q.f(i9);
                        }
                    }
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = l();
                    }
                    if (!simpleQueue.offer(u7)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!l().offer(u7)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            j();
        }
    }

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z7, int i8, int i9) {
        super(flowable);
        this.f47899h = function;
        this.f47900i = z7;
        this.f47901j = i8;
        this.f47902k = i9;
    }

    public static <T, U> FlowableSubscriber<T> h0(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z7, int i8, int i9) {
        return new MergeSubscriber(subscriber, function, z7, i8, i9);
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.b(this.f47792g, subscriber, this.f47899h)) {
            return;
        }
        this.f47792g.Y(h0(subscriber, this.f47899h, this.f47900i, this.f47901j, this.f47902k));
    }
}
