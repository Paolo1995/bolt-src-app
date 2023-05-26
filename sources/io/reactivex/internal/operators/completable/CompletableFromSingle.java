package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

/* loaded from: classes5.dex */
public final class CompletableFromSingle<T> extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f47747f;

    /* loaded from: classes5.dex */
    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47748f;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f47748f = completableObserver;
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f47748f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f47748f.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f47748f.onComplete();
        }
    }

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.f47747f = singleSource;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47747f.a(new CompletableFromSingleObserver(completableObserver));
    }
}
