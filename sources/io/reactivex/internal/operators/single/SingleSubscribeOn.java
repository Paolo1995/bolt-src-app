package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SingleSubscribeOn<T> extends Single<T> {

    /* renamed from: f  reason: collision with root package name */
    final SingleSource<? extends T> f49604f;

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f49605g;

    /* loaded from: classes5.dex */
    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super T> f49606f;

        /* renamed from: g  reason: collision with root package name */
        final SequentialDisposable f49607g = new SequentialDisposable();

        /* renamed from: h  reason: collision with root package name */
        final SingleSource<? extends T> f49608h;

        SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f49606f = singleObserver;
            this.f49608h = singleSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            this.f49607g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f49606f.onError(th);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f49606f.onSuccess(t7);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f49608h.a(this);
        }
    }

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.f49604f = singleSource;
        this.f49605g = scheduler;
    }

    @Override // io.reactivex.Single
    protected void J(SingleObserver<? super T> singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.f49604f);
        singleObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.f49607g.a(this.f49605g.d(subscribeOnObserver));
    }
}
