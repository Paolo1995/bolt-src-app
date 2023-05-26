package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f49154g;

    /* loaded from: classes5.dex */
    static final class SkipObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49155f;

        /* renamed from: g  reason: collision with root package name */
        long f49156g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49157h;

        SkipObserver(Observer<? super T> observer, long j8) {
            this.f49155f = observer;
            this.f49156g = j8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49157h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49157h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49155f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49155f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            long j8 = this.f49156g;
            if (j8 != 0) {
                this.f49156g = j8 - 1;
            } else {
                this.f49155f.onNext(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49157h, disposable)) {
                this.f49157h = disposable;
                this.f49155f.onSubscribe(this);
            }
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j8) {
        super(observableSource);
        this.f49154g = j8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new SkipObserver(observer, this.f49154g));
    }
}
