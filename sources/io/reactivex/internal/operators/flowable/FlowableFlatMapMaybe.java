package io.reactivex.internal.operators.flowable;

import androidx.camera.view.e;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: h  reason: collision with root package name */
    final Function<? super T, ? extends MaybeSource<? extends R>> f47955h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f47956i;

    /* renamed from: j  reason: collision with root package name */
    final int f47957j;

    /* loaded from: classes5.dex */
    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super R> f47958f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f47959g;

        /* renamed from: h  reason: collision with root package name */
        final int f47960h;

        /* renamed from: m  reason: collision with root package name */
        final Function<? super T, ? extends MaybeSource<? extends R>> f47965m;

        /* renamed from: o  reason: collision with root package name */
        Subscription f47967o;

        /* renamed from: p  reason: collision with root package name */
        volatile boolean f47968p;

        /* renamed from: i  reason: collision with root package name */
        final AtomicLong f47961i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        final CompositeDisposable f47962j = new CompositeDisposable();

        /* renamed from: l  reason: collision with root package name */
        final AtomicThrowable f47964l = new AtomicThrowable();

        /* renamed from: k  reason: collision with root package name */
        final AtomicInteger f47963k = new AtomicInteger(1);

        /* renamed from: n  reason: collision with root package name */
        final AtomicReference<SpscLinkedArrayQueue<R>> f47966n = new AtomicReference<>();

        /* loaded from: classes5.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            InnerObserver() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.c(get());
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapMaybeSubscriber.this.i(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.j(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r7) {
                FlatMapMaybeSubscriber.this.k(this, r7);
            }
        }

        FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7, int i8) {
            this.f47958f = subscriber;
            this.f47965m = function;
            this.f47959g = z7;
            this.f47960h = i8;
        }

        void a() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f47966n.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            if (SubscriptionHelper.p(this.f47967o, subscription)) {
                this.f47967o = subscription;
                this.f47958f.c(this);
                int i8 = this.f47960h;
                if (i8 == Integer.MAX_VALUE) {
                    subscription.f(Long.MAX_VALUE);
                } else {
                    subscription.f(i8);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f47968p = true;
            this.f47967o.cancel();
            this.f47962j.dispose();
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
            if (r13 != 0) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
            if (r17.f47968p == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
            if (r17.f47959g != false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
            if (r17.f47964l.get() == null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
            r2 = r17.f47964l.b();
            a();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
            if (r2.get() != 0) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
            if (r7 == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
            if (r7.isEmpty() == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b3, code lost:
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
            if (r6 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
            if (r12 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
            r2 = r17.f47964l.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
            if (r2 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ca, code lost:
            if (r10 == 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00cc, code lost:
            io.reactivex.internal.util.BackpressureHelper.c(r17.f47961i, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
            if (r17.f47960h == Integer.MAX_VALUE) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
            r17.f47967o.f(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void d() {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.d():void");
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this.f47961i, j8);
                b();
            }
        }

        SpscLinkedArrayQueue<R> g() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f47966n.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Flowable.b());
            } while (!e.a(this.f47966n, null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        void i(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.f47962j.c(innerObserver);
            if (get() == 0) {
                boolean z7 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f47963k.decrementAndGet() == 0) {
                        z7 = true;
                    }
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f47966n.get();
                    if (z7 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable b8 = this.f47964l.b();
                        if (b8 != null) {
                            this.f47958f.onError(b8);
                            return;
                        } else {
                            this.f47958f.onComplete();
                            return;
                        }
                    }
                    if (this.f47960h != Integer.MAX_VALUE) {
                        this.f47967o.f(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    d();
                    return;
                }
            }
            this.f47963k.decrementAndGet();
            if (this.f47960h != Integer.MAX_VALUE) {
                this.f47967o.f(1L);
            }
            b();
        }

        void j(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            this.f47962j.c(innerObserver);
            if (this.f47964l.a(th)) {
                if (!this.f47959g) {
                    this.f47967o.cancel();
                    this.f47962j.dispose();
                } else if (this.f47960h != Integer.MAX_VALUE) {
                    this.f47967o.f(1L);
                }
                this.f47963k.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        void k(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r7) {
            this.f47962j.c(innerObserver);
            if (get() == 0) {
                boolean z7 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f47963k.decrementAndGet() == 0) {
                        z7 = true;
                    }
                    if (this.f47961i.get() != 0) {
                        this.f47958f.onNext(r7);
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f47966n.get();
                        if (z7 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            Throwable b8 = this.f47964l.b();
                            if (b8 != null) {
                                this.f47958f.onError(b8);
                                return;
                            } else {
                                this.f47958f.onComplete();
                                return;
                            }
                        }
                        BackpressureHelper.c(this.f47961i, 1L);
                        if (this.f47960h != Integer.MAX_VALUE) {
                            this.f47967o.f(1L);
                        }
                    } else {
                        SpscLinkedArrayQueue<R> g8 = g();
                        synchronized (g8) {
                            g8.offer(r7);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    d();
                }
            }
            SpscLinkedArrayQueue<R> g9 = g();
            synchronized (g9) {
                g9.offer(r7);
            }
            this.f47963k.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f47963k.decrementAndGet();
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f47963k.decrementAndGet();
            if (this.f47964l.a(th)) {
                if (!this.f47959g) {
                    this.f47962j.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.e(this.f47965m.apply(t7), "The mapper returned a null MaybeSource");
                this.f47963k.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f47968p && this.f47962j.b(innerObserver)) {
                    maybeSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f47967o.cancel();
                onError(th);
            }
        }
    }

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7, int i8) {
        super(flowable);
        this.f47955h = function;
        this.f47956i = z7;
        this.f47957j = i8;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super R> subscriber) {
        this.f47792g.Y(new FlatMapMaybeSubscriber(subscriber, this.f47955h, this.f47956i, this.f47957j));
    }
}
