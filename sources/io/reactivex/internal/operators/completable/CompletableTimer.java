package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class CompletableTimer extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final long f47787f;

    /* renamed from: g  reason: collision with root package name */
    final TimeUnit f47788g;

    /* renamed from: h  reason: collision with root package name */
    final Scheduler f47789h;

    /* loaded from: classes5.dex */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47790f;

        TimerDisposable(CompletableObserver completableObserver) {
            this.f47790f = completableObserver;
        }

        void a(Disposable disposable) {
            DisposableHelper.e(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47790f.onComplete();
        }
    }

    public CompletableTimer(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        this.f47787f = j8;
        this.f47788g = timeUnit;
        this.f47789h = scheduler;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.a(this.f47789h.e(timerDisposable, this.f47787f, this.f47788g));
    }
}
