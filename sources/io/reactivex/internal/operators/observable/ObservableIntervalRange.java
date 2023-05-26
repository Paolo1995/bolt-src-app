package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableIntervalRange extends Observable<Long> {

    /* renamed from: f  reason: collision with root package name */
    final Scheduler f48810f;

    /* renamed from: g  reason: collision with root package name */
    final long f48811g;

    /* renamed from: h  reason: collision with root package name */
    final long f48812h;

    /* renamed from: i  reason: collision with root package name */
    final long f48813i;

    /* renamed from: j  reason: collision with root package name */
    final long f48814j;

    /* renamed from: k  reason: collision with root package name */
    final TimeUnit f48815k;

    /* loaded from: classes5.dex */
    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Long> f48816f;

        /* renamed from: g  reason: collision with root package name */
        final long f48817g;

        /* renamed from: h  reason: collision with root package name */
        long f48818h;

        IntervalRangeObserver(Observer<? super Long> observer, long j8, long j9) {
            this.f48816f = observer;
            this.f48818h = j8;
            this.f48817g = j9;
        }

        public void a(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                long j8 = this.f48818h;
                this.f48816f.onNext(Long.valueOf(j8));
                if (j8 == this.f48817g) {
                    DisposableHelper.a(this);
                    this.f48816f.onComplete();
                    return;
                }
                this.f48818h = j8 + 1;
            }
        }
    }

    public ObservableIntervalRange(long j8, long j9, long j10, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f48813i = j10;
        this.f48814j = j11;
        this.f48815k = timeUnit;
        this.f48810f = scheduler;
        this.f48811g = j8;
        this.f48812h = j9;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.f48811g, this.f48812h);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.f48810f;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker b8 = scheduler.b();
            intervalRangeObserver.a(b8);
            b8.d(intervalRangeObserver, this.f48813i, this.f48814j, this.f48815k);
            return;
        }
        intervalRangeObserver.a(scheduler.f(intervalRangeObserver, this.f48813i, this.f48814j, this.f48815k));
    }
}
