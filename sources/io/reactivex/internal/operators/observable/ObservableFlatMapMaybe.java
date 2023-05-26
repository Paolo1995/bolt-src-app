package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends MaybeSource<? extends R>> f48663g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48664h;

    /* loaded from: classes5.dex */
    static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48665f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f48666g;

        /* renamed from: k  reason: collision with root package name */
        final Function<? super T, ? extends MaybeSource<? extends R>> f48670k;

        /* renamed from: m  reason: collision with root package name */
        Disposable f48672m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48673n;

        /* renamed from: h  reason: collision with root package name */
        final CompositeDisposable f48667h = new CompositeDisposable();

        /* renamed from: j  reason: collision with root package name */
        final AtomicThrowable f48669j = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        final AtomicInteger f48668i = new AtomicInteger(1);

        /* renamed from: l  reason: collision with root package name */
        final AtomicReference<SpscLinkedArrayQueue<R>> f48671l = new AtomicReference<>();

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
                FlatMapMaybeObserver.this.e(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.f(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r7) {
                FlatMapMaybeObserver.this.g(this, r7);
            }
        }

        FlatMapMaybeObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7) {
            this.f48665f = observer;
            this.f48670k = function;
            this.f48666g = z7;
        }

        void a() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f48671l.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        void c() {
            boolean z7;
            R r7;
            Observer<? super R> observer = this.f48665f;
            AtomicInteger atomicInteger = this.f48668i;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f48671l;
            int i8 = 1;
            while (!this.f48673n) {
                if (!this.f48666g && this.f48669j.get() != null) {
                    Throwable b8 = this.f48669j.b();
                    a();
                    observer.onError(b8);
                    return;
                }
                boolean z8 = false;
                if (atomicInteger.get() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue = atomicReference.get();
                if (spscLinkedArrayQueue != null) {
                    r7 = spscLinkedArrayQueue.poll();
                } else {
                    r7 = (Object) null;
                }
                if (r7 == null) {
                    z8 = true;
                }
                if (z7 && z8) {
                    Throwable b9 = this.f48669j.b();
                    if (b9 != null) {
                        observer.onError(b9);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (z8) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(r7);
                }
            }
            a();
        }

        SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f48671l.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            } while (!e.a(this.f48671l, null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48673n = true;
            this.f48672m.dispose();
            this.f48667h.dispose();
        }

        void e(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
            this.f48667h.c(innerObserver);
            if (get() == 0) {
                boolean z7 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f48668i.decrementAndGet() == 0) {
                        z7 = true;
                    }
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f48671l.get();
                    if (z7 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable b8 = this.f48669j.b();
                        if (b8 != null) {
                            this.f48665f.onError(b8);
                            return;
                        } else {
                            this.f48665f.onComplete();
                            return;
                        }
                    } else if (decrementAndGet() == 0) {
                        return;
                    } else {
                        c();
                        return;
                    }
                }
            }
            this.f48668i.decrementAndGet();
            b();
        }

        void f(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.f48667h.c(innerObserver);
            if (this.f48669j.a(th)) {
                if (!this.f48666g) {
                    this.f48672m.dispose();
                    this.f48667h.dispose();
                }
                this.f48668i.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        void g(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r7) {
            this.f48667h.c(innerObserver);
            if (get() == 0) {
                boolean z7 = false;
                if (compareAndSet(0, 1)) {
                    this.f48665f.onNext(r7);
                    if (this.f48668i.decrementAndGet() == 0) {
                        z7 = true;
                    }
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f48671l.get();
                    if (z7 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable b8 = this.f48669j.b();
                        if (b8 != null) {
                            this.f48665f.onError(b8);
                            return;
                        } else {
                            this.f48665f.onComplete();
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                }
            }
            SpscLinkedArrayQueue<R> d8 = d();
            synchronized (d8) {
                d8.offer(r7);
            }
            this.f48668i.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48673n;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48668i.decrementAndGet();
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48668i.decrementAndGet();
            if (this.f48669j.a(th)) {
                if (!this.f48666g) {
                    this.f48667h.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.e(this.f48670k.apply(t7), "The mapper returned a null MaybeSource");
                this.f48668i.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f48673n && this.f48667h.b(innerObserver)) {
                    maybeSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48672m.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48672m, disposable)) {
                this.f48672m = disposable;
                this.f48665f.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z7) {
        super(observableSource);
        this.f48663g = function;
        this.f48664h = z7;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.f48232f.subscribe(new FlatMapMaybeObserver(observer, this.f48663g, this.f48664h));
    }
}
