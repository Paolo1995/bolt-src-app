package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final CompletableSource f48476g;

    /* loaded from: classes5.dex */
    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48477f;

        /* renamed from: g  reason: collision with root package name */
        CompletableSource f48478g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48479h;

        ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
            this.f48477f = observer;
            this.f48478g = completableSource;
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
            if (this.f48479h) {
                this.f48477f.onComplete();
                return;
            }
            this.f48479h = true;
            DisposableHelper.e(this, null);
            CompletableSource completableSource = this.f48478g;
            this.f48478g = null;
            completableSource.a(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48477f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48477f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this, disposable) && !this.f48479h) {
                this.f48477f.onSubscribe(this);
            }
        }
    }

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f48476g = completableSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new ConcatWithObserver(observer, this.f48476g));
    }
}
