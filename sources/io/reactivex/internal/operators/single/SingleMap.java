package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes5.dex */
public final class SingleMap<T, R> extends Single<R> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<? extends T> f49584f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends R> f49585g;

    /* loaded from: classes5.dex */
    static final class MapSingleObserver<T, R> implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super R> f49586f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends R> f49587g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f49586f = singleObserver;
            this.f49587g = function;
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49586f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f49586f.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            try {
                this.f49586f.onSuccess(ObjectHelper.e(this.f49587g.apply(t7), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.f49584f = singleSource;
        this.f49585g = function;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super R> singleObserver) {
        this.f49584f.a(new MapSingleObserver(singleObserver, this.f49585g));
    }
}
