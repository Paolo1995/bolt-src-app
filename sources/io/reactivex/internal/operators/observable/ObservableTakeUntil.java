package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<? extends U> f49251g;

    /* loaded from: classes5.dex */
    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49252f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f49253g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final TakeUntilMainObserver<T, U>.OtherObserver f49254h = new OtherObserver();

        /* renamed from: i  reason: collision with root package name */
        final AtomicThrowable f49255i = new AtomicThrowable();

        /* loaded from: classes5.dex */
        final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            OtherObserver() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                TakeUntilMainObserver.this.a();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                TakeUntilMainObserver.this.b(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u7) {
                DisposableHelper.a(this);
                TakeUntilMainObserver.this.a();
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.j(this, disposable);
            }
        }

        TakeUntilMainObserver(Observer<? super T> observer) {
            this.f49252f = observer;
        }

        void a() {
            DisposableHelper.a(this.f49253g);
            HalfSerializer.a(this.f49252f, this, this.f49255i);
        }

        void b(Throwable th) {
            DisposableHelper.a(this.f49253g);
            HalfSerializer.c(this.f49252f, th, this, this.f49255i);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49253g);
            DisposableHelper.a(this.f49254h);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f49253g.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this.f49254h);
            HalfSerializer.a(this.f49252f, this, this.f49255i);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f49254h);
            HalfSerializer.c(this.f49252f, th, this, this.f49255i);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            HalfSerializer.e(this.f49252f, t7, this, this.f49255i);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49253g, disposable);
        }
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f49251g = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.f49251g.subscribe(takeUntilMainObserver.f49254h);
        this.f48232f.subscribe(takeUntilMainObserver);
    }
}
