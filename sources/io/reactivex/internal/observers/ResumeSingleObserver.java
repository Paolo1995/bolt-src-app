package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<Disposable> f47707f;

    /* renamed from: g  reason: collision with root package name */
    final SingleObserver<? super T> f47708g;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f47707f = atomicReference;
        this.f47708g = singleObserver;
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        this.f47708g.onError(th);
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.e(this.f47707f, disposable);
    }

    @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
    public void onSuccess(T t7) {
        this.f47708g.onSuccess(t7);
    }
}
