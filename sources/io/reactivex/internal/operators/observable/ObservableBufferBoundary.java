package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final Callable<U> f48306g;

    /* renamed from: h  reason: collision with root package name */
    final ObservableSource<? extends Open> f48307h;

    /* renamed from: i  reason: collision with root package name */
    final Function<? super Open, ? extends ObservableSource<? extends Close>> f48308i;

    /* loaded from: classes5.dex */
    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super C> f48309f;

        /* renamed from: g  reason: collision with root package name */
        final Callable<C> f48310g;

        /* renamed from: h  reason: collision with root package name */
        final ObservableSource<? extends Open> f48311h;

        /* renamed from: i  reason: collision with root package name */
        final Function<? super Open, ? extends ObservableSource<? extends Close>> f48312i;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48316m;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f48318o;

        /* renamed from: p  reason: collision with root package name */
        long f48319p;

        /* renamed from: n  reason: collision with root package name */
        final SpscLinkedArrayQueue<C> f48317n = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: j  reason: collision with root package name */
        final CompositeDisposable f48313j = new CompositeDisposable();

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Disposable> f48314k = new AtomicReference<>();

        /* renamed from: q  reason: collision with root package name */
        Map<Long, C> f48320q = new LinkedHashMap();

        /* renamed from: l  reason: collision with root package name */
        final AtomicThrowable f48315l = new AtomicThrowable();

        /* loaded from: classes5.dex */
        static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {

            /* renamed from: f  reason: collision with root package name */
            final BufferBoundaryObserver<?, ?, Open, ?> f48321f;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.f48321f = bufferBoundaryObserver;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                if (get() == DisposableHelper.DISPOSED) {
                    return true;
                }
                return false;
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.f48321f.e(this);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.f48321f.a(this, th);
            }

            @Override // io.reactivex.Observer
            public void onNext(Open open) {
                this.f48321f.d(open);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
            this.f48309f = observer;
            this.f48310g = callable;
            this.f48311h = observableSource;
            this.f48312i = function;
        }

        void a(Disposable disposable, Throwable th) {
            DisposableHelper.a(this.f48314k);
            this.f48313j.c(disposable);
            onError(th);
        }

        void b(BufferCloseObserver<T, C> bufferCloseObserver, long j8) {
            boolean z7;
            this.f48313j.c(bufferCloseObserver);
            if (this.f48313j.f() == 0) {
                DisposableHelper.a(this.f48314k);
                z7 = true;
            } else {
                z7 = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.f48320q;
                if (map == null) {
                    return;
                }
                this.f48317n.offer(map.remove(Long.valueOf(j8)));
                if (z7) {
                    this.f48316m = true;
                }
                c();
            }
        }

        void c() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super C> observer = this.f48309f;
            SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.f48317n;
            int i8 = 1;
            while (!this.f48318o) {
                boolean z8 = this.f48316m;
                if (z8 && this.f48315l.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observer.onError(this.f48315l.b());
                    return;
                }
                C poll = spscLinkedArrayQueue.poll();
                if (poll == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z8 && z7) {
                    observer.onComplete();
                    return;
                } else if (z7) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void d(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.e(this.f48310g.call(), "The bufferSupplier returned a null Collection");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48312i.apply(open), "The bufferClose returned a null ObservableSource");
                long j8 = this.f48319p;
                this.f48319p = 1 + j8;
                synchronized (this) {
                    Map<Long, C> map = this.f48320q;
                    if (map == 0) {
                        return;
                    }
                    map.put(Long.valueOf(j8), collection);
                    BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j8);
                    this.f48313j.b(bufferCloseObserver);
                    observableSource.subscribe(bufferCloseObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                DisposableHelper.a(this.f48314k);
                onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.a(this.f48314k)) {
                this.f48318o = true;
                this.f48313j.dispose();
                synchronized (this) {
                    this.f48320q = null;
                }
                if (getAndIncrement() != 0) {
                    this.f48317n.clear();
                }
            }
        }

        void e(BufferOpenObserver<Open> bufferOpenObserver) {
            this.f48313j.c(bufferOpenObserver);
            if (this.f48313j.f() == 0) {
                DisposableHelper.a(this.f48314k);
                this.f48316m = true;
                c();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f48314k.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48313j.dispose();
            synchronized (this) {
                Map<Long, C> map = this.f48320q;
                if (map == null) {
                    return;
                }
                for (C c8 : map.values()) {
                    this.f48317n.offer(c8);
                }
                this.f48320q = null;
                this.f48316m = true;
                c();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48315l.a(th)) {
                this.f48313j.dispose();
                synchronized (this) {
                    this.f48320q = null;
                }
                this.f48316m = true;
                c();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            synchronized (this) {
                Map<Long, C> map = this.f48320q;
                if (map == null) {
                    return;
                }
                for (C c8 : map.values()) {
                    c8.add(t7);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this.f48314k, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.f48313j.b(bufferOpenObserver);
                this.f48311h.subscribe(bufferOpenObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final BufferBoundaryObserver<T, C, ?, ?> f48322f;

        /* renamed from: g  reason: collision with root package name */
        final long f48323g;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j8) {
            this.f48322f = bufferBoundaryObserver;
            this.f48323g = j8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                this.f48322f.b(this, this.f48323g);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                this.f48322f.a(this, th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.f48322f.b(this, this.f48323g);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        this.f48307h = observableSource2;
        this.f48308i = function;
        this.f48306g = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.f48307h, this.f48308i, this.f48306g);
        observer.onSubscribe(bufferBoundaryObserver);
        this.f48232f.subscribe(bufferBoundaryObserver);
    }
}
