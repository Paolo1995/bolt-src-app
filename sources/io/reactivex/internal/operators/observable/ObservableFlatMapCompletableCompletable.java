package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48652f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f48653g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48654h;

    /* loaded from: classes5.dex */
    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f48655f;

        /* renamed from: h  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f48657h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f48658i;

        /* renamed from: k  reason: collision with root package name */
        Disposable f48660k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48661l;

        /* renamed from: g  reason: collision with root package name */
        final AtomicThrowable f48656g = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final CompositeDisposable f48659j = new CompositeDisposable();

        /* loaded from: classes5.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
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

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapCompletableMainObserver.this.a(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.b(this, th);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        FlatMapCompletableMainObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z7) {
            this.f48655f = completableObserver;
            this.f48657h = function;
            this.f48658i = z7;
            lazySet(1);
        }

        void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.f48659j.c(innerObserver);
            onComplete();
        }

        void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.f48659j.c(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48661l = true;
            this.f48660k.dispose();
            this.f48659j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48660k.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b8 = this.f48656g.b();
                if (b8 != null) {
                    this.f48655f.onError(b8);
                } else {
                    this.f48655f.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48656g.a(th)) {
                if (this.f48658i) {
                    if (decrementAndGet() == 0) {
                        this.f48655f.onError(this.f48656g.b());
                        return;
                    }
                    return;
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.f48655f.onError(this.f48656g.b());
                    return;
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f48657h.apply(t7), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f48661l && this.f48659j.b(innerObserver)) {
                    completableSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48660k.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48660k, disposable)) {
                this.f48660k = disposable;
                this.f48655f.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z7) {
        this.f48652f = observableSource;
        this.f48653g = function;
        this.f48654h = z7;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f48652f.subscribe(new FlatMapCompletableMainObserver(completableObserver, this.f48653g, this.f48654h));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<T> b() {
        return RxJavaPlugins.n(new ObservableFlatMapCompletable(this.f48652f, this.f48653g, this.f48654h));
    }
}
