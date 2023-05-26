package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableConcatMapSingle<T, R> extends Observable<R> {

    /* renamed from: f  reason: collision with root package name */
    final Observable<T> f48172f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends SingleSource<? extends R>> f48173g;

    /* renamed from: h  reason: collision with root package name */
    final ErrorMode f48174h;

    /* renamed from: i  reason: collision with root package name */
    final int f48175i;

    /* loaded from: classes5.dex */
    static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48176f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends SingleSource<? extends R>> f48177g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicThrowable f48178h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        final ConcatMapSingleObserver<R> f48179i = new ConcatMapSingleObserver<>(this);

        /* renamed from: j  reason: collision with root package name */
        final SimplePlainQueue<T> f48180j;

        /* renamed from: k  reason: collision with root package name */
        final ErrorMode f48181k;

        /* renamed from: l  reason: collision with root package name */
        Disposable f48182l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48183m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48184n;

        /* renamed from: o  reason: collision with root package name */
        R f48185o;

        /* renamed from: p  reason: collision with root package name */
        volatile int f48186p;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {

            /* renamed from: f  reason: collision with root package name */
            final ConcatMapSingleMainObserver<?, R> f48187f;

            ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.f48187f = concatMapSingleMainObserver;
            }

            void a() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48187f.b(th);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.e(this, disposable);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
            public void onSuccess(R r7) {
                this.f48187f.c(r7);
            }
        }

        ConcatMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i8, ErrorMode errorMode) {
            this.f48176f = observer;
            this.f48177g = function;
            this.f48181k = errorMode;
            this.f48180j = new SpscLinkedArrayQueue(i8);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.f48176f;
            ErrorMode errorMode = this.f48181k;
            SimplePlainQueue<T> simplePlainQueue = this.f48180j;
            AtomicThrowable atomicThrowable = this.f48178h;
            int i8 = 1;
            while (true) {
                if (this.f48184n) {
                    simplePlainQueue.clear();
                    this.f48185o = null;
                } else {
                    int i9 = this.f48186p;
                    if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i9 != 0))) {
                        boolean z7 = false;
                        if (i9 == 0) {
                            boolean z8 = this.f48183m;
                            T poll = simplePlainQueue.poll();
                            if (poll == null) {
                                z7 = true;
                            }
                            if (z8 && z7) {
                                Throwable b8 = atomicThrowable.b();
                                if (b8 == null) {
                                    observer.onComplete();
                                    return;
                                } else {
                                    observer.onError(b8);
                                    return;
                                }
                            } else if (!z7) {
                                try {
                                    SingleSource singleSource = (SingleSource) ObjectHelper.e(this.f48177g.apply(poll), "The mapper returned a null SingleSource");
                                    this.f48186p = 1;
                                    singleSource.a(this.f48179i);
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    this.f48182l.dispose();
                                    simplePlainQueue.clear();
                                    atomicThrowable.a(th);
                                    observer.onError(atomicThrowable.b());
                                    return;
                                }
                            }
                        } else if (i9 == 2) {
                            this.f48185o = null;
                            observer.onNext((R) this.f48185o);
                            this.f48186p = 0;
                        }
                    }
                }
                i8 = addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
            }
            simplePlainQueue.clear();
            this.f48185o = null;
            observer.onError(atomicThrowable.b());
        }

        void b(Throwable th) {
            if (this.f48178h.a(th)) {
                if (this.f48181k != ErrorMode.END) {
                    this.f48182l.dispose();
                }
                this.f48186p = 0;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        void c(R r7) {
            this.f48185o = r7;
            this.f48186p = 2;
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48184n = true;
            this.f48182l.dispose();
            this.f48179i.a();
            if (getAndIncrement() == 0) {
                this.f48180j.clear();
                this.f48185o = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48184n;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48183m = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48178h.a(th)) {
                if (this.f48181k == ErrorMode.IMMEDIATE) {
                    this.f48179i.a();
                }
                this.f48183m = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48180j.offer(t7);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48182l, disposable)) {
                this.f48182l = disposable;
                this.f48176f.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i8) {
        this.f48172f = observable;
        this.f48173g = function;
        this.f48174h = errorMode;
        this.f48175i = i8;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.f48172f, this.f48173g, observer)) {
            this.f48172f.subscribe(new ConcatMapSingleMainObserver(observer, this.f48173g, this.f48175i, this.f48174h));
        }
    }
}
