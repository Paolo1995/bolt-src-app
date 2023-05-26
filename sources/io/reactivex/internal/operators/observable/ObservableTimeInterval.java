package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f49293g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49294h;

    /* loaded from: classes5.dex */
    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Timed<T>> f49295f;

        /* renamed from: g  reason: collision with root package name */
        final TimeUnit f49296g;

        /* renamed from: h  reason: collision with root package name */
        final Scheduler f49297h;

        /* renamed from: i  reason: collision with root package name */
        long f49298i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f49299j;

        TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.f49295f = observer;
            this.f49297h = scheduler;
            this.f49296g = timeUnit;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49299j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49299j.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49295f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49295f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            long c8 = this.f49297h.c(this.f49296g);
            long j8 = this.f49298i;
            this.f49298i = c8;
            this.f49295f.onNext(new Timed(t7, c8 - j8, this.f49296g));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49299j, disposable)) {
                this.f49299j = disposable;
                this.f49298i = this.f49297h.c(this.f49296g);
                this.f49295f.onSubscribe(this);
            }
        }
    }

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f49293g = scheduler;
        this.f49294h = timeUnit;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Timed<T>> observer) {
        this.f48232f.subscribe(new TimeIntervalObserver(observer, this.f49294h, this.f49293g));
    }
}
