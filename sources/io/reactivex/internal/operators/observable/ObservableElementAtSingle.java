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
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48602f;

    /* renamed from: g  reason: collision with root package name */
    final long f48603g;

    /* renamed from: h  reason: collision with root package name */
    final T f48604h;

    /* loaded from: classes5.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f48605f;

        /* renamed from: g  reason: collision with root package name */
        final long f48606g;

        /* renamed from: h  reason: collision with root package name */
        final T f48607h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f48608i;

        /* renamed from: j  reason: collision with root package name */
        long f48609j;

        /* renamed from: k  reason: collision with root package name */
        boolean f48610k;

        ElementAtObserver(SingleObserver<? super T> singleObserver, long j8, T t7) {
            this.f48605f = singleObserver;
            this.f48606g = j8;
            this.f48607h = t7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48608i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48608i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f48610k) {
                this.f48610k = true;
                T t7 = this.f48607h;
                if (t7 != null) {
                    this.f48605f.onSuccess(t7);
                } else {
                    this.f48605f.onError(new NoSuchElementException());
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48610k) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48610k = true;
            this.f48605f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48610k) {
                return;
            }
            long j8 = this.f48609j;
            if (j8 == this.f48606g) {
                this.f48610k = true;
                this.f48608i.dispose();
                this.f48605f.onSuccess(t7);
                return;
            }
            this.f48609j = j8 + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48608i, disposable)) {
                this.f48608i = disposable;
                this.f48605f.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j8, T t7) {
        this.f48602f = observableSource;
        this.f48603g = j8;
        this.f48604h = t7;
    }

    @Override // io.reactivex.Single
    public void J(SingleObserver<? super T> singleObserver) {
        this.f48602f.subscribe(new ElementAtObserver(singleObserver, this.f48603g, this.f48604h));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<T> b() {
        return RxJavaPlugins.n(new ObservableElementAt(this.f48602f, this.f48603g, this.f48604h, true));
    }
}
