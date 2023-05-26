package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableConcatWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final SingleSource<? extends T> f48484g;

    /* loaded from: classes5.dex */
    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48485f;

        /* renamed from: g  reason: collision with root package name */
        SingleSource<? extends T> f48486g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48487h;

        ConcatWithObserver(Observer<? super T> observer, SingleSource<? extends T> singleSource) {
            this.f48485f = observer;
            this.f48486g = singleSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48487h = true;
            DisposableHelper.e(this, null);
            SingleSource<? extends T> singleSource = this.f48486g;
            this.f48486g = null;
            singleSource.a(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48485f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48485f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable) && !this.f48487h) {
                this.f48485f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver, io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f48485f.onNext(t7);
            this.f48485f.onComplete();
        }
    }

    public ObservableConcatWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f48484g = singleSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new ConcatWithObserver(observer, this.f48484g));
    }
}
