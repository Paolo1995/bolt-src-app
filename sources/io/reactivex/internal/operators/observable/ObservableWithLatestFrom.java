package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final BiFunction<? super T, ? super U, ? extends R> f49477g;

    /* renamed from: h  reason: collision with root package name */
    final ObservableSource<? extends U> f49478h;

    /* loaded from: classes5.dex */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f49479f;

        /* renamed from: g  reason: collision with root package name */
        final BiFunction<? super T, ? super U, ? extends R> f49480g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<Disposable> f49481h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<Disposable> f49482i = new AtomicReference<>();

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f49479f = observer;
            this.f49480g = biFunction;
        }

        public void a(Throwable th) {
            DisposableHelper.a(this.f49481h);
            this.f49479f.onError(th);
        }

        public boolean b(Disposable disposable) {
            return DisposableHelper.j(this.f49482i, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49481h);
            DisposableHelper.a(this.f49482i);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f49481h.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this.f49482i);
            this.f49479f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f49482i);
            this.f49479f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            U u7 = get();
            if (u7 != null) {
                try {
                    this.f49479f.onNext(ObjectHelper.e(this.f49480g.apply(t7, u7), "The combiner returned a null value"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    dispose();
                    this.f49479f.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49481h, disposable);
        }
    }

    /* loaded from: classes5.dex */
    final class WithLatestFromOtherObserver implements Observer<U> {

        /* renamed from: f  reason: collision with root package name */
        private final WithLatestFromObserver<T, U, R> f49483f;

        WithLatestFromOtherObserver(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.f49483f = withLatestFromObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49483f.a(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u7) {
            this.f49483f.lazySet(u7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f49483f.b(disposable);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f49477g = biFunction;
        this.f49478h = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.f49477g);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.f49478h.subscribe(new WithLatestFromOtherObserver(withLatestFromObserver));
        this.f48232f.subscribe(withLatestFromObserver);
    }
}
