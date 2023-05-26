package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends Iterable<? extends R>> f48687g;

    /* loaded from: classes5.dex */
    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48688f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends Iterable<? extends R>> f48689g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48690h;

        FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f48688f = observer;
            this.f48689g = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48690h.dispose();
            this.f48690h = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48690h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Disposable disposable = this.f48690h;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            this.f48690h = disposableHelper;
            this.f48688f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Disposable disposable = this.f48690h;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48690h = disposableHelper;
            this.f48688f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48690h == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                Observer<? super R> observer = this.f48688f;
                for (R r7 : this.f48689g.apply(t7)) {
                    try {
                        try {
                            observer.onNext((Object) ObjectHelper.e(r7, "The iterator returned a null value"));
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.f48690h.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        this.f48690h.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                this.f48690h.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48690h, disposable)) {
                this.f48690h = disposable;
                this.f48688f.onSubscribe(this);
            }
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.f48687g = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.f48232f.subscribe(new FlattenIterableObserver(observer, this.f48687g));
    }
}
