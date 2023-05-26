package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class SingleError<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final Callable<? extends Throwable> f49570f;

    public SingleError(Callable<? extends Throwable> callable) {
        this.f49570f = callable;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        try {
            th = (Throwable) ObjectHelper.e(this.f49570f.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptyDisposable.j(th, singleObserver);
    }
}
