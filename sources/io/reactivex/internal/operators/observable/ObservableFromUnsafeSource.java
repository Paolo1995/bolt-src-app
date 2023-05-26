package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

/* loaded from: classes5.dex */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48711f;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f48711f = observableSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48711f.subscribe(observer);
    }
}
