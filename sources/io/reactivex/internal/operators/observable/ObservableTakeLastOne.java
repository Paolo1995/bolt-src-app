package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    /* loaded from: classes5.dex */
    static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49232f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f49233g;

        /* renamed from: h  reason: collision with root package name */
        T f49234h;

        TakeLastOneObserver(Observer<? super T> observer) {
            this.f49232f = observer;
        }

        void a() {
            T t7 = this.f49234h;
            if (t7 != null) {
                this.f49234h = null;
                this.f49232f.onNext(t7);
            }
            this.f49232f.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49234h = null;
            this.f49233g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49233g.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49234h = null;
            this.f49232f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49234h = t7;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49233g, disposable)) {
                this.f49233g = disposable;
                this.f49232f.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastOne(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new TakeLastOneObserver(observer));
    }
}
