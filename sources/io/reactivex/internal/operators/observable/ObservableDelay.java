package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f48525g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f48526h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f48527i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f48528j;

    /* loaded from: classes5.dex */
    static final class DelayObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48529f;

        /* renamed from: g  reason: collision with root package name */
        final long f48530g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f48531h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler.Worker f48532i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f48533j;

        /* renamed from: k  reason: collision with root package name */
        Disposable f48534k;

        /* loaded from: classes5.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.f48529f.onComplete();
                } finally {
                    DelayObserver.this.f48532i.dispose();
                }
            }
        }

        /* loaded from: classes5.dex */
        final class OnError implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private final Throwable f48536f;

            OnError(Throwable th) {
                this.f48536f = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.f48529f.onError(this.f48536f);
                } finally {
                    DelayObserver.this.f48532i.dispose();
                }
            }
        }

        /* loaded from: classes5.dex */
        final class OnNext implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private final T f48538f;

            OnNext(T t7) {
                this.f48538f = t7;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelayObserver.this.f48529f.onNext((T) this.f48538f);
            }
        }

        DelayObserver(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler.Worker worker, boolean z7) {
            this.f48529f = observer;
            this.f48530g = j8;
            this.f48531h = timeUnit;
            this.f48532i = worker;
            this.f48533j = z7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48534k.dispose();
            this.f48532i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48532i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48532i.c(new OnComplete(), this.f48530g, this.f48531h);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            long j8;
            Scheduler.Worker worker = this.f48532i;
            OnError onError = new OnError(th);
            if (this.f48533j) {
                j8 = this.f48530g;
            } else {
                j8 = 0;
            }
            worker.c(onError, j8, this.f48531h);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48532i.c(new OnNext(t7), this.f48530g, this.f48531h);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48534k, disposable)) {
                this.f48534k = disposable;
                this.f48529f.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        super(observableSource);
        this.f48525g = j8;
        this.f48526h = timeUnit;
        this.f48527i = scheduler;
        this.f48528j = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver;
        if (this.f48528j) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.f48232f.subscribe(new DelayObserver(serializedObserver, this.f48525g, this.f48526h, this.f48527i.b(), this.f48528j));
    }
}
