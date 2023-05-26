package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final BiPredicate<? super Integer, ? super Throwable> f49046g;

    /* loaded from: classes5.dex */
    static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49047f;

        /* renamed from: g  reason: collision with root package name */
        final SequentialDisposable f49048g;

        /* renamed from: h  reason: collision with root package name */
        final ObservableSource<? extends T> f49049h;

        /* renamed from: i  reason: collision with root package name */
        final BiPredicate<? super Integer, ? super Throwable> f49050i;

        /* renamed from: j  reason: collision with root package name */
        int f49051j;

        RetryBiObserver(Observer<? super T> observer, BiPredicate<? super Integer, ? super Throwable> biPredicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f49047f = observer;
            this.f49048g = sequentialDisposable;
            this.f49049h = observableSource;
            this.f49050i = biPredicate;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i8 = 1;
                while (!this.f49048g.isDisposed()) {
                    this.f49049h.subscribe(this);
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49047f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.f49050i;
                int i8 = this.f49051j + 1;
                this.f49051j = i8;
                if (!biPredicate.test(Integer.valueOf(i8), th)) {
                    this.f49047f.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f49047f.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49047f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f49048g.a(disposable);
        }
    }

    public ObservableRetryBiPredicate(Observable<T> observable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(observable);
        this.f49046g = biPredicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RetryBiObserver(observer, this.f49046g, sequentialDisposable, this.f48232f).a();
    }
}
