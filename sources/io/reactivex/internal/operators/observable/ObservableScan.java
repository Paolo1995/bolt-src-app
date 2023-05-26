package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final BiFunction<T, T, T> f49093g;

    /* loaded from: classes5.dex */
    static final class ScanObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49094f;

        /* renamed from: g  reason: collision with root package name */
        final BiFunction<T, T, T> f49095g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49096h;

        /* renamed from: i  reason: collision with root package name */
        T f49097i;

        /* renamed from: j  reason: collision with root package name */
        boolean f49098j;

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.f49094f = observer;
            this.f49095g = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49096h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49096h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49098j) {
                return;
            }
            this.f49098j = true;
            this.f49094f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49098j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49098j = true;
            this.f49094f.onError(th);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49098j) {
                return;
            }
            Observer<? super T> observer = this.f49094f;
            T t8 = this.f49097i;
            if (t8 == null) {
                this.f49097i = t7;
                observer.onNext(t7);
                return;
            }
            try {
                ?? r42 = (T) ObjectHelper.e(this.f49095g.apply(t8, t7), "The value returned by the accumulator is null");
                this.f49097i = r42;
                observer.onNext(r42);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49096h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49096h, disposable)) {
                this.f49096h = disposable;
                this.f49094f.onSubscribe(this);
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.f49093g = biFunction;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new ScanObserver(observer, this.f49093g));
    }
}
