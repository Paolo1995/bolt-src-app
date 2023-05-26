package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableSingleMaybe<T> extends Maybe<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f49142f;

    /* loaded from: classes5.dex */
    static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final MaybeObserver<? super T> f49143f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f49144g;

        /* renamed from: h  reason: collision with root package name */
        T f49145h;

        /* renamed from: i  reason: collision with root package name */
        boolean f49146i;

        SingleElementObserver(MaybeObserver<? super T> maybeObserver) {
            this.f49143f = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49144g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49144g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49146i) {
                return;
            }
            this.f49146i = true;
            T t7 = this.f49145h;
            this.f49145h = null;
            if (t7 == null) {
                this.f49143f.onComplete();
            } else {
                this.f49143f.onSuccess(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49146i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49146i = true;
            this.f49143f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49146i) {
                return;
            }
            if (this.f49145h != null) {
                this.f49146i = true;
                this.f49144g.dispose();
                this.f49143f.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f49145h = t7;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49144g, disposable)) {
                this.f49144g = disposable;
                this.f49143f.onSubscribe(this);
            }
        }
    }

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.f49142f = observableSource;
    }

    @Override // io.reactivex.Maybe
    public void i(MaybeObserver<? super T> maybeObserver) {
        this.f49142f.subscribe(new SingleElementObserver(maybeObserver));
    }
}
