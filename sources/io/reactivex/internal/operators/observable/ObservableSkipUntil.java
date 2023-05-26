package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

/* loaded from: classes5.dex */
public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<U> f49177g;

    /* loaded from: classes5.dex */
    final class SkipUntil implements Observer<U> {

        /* renamed from: f  reason: collision with root package name */
        final ArrayCompositeDisposable f49178f;

        /* renamed from: g  reason: collision with root package name */
        final SkipUntilObserver<T> f49179g;

        /* renamed from: h  reason: collision with root package name */
        final SerializedObserver<T> f49180h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f49181i;

        SkipUntil(ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver<T> skipUntilObserver, SerializedObserver<T> serializedObserver) {
            this.f49178f = arrayCompositeDisposable;
            this.f49179g = skipUntilObserver;
            this.f49180h = serializedObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49179g.f49186i = true;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49178f.dispose();
            this.f49180h.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u7) {
            this.f49181i.dispose();
            this.f49179g.f49186i = true;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49181i, disposable)) {
                this.f49181i = disposable;
                this.f49178f.a(1, disposable);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class SkipUntilObserver<T> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49183f;

        /* renamed from: g  reason: collision with root package name */
        final ArrayCompositeDisposable f49184g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49185h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f49186i;

        /* renamed from: j  reason: collision with root package name */
        boolean f49187j;

        SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f49183f = observer;
            this.f49184g = arrayCompositeDisposable;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49184g.dispose();
            this.f49183f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49184g.dispose();
            this.f49183f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49187j) {
                this.f49183f.onNext(t7);
            } else if (this.f49186i) {
                this.f49187j = true;
                this.f49183f.onNext(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49185h, disposable)) {
                this.f49185h = disposable;
                this.f49184g.a(0, disposable);
            }
        }
    }

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.f49177g = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.onSubscribe(arrayCompositeDisposable);
        SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.f49177g.subscribe(new SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.f48232f.subscribe(skipUntilObserver);
    }
}
