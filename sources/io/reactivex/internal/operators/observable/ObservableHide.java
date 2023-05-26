package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {

    /* loaded from: classes5.dex */
    static final class HideDisposable<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48771f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48772g;

        HideDisposable(Observer<? super T> observer) {
            this.f48771f = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48772g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48772g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48771f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48771f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48771f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48772g, disposable)) {
                this.f48772g = disposable;
                this.f48771f.onSubscribe(this);
            }
        }
    }

    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new HideDisposable(observer));
    }
}
