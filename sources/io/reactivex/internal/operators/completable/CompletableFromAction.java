package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class CompletableFromAction extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final Action f47742f;

    public CompletableFromAction(Action action) {
        this.f47742f = action;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        Disposable b8 = Disposables.b();
        completableObserver.onSubscribe(b8);
        try {
            this.f47742f.run();
            if (!b8.isDisposed()) {
                completableObserver.onComplete();
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            if (!b8.isDisposed()) {
                completableObserver.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }
    }
}
