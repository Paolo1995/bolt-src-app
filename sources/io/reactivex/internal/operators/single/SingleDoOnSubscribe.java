package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class SingleDoOnSubscribe<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49561f;

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super Disposable> f49562g;

    /* loaded from: classes5.dex */
    static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49563f;

        /* renamed from: g  reason: collision with root package name */
        final Consumer<? super Disposable> f49564g;

        /* renamed from: h  reason: collision with root package name */
        boolean f49565h;

        DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.f49563f = singleObserver;
            this.f49564g = consumer;
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.f49565h) {
                RxJavaPlugins.s(th);
            } else {
                this.f49563f.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            try {
                this.f49564g.accept(disposable);
                this.f49563f.onSubscribe(disposable);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49565h = true;
                disposable.dispose();
                EmptyDisposable.j(th, this.f49563f);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            if (this.f49565h) {
                return;
            }
            this.f49563f.onSuccess(t7);
        }
    }

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.f49561f = singleSource;
        this.f49562g = consumer;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49561f.a(new DoOnSubscribeSingleObserver(singleObserver, this.f49562g));
    }
}
