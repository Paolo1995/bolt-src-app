package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleTimer extends Single<Long> {

    /* renamed from: f  reason: collision with root package name */
    final long f49621f;

    /* renamed from: g  reason: collision with root package name */
    final TimeUnit f49622g;

    /* renamed from: h  reason: collision with root package name */
    final Scheduler f49623h;

    /* loaded from: classes5.dex */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super Long> f49624f;

        TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.f49624f = singleObserver;
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
            this.f49624f.onSuccess(0L);
        }
    }

    public SingleTimer(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        this.f49621f = j8;
        this.f49622g = timeUnit;
        this.f49623h = scheduler;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        timerDisposable.a(this.f49623h.e(timerDisposable, this.f49621f, this.f49622g));
    }
}
