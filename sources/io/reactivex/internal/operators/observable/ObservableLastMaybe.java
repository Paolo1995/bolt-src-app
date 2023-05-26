package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class ObservableLastMaybe<T> extends Maybe<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48841f;

    /* loaded from: classes5.dex */
    static final class LastObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final MaybeObserver<? super T> f48842f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48843g;

        /* renamed from: h  reason: collision with root package name */
        T f48844h;

        LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.f48842f = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48843g.dispose();
            this.f48843g = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f48843g == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48843g = DisposableHelper.DISPOSED;
            T t7 = this.f48844h;
            if (t7 != null) {
                this.f48844h = null;
                this.f48842f.onSuccess(t7);
                return;
            }
            this.f48842f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48843g = DisposableHelper.DISPOSED;
            this.f48844h = null;
            this.f48842f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48844h = t7;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48843g, disposable)) {
                this.f48843g = disposable;
                this.f48842f.onSubscribe(this);
            }
        }
    }

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.f48841f = observableSource;
    }

    @Override // io.reactivex.Maybe
    protected void i(MaybeObserver<? super T> maybeObserver) {
        this.f48841f.subscribe(new LastObserver(maybeObserver));
    }
}
