package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48264f;

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f48265g;

    /* loaded from: classes5.dex */
    static final class AllObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super Boolean> f48266f;

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f48267g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48268h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48269i;

        AllObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f48266f = singleObserver;
            this.f48267g = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48268h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48268h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48269i) {
                return;
            }
            this.f48269i = true;
            this.f48266f.onSuccess(Boolean.TRUE);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48269i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48269i = true;
            this.f48266f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48269i) {
                return;
            }
            try {
                if (!this.f48267g.test(t7)) {
                    this.f48269i = true;
                    this.f48268h.dispose();
                    this.f48266f.onSuccess(Boolean.FALSE);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48268h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48268h, disposable)) {
                this.f48268h = disposable;
                this.f48266f.onSubscribe(this);
            }
        }
    }

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f48264f = observableSource;
        this.f48265g = predicate;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super Boolean> singleObserver) {
        this.f48264f.subscribe(new AllObserver(singleObserver, this.f48265g));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Boolean> b() {
        return RxJavaPlugins.n(new ObservableAll(this.f48264f, this.f48265g));
    }
}
