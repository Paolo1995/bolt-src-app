package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableAll<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f48259g;

    /* loaded from: classes5.dex */
    static final class AllObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Boolean> f48260f;

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f48261g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f48262h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48263i;

        AllObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f48260f = observer;
            this.f48261g = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48262h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48262h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48263i) {
                return;
            }
            this.f48263i = true;
            this.f48260f.onNext(Boolean.TRUE);
            this.f48260f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48263i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48263i = true;
            this.f48260f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48263i) {
                return;
            }
            try {
                if (!this.f48261g.test(t7)) {
                    this.f48263i = true;
                    this.f48262h.dispose();
                    this.f48260f.onNext(Boolean.FALSE);
                    this.f48260f.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48262h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48262h, disposable)) {
                this.f48262h = disposable;
                this.f48260f.onSubscribe(this);
            }
        }
    }

    public ObservableAll(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f48259g = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Boolean> observer) {
        this.f48232f.subscribe(new AllObserver(observer, this.f48259g));
    }
}
