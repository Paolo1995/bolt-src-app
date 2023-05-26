package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class ObservableSingleSingle<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T> f49147f;

    /* renamed from: g  reason: collision with root package name */
    final T f49148g;

    /* loaded from: classes5.dex */
    static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49149f;

        /* renamed from: g  reason: collision with root package name */
        final T f49150g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49151h;

        /* renamed from: i  reason: collision with root package name */
        T f49152i;

        /* renamed from: j  reason: collision with root package name */
        boolean f49153j;

        SingleElementObserver(SingleObserver<? super T> singleObserver, T t7) {
            this.f49149f = singleObserver;
            this.f49150g = t7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49151h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49151h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49153j) {
                return;
            }
            this.f49153j = true;
            T t7 = this.f49152i;
            this.f49152i = null;
            if (t7 == null) {
                t7 = this.f49150g;
            }
            if (t7 != null) {
                this.f49149f.onSuccess(t7);
            } else {
                this.f49149f.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49153j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49153j = true;
            this.f49149f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49153j) {
                return;
            }
            if (this.f49152i != null) {
                this.f49153j = true;
                this.f49151h.dispose();
                this.f49149f.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f49152i = t7;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49151h, disposable)) {
                this.f49151h = disposable;
                this.f49149f.onSubscribe(this);
            }
        }
    }

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t7) {
        this.f49147f = observableSource;
        this.f49148g = t7;
    }

    @Override // io.reactivex.Single
    public void J(SingleObserver<? super T> singleObserver) {
        this.f49147f.subscribe(new SingleElementObserver(singleObserver, this.f49148g));
    }
}
