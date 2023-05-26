package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f49267g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49268h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f49269i;

    /* loaded from: classes5.dex */
    static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49270f;

        /* renamed from: g  reason: collision with root package name */
        final long f49271g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f49272h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler.Worker f49273i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f49274j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f49275k;

        /* renamed from: l  reason: collision with root package name */
        boolean f49276l;

        DebounceTimedObserver(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f49270f = observer;
            this.f49271g = j8;
            this.f49272h = timeUnit;
            this.f49273i = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49274j.dispose();
            this.f49273i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49273i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f49276l) {
                this.f49276l = true;
                this.f49270f.onComplete();
                this.f49273i.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49276l) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49276l = true;
            this.f49270f.onError(th);
            this.f49273i.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (!this.f49275k && !this.f49276l) {
                this.f49275k = true;
                this.f49270f.onNext(t7);
                Disposable disposable = get();
                if (disposable != null) {
                    disposable.dispose();
                }
                DisposableHelper.e(this, this.f49273i.c(this, this.f49271g, this.f49272h));
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49274j, disposable)) {
                this.f49274j = disposable;
                this.f49270f.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f49275k = false;
        }
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f49267g = j8;
        this.f49268h = timeUnit;
        this.f49269i = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f49267g, this.f49268h, this.f49269i.b()));
    }
}
