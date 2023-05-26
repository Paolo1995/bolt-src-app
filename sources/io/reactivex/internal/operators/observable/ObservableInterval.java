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
public final class ObservableInterval extends Observable<Long> {

    /* renamed from: f  reason: collision with root package name */
    final Scheduler f48804f;

    /* renamed from: g  reason: collision with root package name */
    final long f48805g;

    /* renamed from: h  reason: collision with root package name */
    final long f48806h;

    /* renamed from: i  reason: collision with root package name */
    final TimeUnit f48807i;

    /* loaded from: classes5.dex */
    static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Long> f48808f;

        /* renamed from: g  reason: collision with root package name */
        long f48809g;

        IntervalObserver(Observer<? super Long> observer) {
            this.f48808f = observer;
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
            if (get() != DisposableHelper.DISPOSED) {
                Observer<? super Long> observer = this.f48808f;
                long j8 = this.f48809g;
                this.f48809g = 1 + j8;
                observer.onNext(Long.valueOf(j8));
            }
        }
    }

    public ObservableInterval(long j8, long j9, TimeUnit timeUnit, Scheduler scheduler) {
        this.f48805g = j8;
        this.f48806h = j9;
        this.f48807i = timeUnit;
        this.f48804f = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        Scheduler scheduler = this.f48804f;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker b8 = scheduler.b();
            intervalObserver.a(b8);
            b8.d(intervalObserver, this.f48805g, this.f48806h, this.f48807i);
            return;
        }
        intervalObserver.a(scheduler.f(intervalObserver, this.f48805g, this.f48806h, this.f48807i));
    }
}
