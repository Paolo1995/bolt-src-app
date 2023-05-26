package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final Callable<U> f49341g;

    /* loaded from: classes5.dex */
    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super U> f49342f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f49343g;

        /* renamed from: h  reason: collision with root package name */
        U f49344h;

        ToListObserver(Observer<? super U> observer, U u7) {
            this.f49342f = observer;
            this.f49344h = u7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49343g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49343g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u7 = this.f49344h;
            this.f49344h = null;
            this.f49342f.onNext(u7);
            this.f49342f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49344h = null;
            this.f49342f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49344h.add(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49343g, disposable)) {
                this.f49343g = disposable;
                this.f49342f.onSubscribe(this);
            }
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, int i8) {
        super(observableSource);
        this.f49341g = Functions.e(i8);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.f48232f.subscribe(new ToListObserver(observer, (Collection) ObjectHelper.e(this.f49341g.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.f49341g = callable;
    }
}
