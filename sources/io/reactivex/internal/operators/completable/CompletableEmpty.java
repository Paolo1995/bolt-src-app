package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes5.dex */
public final class CompletableEmpty extends Completable {

    /* renamed from: f  reason: collision with root package name */
    public static final Completable f47740f = new CompletableEmpty();

    private CompletableEmpty() {
    }

    @Override // io.reactivex.Completable
    public void H(CompletableObserver completableObserver) {
        EmptyDisposable.c(completableObserver);
    }
}
