package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {

    /* loaded from: classes5.dex */
    static final class CountObserver implements Observer<Object>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Long> f48488f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48489g;

        /* renamed from: h  reason: collision with root package name */
        long f48490h;

        CountObserver(Observer<? super Long> observer) {
            this.f48488f = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48489g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48489g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48488f.onNext(Long.valueOf(this.f48490h));
            this.f48488f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48488f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.f48490h++;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48489g, disposable)) {
                this.f48489g = disposable;
                this.f48488f.onSubscribe(this);
            }
        }
    }

    public ObservableCount(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        this.f48232f.subscribe(new CountObserver(observer));
    }
}
