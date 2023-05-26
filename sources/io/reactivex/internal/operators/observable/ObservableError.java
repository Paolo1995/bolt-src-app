package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableError<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Callable<? extends Throwable> f48612f;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.f48612f = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ObjectHelper.e(this.f48612f.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptyDisposable.h(th, observer);
    }
}
