package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class SingleDefer<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final Callable<? extends SingleSource<? extends T>> f49527f;

    public SingleDefer(Callable<? extends SingleSource<? extends T>> callable) {
        this.f49527f = callable;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        try {
            ((SingleSource) ObjectHelper.e(this.f49527f.call(), "The singleSupplier returned a null SingleSource")).a(singleObserver);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
