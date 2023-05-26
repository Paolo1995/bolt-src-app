package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {

    /* renamed from: g  reason: collision with root package name */
    final Publisher<? extends T>[] f47793g;

    /* renamed from: h  reason: collision with root package name */
    final Iterable<? extends Publisher<? extends T>> f47794h = null;

    /* renamed from: i  reason: collision with root package name */
    final Function<? super Object[], ? extends R> f47795i;

    /* renamed from: j  reason: collision with root package name */
    final int f47796j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f47797k;

    /* loaded from: classes5.dex */
    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super R> f47798f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Object[], ? extends R> f47799g;

        /* renamed from: h  reason: collision with root package name */
        final CombineLatestInnerSubscriber<T>[] f47800h;

        /* renamed from: i  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f47801i;

        /* renamed from: j  reason: collision with root package name */
        final Object[] f47802j;

        /* renamed from: k  reason: collision with root package name */
        final boolean f47803k;

        /* renamed from: l  reason: collision with root package name */
        boolean f47804l;

        /* renamed from: m  reason: collision with root package name */
        int f47805m;

        /* renamed from: n  reason: collision with root package name */
        int f47806n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f47807o;

        /* renamed from: p  reason: collision with root package name */
        final AtomicLong f47808p;

        /* renamed from: q  reason: collision with root package name */
        volatile boolean f47809q;

        /* renamed from: r  reason: collision with root package name */
        final AtomicReference<Throwable> f47810r;

        CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i8, int i9, boolean z7) {
            this.f47798f = subscriber;
            this.f47799g = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i8];
            for (int i10 = 0; i10 < i8; i10++) {
                combineLatestInnerSubscriberArr[i10] = new CombineLatestInnerSubscriber<>(this, i10, i9);
            }
            this.f47800h = combineLatestInnerSubscriberArr;
            this.f47802j = new Object[i8];
            this.f47801i = new SpscLinkedArrayQueue<>(i9);
            this.f47808p = new AtomicLong();
            this.f47810r = new AtomicReference<>();
            this.f47803k = z7;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            boolean z7 = false;
            if ((i8 & 4) != 0) {
                return 0;
            }
            int i9 = i8 & 2;
            if (i9 != 0) {
                z7 = true;
            }
            this.f47804l = z7;
            return i9;
        }

        void b() {
            for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.f47800h) {
                combineLatestInnerSubscriber.a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f47807o = true;
            b();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f47801i.clear();
        }

        boolean d(boolean z7, boolean z8, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.f47807o) {
                b();
                spscLinkedArrayQueue.clear();
                return true;
            } else if (z7) {
                if (this.f47803k) {
                    if (z8) {
                        b();
                        Throwable b8 = ExceptionHelper.b(this.f47810r);
                        if (b8 != null && b8 != ExceptionHelper.f49808a) {
                            subscriber.onError(b8);
                        } else {
                            subscriber.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable b9 = ExceptionHelper.b(this.f47810r);
                if (b9 != null && b9 != ExceptionHelper.f49808a) {
                    b();
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(b9);
                    return true;
                } else if (z8) {
                    b();
                    subscriber.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this.f47808p, j8);
                g();
            }
        }

        void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.f47804l) {
                j();
            } else {
                i();
            }
        }

        void i() {
            int i8;
            boolean z7;
            Subscriber<? super R> subscriber = this.f47798f;
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.f47801i;
            int i9 = 1;
            do {
                long j8 = this.f47808p.get();
                long j9 = 0;
                while (true) {
                    i8 = (j9 > j8 ? 1 : (j9 == j8 ? 0 : -1));
                    if (i8 == 0) {
                        break;
                    }
                    boolean z8 = this.f47809q;
                    Object poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (d(z8, z7, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    try {
                        subscriber.onNext((Object) ObjectHelper.e(this.f47799g.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                        ((CombineLatestInnerSubscriber) poll).b();
                        j9++;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        b();
                        ExceptionHelper.a(this.f47810r, th);
                        subscriber.onError(ExceptionHelper.b(this.f47810r));
                        return;
                    }
                }
                if (i8 == 0 && d(this.f47809q, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j9 != 0 && j8 != Long.MAX_VALUE) {
                    this.f47808p.addAndGet(-j9);
                }
                i9 = addAndGet(-i9);
            } while (i9 != 0);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f47801i.isEmpty();
        }

        void j() {
            Subscriber<? super R> subscriber = this.f47798f;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f47801i;
            int i8 = 1;
            while (!this.f47807o) {
                Throwable th = this.f47810r.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z7 = this.f47809q;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (!isEmpty) {
                    subscriber.onNext(null);
                }
                if (z7 && isEmpty) {
                    subscriber.onComplete();
                    return;
                }
                i8 = addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void k(int i8) {
            synchronized (this) {
                Object[] objArr = this.f47802j;
                if (objArr[i8] != null) {
                    int i9 = this.f47806n + 1;
                    if (i9 == objArr.length) {
                        this.f47809q = true;
                    } else {
                        this.f47806n = i9;
                        return;
                    }
                } else {
                    this.f47809q = true;
                }
                g();
            }
        }

        void l(int i8, Throwable th) {
            if (ExceptionHelper.a(this.f47810r, th)) {
                if (!this.f47803k) {
                    b();
                    this.f47809q = true;
                    g();
                    return;
                }
                k(i8);
                return;
            }
            RxJavaPlugins.s(th);
        }

        void m(int i8, T t7) {
            boolean z7;
            synchronized (this) {
                Object[] objArr = this.f47802j;
                int i9 = this.f47805m;
                if (objArr[i8] == null) {
                    i9++;
                    this.f47805m = i9;
                }
                objArr[i8] = t7;
                if (objArr.length == i9) {
                    this.f47801i.m(this.f47800h[i8], objArr.clone());
                    z7 = false;
                } else {
                    z7 = true;
                }
            }
            if (z7) {
                this.f47800h[i8].b();
            } else {
                g();
            }
        }

        void n(Publisher<? extends T>[] publisherArr, int i8) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.f47800h;
            for (int i9 = 0; i9 < i8 && !this.f47809q && !this.f47807o; i9++) {
                publisherArr[i9].a(combineLatestInnerSubscriberArr[i9]);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
            Object poll = this.f47801i.poll();
            if (poll == null) {
                return null;
            }
            R r7 = (R) ObjectHelper.e(this.f47799g.apply((Object[]) this.f47801i.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).b();
            return r7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {

        /* renamed from: f  reason: collision with root package name */
        final CombineLatestCoordinator<T, ?> f47811f;

        /* renamed from: g  reason: collision with root package name */
        final int f47812g;

        /* renamed from: h  reason: collision with root package name */
        final int f47813h;

        /* renamed from: i  reason: collision with root package name */
        final int f47814i;

        /* renamed from: j  reason: collision with root package name */
        int f47815j;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i8, int i9) {
            this.f47811f = combineLatestCoordinator;
            this.f47812g = i8;
            this.f47813h = i9;
            this.f47814i = i9 - (i9 >> 2);
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        public void b() {
            int i8 = this.f47815j + 1;
            if (i8 == this.f47814i) {
                this.f47815j = 0;
                get().f(i8);
                return;
            }
            this.f47815j = i8;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            SubscriptionHelper.l(this, subscription, this.f47813h);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f47811f.k(this.f47812g);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f47811f.l(this.f47812g, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t7) {
            this.f47811f.m(this.f47812g, t7);
        }
    }

    /* loaded from: classes5.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t7) throws Exception {
            return FlowableCombineLatest.this.f47795i.apply(new Object[]{t7});
        }
    }

    public FlowableCombineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i8, boolean z7) {
        this.f47793g = publisherArr;
        this.f47795i = function;
        this.f47796j = i8;
        this.f47797k = z7;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.f47793g;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                Iterator it = (Iterator) ObjectHelper.e(this.f47794h.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher<? extends T> publisher = (Publisher) ObjectHelper.e(it.next(), "The publisher returned by the iterator is null");
                            if (length == publisherArr.length) {
                                Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                                System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                                publisherArr = publisherArr2;
                            }
                            publisherArr[length] = publisher;
                            length++;
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            EmptySubscription.e(th, subscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        EmptySubscription.e(th2, subscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                EmptySubscription.e(th3, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        int i8 = length;
        if (i8 == 0) {
            EmptySubscription.c(subscriber);
        } else if (i8 == 1) {
            publisherArr[0].a(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.f47795i, i8, this.f47796j, this.f47797k);
            subscriber.c(combineLatestCoordinator);
            combineLatestCoordinator.n(publisherArr, i8);
        }
    }
}
