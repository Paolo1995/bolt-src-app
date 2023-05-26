package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleFlatMap<T, R> extends Single<R> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<? extends T> f49571f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends SingleSource<? extends R>> f49572g;

    /* loaded from: classes5.dex */
    static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super R> f49573f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends SingleSource<? extends R>> f49574g;

        /* loaded from: classes5.dex */
        static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

            /* renamed from: f  reason: collision with root package name */
            final AtomicReference<Disposable> f49575f;

            /* renamed from: g  reason: collision with root package name */
            final SingleObserver<? super R> f49576g;

            FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
                this.f49575f = atomicReference;
                this.f49576g = singleObserver;
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f49576g.onError(th);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.e(this.f49575f, disposable);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
            public void onSuccess(R r7) {
                this.f49576g.onSuccess(r7);
            }
        }

        SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f49573f = singleObserver;
            this.f49574g = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49573f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                this.f49573f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.e(this.f49574g.apply(t7), "The single returned by the mapper is null");
                if (!isDisposed()) {
                    singleSource.a(new FlatMapSingleObserver(this, this.f49573f));
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49573f.onError(th);
            }
        }
    }

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f49572g = function;
        this.f49571f = singleSource;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super R> singleObserver) {
        this.f49571f.a(new SingleFlatMapCallback(singleObserver, this.f49572g));
    }
}
