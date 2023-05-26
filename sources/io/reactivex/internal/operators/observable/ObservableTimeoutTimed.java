package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f49315g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49316h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f49317i;

    /* renamed from: j  reason: collision with root package name */
    final ObservableSource<? extends T> f49318j;

    /* loaded from: classes5.dex */
    static final class FallbackObserver<T> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49319f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f49320g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.f49319f = observer;
            this.f49320g = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49319f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49319f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49319f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.e(this.f49320g, disposable);
        }
    }

    /* loaded from: classes5.dex */
    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49321f;

        /* renamed from: g  reason: collision with root package name */
        final long f49322g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f49323h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler.Worker f49324i;

        /* renamed from: j  reason: collision with root package name */
        final SequentialDisposable f49325j = new SequentialDisposable();

        /* renamed from: k  reason: collision with root package name */
        final AtomicLong f49326k = new AtomicLong();

        /* renamed from: l  reason: collision with root package name */
        final AtomicReference<Disposable> f49327l = new AtomicReference<>();

        /* renamed from: m  reason: collision with root package name */
        ObservableSource<? extends T> f49328m;

        TimeoutFallbackObserver(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.f49321f = observer;
            this.f49322g = j8;
            this.f49323h = timeUnit;
            this.f49324i = worker;
            this.f49328m = observableSource;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void b(long j8) {
            if (this.f49326k.compareAndSet(j8, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f49327l);
                ObservableSource<? extends T> observableSource = this.f49328m;
                this.f49328m = null;
                observableSource.subscribe(new FallbackObserver(this.f49321f, this));
                this.f49324i.dispose();
            }
        }

        void c(long j8) {
            this.f49325j.a(this.f49324i.c(new TimeoutTask(j8, this), this.f49322g, this.f49323h));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49327l);
            DisposableHelper.a(this);
            this.f49324i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49326k.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f49325j.dispose();
                this.f49321f.onComplete();
                this.f49324i.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49326k.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f49325j.dispose();
                this.f49321f.onError(th);
                this.f49324i.dispose();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            long j8 = this.f49326k.get();
            if (j8 != Long.MAX_VALUE) {
                long j9 = 1 + j8;
                if (this.f49326k.compareAndSet(j8, j9)) {
                    this.f49325j.get().dispose();
                    this.f49321f.onNext(t7);
                    c(j9);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49327l, disposable);
        }
    }

    /* loaded from: classes5.dex */
    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49329f;

        /* renamed from: g  reason: collision with root package name */
        final long f49330g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f49331h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler.Worker f49332i;

        /* renamed from: j  reason: collision with root package name */
        final SequentialDisposable f49333j = new SequentialDisposable();

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Disposable> f49334k = new AtomicReference<>();

        TimeoutObserver(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f49329f = observer;
            this.f49330g = j8;
            this.f49331h = timeUnit;
            this.f49332i = worker;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void b(long j8) {
            if (compareAndSet(j8, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f49334k);
                this.f49329f.onError(new TimeoutException(ExceptionHelper.d(this.f49330g, this.f49331h)));
                this.f49332i.dispose();
            }
        }

        void c(long j8) {
            this.f49333j.a(this.f49332i.c(new TimeoutTask(j8, this), this.f49330g, this.f49331h));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49334k);
            this.f49332i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f49334k.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f49333j.dispose();
                this.f49329f.onComplete();
                this.f49332i.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f49333j.dispose();
                this.f49329f.onError(th);
                this.f49332i.dispose();
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
                    this.f49333j.get().dispose();
                    this.f49329f.onNext(t7);
                    c(j9);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49334k, disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface TimeoutSupport {
        void b(long j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class TimeoutTask implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        final TimeoutSupport f49335f;

        /* renamed from: g  reason: collision with root package name */
        final long f49336g;

        TimeoutTask(long j8, TimeoutSupport timeoutSupport) {
            this.f49336g = j8;
            this.f49335f = timeoutSupport;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f49335f.b(this.f49336g);
        }
    }

    public ObservableTimeoutTimed(Observable<T> observable, long j8, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.f49315g = j8;
        this.f49316h = timeUnit;
        this.f49317i = scheduler;
        this.f49318j = observableSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        if (this.f49318j == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f49315g, this.f49316h, this.f49317i.b());
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.c(0L);
            this.f48232f.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f49315g, this.f49316h, this.f49317i.b(), this.f49318j);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.c(0L);
        this.f48232f.subscribe(timeoutFallbackObserver);
    }
}
