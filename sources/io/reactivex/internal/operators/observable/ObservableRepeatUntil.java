package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final BooleanSupplier f48995g;

    /* loaded from: classes5.dex */
    static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48996f;

        /* renamed from: g  reason: collision with root package name */
        final SequentialDisposable f48997g;

        /* renamed from: h  reason: collision with root package name */
        final ObservableSource<? extends T> f48998h;

        /* renamed from: i  reason: collision with root package name */
        final BooleanSupplier f48999i;

        RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f48996f = observer;
            this.f48997g = sequentialDisposable;
            this.f48998h = observableSource;
            this.f48999i = booleanSupplier;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i8 = 1;
                do {
                    this.f48998h.subscribe(this);
                    i8 = addAndGet(-i8);
                } while (i8 != 0);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            try {
                if (this.f48999i.getAsBoolean()) {
                    this.f48996f.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48996f.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48996f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48996f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f48997g.a(disposable);
        }
    }

    public ObservableRepeatUntil(Observable<T> observable, BooleanSupplier booleanSupplier) {
        super(observable);
        this.f48995g = booleanSupplier;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(observer, this.f48995g, sequentialDisposable, this.f48232f).a();
    }
}
