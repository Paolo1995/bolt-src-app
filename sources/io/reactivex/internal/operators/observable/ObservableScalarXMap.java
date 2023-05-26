package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableScalarXMap {

    /* loaded from: classes5.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49089f;

        /* renamed from: g  reason: collision with root package name */
        final T f49090g;

        public ScalarDisposable(Observer<? super T> observer, T t7) {
            this.f49089f = observer;
            this.f49090g = t7;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == 3) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (get() != 1) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t7) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.f49090g;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f49089f.onNext((T) this.f49090g);
                if (get() == 2) {
                    lazySet(3);
                    this.f49089f.onComplete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ScalarXMapObservable<T, R> extends Observable<R> {

        /* renamed from: f  reason: collision with root package name */
        final T f49091f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f49092g;

        ScalarXMapObservable(T t7, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f49091f = t7;
            this.f49092g = function;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super R> observer) {
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49092g.apply((T) this.f49091f), "The mapper returned a null ObservableSource");
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.e(observer);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                        return;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        EmptyDisposable.h(th, observer);
                        return;
                    }
                }
                observableSource.subscribe(observer);
            } catch (Throwable th2) {
                EmptyDisposable.h(th2, observer);
            }
        }
    }

    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Observable<U> a(T t7, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.n(new ScalarXMapObservable(t7, function));
    }

    public static <T, R> boolean b(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (observableSource instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) observableSource).call();
                if (obj == 0) {
                    EmptyDisposable.e(observer);
                    return true;
                }
                try {
                    ObservableSource observableSource2 = (ObservableSource) ObjectHelper.e(function.apply(obj), "The mapper returned a null ObservableSource");
                    if (observableSource2 instanceof Callable) {
                        try {
                            Object call = ((Callable) observableSource2).call();
                            if (call == null) {
                                EmptyDisposable.e(observer);
                                return true;
                            }
                            ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                            observer.onSubscribe(scalarDisposable);
                            scalarDisposable.run();
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            EmptyDisposable.h(th, observer);
                            return true;
                        }
                    } else {
                        observableSource2.subscribe(observer);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    EmptyDisposable.h(th2, observer);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                EmptyDisposable.h(th3, observer);
                return true;
            }
        }
        return false;
    }
}
