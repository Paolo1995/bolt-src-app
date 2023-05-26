package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes5.dex */
public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<? extends T> f49198g;

    /* loaded from: classes5.dex */
    static final class SwitchIfEmptyObserver<T> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49199f;

        /* renamed from: g  reason: collision with root package name */
        final ObservableSource<? extends T> f49200g;

        /* renamed from: i  reason: collision with root package name */
        boolean f49202i = true;

        /* renamed from: h  reason: collision with root package name */
        final SequentialDisposable f49201h = new SequentialDisposable();

        SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.f49199f = observer;
            this.f49200g = observableSource;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49202i) {
                this.f49202i = false;
                this.f49200g.subscribe(this);
                return;
            }
            this.f49199f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49199f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49202i) {
                this.f49202i = false;
            }
            this.f49199f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f49201h.b(disposable);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f49198g = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.f49198g);
        observer.onSubscribe(switchIfEmptyObserver.f49201h);
        this.f48232f.subscribe(switchIfEmptyObserver);
    }
}
