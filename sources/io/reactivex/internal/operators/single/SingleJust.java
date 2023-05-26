package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

/* loaded from: classes5.dex */
public final class SingleJust<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final T f49583f;

    public SingleJust(T t7) {
        this.f49583f = t7;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposables.a());
        singleObserver.onSuccess((T) this.f49583f);
    }
}
