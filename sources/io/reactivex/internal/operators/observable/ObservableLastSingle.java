package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class ObservableLastSingle<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48845f;

    /* renamed from: g  reason: collision with root package name */
    final T f48846g;

    /* loaded from: classes5.dex */
    static final class LastObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f48847f;

        /* renamed from: g  reason: collision with root package name */
        final T f48848g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48849h;

        /* renamed from: i  reason: collision with root package name */
        T f48850i;

        LastObserver(SingleObserver<? super T> singleObserver, T t7) {
            this.f48847f = singleObserver;
            this.f48848g = t7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48849h.dispose();
            this.f48849h = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f48849h == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48849h = DisposableHelper.DISPOSED;
            T t7 = this.f48850i;
            if (t7 != null) {
                this.f48850i = null;
                this.f48847f.onSuccess(t7);
                return;
            }
            T t8 = this.f48848g;
            if (t8 != null) {
                this.f48847f.onSuccess(t8);
            } else {
                this.f48847f.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48849h = DisposableHelper.DISPOSED;
            this.f48850i = null;
            this.f48847f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48850i = t7;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48849h, disposable)) {
                this.f48849h = disposable;
                this.f48847f.onSubscribe(this);
            }
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t7) {
        this.f48845f = observableSource;
        this.f48846g = t7;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f48845f.subscribe(new LastObserver(singleObserver, this.f48846g));
    }
}
