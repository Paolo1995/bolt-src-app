package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableDematerialize<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends Notification<R>> f48547g;

    /* loaded from: classes5.dex */
    static final class DematerializeObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48548f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends Notification<R>> f48549g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48550h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f48551i;

        DematerializeObserver(Observer<? super R> observer, Function<? super T, ? extends Notification<R>> function) {
            this.f48548f = observer;
            this.f48549g = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48551i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48551i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48550h) {
                return;
            }
            this.f48550h = true;
            this.f48548f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48550h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48550h = true;
            this.f48548f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48550h) {
                if (t7 instanceof Notification) {
                    Notification notification = (Notification) t7;
                    if (notification.g()) {
                        RxJavaPlugins.s(notification.d());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                Notification notification2 = (Notification) ObjectHelper.e(this.f48549g.apply(t7), "The selector returned a null Notification");
                if (notification2.g()) {
                    this.f48551i.dispose();
                    onError(notification2.d());
                } else if (notification2.f()) {
                    this.f48551i.dispose();
                    onComplete();
                } else {
                    this.f48548f.onNext((Object) notification2.e());
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48551i.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48551i, disposable)) {
                this.f48551i = disposable;
                this.f48548f.onSubscribe(this);
            }
        }
    }

    public ObservableDematerialize(ObservableSource<T> observableSource, Function<? super T, ? extends Notification<R>> function) {
        super(observableSource);
        this.f48547g = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.f48232f.subscribe(new DematerializeObserver(observer, this.f48547g));
    }
}
