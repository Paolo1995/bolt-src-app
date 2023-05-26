package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* loaded from: classes5.dex */
public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {

    /* loaded from: classes5.dex */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48773f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48774g;

        IgnoreObservable(Observer<? super T> observer) {
            this.f48773f = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48774g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48774g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48773f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48773f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f48774g = disposable;
            this.f48773f.onSubscribe(this);
        }
    }

    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new IgnoreObservable(observer));
    }
}
