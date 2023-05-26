package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48595f;

    /* renamed from: g  reason: collision with root package name */
    final long f48596g;

    /* loaded from: classes5.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final MaybeObserver<? super T> f48597f;

        /* renamed from: g  reason: collision with root package name */
        final long f48598g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48599h;

        /* renamed from: i  reason: collision with root package name */
        long f48600i;

        /* renamed from: j  reason: collision with root package name */
        boolean f48601j;

        ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j8) {
            this.f48597f = maybeObserver;
            this.f48598g = j8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48599h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48599h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f48601j) {
                this.f48601j = true;
                this.f48597f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48601j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48601j = true;
            this.f48597f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48601j) {
                return;
            }
            long j8 = this.f48600i;
            if (j8 == this.f48598g) {
                this.f48601j = true;
                this.f48599h.dispose();
                this.f48597f.onSuccess(t7);
                return;
            }
            this.f48600i = j8 + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48599h, disposable)) {
                this.f48599h = disposable;
                this.f48597f.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j8) {
        this.f48595f = observableSource;
        this.f48596g = j8;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<T> b() {
        return RxJavaPlugins.n(new ObservableElementAt(this.f48595f, this.f48596g, null, false));
    }

    @Override // io.reactivex.Maybe
    public void i(MaybeObserver<? super T> maybeObserver) {
        this.f48595f.subscribe(new ElementAtObserver(maybeObserver, this.f48596g));
    }
}
