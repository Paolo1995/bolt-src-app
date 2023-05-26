package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Callable<? extends T> f48122f;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.f48122f = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.f48122f.call();
    }

    @Override // io.reactivex.Maybe
    protected void i(MaybeObserver<? super T> maybeObserver) {
        Disposable b8 = Disposables.b();
        maybeObserver.onSubscribe(b8);
        if (!b8.isDisposed()) {
            try {
                Object obj = (T) this.f48122f.call();
                if (!b8.isDisposed()) {
                    if (obj == null) {
                        maybeObserver.onComplete();
                    } else {
                        maybeObserver.onSuccess(obj);
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!b8.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.s(th);
                }
            }
        }
    }
}
