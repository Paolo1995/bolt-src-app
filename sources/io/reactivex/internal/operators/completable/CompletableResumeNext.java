package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class CompletableResumeNext extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f47777f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super Throwable, ? extends CompletableSource> f47778g;

    /* loaded from: classes5.dex */
    static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47779f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Throwable, ? extends CompletableSource> f47780g;

        /* renamed from: h  reason: collision with root package name */
        boolean f47781h;

        ResumeNextObserver(CompletableObserver completableObserver, Function<? super Throwable, ? extends CompletableSource> function) {
            this.f47779f = completableObserver;
            this.f47780g = function;
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
            this.f47779f.onComplete();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.f47781h) {
                this.f47779f.onError(th);
                return;
            }
            this.f47781h = true;
            try {
                ((CompletableSource) ObjectHelper.e(this.f47780g.apply(th), "The errorMapper returned a null CompletableSource")).a(this);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f47779f.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.e(this, disposable);
        }
    }

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.f47777f = completableSource;
        this.f47778g = function;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(completableObserver, this.f47778g);
        completableObserver.onSubscribe(resumeNextObserver);
        this.f47777f.a(resumeNextObserver);
    }
}
