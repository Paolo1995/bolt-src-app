package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48491f;

    /* loaded from: classes5.dex */
    static final class CountObserver implements Observer<Object>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super Long> f48492f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48493g;

        /* renamed from: h  reason: collision with root package name */
        long f48494h;

        CountObserver(SingleObserver<? super Long> singleObserver) {
            this.f48492f = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48493g.dispose();
            this.f48493g = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48493g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48493g = DisposableHelper.DISPOSED;
            this.f48492f.onSuccess(Long.valueOf(this.f48494h));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48493g = DisposableHelper.DISPOSED;
            this.f48492f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.f48494h++;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48493g, disposable)) {
                this.f48493g = disposable;
                this.f48492f.onSubscribe(this);
            }
        }
    }

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.f48491f = observableSource;
    }

    @Override // io.reactivex.Single
    public void J(SingleObserver<? super Long> singleObserver) {
        this.f48491f.subscribe(new CountObserver(singleObserver));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Long> b() {
        return RxJavaPlugins.n(new ObservableCount(this.f48491f));
    }
}
