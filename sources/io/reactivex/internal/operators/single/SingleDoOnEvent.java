package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;

/* loaded from: classes5.dex */
public final class SingleDoOnEvent<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49557f;

    /* renamed from: g  reason: collision with root package name */
    final BiConsumer<? super T, ? super Throwable> f49558g;

    /* loaded from: classes5.dex */
    final class DoOnEvent implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        private final SingleObserver<? super T> f49559f;

        DoOnEvent(SingleObserver<? super T> singleObserver) {
            this.f49559f = singleObserver;
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            try {
                SingleDoOnEvent.this.f49558g.accept(null, th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f49559f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f49559f.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            try {
                SingleDoOnEvent.this.f49558g.accept(t7, null);
                this.f49559f.onSuccess(t7);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49559f.onError(th);
            }
        }
    }

    public SingleDoOnEvent(SingleSource<T> singleSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f49557f = singleSource;
        this.f49558g = biConsumer;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49557f.a(new DoOnEvent(singleObserver));
    }
}
