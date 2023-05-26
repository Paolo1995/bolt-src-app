package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<T> f48972f;

    /* renamed from: g  reason: collision with root package name */
    final Callable<R> f48973g;

    /* renamed from: h  reason: collision with root package name */
    final BiFunction<R, ? super T, R> f48974h;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f48972f = observableSource;
        this.f48973g = callable;
        this.f48974h = biFunction;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super R> singleObserver) {
        try {
            this.f48972f.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f48974h, ObjectHelper.e(this.f48973g.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
