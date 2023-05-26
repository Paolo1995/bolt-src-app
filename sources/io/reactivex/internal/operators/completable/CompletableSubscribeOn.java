package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class CompletableSubscribeOn extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f47782f;

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f47783g;

    /* loaded from: classes5.dex */
    static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47784f;

        /* renamed from: g  reason: collision with root package name */
        final SequentialDisposable f47785g = new SequentialDisposable();

        /* renamed from: h  reason: collision with root package name */
        final CompletableSource f47786h;

        SubscribeOnObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f47784f = completableObserver;
            this.f47786h = completableSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            this.f47785g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f47784f.onComplete();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f47784f.onError(th);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47786h.a(this);
        }
    }

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f47782f = completableSource;
        this.f47783g = scheduler;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(completableObserver, this.f47782f);
        completableObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.f47785g.a(this.f47783g.d(subscribeOnObserver));
    }
}
