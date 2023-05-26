package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends CompletableSource> f48642g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48643h;

    /* loaded from: classes5.dex */
    static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48644f;

        /* renamed from: h  reason: collision with root package name */
        final Function<? super T, ? extends CompletableSource> f48646h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f48647i;

        /* renamed from: k  reason: collision with root package name */
        Disposable f48649k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48650l;

        /* renamed from: g  reason: collision with root package name */
        final AtomicThrowable f48645g = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        final CompositeDisposable f48648j = new CompositeDisposable();

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
                FlatMapCompletableMainObserver.this.b(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.c(this, th);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        FlatMapCompletableMainObserver(Observer<? super T> observer, Function<? super T, ? extends CompletableSource> function, boolean z7) {
            this.f48644f = observer;
            this.f48646h = function;
            this.f48647i = z7;
            lazySet(1);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            return i8 & 2;
        }

        void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.f48648j.c(innerObserver);
            onComplete();
        }

        void c(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.f48648j.c(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48650l = true;
            this.f48649k.dispose();
            this.f48648j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48649k.isDisposed();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b8 = this.f48645g.b();
                if (b8 != null) {
                    this.f48644f.onError(b8);
                } else {
                    this.f48644f.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48645g.a(th)) {
                if (this.f48647i) {
                    if (decrementAndGet() == 0) {
                        this.f48644f.onError(this.f48645g.b());
                        return;
                    }
                    return;
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.f48644f.onError(this.f48645g.b());
                    return;
                }
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.e(this.f48646h.apply(t7), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f48650l && this.f48648j.b(innerObserver)) {
                    completableSource.a(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48649k.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48649k, disposable)) {
                this.f48649k = disposable;
                this.f48644f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return null;
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z7) {
        super(observableSource);
        this.f48642g = function;
        this.f48643h = z7;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new FlatMapCompletableMainObserver(observer, this.f48642g, this.f48643h));
    }
}
