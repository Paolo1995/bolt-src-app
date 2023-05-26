package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48965f;

    /* renamed from: g  reason: collision with root package name */
    final R f48966g;

    /* renamed from: h  reason: collision with root package name */
    final BiFunction<R, ? super T, R> f48967h;

    /* loaded from: classes5.dex */
    static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super R> f48968f;

        /* renamed from: g  reason: collision with root package name */
        final BiFunction<R, ? super T, R> f48969g;

        /* renamed from: h  reason: collision with root package name */
        R f48970h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f48971i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r7) {
            this.f48968f = singleObserver;
            this.f48970h = r7;
            this.f48969g = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48971i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48971i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            R r7 = this.f48970h;
            if (r7 != null) {
                this.f48970h = null;
                this.f48968f.onSuccess(r7);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48970h != null) {
                this.f48970h = null;
                this.f48968f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            R r7 = this.f48970h;
            if (r7 != null) {
                try {
                    this.f48970h = (R) ObjectHelper.e(this.f48969g.apply(r7, t7), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f48971i.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48971i, disposable)) {
                this.f48971i = disposable;
                this.f48968f.onSubscribe(this);
            }
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r7, BiFunction<R, ? super T, R> biFunction) {
        this.f48965f = observableSource;
        this.f48966g = r7;
        this.f48967h = biFunction;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super R> singleObserver) {
        this.f48965f.subscribe(new ReduceSeedObserver(singleObserver, this.f48967h, this.f48966g));
    }
}
