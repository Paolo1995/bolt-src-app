package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
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
public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {

    /* renamed from: f  reason: collision with root package name */
    final Observable<T> f48156f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends MaybeSource<? extends R>> f48157g;

    /* renamed from: h  reason: collision with root package name */
    final ErrorMode f48158h;

    /* renamed from: i  reason: collision with root package name */
    final int f48159i;

    /* loaded from: classes5.dex */
    static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48160f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends MaybeSource<? extends R>> f48161g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicThrowable f48162h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        final ConcatMapMaybeObserver<R> f48163i = new ConcatMapMaybeObserver<>(this);

        /* renamed from: j  reason: collision with root package name */
        final SimplePlainQueue<T> f48164j;

        /* renamed from: k  reason: collision with root package name */
        final ErrorMode f48165k;

        /* renamed from: l  reason: collision with root package name */
        Disposable f48166l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48167m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48168n;

        /* renamed from: o  reason: collision with root package name */
        R f48169o;

        /* renamed from: p  reason: collision with root package name */
        volatile int f48170p;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {

            /* renamed from: f  reason: collision with root package name */
            final ConcatMapMaybeMainObserver<?, R> f48171f;

            ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.f48171f = concatMapMaybeMainObserver;
            }

            void a() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f48171f.b();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48171f.c(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.e(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r7) {
                this.f48171f.d(r7);
            }
        }

        ConcatMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, int i8, ErrorMode errorMode) {
            this.f48160f = observer;
            this.f48161g = function;
            this.f48165k = errorMode;
            this.f48164j = new SpscLinkedArrayQueue(i8);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.f48160f;
            ErrorMode errorMode = this.f48165k;
            SimplePlainQueue<T> simplePlainQueue = this.f48164j;
            AtomicThrowable atomicThrowable = this.f48162h;
            int i8 = 1;
            while (true) {
                if (this.f48168n) {
                    simplePlainQueue.clear();
                    this.f48169o = null;
                } else {
                    int i9 = this.f48170p;
                    if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i9 != 0))) {
                        boolean z7 = false;
                        if (i9 == 0) {
                            boolean z8 = this.f48167m;
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
                                    MaybeSource maybeSource = (MaybeSource) ObjectHelper.e(this.f48161g.apply(poll), "The mapper returned a null MaybeSource");
                                    this.f48170p = 1;
                                    maybeSource.a(this.f48163i);
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    this.f48166l.dispose();
                                    simplePlainQueue.clear();
                                    atomicThrowable.a(th);
                                    observer.onError(atomicThrowable.b());
                                    return;
                                }
                            }
                        } else if (i9 == 2) {
                            this.f48169o = null;
                            observer.onNext((R) this.f48169o);
                            this.f48170p = 0;
                        }
                    }
                }
                i8 = addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
            }
            simplePlainQueue.clear();
            this.f48169o = null;
            observer.onError(atomicThrowable.b());
        }

        void b() {
            this.f48170p = 0;
            a();
        }

        void c(Throwable th) {
            if (this.f48162h.a(th)) {
                if (this.f48165k != ErrorMode.END) {
                    this.f48166l.dispose();
                }
                this.f48170p = 0;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        void d(R r7) {
            this.f48169o = r7;
            this.f48170p = 2;
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48168n = true;
            this.f48166l.dispose();
            this.f48163i.a();
            if (getAndIncrement() == 0) {
                this.f48164j.clear();
                this.f48169o = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48168n;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48167m = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48162h.a(th)) {
                if (this.f48165k == ErrorMode.IMMEDIATE) {
                    this.f48163i.a();
                }
                this.f48167m = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48164j.offer(t7);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48166l, disposable)) {
                this.f48166l = disposable;
                this.f48160f.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i8) {
        this.f48156f = observable;
        this.f48157g = function;
        this.f48158h = errorMode;
        this.f48159i = i8;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.f48156f, this.f48157g, observer)) {
            this.f48156f.subscribe(new ConcatMapMaybeMainObserver(observer, this.f48157g, this.f48159i, this.f48158h));
        }
    }
}
