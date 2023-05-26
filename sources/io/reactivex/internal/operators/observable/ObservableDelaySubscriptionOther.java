package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T> f48540f;

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<U> f48541g;

    /* loaded from: classes5.dex */
    final class DelayObserver implements Observer<U> {

        /* renamed from: f  reason: collision with root package name */
        final SequentialDisposable f48542f;

        /* renamed from: g  reason: collision with root package name */
        final Observer<? super T> f48543g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48544h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public final class OnComplete implements Observer<T> {
            OnComplete() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                DelayObserver.this.f48543g.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                DelayObserver.this.f48543g.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(T t7) {
                DelayObserver.this.f48543g.onNext(t7);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DelayObserver.this.f48542f.b(disposable);
            }
        }

        DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.f48542f = sequentialDisposable;
            this.f48543g = observer;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48544h) {
                return;
            }
            this.f48544h = true;
            ObservableDelaySubscriptionOther.this.f48540f.subscribe(new OnComplete());
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48544h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48544h = true;
            this.f48543g.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u7) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f48542f.b(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.f48540f = observableSource;
        this.f48541g = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.f48541g.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
