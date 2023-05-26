package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends SingleSource<? extends R>> f48675g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48676h;

    /* loaded from: classes5.dex */
    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48677f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f48678g;

        /* renamed from: k  reason: collision with root package name */
        final Function<? super T, ? extends SingleSource<? extends R>> f48682k;

        /* renamed from: m  reason: collision with root package name */
        Disposable f48684m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48685n;

        /* renamed from: h  reason: collision with root package name */
        final CompositeDisposable f48679h = new CompositeDisposable();

        /* renamed from: j  reason: collision with root package name */
        final AtomicThrowable f48681j = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        final AtomicInteger f48680i = new AtomicInteger(1);

        /* renamed from: l  reason: collision with root package name */
        final AtomicReference<SpscLinkedArrayQueue<R>> f48683l = new AtomicReference<>();

        /* loaded from: classes5.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
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

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapSingleObserver.this.e(this, th);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
            public void onSuccess(R r7) {
                FlatMapSingleObserver.this.f(this, r7);
            }
        }

        FlatMapSingleObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z7) {
            this.f48677f = observer;
            this.f48682k = function;
            this.f48678g = z7;
        }

        void a() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f48683l.get();
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
            Observer<? super R> observer = this.f48677f;
            AtomicInteger atomicInteger = this.f48680i;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.f48683l;
            int i8 = 1;
            while (!this.f48685n) {
                if (!this.f48678g && this.f48681j.get() != null) {
                    Throwable b8 = this.f48681j.b();
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
                    Throwable b9 = this.f48681j.b();
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
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.f48683l.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            } while (!e.a(this.f48683l, null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48685n = true;
            this.f48684m.dispose();
            this.f48679h.dispose();
        }

        void e(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.f48679h.c(innerObserver);
            if (this.f48681j.a(th)) {
                if (!this.f48678g) {
                    this.f48684m.dispose();
                    this.f48679h.dispose();
                }
                this.f48680i.decrementAndGet();
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        void f(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r7) {
            this.f48679h.c(innerObserver);
            if (get() == 0) {
                boolean z7 = false;
                if (compareAndSet(0, 1)) {
                    this.f48677f.onNext(r7);
                    if (this.f48680i.decrementAndGet() == 0) {
                        z7 = true;
                    }
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.f48683l.get();
                    if (z7 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable b8 = this.f48681j.b();
                        if (b8 != null) {
                            this.f48677f.onError(b8);
                            return;
                        } else {
                            this.f48677f.onComplete();
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
            this.f48680i.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48685n;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48680i.decrementAndGet();
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48680i.decrementAndGet();
            if (this.f48681j.a(th)) {
                if (!this.f48678g) {
                    this.f48679h.dispose();
                }
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.e(this.f48682k.apply(t7), "The mapper returned a null SingleSource");
                this.f48680i.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f48685n && this.f48679h.b(innerObserver)) {
                    singleSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48684m.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48684m, disposable)) {
                this.f48684m = disposable;
                this.f48677f.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z7) {
        super(observableSource);
        this.f48675g = function;
        this.f48676h = z7;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.f48232f.subscribe(new FlatMapSingleObserver(observer, this.f48675g, this.f48676h));
    }
}
