package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    /* loaded from: classes5.dex */
    static final class MaterializeObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Notification<T>> f48862f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48863g;

        MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.f48862f = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48863g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48863g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48862f.onNext(Notification.a());
            this.f48862f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48862f.onNext(Notification.b(th));
            this.f48862f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48862f.onNext(Notification.c(t7));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48863g, disposable)) {
                this.f48863g = disposable;
                this.f48862f.onSubscribe(this);
            }
        }
    }

    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Notification<T>> observer) {
        this.f48232f.subscribe(new MaterializeObserver(observer));
    }
}
