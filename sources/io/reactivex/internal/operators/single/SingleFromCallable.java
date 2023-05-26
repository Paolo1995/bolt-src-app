package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class SingleFromCallable<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final Callable<? extends T> f49581f;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.f49581f = callable;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        Disposable b8 = Disposables.b();
        singleObserver.onSubscribe(b8);
        if (b8.isDisposed()) {
            return;
        }
        try {
            Object obj = (Object) ObjectHelper.e(this.f49581f.call(), "The callable returned a null value");
            if (!b8.isDisposed()) {
                singleObserver.onSuccess(obj);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            if (!b8.isDisposed()) {
                singleObserver.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }
    }
}
