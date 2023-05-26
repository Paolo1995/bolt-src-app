package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class CompletableDefer extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Callable<? extends CompletableSource> f47723f;

    public CompletableDefer(Callable<? extends CompletableSource> callable) {
        this.f47723f = callable;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        try {
            ((CompletableSource) ObjectHelper.e(this.f47723f.call(), "The completableSupplier returned a null CompletableSource")).a(completableObserver);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.f(th, completableObserver);
        }
    }
}
