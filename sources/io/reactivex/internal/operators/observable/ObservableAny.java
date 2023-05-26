package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f48279g;

    /* loaded from: classes5.dex */
    static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Boolean> f48280f;

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f48281g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48282h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48283i;

        AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f48280f = observer;
            this.f48281g = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48282h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48282h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f48283i) {
                this.f48283i = true;
                this.f48280f.onNext(Boolean.FALSE);
                this.f48280f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48283i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48283i = true;
            this.f48280f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48283i) {
                return;
            }
            try {
                if (this.f48281g.test(t7)) {
                    this.f48283i = true;
                    this.f48282h.dispose();
                    this.f48280f.onNext(Boolean.TRUE);
                    this.f48280f.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48282h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48282h, disposable)) {
                this.f48282h = disposable;
                this.f48280f.onSubscribe(this);
            }
        }
    }

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f48279g = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Boolean> observer) {
        this.f48232f.subscribe(new AnyObserver(observer, this.f48279g));
    }
}
