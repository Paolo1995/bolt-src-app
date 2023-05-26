package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Throwable, ? extends T> f48917g;

    /* loaded from: classes5.dex */
    static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48918f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Throwable, ? extends T> f48919g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48920h;

        OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.f48918f = observer;
            this.f48919g = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48920h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48920h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48918f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                T apply = this.f48919g.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f48918f.onError(nullPointerException);
                    return;
                }
                this.f48918f.onNext(apply);
                this.f48918f.onComplete();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f48918f.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48918f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48920h, disposable)) {
                this.f48920h = disposable;
                this.f48918f.onSubscribe(this);
            }
        }
    }

    public ObservableOnErrorReturn(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.f48917g = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new OnErrorReturnObserver(observer, this.f48917g));
    }
}
