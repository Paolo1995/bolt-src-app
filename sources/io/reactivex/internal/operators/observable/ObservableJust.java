package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* loaded from: classes5.dex */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {

    /* renamed from: f  reason: collision with root package name */
    private final T f48840f;

    public ObservableJust(T t7) {
        this.f48840f = t7;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.f48840f;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.f48840f);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
