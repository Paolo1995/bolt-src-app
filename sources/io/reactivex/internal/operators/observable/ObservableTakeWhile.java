package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super T> f49262g;

    /* loaded from: classes5.dex */
    static final class TakeWhileObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49263f;

        /* renamed from: g  reason: collision with root package name */
        final Predicate<? super T> f49264g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f49265h;

        /* renamed from: i  reason: collision with root package name */
        boolean f49266i;

        TakeWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.f49263f = observer;
            this.f49264g = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49265h.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49265h.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49266i) {
                return;
            }
            this.f49266i = true;
            this.f49263f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49266i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49266i = true;
            this.f49263f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49266i) {
                return;
            }
            try {
                if (!this.f49264g.test(t7)) {
                    this.f49266i = true;
                    this.f49265h.dispose();
                    this.f49263f.onComplete();
                    return;
                }
                this.f49263f.onNext(t7);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49265h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49265h, disposable)) {
                this.f49265h = disposable;
                this.f49263f.onSubscribe(this);
            }
        }
    }

    public ObservableTakeWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f49262g = predicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new TakeWhileObserver(observer, this.f49262g));
    }
}
