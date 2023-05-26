package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* loaded from: classes5.dex */
public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    /* loaded from: classes5.dex */
    static final class DetachObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        Observer<? super T> f48552f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48553g;

        DetachObserver(Observer<? super T> observer) {
            this.f48552f = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f48553g;
            this.f48553g = EmptyComponent.INSTANCE;
            this.f48552f = EmptyComponent.a();
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48553g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer<? super T> observer = this.f48552f;
            this.f48553g = EmptyComponent.INSTANCE;
            this.f48552f = EmptyComponent.a();
            observer.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Observer<? super T> observer = this.f48552f;
            this.f48553g = EmptyComponent.INSTANCE;
            this.f48552f = EmptyComponent.a();
            observer.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48552f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48553g, disposable)) {
                this.f48553g = disposable;
                this.f48552f.onSubscribe(this);
            }
        }
    }

    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new DetachObserver(observer));
    }
}
