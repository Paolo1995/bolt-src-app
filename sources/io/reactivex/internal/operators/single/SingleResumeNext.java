package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleResumeNext<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<? extends T> f49600f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Throwable, ? extends SingleSource<? extends T>> f49601g;

    /* loaded from: classes5.dex */
    static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49602f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Throwable, ? extends SingleSource<? extends T>> f49603g;

        ResumeMainSingleObserver(SingleObserver<? super T> singleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
            this.f49602f = singleObserver;
            this.f49603g = function;
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
            try {
                ((SingleSource) ObjectHelper.e(this.f49603g.apply(th), "The nextFunction returned a null SingleSource.")).a(new ResumeSingleObserver(this, this.f49602f));
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f49602f.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                this.f49602f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f49602f.onSuccess(t7);
        }
    }

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.f49600f = singleSource;
        this.f49601g = function;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49600f.a(new ResumeMainSingleObserver(singleObserver, this.f49601g));
    }
}
