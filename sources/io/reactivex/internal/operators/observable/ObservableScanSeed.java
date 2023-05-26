package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final BiFunction<R, ? super T, R> f49099g;

    /* renamed from: h  reason: collision with root package name */
    final Callable<R> f49100h;

    /* loaded from: classes5.dex */
    static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f49101f;

        /* renamed from: g  reason: collision with root package name */
        final BiFunction<R, ? super T, R> f49102g;

        /* renamed from: h  reason: collision with root package name */
        R f49103h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f49104i;

        /* renamed from: j  reason: collision with root package name */
        boolean f49105j;

        ScanSeedObserver(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r7) {
            this.f49101f = observer;
            this.f49102g = biFunction;
            this.f49103h = r7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49104i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49104i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49105j) {
                return;
            }
            this.f49105j = true;
            this.f49101f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49105j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49105j = true;
            this.f49101f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49105j) {
                return;
            }
            try {
                R r7 = (R) ObjectHelper.e(this.f49102g.apply(this.f49103h, t7), "The accumulator returned a null value");
                this.f49103h = r7;
                this.f49101f.onNext(r7);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49104i.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49104i, disposable)) {
                this.f49104i = disposable;
                this.f49101f.onSubscribe(this);
                this.f49101f.onNext((R) this.f49103h);
            }
        }
    }

    public ObservableScanSeed(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.f49099g = biFunction;
        this.f49100h = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        try {
            this.f48232f.subscribe(new ScanSeedObserver(observer, this.f49099g, ObjectHelper.e(this.f49100h.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
