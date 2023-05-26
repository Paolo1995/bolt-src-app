package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableReduceMaybe<T> extends Maybe<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48958f;

    /* renamed from: g  reason: collision with root package name */
    final BiFunction<T, T, T> f48959g;

    /* loaded from: classes5.dex */
    static final class ReduceObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final MaybeObserver<? super T> f48960f;

        /* renamed from: g  reason: collision with root package name */
        final BiFunction<T, T, T> f48961g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48962h;

        /* renamed from: i  reason: collision with root package name */
        T f48963i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f48964j;

        ReduceObserver(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f48960f = maybeObserver;
            this.f48961g = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48964j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48964j.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48962h) {
                return;
            }
            this.f48962h = true;
            T t7 = this.f48963i;
            this.f48963i = null;
            if (t7 != null) {
                this.f48960f.onSuccess(t7);
            } else {
                this.f48960f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48962h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48962h = true;
            this.f48963i = null;
            this.f48960f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (!this.f48962h) {
                T t8 = this.f48963i;
                if (t8 == null) {
                    this.f48963i = t7;
                    return;
                }
                try {
                    this.f48963i = (T) ObjectHelper.e(this.f48961g.apply(t8, t7), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f48964j.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48964j, disposable)) {
                this.f48964j = disposable;
                this.f48960f.onSubscribe(this);
            }
        }
    }

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.f48958f = observableSource;
        this.f48959g = biFunction;
    }

    @Override // io.reactivex.Maybe
    protected void i(MaybeObserver<? super T> maybeObserver) {
        this.f48958f.subscribe(new ReduceObserver(maybeObserver, this.f48959g));
    }
}
