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
public final class ObservableAnySingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48284f;

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f48285g;

    /* loaded from: classes5.dex */
    static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super Boolean> f48286f;

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f48287g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48288h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48289i;

        AnyObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f48286f = singleObserver;
            this.f48287g = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48288h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48288h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f48289i) {
                this.f48289i = true;
                this.f48286f.onSuccess(Boolean.FALSE);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48289i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48289i = true;
            this.f48286f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48289i) {
                return;
            }
            try {
                if (this.f48287g.test(t7)) {
                    this.f48289i = true;
                    this.f48288h.dispose();
                    this.f48286f.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48288h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48288h, disposable)) {
                this.f48288h = disposable;
                this.f48286f.onSubscribe(this);
            }
        }
    }

    public ObservableAnySingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f48284f = observableSource;
        this.f48285g = predicate;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super Boolean> singleObserver) {
        this.f48284f.subscribe(new AnyObserver(singleObserver, this.f48285g));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Boolean> b() {
        return RxJavaPlugins.n(new ObservableAny(this.f48284f, this.f48285g));
    }
}
