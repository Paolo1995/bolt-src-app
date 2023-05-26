package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class CompletableAndThenObservable<R> extends Observable<R> {

    /* renamed from: f  reason: collision with root package name */
    final CompletableSource f48136f;

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<? extends R> f48137g;

    /* loaded from: classes5.dex */
    static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48138f;

        /* renamed from: g  reason: collision with root package name */
        ObservableSource<? extends R> f48139g;

        AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
            this.f48139g = observableSource;
            this.f48138f = observer;
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
            ObservableSource<? extends R> observableSource = this.f48139g;
            if (observableSource == null) {
                this.f48138f.onComplete();
                return;
            }
            this.f48139g = null;
            observableSource.subscribe(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48138f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r7) {
            this.f48138f.onNext(r7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.e(this, disposable);
        }
    }

    public CompletableAndThenObservable(CompletableSource completableSource, ObservableSource<? extends R> observableSource) {
        this.f48136f = completableSource;
        this.f48137g = observableSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(observer, this.f48137g);
        observer.onSubscribe(andThenObservableObserver);
        this.f48136f.a(andThenObservableObserver);
    }
}
