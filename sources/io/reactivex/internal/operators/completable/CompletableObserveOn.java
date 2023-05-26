package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class CompletableObserveOn extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f47758f;

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f47759g;

    /* loaded from: classes5.dex */
    static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47760f;

        /* renamed from: g  reason: collision with root package name */
        final Scheduler f47761g;

        /* renamed from: h  reason: collision with root package name */
        Throwable f47762h;

        ObserveOnCompletableObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f47760f = completableObserver;
            this.f47761g = scheduler;
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
            DisposableHelper.e(this, this.f47761g.d(this));
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f47762h = th;
            DisposableHelper.e(this, this.f47761g.d(this));
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                this.f47760f.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f47762h;
            if (th != null) {
                this.f47762h = null;
                this.f47760f.onError(th);
                return;
            }
            this.f47760f.onComplete();
        }
    }

    public CompletableObserveOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f47758f = completableSource;
        this.f47759g = scheduler;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47758f.a(new ObserveOnCompletableObserver(completableObserver, this.f47759g));
    }
}
