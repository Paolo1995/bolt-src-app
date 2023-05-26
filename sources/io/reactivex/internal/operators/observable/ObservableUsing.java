package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class ObservableUsing<T, D> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final Callable<? extends D> f49355f;

    /* renamed from: g  reason: collision with root package name */
    final Function<? super D, ? extends ObservableSource<? extends T>> f49356g;

    /* renamed from: h  reason: collision with root package name */
    final Consumer<? super D> f49357h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f49358i;

    /* loaded from: classes5.dex */
    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49359f;

        /* renamed from: g  reason: collision with root package name */
        final D f49360g;

        /* renamed from: h  reason: collision with root package name */
        final Consumer<? super D> f49361h;

        /* renamed from: i  reason: collision with root package name */
        final boolean f49362i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f49363j;

        UsingObserver(Observer<? super T> observer, D d8, Consumer<? super D> consumer, boolean z7) {
            this.f49359f = observer;
            this.f49360g = d8;
            this.f49361h = consumer;
            this.f49362i = z7;
        }

        void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f49361h.accept((D) this.f49360g);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            a();
            this.f49363j.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49362i) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f49361h.accept((D) this.f49360g);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f49359f.onError(th);
                        return;
                    }
                }
                this.f49363j.dispose();
                this.f49359f.onComplete();
                return;
            }
            this.f49359f.onComplete();
            this.f49363j.dispose();
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49362i) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f49361h.accept((D) this.f49360g);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.f49363j.dispose();
                this.f49359f.onError(th);
                return;
            }
            this.f49359f.onError(th);
            this.f49363j.dispose();
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49359f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49363j, disposable)) {
                this.f49363j = disposable;
                this.f49359f.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z7) {
        this.f49355f = callable;
        this.f49356g = function;
        this.f49357h = consumer;
        this.f49358i = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            D call = this.f49355f.call();
            try {
                ((ObservableSource) ObjectHelper.e(this.f49356g.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(observer, call, this.f49357h, this.f49358i));
            } catch (Throwable th) {
                Exceptions.b(th);
                try {
                    this.f49357h.accept(call);
                    EmptyDisposable.h(th, observer);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    EmptyDisposable.h(new CompositeException(th, th2), observer);
                }
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            EmptyDisposable.h(th3, observer);
        }
    }
}
