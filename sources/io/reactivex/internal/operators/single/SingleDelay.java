package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class SingleDelay<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<? extends T> f49528f;

    /* renamed from: g  reason: collision with root package name */
    final long f49529g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49530h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f49531i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f49532j;

    /* loaded from: classes5.dex */
    final class Delay implements SingleObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        private final SequentialDisposable f49533f;

        /* renamed from: g  reason: collision with root package name */
        final SingleObserver<? super T> f49534g;

        /* loaded from: classes5.dex */
        final class OnError implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private final Throwable f49536f;

            OnError(Throwable th) {
                this.f49536f = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f49534g.onError(this.f49536f);
            }
        }

        /* loaded from: classes5.dex */
        final class OnSuccess implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private final T f49538f;

            OnSuccess(T t7) {
                this.f49538f = t7;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f49534g.onSuccess((T) this.f49538f);
            }
        }

        Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.f49533f = sequentialDisposable;
            this.f49534g = singleObserver;
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            long j8;
            SequentialDisposable sequentialDisposable = this.f49533f;
            Scheduler scheduler = SingleDelay.this.f49531i;
            OnError onError = new OnError(th);
            SingleDelay singleDelay = SingleDelay.this;
            if (singleDelay.f49532j) {
                j8 = singleDelay.f49529g;
            } else {
                j8 = 0;
            }
            sequentialDisposable.a(scheduler.e(onError, j8, singleDelay.f49530h));
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.f49533f.a(disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            SequentialDisposable sequentialDisposable = this.f49533f;
            Scheduler scheduler = SingleDelay.this.f49531i;
            OnSuccess onSuccess = new OnSuccess(t7);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.a(scheduler.e(onSuccess, singleDelay.f49529g, singleDelay.f49530h));
        }
    }

    public SingleDelay(SingleSource<? extends T> singleSource, long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        this.f49528f = singleSource;
        this.f49529g = j8;
        this.f49530h = timeUnit;
        this.f49531i = scheduler;
        this.f49532j = z7;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.f49528f.a(new Delay(sequentialDisposable, singleObserver));
    }
}
