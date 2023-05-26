package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f49277g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49278h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f49279i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f49280j;

    /* loaded from: classes5.dex */
    static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49281f;

        /* renamed from: g  reason: collision with root package name */
        final long f49282g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f49283h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler.Worker f49284i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f49285j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<T> f49286k = new AtomicReference<>();

        /* renamed from: l  reason: collision with root package name */
        Disposable f49287l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f49288m;

        /* renamed from: n  reason: collision with root package name */
        Throwable f49289n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f49290o;

        /* renamed from: p  reason: collision with root package name */
        volatile boolean f49291p;

        /* renamed from: q  reason: collision with root package name */
        boolean f49292q;

        ThrottleLatestObserver(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler.Worker worker, boolean z7) {
            this.f49281f = observer;
            this.f49282g = j8;
            this.f49283h = timeUnit;
            this.f49284i = worker;
            this.f49285j = z7;
        }

        void a() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.f49286k;
            Observer<? super T> observer = this.f49281f;
            int i8 = 1;
            while (!this.f49290o) {
                boolean z8 = this.f49288m;
                if (z8 && this.f49289n != null) {
                    atomicReference.lazySet(null);
                    observer.onError(this.f49289n);
                    this.f49284i.dispose();
                    return;
                }
                if (atomicReference.get() == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z8) {
                    T andSet = atomicReference.getAndSet(null);
                    if (!z7 && this.f49285j) {
                        observer.onNext(andSet);
                    }
                    observer.onComplete();
                    this.f49284i.dispose();
                    return;
                }
                if (z7) {
                    if (this.f49291p) {
                        this.f49292q = false;
                        this.f49291p = false;
                    }
                } else if (!this.f49292q || this.f49291p) {
                    observer.onNext(atomicReference.getAndSet(null));
                    this.f49291p = false;
                    this.f49292q = true;
                    this.f49284i.c(this, this.f49282g, this.f49283h);
                }
                i8 = addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49290o = true;
            this.f49287l.dispose();
            this.f49284i.dispose();
            if (getAndIncrement() == 0) {
                this.f49286k.lazySet(null);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49290o;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49288m = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49289n = th;
            this.f49288m = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49286k.set(t7);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49287l, disposable)) {
                this.f49287l = disposable;
                this.f49281f.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f49291p = true;
            a();
        }
    }

    public ObservableThrottleLatest(Observable<T> observable, long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        super(observable);
        this.f49277g = j8;
        this.f49278h = timeUnit;
        this.f49279i = scheduler;
        this.f49280j = z7;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new ThrottleLatestObserver(observer, this.f49277g, this.f49278h, this.f49279i.b(), this.f49280j));
    }
}
