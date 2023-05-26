package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/* loaded from: classes5.dex */
abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> {

    /* renamed from: f  reason: collision with root package name */
    protected final ObservableSource<T> f48232f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.f48232f = observableSource;
    }
}
