package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f49069g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49070h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f49071i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f49072j;

    /* loaded from: classes5.dex */
    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {

        /* renamed from: l  reason: collision with root package name */
        final AtomicInteger f49073l;

        SampleTimedEmitLast(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j8, timeUnit, scheduler);
            this.f49073l = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void b() {
            c();
            if (this.f49073l.decrementAndGet() == 0) {
                this.f49074f.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f49073l.incrementAndGet() == 2) {
                c();
                if (this.f49073l.decrementAndGet() == 0) {
                    this.f49074f.onComplete();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        SampleTimedNoLast(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j8, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void b() {
            this.f49074f.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    /* loaded from: classes5.dex */
    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49074f;

        /* renamed from: g  reason: collision with root package name */
        final long f49075g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f49076h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler f49077i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<Disposable> f49078j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        Disposable f49079k;

        SampleTimedObserver(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler scheduler) {
            this.f49074f = observer;
            this.f49075g = j8;
            this.f49076h = timeUnit;
            this.f49077i = scheduler;
        }

        void a() {
            DisposableHelper.a(this.f49078j);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.f49074f.onNext(andSet);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            a();
            this.f49079k.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49079k.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            a();
            this.f49074f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            lazySet(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49079k, disposable)) {
                this.f49079k = disposable;
                this.f49074f.onSubscribe(this);
                Scheduler scheduler = this.f49077i;
                long j8 = this.f49075g;
                DisposableHelper.e(this.f49078j, scheduler.f(this, j8, j8, this.f49076h));
            }
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        super(observableSource);
        this.f49069g = j8;
        this.f49070h = timeUnit;
        this.f49071i = scheduler;
        this.f49072j = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f49072j) {
            this.f48232f.subscribe(new SampleTimedEmitLast(serializedObserver, this.f49069g, this.f49070h, this.f49071i));
        } else {
            this.f48232f.subscribe(new SampleTimedNoLast(serializedObserver, this.f49069g, this.f49070h, this.f49071i));
        }
    }
}
