package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends U>> f48615g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48616h;

    /* renamed from: i  reason: collision with root package name */
    final int f48617i;

    /* renamed from: j  reason: collision with root package name */
    final int f48618j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {

        /* renamed from: f  reason: collision with root package name */
        final long f48619f;

        /* renamed from: g  reason: collision with root package name */
        final MergeObserver<T, U> f48620g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f48621h;

        /* renamed from: i  reason: collision with root package name */
        volatile SimpleQueue<U> f48622i;

        /* renamed from: j  reason: collision with root package name */
        int f48623j;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j8) {
            this.f48619f = j8;
            this.f48620g = mergeObserver;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48621h = true;
            this.f48620g.d();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48620g.f48633m.a(th)) {
                MergeObserver<T, U> mergeObserver = this.f48620g;
                if (!mergeObserver.f48628h) {
                    mergeObserver.c();
                }
                this.f48621h = true;
                this.f48620g.d();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u7) {
            if (this.f48623j == 0) {
                this.f48620g.i(u7, this);
            } else {
                this.f48620g.d();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int a8 = queueDisposable.a(7);
                if (a8 == 1) {
                    this.f48623j = a8;
                    this.f48622i = queueDisposable;
                    this.f48621h = true;
                    this.f48620g.d();
                } else if (a8 == 2) {
                    this.f48623j = a8;
                    this.f48622i = queueDisposable;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {

        /* renamed from: v  reason: collision with root package name */
        static final InnerObserver<?, ?>[] f48624v = new InnerObserver[0];

        /* renamed from: w  reason: collision with root package name */
        static final InnerObserver<?, ?>[] f48625w = new InnerObserver[0];

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super U> f48626f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends U>> f48627g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f48628h;

        /* renamed from: i  reason: collision with root package name */
        final int f48629i;

        /* renamed from: j  reason: collision with root package name */
        final int f48630j;

        /* renamed from: k  reason: collision with root package name */
        volatile SimplePlainQueue<U> f48631k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48632l;

        /* renamed from: m  reason: collision with root package name */
        final AtomicThrowable f48633m = new AtomicThrowable();

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48634n;

        /* renamed from: o  reason: collision with root package name */
        final AtomicReference<InnerObserver<?, ?>[]> f48635o;

        /* renamed from: p  reason: collision with root package name */
        Disposable f48636p;

        /* renamed from: q  reason: collision with root package name */
        long f48637q;

        /* renamed from: r  reason: collision with root package name */
        long f48638r;

        /* renamed from: s  reason: collision with root package name */
        int f48639s;

        /* renamed from: t  reason: collision with root package name */
        Queue<ObservableSource<? extends U>> f48640t;

        /* renamed from: u  reason: collision with root package name */
        int f48641u;

        MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z7, int i8, int i9) {
            this.f48626f = observer;
            this.f48627g = function;
            this.f48628h = z7;
            this.f48629i = i8;
            this.f48630j = i9;
            if (i8 != Integer.MAX_VALUE) {
                this.f48640t = new ArrayDeque(i8);
            }
            this.f48635o = new AtomicReference<>(f48624v);
        }

        boolean a(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.f48635o.get();
                if (innerObserverArr == f48625w) {
                    innerObserver.a();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!e.a(this.f48635o, innerObserverArr, innerObserverArr2));
            return true;
        }

        boolean b() {
            if (this.f48634n) {
                return true;
            }
            Throwable th = this.f48633m.get();
            if (!this.f48628h && th != null) {
                c();
                Throwable b8 = this.f48633m.b();
                if (b8 != ExceptionHelper.f49808a) {
                    this.f48626f.onError(b8);
                }
                return true;
            }
            return false;
        }

        boolean c() {
            InnerObserver<?, ?>[] andSet;
            this.f48636p.dispose();
            InnerObserver<?, ?>[] innerObserverArr = this.f48635o.get();
            InnerObserver<?, ?>[] innerObserverArr2 = f48625w;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.f48635o.getAndSet(innerObserverArr2)) == innerObserverArr2) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.a();
            }
            return true;
        }

        void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Throwable b8;
            if (!this.f48634n) {
                this.f48634n = true;
                if (c() && (b8 = this.f48633m.b()) != null && b8 != ExceptionHelper.f49808a) {
                    RxJavaPlugins.s(b8);
                }
            }
        }

        void e() {
            int i8;
            Observer<? super U> observer = this.f48626f;
            int i9 = 1;
            while (!b()) {
                SimplePlainQueue<U> simplePlainQueue = this.f48631k;
                int i10 = 0;
                if (simplePlainQueue != null) {
                    while (!b()) {
                        Object obj = (U) simplePlainQueue.poll();
                        if (obj != null) {
                            observer.onNext(obj);
                            i10++;
                        }
                    }
                    return;
                }
                if (i10 != 0) {
                    if (this.f48629i != Integer.MAX_VALUE) {
                        h(i10);
                    }
                } else {
                    boolean z7 = this.f48632l;
                    SimplePlainQueue<U> simplePlainQueue2 = this.f48631k;
                    InnerObserver<?, ?>[] innerObserverArr = this.f48635o.get();
                    int length = innerObserverArr.length;
                    if (this.f48629i != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i8 = this.f48640t.size();
                        }
                    } else {
                        i8 = 0;
                    }
                    if (z7 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i8 == 0)) {
                        Throwable b8 = this.f48633m.b();
                        if (b8 != ExceptionHelper.f49808a) {
                            if (b8 == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(b8);
                                return;
                            }
                        }
                        return;
                    }
                    if (length != 0) {
                        long j8 = this.f48638r;
                        int i11 = this.f48639s;
                        if (length <= i11 || innerObserverArr[i11].f48619f != j8) {
                            if (length <= i11) {
                                i11 = 0;
                            }
                            for (int i12 = 0; i12 < length && innerObserverArr[i11].f48619f != j8; i12++) {
                                i11++;
                                if (i11 == length) {
                                    i11 = 0;
                                }
                            }
                            this.f48639s = i11;
                            this.f48638r = innerObserverArr[i11].f48619f;
                        }
                        for (int i13 = 0; i13 < length; i13++) {
                            if (b()) {
                                return;
                            }
                            InnerObserver<T, U> innerObserver = innerObserverArr[i11];
                            SimpleQueue<U> simpleQueue = innerObserver.f48622i;
                            if (simpleQueue != null) {
                                while (true) {
                                    try {
                                        Object obj2 = (U) simpleQueue.poll();
                                        if (obj2 == null) {
                                            break;
                                        }
                                        observer.onNext(obj2);
                                        if (b()) {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.b(th);
                                        innerObserver.a();
                                        this.f48633m.a(th);
                                        if (b()) {
                                            return;
                                        }
                                        f(innerObserver);
                                        i10++;
                                        i11++;
                                        if (i11 != length) {
                                        }
                                    }
                                }
                            }
                            boolean z8 = innerObserver.f48621h;
                            SimpleQueue<U> simpleQueue2 = innerObserver.f48622i;
                            if (z8 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                f(innerObserver);
                                if (b()) {
                                    return;
                                }
                                i10++;
                            }
                            i11++;
                            if (i11 != length) {
                            }
                            i11 = 0;
                        }
                        this.f48639s = i11;
                        this.f48638r = innerObserverArr[i11].f48619f;
                    }
                    if (i10 != 0) {
                        if (this.f48629i != Integer.MAX_VALUE) {
                            h(i10);
                        }
                    } else {
                        i9 = addAndGet(-i9);
                        if (i9 == 0) {
                            return;
                        }
                    }
                }
            }
        }

        void f(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.f48635o.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i8 = -1;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        break;
                    } else if (innerObserverArr[i9] == innerObserver) {
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
                    innerObserverArr2 = f48624v;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i8);
                    System.arraycopy(innerObserverArr, i8 + 1, innerObserverArr3, i8, (length - i8) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!e.a(this.f48635o, innerObserverArr, innerObserverArr2));
        }

        void g(ObservableSource<? extends U> observableSource) {
            ObservableSource<? extends U> poll;
            while (observableSource instanceof Callable) {
                if (j((Callable) observableSource) && this.f48629i != Integer.MAX_VALUE) {
                    boolean z7 = false;
                    synchronized (this) {
                        poll = this.f48640t.poll();
                        if (poll == null) {
                            this.f48641u--;
                            z7 = true;
                        }
                    }
                    if (z7) {
                        d();
                        return;
                    }
                    observableSource = poll;
                } else {
                    return;
                }
            }
            long j8 = this.f48637q;
            this.f48637q = 1 + j8;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j8);
            if (a(innerObserver)) {
                observableSource.subscribe(innerObserver);
            }
        }

        void h(int i8) {
            while (true) {
                int i9 = i8 - 1;
                if (i8 != 0) {
                    synchronized (this) {
                        ObservableSource<? extends U> poll = this.f48640t.poll();
                        if (poll == null) {
                            this.f48641u--;
                        } else {
                            g(poll);
                        }
                    }
                    i8 = i9;
                } else {
                    return;
                }
            }
        }

        void i(U u7, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f48626f.onNext(u7);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue = innerObserver.f48622i;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.f48630j);
                    innerObserver.f48622i = simpleQueue;
                }
                simpleQueue.offer(u7);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            e();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48634n;
        }

        boolean j(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f48626f.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    SimplePlainQueue<U> simplePlainQueue = this.f48631k;
                    if (simplePlainQueue == null) {
                        if (this.f48629i == Integer.MAX_VALUE) {
                            simplePlainQueue = new SpscLinkedArrayQueue<>(this.f48630j);
                        } else {
                            simplePlainQueue = new SpscArrayQueue<>(this.f48629i);
                        }
                        this.f48631k = simplePlainQueue;
                    }
                    if (!simplePlainQueue.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                e();
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48633m.a(th);
                d();
                return true;
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48632l) {
                return;
            }
            this.f48632l = true;
            d();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48632l) {
                RxJavaPlugins.s(th);
            } else if (this.f48633m.a(th)) {
                this.f48632l = true;
                d();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48632l) {
                return;
            }
            try {
                ObservableSource<? extends U> observableSource = (ObservableSource) ObjectHelper.e(this.f48627g.apply(t7), "The mapper returned a null ObservableSource");
                if (this.f48629i != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i8 = this.f48641u;
                        if (i8 == this.f48629i) {
                            this.f48640t.offer(observableSource);
                            return;
                        }
                        this.f48641u = i8 + 1;
                    }
                }
                g(observableSource);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48636p.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48636p, disposable)) {
                this.f48636p = disposable;
                this.f48626f.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z7, int i8, int i9) {
        super(observableSource);
        this.f48615g = function;
        this.f48616h = z7;
        this.f48617i = i8;
        this.f48618j = i9;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (ObservableScalarXMap.b(this.f48232f, observer, this.f48615g)) {
            return;
        }
        this.f48232f.subscribe(new MergeObserver(observer, this.f48615g, this.f48616h, this.f48617i, this.f48618j));
    }
}
