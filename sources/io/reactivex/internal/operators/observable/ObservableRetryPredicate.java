package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super Throwable> f49052g;

    /* renamed from: h  reason: collision with root package name */
    final long f49053h;

    /* loaded from: classes5.dex */
    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49054f;

        /* renamed from: g  reason: collision with root package name */
        final SequentialDisposable f49055g;

        /* renamed from: h  reason: collision with root package name */
        final ObservableSource<? extends T> f49056h;

        /* renamed from: i  reason: collision with root package name */
        final Predicate<? super Throwable> f49057i;

        /* renamed from: j  reason: collision with root package name */
        long f49058j;

        RepeatObserver(Observer<? super T> observer, long j8, Predicate<? super Throwable> predicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f49054f = observer;
            this.f49055g = sequentialDisposable;
            this.f49056h = observableSource;
            this.f49057i = predicate;
            this.f49058j = j8;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i8 = 1;
                while (!this.f49055g.isDisposed()) {
                    this.f49056h.subscribe(this);
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49054f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            long j8 = this.f49058j;
            if (j8 != Long.MAX_VALUE) {
                this.f49058j = j8 - 1;
            }
            if (j8 == 0) {
                this.f49054f.onError(th);
                return;
            }
            try {
                if (!this.f49057i.test(th)) {
                    this.f49054f.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f49054f.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49054f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f49055g.a(disposable);
        }
    }

    public ObservableRetryPredicate(Observable<T> observable, long j8, Predicate<? super Throwable> predicate) {
        super(observable);
        this.f49052g = predicate;
        this.f49053h = j8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatObserver(observer, this.f49053h, this.f49052g, sequentialDisposable, this.f48232f).a();
    }
}
