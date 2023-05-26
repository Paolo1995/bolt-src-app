package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: classes5.dex */
public final class SingleDoOnSuccess<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49566f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super T> f49567g;

    /* loaded from: classes5.dex */
    final class DoOnSuccess implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49568f;

        DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.f49568f = singleObserver;
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49568f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f49568f.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            try {
                SingleDoOnSuccess.this.f49567g.accept(t7);
                this.f49568f.onSuccess(t7);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49568f.onError(th);
            }
        }
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f49566f = singleSource;
        this.f49567g = consumer;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49566f.a(new DoOnSuccess(singleObserver));
    }
}
