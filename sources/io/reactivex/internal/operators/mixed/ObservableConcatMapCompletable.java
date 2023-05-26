package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
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
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableConcatMapCompletable<T> extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Observable<T> f48140f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f48141g;

    /* renamed from: h  reason: collision with root package name */
    final ErrorMode f48142h;

    /* renamed from: i  reason: collision with root package name */
    final int f48143i;

    /* loaded from: classes5.dex */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f48144f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f48145g;

        /* renamed from: h  reason: collision with root package name */
        final ErrorMode f48146h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f48147i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final ConcatMapInnerObserver f48148j = new ConcatMapInnerObserver(this);

        /* renamed from: k  reason: collision with root package name */
        final int f48149k;

        /* renamed from: l  reason: collision with root package name */
        SimpleQueue<T> f48150l;

        /* renamed from: m  reason: collision with root package name */
        Disposable f48151m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48152n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f48153o;

        /* renamed from: p  reason: collision with root package name */
        volatile boolean f48154p;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {

            /* renamed from: f  reason: collision with root package name */
            final ConcatMapCompletableObserver<?> f48155f;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.f48155f = concatMapCompletableObserver;
            }

            void a() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f48155f.b();
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f48155f.c(th);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.e(this, disposable);
            }
        }

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i8) {
            this.f48144f = completableObserver;
            this.f48145g = function;
            this.f48146h = errorMode;
            this.f48149k = i8;
        }

        void a() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicThrowable atomicThrowable = this.f48147i;
            ErrorMode errorMode = this.f48146h;
            while (!this.f48154p) {
                if (!this.f48152n) {
                    if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                        this.f48154p = true;
                        this.f48150l.clear();
                        this.f48144f.onError(atomicThrowable.b());
                        return;
                    }
                    boolean z8 = this.f48153o;
                    CompletableSource completableSource = null;
                    try {
                        T poll = this.f48150l.poll();
                        if (poll != null) {
                            completableSource = (CompletableSource) ObjectHelper.e(this.f48145g.apply(poll), "The mapper returned a null CompletableSource");
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (z8 && z7) {
                            this.f48154p = true;
                            Throwable b8 = atomicThrowable.b();
                            if (b8 != null) {
                                this.f48144f.onError(b8);
                                return;
                            } else {
                                this.f48144f.onComplete();
                                return;
                            }
                        } else if (!z7) {
                            this.f48152n = true;
                            completableSource.a(this.f48148j);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f48154p = true;
                        this.f48150l.clear();
                        this.f48151m.dispose();
                        atomicThrowable.a(th);
                        this.f48144f.onError(atomicThrowable.b());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f48150l.clear();
        }

        void b() {
            this.f48152n = false;
            a();
        }

        void c(Throwable th) {
            if (this.f48147i.a(th)) {
                if (this.f48146h == ErrorMode.IMMEDIATE) {
                    this.f48154p = true;
                    this.f48151m.dispose();
                    Throwable b8 = this.f48147i.b();
                    if (b8 != ExceptionHelper.f49808a) {
                        this.f48144f.onError(b8);
                    }
                    if (getAndIncrement() == 0) {
                        this.f48150l.clear();
                        return;
                    }
                    return;
                }
                this.f48152n = false;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48154p = true;
            this.f48151m.dispose();
            this.f48148j.a();
            if (getAndIncrement() == 0) {
                this.f48150l.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48154p;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48153o = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48147i.a(th)) {
                if (this.f48146h == ErrorMode.IMMEDIATE) {
                    this.f48154p = true;
                    this.f48148j.a();
                    Throwable b8 = this.f48147i.b();
                    if (b8 != ExceptionHelper.f49808a) {
                        this.f48144f.onError(b8);
                    }
                    if (getAndIncrement() == 0) {
                        this.f48150l.clear();
                        return;
                    }
                    return;
                }
                this.f48153o = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (t7 != null) {
                this.f48150l.offer(t7);
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48151m, disposable)) {
                this.f48151m = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a8 = queueDisposable.a(3);
                    if (a8 == 1) {
                        this.f48150l = queueDisposable;
                        this.f48153o = true;
                        this.f48144f.onSubscribe(this);
                        a();
                        return;
                    } else if (a8 == 2) {
                        this.f48150l = queueDisposable;
                        this.f48144f.onSubscribe(this);
                        return;
                    }
                }
                this.f48150l = new SpscLinkedArrayQueue(this.f48149k);
                this.f48144f.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i8) {
        this.f48140f = observable;
        this.f48141g = function;
        this.f48142h = errorMode;
        this.f48143i = i8;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.f48140f, this.f48141g, completableObserver)) {
            this.f48140f.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f48141g, this.f48142h, this.f48143i));
        }
    }
}
