package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48403f;

    /* renamed from: g  reason: collision with root package name */
    final Callable<? extends U> f48404g;

    /* renamed from: h  reason: collision with root package name */
    final BiConsumer<? super U, ? super T> f48405h;

    /* loaded from: classes5.dex */
    static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super U> f48406f;

        /* renamed from: g  reason: collision with root package name */
        final BiConsumer<? super U, ? super T> f48407g;

        /* renamed from: h  reason: collision with root package name */
        final U f48408h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f48409i;

        /* renamed from: j  reason: collision with root package name */
        boolean f48410j;

        CollectObserver(SingleObserver<? super U> singleObserver, U u7, BiConsumer<? super U, ? super T> biConsumer) {
            this.f48406f = singleObserver;
            this.f48407g = biConsumer;
            this.f48408h = u7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48409i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48409i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48410j) {
                return;
            }
            this.f48410j = true;
            this.f48406f.onSuccess((U) this.f48408h);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48410j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48410j = true;
            this.f48406f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48410j) {
                return;
            }
            try {
                this.f48407g.accept((U) this.f48408h, t7);
            } catch (Throwable th) {
                this.f48409i.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48409i, disposable)) {
                this.f48409i = disposable;
                this.f48406f.onSubscribe(this);
            }
        }
    }

    public ObservableCollectSingle(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.f48403f = observableSource;
        this.f48404g = callable;
        this.f48405h = biConsumer;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super U> singleObserver) {
        try {
            this.f48403f.subscribe(new CollectObserver(singleObserver, ObjectHelper.e(this.f48404g.call(), "The initialSupplier returned a null value"), this.f48405h));
        } catch (Throwable th) {
            EmptyDisposable.j(th, singleObserver);
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<U> b() {
        return RxJavaPlugins.n(new ObservableCollect(this.f48403f, this.f48404g, this.f48405h));
    }
}
