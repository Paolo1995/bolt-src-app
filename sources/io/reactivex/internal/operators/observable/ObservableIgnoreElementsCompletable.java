package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48775f;

    /* loaded from: classes5.dex */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f48776f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48777g;

        IgnoreObservable(CompletableObserver completableObserver) {
            this.f48776f = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48777g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48777g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48776f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48776f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f48777g = disposable;
            this.f48776f.onSubscribe(this);
        }
    }

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f48775f = observableSource;
    }

    @Override // io.reactivex.Completable
    public void H(CompletableObserver completableObserver) {
        this.f48775f.subscribe(new IgnoreObservable(completableObserver));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<T> b() {
        return RxJavaPlugins.n(new ObservableIgnoreElements(this.f48775f));
    }
}
