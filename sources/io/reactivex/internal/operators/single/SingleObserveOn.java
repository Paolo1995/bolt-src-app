package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleObserveOn<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<T> f49589f;

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f49590g;

    /* loaded from: classes5.dex */
    static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49591f;

        /* renamed from: g  reason: collision with root package name */
        final Scheduler f49592g;

        /* renamed from: h  reason: collision with root package name */
        T f49593h;

        /* renamed from: i  reason: collision with root package name */
        Throwable f49594i;

        ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f49591f = singleObserver;
            this.f49592g = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49594i = th;
            DisposableHelper.e(this, this.f49592g.d(this));
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable)) {
                this.f49591f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f49593h = t7;
            DisposableHelper.e(this, this.f49592g.d(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f49594i;
            if (th != null) {
                this.f49591f.onError(th);
            } else {
                this.f49591f.onSuccess((T) this.f49593h);
            }
        }
    }

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f49589f = singleSource;
        this.f49590g = scheduler;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        this.f49589f.a(new ObserveOnSingleObserver(singleObserver, this.f49590g));
    }
}
