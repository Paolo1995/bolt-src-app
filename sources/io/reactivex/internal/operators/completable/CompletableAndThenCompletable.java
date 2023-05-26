package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class CompletableAndThenCompletable extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f47711f;

    /* renamed from: g  reason: collision with root package name */
    final CompletableSource f47712g;

    /* loaded from: classes5.dex */
    static final class NextObserver implements CompletableObserver {

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<Disposable> f47713f;

        /* renamed from: g  reason: collision with root package name */
        final CompletableObserver f47714g;

        NextObserver(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
            this.f47713f = atomicReference;
            this.f47714g = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f47714g.onComplete();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f47714g.onError(th);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.e(this.f47713f, disposable);
        }
    }

    /* loaded from: classes5.dex */
    static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47715f;

        /* renamed from: g  reason: collision with root package name */
        final CompletableSource f47716g;

        SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f47715f = completableObserver;
            this.f47716g = completableSource;
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
            this.f47716g.a(new NextObserver(this, this.f47715f));
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f47715f.onError(th);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                this.f47715f.onSubscribe(this);
            }
        }
    }

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.f47711f = completableSource;
        this.f47712g = completableSource2;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47711f.a(new SourceObserver(completableObserver, this.f47712g));
    }
}
