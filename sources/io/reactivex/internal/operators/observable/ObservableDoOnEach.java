package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Consumer<? super T> f48572g;

    /* renamed from: h  reason: collision with root package name */
    final Consumer<? super Throwable> f48573h;

    /* renamed from: i  reason: collision with root package name */
    final Action f48574i;

    /* renamed from: j  reason: collision with root package name */
    final Action f48575j;

    /* loaded from: classes5.dex */
    static final class DoOnEachObserver<T> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48576f;

        /* renamed from: g  reason: collision with root package name */
        final Consumer<? super T> f48577g;

        /* renamed from: h  reason: collision with root package name */
        final Consumer<? super Throwable> f48578h;

        /* renamed from: i  reason: collision with root package name */
        final Action f48579i;

        /* renamed from: j  reason: collision with root package name */
        final Action f48580j;

        /* renamed from: k  reason: collision with root package name */
        Disposable f48581k;

        /* renamed from: l  reason: collision with root package name */
        boolean f48582l;

        DoOnEachObserver(Observer<? super T> observer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            this.f48576f = observer;
            this.f48577g = consumer;
            this.f48578h = consumer2;
            this.f48579i = action;
            this.f48580j = action2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48581k.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48581k.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48582l) {
                return;
            }
            try {
                this.f48579i.run();
                this.f48582l = true;
                this.f48576f.onComplete();
                try {
                    this.f48580j.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48582l) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48582l = true;
            try {
                this.f48578h.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f48576f.onError(th);
            try {
                this.f48580j.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48582l) {
                return;
            }
            try {
                this.f48577g.accept(t7);
                this.f48576f.onNext(t7);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f48581k.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48581k, disposable)) {
                this.f48581k = disposable;
                this.f48576f.onSubscribe(this);
            }
        }
    }

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.f48572g = consumer;
        this.f48573h = consumer2;
        this.f48574i = action;
        this.f48575j = action2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new DoOnEachObserver(observer, this.f48572g, this.f48573h, this.f48574i, this.f48575j));
    }
}
