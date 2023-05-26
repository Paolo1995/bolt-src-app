package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class CompletableDelay extends Completable {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f47724f;

    /* renamed from: g  reason: collision with root package name */
    final long f47725g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f47726h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f47727i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f47728j;

    /* loaded from: classes5.dex */
    static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final CompletableObserver f47729f;

        /* renamed from: g  reason: collision with root package name */
        final long f47730g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f47731h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler f47732i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f47733j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f47734k;

        Delay(CompletableObserver completableObserver, long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
            this.f47729f = completableObserver;
            this.f47730g = j8;
            this.f47731h = timeUnit;
            this.f47732i = scheduler;
            this.f47733j = z7;
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
            DisposableHelper.e(this, this.f47732i.e(this, this.f47730g, this.f47731h));
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            long j8;
            this.f47734k = th;
            Scheduler scheduler = this.f47732i;
            if (this.f47733j) {
                j8 = this.f47730g;
            } else {
                j8 = 0;
            }
            DisposableHelper.e(this, scheduler.e(this, j8, this.f47731h));
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                this.f47729f.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f47734k;
            this.f47734k = null;
            if (th != null) {
                this.f47729f.onError(th);
            } else {
                this.f47729f.onComplete();
            }
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j8, TimeUnit timeUnit, Scheduler scheduler, boolean z7) {
        this.f47724f = completableSource;
        this.f47725g = j8;
        this.f47726h = timeUnit;
        this.f47727i = scheduler;
        this.f47728j = z7;
    }

    @Override // io.reactivex.Completable
    protected void H(CompletableObserver completableObserver) {
        this.f47724f.a(new Delay(completableObserver, this.f47725g, this.f47726h, this.f47727i, this.f47728j));
    }
}
