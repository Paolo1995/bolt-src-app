package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> f48909g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48910h;

    /* loaded from: classes5.dex */
    static final class OnErrorNextObserver<T> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48911f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> f48912g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f48913h;

        /* renamed from: i  reason: collision with root package name */
        final SequentialDisposable f48914i = new SequentialDisposable();

        /* renamed from: j  reason: collision with root package name */
        boolean f48915j;

        /* renamed from: k  reason: collision with root package name */
        boolean f48916k;

        OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z7) {
            this.f48911f = observer;
            this.f48912g = function;
            this.f48913h = z7;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48916k) {
                return;
            }
            this.f48916k = true;
            this.f48915j = true;
            this.f48911f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48915j) {
                if (this.f48916k) {
                    RxJavaPlugins.s(th);
                    return;
                } else {
                    this.f48911f.onError(th);
                    return;
                }
            }
            this.f48915j = true;
            if (this.f48913h && !(th instanceof Exception)) {
                this.f48911f.onError(th);
                return;
            }
            try {
                ObservableSource<? extends T> apply = this.f48912g.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Observable is null");
                    nullPointerException.initCause(th);
                    this.f48911f.onError(nullPointerException);
                    return;
                }
                apply.subscribe(this);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f48911f.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48916k) {
                return;
            }
            this.f48911f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f48914i.a(disposable);
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z7) {
        super(observableSource);
        this.f48909g = function;
        this.f48910h = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.f48909g, this.f48910h);
        observer.onSubscribe(onErrorNextObserver.f48914i);
        this.f48232f.subscribe(onErrorNextObserver);
    }
}
