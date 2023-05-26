package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* loaded from: classes5.dex */
public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final int f49227g;

    /* loaded from: classes5.dex */
    static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49228f;

        /* renamed from: g  reason: collision with root package name */
        final int f49229g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49230h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f49231i;

        TakeLastObserver(Observer<? super T> observer, int i8) {
            this.f49228f = observer;
            this.f49229g = i8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49231i) {
                this.f49231i = true;
                this.f49230h.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49231i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer<? super T> observer = this.f49228f;
            while (!this.f49231i) {
                Object obj = (T) poll();
                if (obj == null) {
                    if (!this.f49231i) {
                        observer.onComplete();
                        return;
                    }
                    return;
                }
                observer.onNext(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49228f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49229g == size()) {
                poll();
            }
            offer(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49230h, disposable)) {
                this.f49230h = disposable;
                this.f49228f.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLast(ObservableSource<T> observableSource, int i8) {
        super(observableSource);
        this.f49227g = i8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new TakeLastObserver(observer, this.f49227g));
    }
}
