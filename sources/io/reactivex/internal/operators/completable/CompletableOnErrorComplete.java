package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* loaded from: classes5.dex */
public final class CompletableOnErrorComplete extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f47763f;

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super Throwable> f47764g;

    /* loaded from: classes5.dex */
    final class OnError implements CompletableObserver {

        /* renamed from: f  reason: collision with root package name */
        private final CompletableObserver f47765f;

        OnError(CompletableObserver completableObserver) {
            this.f47765f = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f47765f.onComplete();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.f47764g.test(th)) {
                    this.f47765f.onComplete();
                } else {
                    this.f47765f.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f47765f.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f47765f.onSubscribe(disposable);
        }
    }

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.f47763f = completableSource;
        this.f47764g = predicate;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47763f.a(new OnError(completableObserver));
    }
}
