package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleTimeout<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49609f;

    /* renamed from: g  reason: collision with root package name */
    final long f49610g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49611h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f49612i;

    /* renamed from: j  reason: collision with root package name */
    final SingleSource<? extends T> f49613j;

    /* loaded from: classes5.dex */
    static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49614f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f49615g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final TimeoutFallbackObserver<T> f49616h;

        /* renamed from: i  reason: collision with root package name */
        SingleSource<? extends T> f49617i;

        /* renamed from: j  reason: collision with root package name */
        final long f49618j;

        /* renamed from: k  reason: collision with root package name */
        final TimeUnit f49619k;

        /* loaded from: classes5.dex */
        static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {

            /* renamed from: f  reason: collision with root package name */
            final SingleObserver<? super T> f49620f;

            TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
                this.f49620f = singleObserver;
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f49620f.onError(th);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }

            @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
            public void onSuccess(T t7) {
                this.f49620f.onSuccess(t7);
            }
        }

        TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long j8, TimeUnit timeUnit) {
            this.f49614f = singleObserver;
            this.f49617i = singleSource;
            this.f49618j = j8;
            this.f49619k = timeUnit;
            if (singleSource != null) {
                this.f49616h = new TimeoutFallbackObserver<>(singleObserver);
            } else {
                this.f49616h = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            DisposableHelper.a(this.f49615g);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.f49616h;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.a(timeoutFallbackObserver);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                DisposableHelper.a(this.f49615g);
                this.f49614f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                DisposableHelper.a(this.f49615g);
                this.f49614f.onSuccess(t7);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                if (disposable != null) {
                    disposable.dispose();
                }
                SingleSource<? extends T> singleSource = this.f49617i;
                if (singleSource == null) {
                    this.f49614f.onError(new TimeoutException(ExceptionHelper.d(this.f49618j, this.f49619k)));
                    return;
                }
                this.f49617i = null;
                singleSource.a(this.f49616h);
            }
        }
    }

    public SingleTimeout(SingleSource<T> singleSource, long j8, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.f49609f = singleSource;
        this.f49610g = j8;
        this.f49611h = timeUnit;
        this.f49612i = scheduler;
        this.f49613j = singleSource2;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.f49613j, this.f49610g, this.f49611h);
        singleObserver.onSubscribe(timeoutMainObserver);
        DisposableHelper.e(timeoutMainObserver.f49615g, this.f49612i.e(timeoutMainObserver, this.f49610g, this.f49611h));
        this.f49609f.a(timeoutMainObserver);
    }
}
