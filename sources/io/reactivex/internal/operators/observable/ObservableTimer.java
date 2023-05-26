package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableTimer extends Observable<Long> {

    /* renamed from: f  reason: collision with root package name */
    final Scheduler f49337f;

    /* renamed from: g  reason: collision with root package name */
    final long f49338g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49339h;

    /* loaded from: classes5.dex */
    static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Long> f49340f;

        TimerObserver(Observer<? super Long> observer) {
            this.f49340f = observer;
        }

        public void a(Disposable disposable) {
            DisposableHelper.k(this, disposable);
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
                this.f49340f.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f49340f.onComplete();
            }
        }
    }

    public ObservableTimer(long j8, TimeUnit timeUnit, Scheduler scheduler) {
        this.f49338g = j8;
        this.f49339h = timeUnit;
        this.f49337f = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        timerObserver.a(this.f49337f.e(timerObserver, this.f49338g, this.f49339h));
    }
}
