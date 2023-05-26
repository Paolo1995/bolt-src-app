package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: h  reason: collision with root package name */
    final Function<? super T, ? extends Publisher<? extends R>> f47817h;

    /* renamed from: i  reason: collision with root package name */
    final int f47818i;

    /* renamed from: j  reason: collision with root package name */
    final ErrorMode f47819j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47820a;

        static {
            int[] iArr = new int[ErrorMode.values().length];
            f47820a = iArr;
            try {
                iArr[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47820a[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends Publisher<? extends R>> f47822g;

        /* renamed from: h  reason: collision with root package name */
        final int f47823h;

        /* renamed from: i  reason: collision with root package name */
        final int f47824i;

        /* renamed from: j  reason: collision with root package name */
        Subscription f47825j;

        /* renamed from: k  reason: collision with root package name */
        int f47826k;

        /* renamed from: l  reason: collision with root package name */
        SimpleQueue<T> f47827l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f47828m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f47829n;

        /* renamed from: p  reason: collision with root package name */
        volatile boolean f47831p;

        /* renamed from: q  reason: collision with root package name */
        int f47832q;

        /* renamed from: f  reason: collision with root package name */
        final ConcatMapInner<R> f47821f = new ConcatMapInner<>(this);

        /* renamed from: o  reason: collision with root package name */
        final AtomicThrowable f47830o = new AtomicThrowable();

        BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i8) {
            this.f47822g = function;
            this.f47823h = i8;
            this.f47824i = i8 - (i8 >> 2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public final void b() {
            this.f47831p = false;
            g();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f47825j, subscription)) {
                this.f47825j = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a8 = queueSubscription.a(7);
                    if (a8 == 1) {
                        this.f47832q = a8;
                        this.f47827l = queueSubscription;
                        this.f47828m = true;
                        i();
                        g();
                        return;
                    } else if (a8 == 2) {
                        this.f47832q = a8;
                        this.f47827l = queueSubscription;
                        i();
                        subscription.f(this.f47823h);
                        return;
                    }
                }
                this.f47827l = new SpscArrayQueue(this.f47823h);
                i();
                subscription.f(this.f47823h);
            }
        }

        abstract void g();

        abstract void i();

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.f47828m = true;
            g();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t7) {
            if (this.f47832q != 2 && !this.f47827l.offer(t7)) {
                this.f47825j.cancel();
                onError(new IllegalStateException("Queue full?!"));
                return;
            }
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {

        /* renamed from: r  reason: collision with root package name */
        final Subscriber<? super R> f47833r;

        /* renamed from: s  reason: collision with root package name */
        final boolean f47834s;

        ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i8, boolean z7) {
            super(function, i8);
            this.f47833r = subscriber;
            this.f47834s = z7;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void a(Throwable th) {
            if (this.f47830o.a(th)) {
                if (!this.f47834s) {
                    this.f47825j.cancel();
                    this.f47828m = true;
                }
                this.f47831p = false;
                g();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.f47829n) {
                this.f47829n = true;
                this.f47821f.cancel();
                this.f47825j.cancel();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void d(R r7) {
            this.f47833r.onNext(r7);
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            this.f47821f.f(j8);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void g() {
            boolean z7;
            Object obj;
            if (getAndIncrement() == 0) {
                while (!this.f47829n) {
                    if (!this.f47831p) {
                        boolean z8 = this.f47828m;
                        if (z8 && !this.f47834s && this.f47830o.get() != null) {
                            this.f47833r.onError(this.f47830o.b());
                            return;
                        }
                        try {
                            T poll = this.f47827l.poll();
                            if (poll == null) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z8 && z7) {
                                Throwable b8 = this.f47830o.b();
                                if (b8 != null) {
                                    this.f47833r.onError(b8);
                                    return;
                                } else {
                                    this.f47833r.onComplete();
                                    return;
                                }
                            } else if (!z7) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.e(this.f47822g.apply(poll), "The mapper returned a null Publisher");
                                    if (this.f47832q != 1) {
                                        int i8 = this.f47826k + 1;
                                        if (i8 == this.f47824i) {
                                            this.f47826k = 0;
                                            this.f47825j.f(i8);
                                        } else {
                                            this.f47826k = i8;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            obj = ((Callable) publisher).call();
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            this.f47830o.a(th);
                                            if (!this.f47834s) {
                                                this.f47825j.cancel();
                                                this.f47833r.onError(this.f47830o.b());
                                                return;
                                            }
                                            obj = null;
                                        }
                                        if (obj == null) {
                                            continue;
                                        } else if (this.f47821f.d()) {
                                            this.f47833r.onNext(obj);
                                        } else {
                                            this.f47831p = true;
                                            this.f47821f.i(new SimpleScalarSubscription(obj, this.f47821f));
                                        }
                                    } else {
                                        this.f47831p = true;
                                        publisher.a(this.f47821f);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    this.f47825j.cancel();
                                    this.f47830o.a(th2);
                                    this.f47833r.onError(this.f47830o.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            this.f47825j.cancel();
                            this.f47830o.a(th3);
                            this.f47833r.onError(this.f47830o.b());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void i() {
            this.f47833r.c(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f47830o.a(th)) {
                this.f47828m = true;
                g();
                return;
            }
            RxJavaPlugins.s(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {

        /* renamed from: r  reason: collision with root package name */
        final Subscriber<? super R> f47835r;

        /* renamed from: s  reason: collision with root package name */
        final AtomicInteger f47836s;

        ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i8) {
            super(function, i8);
            this.f47835r = subscriber;
            this.f47836s = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void a(Throwable th) {
            if (this.f47830o.a(th)) {
                this.f47825j.cancel();
                if (getAndIncrement() == 0) {
                    this.f47835r.onError(this.f47830o.b());
                    return;
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.f47829n) {
                this.f47829n = true;
                this.f47821f.cancel();
                this.f47825j.cancel();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void d(R r7) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f47835r.onNext(r7);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.f47835r.onError(this.f47830o.b());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            this.f47821f.f(j8);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void g() {
            boolean z7;
            if (this.f47836s.getAndIncrement() == 0) {
                while (!this.f47829n) {
                    if (!this.f47831p) {
                        boolean z8 = this.f47828m;
                        try {
                            T poll = this.f47827l.poll();
                            if (poll == null) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z8 && z7) {
                                this.f47835r.onComplete();
                                return;
                            } else if (!z7) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.e(this.f47822g.apply(poll), "The mapper returned a null Publisher");
                                    if (this.f47832q != 1) {
                                        int i8 = this.f47826k + 1;
                                        if (i8 == this.f47824i) {
                                            this.f47826k = 0;
                                            this.f47825j.f(i8);
                                        } else {
                                            this.f47826k = i8;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.f47821f.d()) {
                                                if (get() == 0 && compareAndSet(0, 1)) {
                                                    this.f47835r.onNext(call);
                                                    if (!compareAndSet(1, 0)) {
                                                        this.f47835r.onError(this.f47830o.b());
                                                        return;
                                                    }
                                                }
                                            } else {
                                                this.f47831p = true;
                                                this.f47821f.i(new SimpleScalarSubscription(call, this.f47821f));
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            this.f47825j.cancel();
                                            this.f47830o.a(th);
                                            this.f47835r.onError(this.f47830o.b());
                                            return;
                                        }
                                    } else {
                                        this.f47831p = true;
                                        publisher.a(this.f47821f);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    this.f47825j.cancel();
                                    this.f47830o.a(th2);
                                    this.f47835r.onError(this.f47830o.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            this.f47825j.cancel();
                            this.f47830o.a(th3);
                            this.f47835r.onError(this.f47830o.b());
                            return;
                        }
                    }
                    if (this.f47836s.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void i() {
            this.f47835r.c(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f47830o.a(th)) {
                this.f47821f.cancel();
                if (getAndIncrement() == 0) {
                    this.f47835r.onError(this.f47830o.b());
                    return;
                }
                return;
            }
            RxJavaPlugins.s(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {

        /* renamed from: n  reason: collision with root package name */
        final ConcatMapSupport<R> f47837n;

        /* renamed from: o  reason: collision with root package name */
        long f47838o;

        ConcatMapInner(ConcatMapSupport<R> concatMapSupport) {
            super(false);
            this.f47837n = concatMapSupport;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            i(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j8 = this.f47838o;
            if (j8 != 0) {
                this.f47838o = 0L;
                g(j8);
            }
            this.f47837n.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j8 = this.f47838o;
            if (j8 != 0) {
                this.f47838o = 0L;
                g(j8);
            }
            this.f47837n.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r7) {
            this.f47838o++;
            this.f47837n.d(r7);
        }
    }

    /* loaded from: classes5.dex */
    interface ConcatMapSupport<T> {
        void a(Throwable th);

        void b();

        void d(T t7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SimpleScalarSubscription<T> extends AtomicBoolean implements Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f47839f;

        /* renamed from: g  reason: collision with root package name */
        final T f47840g;

        SimpleScalarSubscription(T t7, Subscriber<? super T> subscriber) {
            this.f47840g = t7;
            this.f47839f = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (j8 > 0 && compareAndSet(false, true)) {
                Subscriber<? super T> subscriber = this.f47839f;
                subscriber.onNext((T) this.f47840g);
                subscriber.onComplete();
            }
        }
    }

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i8, ErrorMode errorMode) {
        super(flowable);
        this.f47817h = function;
        this.f47818i = i8;
        this.f47819j = errorMode;
    }

    public static <T, R> Subscriber<T> h0(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i8, ErrorMode errorMode) {
        int i9 = AnonymousClass1.f47820a[errorMode.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                return new ConcatMapImmediate(subscriber, function, i8);
            }
            return new ConcatMapDelayed(subscriber, function, i8, true);
        }
        return new ConcatMapDelayed(subscriber, function, i8, false);
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.b(this.f47792g, subscriber, this.f47817h)) {
            return;
        }
        this.f47792g.a(h0(subscriber, this.f47817h, this.f47818i, this.f47819j));
    }
}
