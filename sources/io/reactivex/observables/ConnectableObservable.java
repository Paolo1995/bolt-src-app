package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservablePublishClassic;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {
    private ConnectableObservable<T> d() {
        if (this instanceof ObservablePublishClassic) {
            return RxJavaPlugins.p(new ObservablePublishAlt(((ObservablePublishClassic) this).a()));
        }
        return this;
    }

    public abstract void c(Consumer<? super Disposable> consumer);

    public Observable<T> e() {
        return RxJavaPlugins.n(new ObservableRefCount(d()));
    }
}
