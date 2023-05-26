package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: classes5.dex */
public final class SingleDoOnError<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49553f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super Throwable> f49554g;

    /* loaded from: classes5.dex */
    final class DoOnError implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        private final SingleObserver<? super T> f49555f;

        DoOnError(SingleObserver<? super T> singleObserver) {
            this.f49555f = singleObserver;
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            try {
                SingleDoOnError.this.f49554g.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f49555f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f49555f.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f49555f.onSuccess(t7);
        }
    }

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.f49553f = singleSource;
        this.f49554g = consumer;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49553f.a(new DoOnError(singleObserver));
    }
}
