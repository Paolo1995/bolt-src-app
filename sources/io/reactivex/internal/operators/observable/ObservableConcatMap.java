package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends U>> f48429g;

    /* renamed from: h  reason: collision with root package name */
    final int f48430h;

    /* renamed from: i  reason: collision with root package name */
    final ErrorMode f48431i;

    /* loaded from: classes5.dex */
    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48432f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f48433g;

        /* renamed from: h  reason: collision with root package name */
        final int f48434h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f48435i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final DelayErrorInnerObserver<R> f48436j;

        /* renamed from: k  reason: collision with root package name */
        final boolean f48437k;

        /* renamed from: l  reason: collision with root package name */
        SimpleQueue<T> f48438l;

        /* renamed from: m  reason: collision with root package name */
        Disposable f48439m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48440n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f48441o;

        /* renamed from: p  reason: collision with root package name */
        volatile boolean f48442p;

        /* renamed from: q  reason: collision with root package name */
        int f48443q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {

            /* renamed from: f  reason: collision with root package name */
            final Observer<? super R> f48444f;

            /* renamed from: g  reason: collision with root package name */
            final ConcatMapDelayErrorObserver<?, R> f48445g;

            DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.f48444f = observer;
                this.f48445g = concatMapDelayErrorObserver;
            }

            void a() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f48445g;
                concatMapDelayErrorObserver.f48440n = false;
                concatMapDelayErrorObserver.a();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f48445g;
                if (concatMapDelayErrorObserver.f48435i.a(th)) {
                    if (!concatMapDelayErrorObserver.f48437k) {
                        concatMapDelayErrorObserver.f48439m.dispose();
                    }
                    concatMapDelayErrorObserver.f48440n = false;
                    concatMapDelayErrorObserver.a();
                    return;
                }
                RxJavaPlugins.s(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(R r7) {
                this.f48444f.onNext(r7);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.e(this, disposable);
            }
        }

        ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i8, boolean z7) {
            this.f48432f = observer;
            this.f48433g = function;
            this.f48434h = i8;
            this.f48437k = z7;
            this.f48436j = new DelayErrorInnerObserver<>(observer, this);
        }

        void a() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.f48432f;
            SimpleQueue<T> simpleQueue = this.f48438l;
            AtomicThrowable atomicThrowable = this.f48435i;
            while (true) {
                if (!this.f48440n) {
                    if (this.f48442p) {
                        simpleQueue.clear();
                        return;
                    } else if (!this.f48437k && atomicThrowable.get() != null) {
                        simpleQueue.clear();
                        this.f48442p = true;
                        observer.onError(atomicThrowable.b());
                        return;
                    } else {
                        boolean z8 = this.f48441o;
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z8 && z7) {
                                this.f48442p = true;
                                Throwable b8 = atomicThrowable.b();
                                if (b8 != null) {
                                    observer.onError(b8);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else if (!z7) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48433g.apply(poll), "The mapper returned a null ObservableSource");
                                    if (observableSource instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) observableSource).call();
                                            if (obj != 0 && !this.f48442p) {
                                                observer.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            atomicThrowable.a(th);
                                        }
                                    } else {
                                        this.f48440n = true;
                                        observableSource.subscribe(this.f48436j);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    this.f48442p = true;
                                    this.f48439m.dispose();
                                    simpleQueue.clear();
                                    atomicThrowable.a(th2);
                                    observer.onError(atomicThrowable.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            this.f48442p = true;
                            this.f48439m.dispose();
                            atomicThrowable.a(th3);
                            observer.onError(atomicThrowable.b());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48442p = true;
            this.f48439m.dispose();
            this.f48436j.a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48442p;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48441o = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48435i.a(th)) {
                this.f48441o = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48443q == 0) {
                this.f48438l.offer(t7);
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48439m, disposable)) {
                this.f48439m = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a8 = queueDisposable.a(3);
                    if (a8 == 1) {
                        this.f48443q = a8;
                        this.f48438l = queueDisposable;
                        this.f48441o = true;
                        this.f48432f.onSubscribe(this);
                        a();
                        return;
                    } else if (a8 == 2) {
                        this.f48443q = a8;
                        this.f48438l = queueDisposable;
                        this.f48432f.onSubscribe(this);
                        return;
                    }
                }
                this.f48438l = new SpscLinkedArrayQueue(this.f48434h);
                this.f48432f.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super U> f48446f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends U>> f48447g;

        /* renamed from: h  reason: collision with root package name */
        final InnerObserver<U> f48448h;

        /* renamed from: i  reason: collision with root package name */
        final int f48449i;

        /* renamed from: j  reason: collision with root package name */
        SimpleQueue<T> f48450j;

        /* renamed from: k  reason: collision with root package name */
        Disposable f48451k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48452l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48453m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48454n;

        /* renamed from: o  reason: collision with root package name */
        int f48455o;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {

            /* renamed from: f  reason: collision with root package name */
            final Observer<? super U> f48456f;

            /* renamed from: g  reason: collision with root package name */
            final SourceObserver<?, ?> f48457g;

            InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.f48456f = observer;
                this.f48457g = sourceObserver;
            }

            void a() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.f48457g.b();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                this.f48457g.dispose();
                this.f48456f.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u7) {
                this.f48456f.onNext(u7);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.e(this, disposable);
            }
        }

        SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i8) {
            this.f48446f = observer;
            this.f48447g = function;
            this.f48449i = i8;
            this.f48448h = new InnerObserver<>(observer, this);
        }

        void a() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f48453m) {
                if (!this.f48452l) {
                    boolean z8 = this.f48454n;
                    try {
                        T poll = this.f48450j.poll();
                        if (poll == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z8 && z7) {
                            this.f48453m = true;
                            this.f48446f.onComplete();
                            return;
                        } else if (!z7) {
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48447g.apply(poll), "The mapper returned a null ObservableSource");
                                this.f48452l = true;
                                observableSource.subscribe(this.f48448h);
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                dispose();
                                this.f48450j.clear();
                                this.f48446f.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        dispose();
                        this.f48450j.clear();
                        this.f48446f.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f48450j.clear();
        }

        void b() {
            this.f48452l = false;
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48453m = true;
            this.f48448h.a();
            this.f48451k.dispose();
            if (getAndIncrement() == 0) {
                this.f48450j.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48453m;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48454n) {
                return;
            }
            this.f48454n = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48454n) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48454n = true;
            dispose();
            this.f48446f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48454n) {
                return;
            }
            if (this.f48455o == 0) {
                this.f48450j.offer(t7);
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48451k, disposable)) {
                this.f48451k = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a8 = queueDisposable.a(3);
                    if (a8 == 1) {
                        this.f48455o = a8;
                        this.f48450j = queueDisposable;
                        this.f48454n = true;
                        this.f48446f.onSubscribe(this);
                        a();
                        return;
                    } else if (a8 == 2) {
                        this.f48455o = a8;
                        this.f48450j = queueDisposable;
                        this.f48446f.onSubscribe(this);
                        return;
                    }
                }
                this.f48450j = new SpscLinkedArrayQueue(this.f48449i);
                this.f48446f.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i8, ErrorMode errorMode) {
        super(observableSource);
        this.f48429g = function;
        this.f48431i = errorMode;
        this.f48430h = Math.max(8, i8);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        boolean z7;
        if (ObservableScalarXMap.b(this.f48232f, observer, this.f48429g)) {
            return;
        }
        if (this.f48431i == ErrorMode.IMMEDIATE) {
            this.f48232f.subscribe(new SourceObserver(new SerializedObserver(observer), this.f48429g, this.f48430h));
            return;
        }
        ObservableSource<T> observableSource = this.f48232f;
        Function<? super T, ? extends ObservableSource<? extends U>> function = this.f48429g;
        int i8 = this.f48430h;
        if (this.f48431i == ErrorMode.END) {
            z7 = true;
        } else {
            z7 = false;
        }
        observableSource.subscribe(new ConcatMapDelayErrorObserver(observer, function, i8, z7));
    }
}
