package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableTakeUntilPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f49257g;

    /* loaded from: classes5.dex */
    static final class TakeUntilPredicateObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49258f;

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f49259g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49260h;

        /* renamed from: i  reason: collision with root package name */
        boolean f49261i;

        TakeUntilPredicateObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f49258f = observer;
            this.f49259g = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49260h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49260h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f49261i) {
                this.f49261i = true;
                this.f49258f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f49261i) {
                this.f49261i = true;
                this.f49258f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (!this.f49261i) {
                this.f49258f.onNext(t7);
                try {
                    if (this.f49259g.test(t7)) {
                        this.f49261i = true;
                        this.f49260h.dispose();
                        this.f49258f.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f49260h.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49260h, disposable)) {
                this.f49260h = disposable;
                this.f49258f.onSubscribe(this);
            }
        }
    }

    public ObservableTakeUntilPredicate(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f49257g = predicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new TakeUntilPredicateObserver(observer, this.f49257g));
    }
}
