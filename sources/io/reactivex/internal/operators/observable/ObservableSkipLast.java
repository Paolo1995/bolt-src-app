package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* loaded from: classes5.dex */
public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final int f49158g;

    /* loaded from: classes5.dex */
    static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49159f;

        /* renamed from: g  reason: collision with root package name */
        final int f49160g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49161h;

        SkipLastObserver(Observer<? super T> observer, int i8) {
            super(i8);
            this.f49159f = observer;
            this.f49160g = i8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49161h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49161h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49159f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49159f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49160g == size()) {
                this.f49159f.onNext((T) poll());
            }
            offer(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49161h, disposable)) {
                this.f49161h = disposable;
                this.f49159f.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i8) {
        super(observableSource);
        this.f49158g = i8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new SkipLastObserver(observer, this.f49158g));
    }
}
