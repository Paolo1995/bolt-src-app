package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes5.dex */
public final class FlowableCreate<T> extends Flowable<T> {

    /* renamed from: g  reason: collision with root package name */
    final FlowableOnSubscribe<T> f47841g;

    /* renamed from: h  reason: collision with root package name */
    final BackpressureStrategy f47842h;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47843a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f47843a = iArr;
            try {
                iArr[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47843a[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47843a[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47843a[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {

        /* renamed from: f  reason: collision with root package name */
        final Subscriber<? super T> f47844f;

        /* renamed from: g  reason: collision with root package name */
        final SequentialDisposable f47845g = new SequentialDisposable();

        BaseEmitter(Subscriber<? super T> subscriber) {
            this.f47844f = subscriber;
        }

        public boolean a(Throwable th) {
            return e(th);
        }

        @Override // io.reactivex.FlowableEmitter
        public final void c(Disposable disposable) {
            this.f47845g.b(disposable);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f47845g.dispose();
            h();
        }

        protected void d() {
            if (isCancelled()) {
                return;
            }
            try {
                this.f47844f.onComplete();
            } finally {
                this.f47845g.dispose();
            }
        }

        protected boolean e(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.f47844f.onError(th);
                this.f47845g.dispose();
                return true;
            } catch (Throwable th2) {
                this.f47845g.dispose();
                throw th2;
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void f(long j8) {
            if (SubscriptionHelper.m(j8)) {
                BackpressureHelper.a(this, j8);
                g();
            }
        }

        void g() {
        }

        void h() {
        }

        @Override // io.reactivex.FlowableEmitter
        public final boolean isCancelled() {
            return this.f47845g.isDisposed();
        }

        @Override // io.reactivex.Emitter
        public final void onError(Throwable th) {
            if (!a(th)) {
                RxJavaPlugins.s(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }

    /* loaded from: classes5.dex */
    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {

        /* renamed from: h  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f47846h;

        /* renamed from: i  reason: collision with root package name */
        Throwable f47847i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f47848j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicInteger f47849k;

        BufferAsyncEmitter(Subscriber<? super T> subscriber, int i8) {
            super(subscriber);
            this.f47846h = new SpscLinkedArrayQueue<>(i8);
            this.f47849k = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean a(Throwable th) {
            if (!this.f47848j && !isCancelled()) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                this.f47847i = th;
                this.f47848j = true;
                i();
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void g() {
            i();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void h() {
            if (this.f47849k.getAndIncrement() == 0) {
                this.f47846h.clear();
            }
        }

        void i() {
            int i8;
            boolean z7;
            if (this.f47849k.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.f47844f;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f47846h;
            int i9 = 1;
            do {
                long j8 = get();
                long j9 = 0;
                while (true) {
                    i8 = (j9 > j8 ? 1 : (j9 == j8 ? 0 : -1));
                    if (i8 == 0) {
                        break;
                    } else if (isCancelled()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    } else {
                        boolean z8 = this.f47848j;
                        Object obj = (T) spscLinkedArrayQueue.poll();
                        if (obj == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z8 && z7) {
                            Throwable th = this.f47847i;
                            if (th != null) {
                                e(th);
                                return;
                            } else {
                                d();
                                return;
                            }
                        } else if (z7) {
                            break;
                        } else {
                            subscriber.onNext(obj);
                            j9++;
                        }
                    }
                }
                if (i8 == 0) {
                    if (isCancelled()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z9 = this.f47848j;
                    boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                    if (z9 && isEmpty) {
                        Throwable th2 = this.f47847i;
                        if (th2 != null) {
                            e(th2);
                            return;
                        } else {
                            d();
                            return;
                        }
                    }
                }
                if (j9 != 0) {
                    BackpressureHelper.c(this, j9);
                }
                i9 = this.f47849k.addAndGet(-i9);
            } while (i9 != 0);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t7) {
            if (!this.f47848j && !isCancelled()) {
                if (t7 == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f47846h.offer(t7);
                i();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void i() {
        }
    }

    /* loaded from: classes5.dex */
    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void i() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* loaded from: classes5.dex */
    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<T> f47850h;

        /* renamed from: i  reason: collision with root package name */
        Throwable f47851i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f47852j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicInteger f47853k;

        LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.f47850h = new AtomicReference<>();
            this.f47853k = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean a(Throwable th) {
            if (!this.f47852j && !isCancelled()) {
                if (th == null) {
                    onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
                }
                this.f47851i = th;
                this.f47852j = true;
                i();
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void g() {
            i();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void h() {
            if (this.f47853k.getAndIncrement() == 0) {
                this.f47850h.lazySet(null);
            }
        }

        void i() {
            boolean z7;
            int i8;
            boolean z8;
            if (this.f47853k.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.f47844f;
            AtomicReference<T> atomicReference = this.f47850h;
            int i9 = 1;
            do {
                long j8 = get();
                long j9 = 0;
                while (true) {
                    z7 = false;
                    i8 = (j9 > j8 ? 1 : (j9 == j8 ? 0 : -1));
                    if (i8 == 0) {
                        break;
                    } else if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    } else {
                        boolean z9 = this.f47852j;
                        Object obj = (T) atomicReference.getAndSet(null);
                        if (obj == null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (z9 && z8) {
                            Throwable th = this.f47851i;
                            if (th != null) {
                                e(th);
                                return;
                            } else {
                                d();
                                return;
                            }
                        } else if (z8) {
                            break;
                        } else {
                            subscriber.onNext(obj);
                            j9++;
                        }
                    }
                }
                if (i8 == 0) {
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z10 = this.f47852j;
                    if (atomicReference.get() == null) {
                        z7 = true;
                    }
                    if (z10 && z7) {
                        Throwable th2 = this.f47851i;
                        if (th2 != null) {
                            e(th2);
                            return;
                        } else {
                            d();
                            return;
                        }
                    }
                }
                if (j9 != 0) {
                    BackpressureHelper.c(this, j9);
                }
                i9 = this.f47853k.addAndGet(-i9);
            } while (i9 != 0);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t7) {
            if (!this.f47852j && !isCancelled()) {
                if (t7 == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f47850h.set(t7);
                i();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class MissingEmitter<T> extends BaseEmitter<T> {
        MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t7) {
            long j8;
            if (isCancelled()) {
                return;
            }
            if (t7 != null) {
                this.f47844f.onNext(t7);
                do {
                    j8 = get();
                    if (j8 == 0) {
                        return;
                    }
                } while (!compareAndSet(j8, j8 - 1));
                return;
            }
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
    }

    /* loaded from: classes5.dex */
    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        abstract void i();

        @Override // io.reactivex.Emitter
        public final void onNext(T t7) {
            if (isCancelled()) {
                return;
            }
            if (t7 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() != 0) {
                this.f47844f.onNext(t7);
                BackpressureHelper.c(this, 1L);
            } else {
                i();
            }
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.f47841g = flowableOnSubscribe;
        this.f47842h = backpressureStrategy;
    }

    @Override // io.reactivex.Flowable
    public void Z(Subscriber<? super T> subscriber) {
        BaseEmitter missingEmitter;
        int i8 = AnonymousClass1.f47843a[this.f47842h.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        missingEmitter = new BufferAsyncEmitter(subscriber, Flowable.b());
                    } else {
                        missingEmitter = new LatestAsyncEmitter(subscriber);
                    }
                } else {
                    missingEmitter = new DropAsyncEmitter(subscriber);
                }
            } else {
                missingEmitter = new ErrorAsyncEmitter(subscriber);
            }
        } else {
            missingEmitter = new MissingEmitter(subscriber);
        }
        subscriber.c(missingEmitter);
        try {
            this.f47841g.a(missingEmitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            missingEmitter.onError(th);
        }
    }
}
