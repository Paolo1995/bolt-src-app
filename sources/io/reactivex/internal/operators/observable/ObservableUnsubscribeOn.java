package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f49350g;

    /* loaded from: classes5.dex */
    static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49351f;

        /* renamed from: g  reason: collision with root package name */
        final Scheduler f49352g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49353h;

        /* loaded from: classes5.dex */
        final class DisposeTask implements Runnable {
            DisposeTask() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.f49353h.dispose();
            }
        }

        UnsubscribeObserver(Observer<? super T> observer, Scheduler scheduler) {
            this.f49351f = observer;
            this.f49352g = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f49352g.d(new DisposeTask());
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!get()) {
                this.f49351f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f49351f.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (!get()) {
                this.f49351f.onNext(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49353h, disposable)) {
                this.f49353h = disposable;
                this.f49351f.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f49350g = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new UnsubscribeObserver(observer, this.f49350g));
    }
}
