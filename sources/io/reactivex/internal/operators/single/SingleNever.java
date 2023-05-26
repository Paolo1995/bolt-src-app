package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes5.dex */
public final class SingleNever extends Single<Object> {

    /* renamed from: f  reason: collision with root package name */
    public static final Single<Object> f49588f = new SingleNever();

    private SingleNever() {
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super Object> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
