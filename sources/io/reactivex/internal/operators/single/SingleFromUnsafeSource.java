package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

/* loaded from: classes5.dex */
public final class SingleFromUnsafeSource<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49582f;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.f49582f = singleSource;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49582f.a(singleObserver);
    }
}
