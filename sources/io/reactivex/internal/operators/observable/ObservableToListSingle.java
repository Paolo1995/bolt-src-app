package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f49345f;

    /* renamed from: g  reason: collision with root package name */
    final Callable<U> f49346g;

    /* loaded from: classes5.dex */
    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super U> f49347f;

        /* renamed from: g  reason: collision with root package name */
        U f49348g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49349h;

        ToListObserver(SingleObserver<? super U> singleObserver, U u7) {
            this.f49347f = singleObserver;
            this.f49348g = u7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49349h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49349h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u7 = this.f49348g;
            this.f49348g = null;
            this.f49347f.onSuccess(u7);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49348g = null;
            this.f49347f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49348g.add(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49349h, disposable)) {
                this.f49349h = disposable;
                this.f49347f.onSubscribe(this);
            }
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, int i8) {
        this.f49345f = observableSource;
        this.f49346g = Functions.e(i8);
    }

    @Override // io.reactivex.Single
    public void J(SingleObserver<? super U> singleObserver) {
        try {
            this.f49345f.subscribe(new ToListObserver(singleObserver, (Collection) ObjectHelper.e(this.f49346g.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<U> b() {
        return RxJavaPlugins.n(new ObservableToList(this.f49345f, this.f49346g));
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Callable<U> callable) {
        this.f49345f = observableSource;
        this.f49346g = callable;
    }
}
