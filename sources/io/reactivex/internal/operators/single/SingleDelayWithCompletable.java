package io.reactivex.internal.operators.single;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleDelayWithCompletable<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49540f;

    /* renamed from: g  reason: collision with root package name */
    final CompletableSource f49541g;

    /* loaded from: classes5.dex */
    static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49542f;

        /* renamed from: g  reason: collision with root package name */
        final SingleSource<T> f49543g;

        OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f49542f = singleObserver;
            this.f49543g = singleSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f49543g.a(new ResumeSingleObserver(this, this.f49542f));
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49542f.onError(th);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                this.f49542f.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithCompletable(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.f49540f = singleSource;
        this.f49541g = completableSource;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49541g.a(new OtherObserver(singleObserver, this.f49540f));
    }
}
