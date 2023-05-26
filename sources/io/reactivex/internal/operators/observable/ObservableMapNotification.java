package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends R>> f48854g;

    /* renamed from: h  reason: collision with root package name */
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> f48855h;

    /* renamed from: i  reason: collision with root package name */
    final Callable<? extends ObservableSource<? extends R>> f48856i;

    /* loaded from: classes5.dex */
    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super ObservableSource<? extends R>> f48857f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f48858g;

        /* renamed from: h  reason: collision with root package name */
        final Function<? super Throwable, ? extends ObservableSource<? extends R>> f48859h;

        /* renamed from: i  reason: collision with root package name */
        final Callable<? extends ObservableSource<? extends R>> f48860i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f48861j;

        MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
            this.f48857f = observer;
            this.f48858g = function;
            this.f48859h = function2;
            this.f48860i = callable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48861j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48861j.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            try {
                this.f48857f.onNext((ObservableSource) ObjectHelper.e(this.f48860i.call(), "The onComplete ObservableSource returned is null"));
                this.f48857f.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48857f.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                this.f48857f.onNext((ObservableSource) ObjectHelper.e(this.f48859h.apply(th), "The onError ObservableSource returned is null"));
                this.f48857f.onComplete();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f48857f.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            try {
                this.f48857f.onNext((ObservableSource) ObjectHelper.e(this.f48858g.apply(t7), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48857f.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48861j, disposable)) {
                this.f48861j = disposable;
                this.f48857f.onSubscribe(this);
            }
        }
    }

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        super(observableSource);
        this.f48854g = function;
        this.f48855h = function2;
        this.f48856i = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.f48232f.subscribe(new MapNotificationObserver(observer, this.f48854g, this.f48855h, this.f48856i));
    }
}
