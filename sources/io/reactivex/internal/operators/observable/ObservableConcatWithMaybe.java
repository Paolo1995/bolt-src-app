package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final MaybeSource<? extends T> f48480g;

    /* loaded from: classes5.dex */
    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48481f;

        /* renamed from: g  reason: collision with root package name */
        MaybeSource<? extends T> f48482g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48483h;

        ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
            this.f48481f = observer;
            this.f48482g = maybeSource;
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
            if (this.f48483h) {
                this.f48481f.onComplete();
                return;
            }
            this.f48483h = true;
            DisposableHelper.e(this, null);
            MaybeSource<? extends T> maybeSource = this.f48482g;
            this.f48482g = null;
            maybeSource.a(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48481f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48481f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable) && !this.f48483h) {
                this.f48481f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t7) {
            this.f48481f.onNext(t7);
            this.f48481f.onComplete();
        }
    }

    public ObservableConcatWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f48480g = maybeSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new ConcatWithObserver(observer, this.f48480g));
    }
}
