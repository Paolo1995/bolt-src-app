package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes5.dex */
public final class CompletableError extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Throwable f47741f;

    public CompletableError(Throwable th) {
        this.f47741f = th;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        EmptyDisposable.f(this.f47741f, completableObserver);
    }
}
