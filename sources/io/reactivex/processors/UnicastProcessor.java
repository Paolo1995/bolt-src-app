package io.reactivex.processors;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: g  reason: collision with root package name */
    final SpscLinkedArrayQueue<T> f49874g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicReference<Runnable> f49875h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f49876i;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f49877j;

    /* renamed from: k  reason: collision with root package name */
    Throwable f49878k;

    /* renamed from: l  reason: collision with root package name */
    final AtomicReference<Subscriber<? super T>> f49879l;

    /* renamed from: m  reason: collision with root package name */
    volatile boolean f49880m;

    /* renamed from: n  reason: collision with root package name */
    final AtomicBoolean f49881n;

    /* renamed from: o  reason: collision with root package name */
    final BasicIntQueueSubscription<T> f49882o;

    /* renamed from: p  reason: collision with root package name */
    final AtomicLong f49883p;

    /* renamed from: q  reason: collision with root package name */
    boolean f49884q;

    /* loaded from: classes5.dex */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        UnicastQueueSubscription() {
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 2) != 0) {
                UnicastProcessor.this.f49884q = true;
                return 2;
            }
            return 0;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (UnicastProcessor.this.f49880m) {
                return;
            }
            UnicastProcessor.this.f49880m = true;
            UnicastProcessor.this.k0();
            UnicastProcessor.this.f49879l.lazySet(null);
            if (UnicastProcessor.this.f49882o.getAndIncrement() == 0) {
                UnicastProcessor.this.f49879l.lazySet(null);
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (!unicastProcessor.f49884q) {
                    unicastProcessor.f49874g.clear();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.f49874g.clear();
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(UnicastProcessor.this.f49883p, j8);
                UnicastProcessor.this.l0();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.f49874g.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() {
            return UnicastProcessor.this.f49874g.poll();
        }
    }

    UnicastProcessor(int i8) {
        this(i8, null, true);
    }

    public static <T> UnicastProcessor<T> j0(int i8) {
        return new UnicastProcessor<>(i8);
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super T> subscriber) {
        if (!this.f49881n.get() && this.f49881n.compareAndSet(false, true)) {
            subscriber.c(this.f49882o);
            this.f49879l.set(subscriber);
            if (this.f49880m) {
                this.f49879l.lazySet(null);
                return;
            } else {
                l0();
                return;
            }
        }
        EmptySubscription.e(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
    }

    @Override // org.reactivestreams.Subscriber
    public void c(Subscription subscription) {
        if (!this.f49877j && !this.f49880m) {
            subscription.f(Long.MAX_VALUE);
        } else {
            subscription.cancel();
        }
    }

    boolean i0(boolean z7, boolean z8, boolean z9, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.f49880m) {
            spscLinkedArrayQueue.clear();
            this.f49879l.lazySet(null);
            return true;
        } else if (z8) {
            if (z7 && this.f49878k != null) {
                spscLinkedArrayQueue.clear();
                this.f49879l.lazySet(null);
                subscriber.onError(this.f49878k);
                return true;
            } else if (z9) {
                Throwable th = this.f49878k;
                this.f49879l.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void k0() {
        Runnable andSet = this.f49875h.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    void l0() {
        if (this.f49882o.getAndIncrement() != 0) {
            return;
        }
        int i8 = 1;
        Subscriber<? super T> subscriber = this.f49879l.get();
        while (subscriber == null) {
            i8 = this.f49882o.addAndGet(-i8);
            if (i8 == 0) {
                return;
            }
            subscriber = this.f49879l.get();
        }
        if (this.f49884q) {
            m0(subscriber);
        } else {
            n0(subscriber);
        }
    }

    void m0(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f49874g;
        int i8 = 1;
        boolean z7 = !this.f49876i;
        while (!this.f49880m) {
            boolean z8 = this.f49877j;
            if (z7 && z8 && this.f49878k != null) {
                spscLinkedArrayQueue.clear();
                this.f49879l.lazySet(null);
                subscriber.onError(this.f49878k);
                return;
            }
            subscriber.onNext(null);
            if (z8) {
                this.f49879l.lazySet(null);
                Throwable th = this.f49878k;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            i8 = this.f49882o.addAndGet(-i8);
            if (i8 == 0) {
                return;
            }
        }
        this.f49879l.lazySet(null);
    }

    void n0(Subscriber<? super T> subscriber) {
        int i8;
        long j8;
        boolean z7;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f49874g;
        boolean z8 = !this.f49876i;
        int i9 = 1;
        while (true) {
            long j9 = this.f49883p.get();
            long j10 = 0;
            while (true) {
                i8 = (j9 > j10 ? 1 : (j9 == j10 ? 0 : -1));
                if (i8 != 0) {
                    boolean z9 = this.f49877j;
                    T poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    j8 = j10;
                    if (i0(z8, z9, z7, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j10 = 1 + j8;
                } else {
                    j8 = j10;
                    break;
                }
            }
            if (i8 == 0 && i0(z8, this.f49877j, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j8 != 0 && j9 != Long.MAX_VALUE) {
                this.f49883p.addAndGet(-j8);
            }
            i9 = this.f49882o.addAndGet(-i9);
            if (i9 == 0) {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.f49877j && !this.f49880m) {
            this.f49877j = true;
            k0();
            l0();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f49877j && !this.f49880m) {
            this.f49878k = th;
            this.f49877j = true;
            k0();
            l0();
            return;
        }
        RxJavaPlugins.s(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t7) {
        ObjectHelper.e(t7, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f49877j && !this.f49880m) {
            this.f49874g.offer(t7);
            l0();
        }
    }

    UnicastProcessor(int i8, Runnable runnable, boolean z7) {
        this.f49874g = new SpscLinkedArrayQueue<>(ObjectHelper.f(i8, "capacityHint"));
        this.f49875h = new AtomicReference<>(runnable);
        this.f49876i = z7;
        this.f49879l = new AtomicReference<>();
        this.f49881n = new AtomicBoolean();
        this.f49882o = new UnicastQueueSubscription();
        this.f49883p = new AtomicLong();
    }
}
