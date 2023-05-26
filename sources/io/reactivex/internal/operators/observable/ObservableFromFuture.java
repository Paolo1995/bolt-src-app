package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class ObservableFromFuture<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Future<? extends T> f48698f;

    /* renamed from: g  reason: collision with root package name */
    final long f48699g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f48700h;

    public ObservableFromFuture(Future<? extends T> future, long j8, TimeUnit timeUnit) {
        this.f48698f = future;
        this.f48699g = j8;
        this.f48700h = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        T t7;
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                TimeUnit timeUnit = this.f48700h;
                if (timeUnit != null) {
                    t7 = this.f48698f.get(this.f48699g, timeUnit);
                } else {
                    t7 = this.f48698f.get();
                }
                deferredScalarDisposable.c(ObjectHelper.e(t7, "Future returned null"));
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                }
            }
        }
    }
}
