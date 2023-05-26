package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes5.dex */
public final class ObservableNever extends Observable<Object> {

    /* renamed from: f  reason: collision with root package name */
    public static final Observable<Object> f48894f = new ObservableNever();

    private ObservableNever() {
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Object> observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
