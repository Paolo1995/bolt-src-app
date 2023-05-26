package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<U> f49300g;

    /* renamed from: h  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<V>> f49301h;

    /* renamed from: i  reason: collision with root package name */
    final ObservableSource<? extends T> f49302i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final TimeoutSelectorSupport f49303f;

        /* renamed from: g  reason: collision with root package name */
        final long f49304g;

        TimeoutConsumer(long j8, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f49304g = j8;
            this.f49303f = timeoutSelectorSupport;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f49303f.b(this.f49304g);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f49303f.a(this.f49304g, th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                disposable.dispose();
                lazySet(disposableHelper);
                this.f49303f.b(this.f49304g);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }
    }

    /* loaded from: classes5.dex */
    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49305f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<?>> f49306g;

        /* renamed from: h  reason: collision with root package name */
        final SequentialDisposable f49307h = new SequentialDisposable();

        /* renamed from: i  reason: collision with root package name */
        final AtomicLong f49308i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<Disposable> f49309j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        ObservableSource<? extends T> f49310k;

        TimeoutFallbackObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function, ObservableSource<? extends T> observableSource) {
            this.f49305f = observer;
            this.f49306g = function;
            this.f49310k = observableSource;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutSelectorSupport
        public void a(long j8, Throwable th) {
            if (this.f49308i.compareAndSet(j8, Long.MAX_VALUE)) {
                DisposableHelper.a(this);
                this.f49305f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void b(long j8) {
            if (this.f49308i.compareAndSet(j8, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f49309j);
                ObservableSource<? extends T> observableSource = this.f49310k;
                this.f49310k = null;
                observableSource.subscribe(new ObservableTimeoutTimed.FallbackObserver(this.f49305f, this));
            }
        }

        void c(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.f49307h.a(timeoutConsumer)) {
                    observableSource.subscribe(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49309j);
            DisposableHelper.a(this);
            this.f49307h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49308i.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f49307h.dispose();
                this.f49305f.onComplete();
                this.f49307h.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49308i.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f49307h.dispose();
                this.f49305f.onError(th);
                this.f49307h.dispose();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            long j8 = this.f49308i.get();
            if (j8 != Long.MAX_VALUE) {
                long j9 = 1 + j8;
                if (this.f49308i.compareAndSet(j8, j9)) {
                    Disposable disposable = this.f49307h.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f49305f.onNext(t7);
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49306g.apply(t7), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j9, this);
                        if (this.f49307h.a(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f49309j.get().dispose();
                        this.f49308i.getAndSet(Long.MAX_VALUE);
                        this.f49305f.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49309j, disposable);
        }
    }

    /* loaded from: classes5.dex */
    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49311f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<?>> f49312g;

        /* renamed from: h  reason: collision with root package name */
        final SequentialDisposable f49313h = new SequentialDisposable();

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<Disposable> f49314i = new AtomicReference<>();

        TimeoutObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function) {
            this.f49311f = observer;
            this.f49312g = function;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutSelectorSupport
        public void a(long j8, Throwable th) {
            if (compareAndSet(j8, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f49314i);
                this.f49311f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void b(long j8) {
            if (compareAndSet(j8, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f49314i);
                this.f49311f.onError(new TimeoutException());
            }
        }

        void c(ObservableSource<?> observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.f49313h.a(timeoutConsumer)) {
                    observableSource.subscribe(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49314i);
            this.f49313h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f49314i.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f49313h.dispose();
                this.f49311f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f49313h.dispose();
                this.f49311f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            long j8 = get();
            if (j8 != Long.MAX_VALUE) {
                long j9 = 1 + j8;
                if (compareAndSet(j8, j9)) {
                    Disposable disposable = this.f49313h.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f49311f.onNext(t7);
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49312g.apply(t7), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j9, this);
                        if (this.f49313h.a(timeoutConsumer)) {
                            observableSource.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f49314i.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.f49311f.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49314i, disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface TimeoutSelectorSupport extends ObservableTimeoutTimed.TimeoutSupport {
        void a(long j8, Throwable th);
    }

    public ObservableTimeout(Observable<T> observable, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        super(observable);
        this.f49300g = observableSource;
        this.f49301h = function;
        this.f49302i = observableSource2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        if (this.f49302i == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f49301h);
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.c(this.f49300g);
            this.f48232f.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f49301h, this.f49302i);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.c(this.f49300g);
        this.f48232f.subscribe(timeoutFallbackObserver);
    }
}
