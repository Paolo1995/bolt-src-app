package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes5.dex */
public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f49188g;

    /* loaded from: classes5.dex */
    static final class SkipWhileObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49189f;

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f49190g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49191h;

        /* renamed from: i  reason: collision with root package name */
        boolean f49192i;

        SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f49189f = observer;
            this.f49190g = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49191h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49191h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49189f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49189f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49192i) {
                this.f49189f.onNext(t7);
                return;
            }
            try {
                if (!this.f49190g.test(t7)) {
                    this.f49192i = true;
                    this.f49189f.onNext(t7);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49191h.dispose();
                this.f49189f.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49191h, disposable)) {
                this.f49191h = disposable;
                this.f49189f.onSubscribe(this);
            }
        }
    }

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f49188g = predicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new SkipWhileObserver(observer, this.f49188g));
    }
}
