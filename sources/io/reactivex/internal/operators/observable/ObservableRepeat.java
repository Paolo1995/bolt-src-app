package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f48990g;

    /* loaded from: classes5.dex */
    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48991f;

        /* renamed from: g  reason: collision with root package name */
        final SequentialDisposable f48992g;

        /* renamed from: h  reason: collision with root package name */
        final ObservableSource<? extends T> f48993h;

        /* renamed from: i  reason: collision with root package name */
        long f48994i;

        RepeatObserver(Observer<? super T> observer, long j8, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f48991f = observer;
            this.f48992g = sequentialDisposable;
            this.f48993h = observableSource;
            this.f48994i = j8;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i8 = 1;
                while (!this.f48992g.isDisposed()) {
                    this.f48993h.subscribe(this);
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            long j8 = this.f48994i;
            if (j8 != Long.MAX_VALUE) {
                this.f48994i = j8 - 1;
            }
            if (j8 != 0) {
                a();
            } else {
                this.f48991f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48991f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48991f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f48992g.a(disposable);
        }
    }

    public ObservableRepeat(Observable<T> observable, long j8) {
        super(observable);
        this.f48990g = j8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j8 = this.f48990g;
        long j9 = Long.MAX_VALUE;
        if (j8 != Long.MAX_VALUE) {
            j9 = j8 - 1;
        }
        new RepeatObserver(observer, j9, sequentialDisposable, this.f48232f).a();
    }
}
