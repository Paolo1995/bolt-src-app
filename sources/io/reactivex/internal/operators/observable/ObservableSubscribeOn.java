package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f49193g;

    /* loaded from: classes5.dex */
    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49194f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f49195g = new AtomicReference<>();

        SubscribeOnObserver(Observer<? super T> observer) {
            this.f49194f = observer;
        }

        void a(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49195g);
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49194f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49194f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49194f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49195g, disposable);
        }
    }

    /* loaded from: classes5.dex */
    final class SubscribeTask implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final SubscribeOnObserver<T> f49196f;

        SubscribeTask(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f49196f = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f48232f.subscribe(this.f49196f);
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f49193g = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.a(this.f49193g.d(new SubscribeTask(subscribeOnObserver)));
    }
}
