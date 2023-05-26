package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

/* loaded from: classes5.dex */
public final class SingleOnErrorReturn<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<? extends T> f49595f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Throwable, ? extends T> f49596g;

    /* renamed from: h  reason: collision with root package name */
    final T f49597h;

    /* loaded from: classes5.dex */
    final class OnErrorReturn implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        private final SingleObserver<? super T> f49598f;

        OnErrorReturn(SingleObserver<? super T> singleObserver) {
            this.f49598f = singleObserver;
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            T apply;
            SingleOnErrorReturn singleOnErrorReturn = SingleOnErrorReturn.this;
            Function<? super Throwable, ? extends T> function = singleOnErrorReturn.f49596g;
            if (function != null) {
                try {
                    apply = function.apply(th);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f49598f.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                apply = singleOnErrorReturn.f49597h;
            }
            if (apply == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.f49598f.onError(nullPointerException);
                return;
            }
            this.f49598f.onSuccess(apply);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f49598f.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f49598f.onSuccess(t7);
        }
    }

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t7) {
        this.f49595f = singleSource;
        this.f49596g = function;
        this.f49597h = t7;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49595f.a(new OnErrorReturn(singleObserver));
    }
}
