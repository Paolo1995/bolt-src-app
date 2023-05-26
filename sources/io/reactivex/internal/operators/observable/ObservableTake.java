package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f49222g;

    /* loaded from: classes5.dex */
    static final class TakeObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49223f;

        /* renamed from: g  reason: collision with root package name */
        boolean f49224g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49225h;

        /* renamed from: i  reason: collision with root package name */
        long f49226i;

        TakeObserver(Observer<? super T> observer, long j8) {
            this.f49223f = observer;
            this.f49226i = j8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49225h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49225h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f49224g) {
                this.f49224g = true;
                this.f49225h.dispose();
                this.f49223f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49224g) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49224g = true;
            this.f49225h.dispose();
            this.f49223f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            boolean z7;
            if (!this.f49224g) {
                long j8 = this.f49226i;
                long j9 = j8 - 1;
                this.f49226i = j9;
                if (j8 > 0) {
                    if (j9 == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    this.f49223f.onNext(t7);
                    if (z7) {
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49225h, disposable)) {
                this.f49225h = disposable;
                if (this.f49226i == 0) {
                    this.f49224g = true;
                    disposable.dispose();
                    EmptyDisposable.e(this.f49223f);
                    return;
                }
                this.f49223f.onSubscribe(this);
            }
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j8) {
        super(observableSource);
        this.f49222g = j8;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new TakeObserver(observer, this.f49222g));
    }
}
