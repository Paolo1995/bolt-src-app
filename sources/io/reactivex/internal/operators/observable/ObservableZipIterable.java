package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class ObservableZipIterable<T, U, V> extends Observable<V> {

    /* renamed from: f  reason: collision with root package name */
    final Observable<? extends T> f49515f;

    /* renamed from: g  reason: collision with root package name */
    final Iterable<U> f49516g;

    /* renamed from: h  reason: collision with root package name */
    final BiFunction<? super T, ? super U, ? extends V> f49517h;

    /* loaded from: classes5.dex */
    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super V> f49518f;

        /* renamed from: g  reason: collision with root package name */
        final Iterator<U> f49519g;

        /* renamed from: h  reason: collision with root package name */
        final BiFunction<? super T, ? super U, ? extends V> f49520h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f49521i;

        /* renamed from: j  reason: collision with root package name */
        boolean f49522j;

        ZipIterableObserver(Observer<? super V> observer, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f49518f = observer;
            this.f49519g = it;
            this.f49520h = biFunction;
        }

        void a(Throwable th) {
            this.f49522j = true;
            this.f49521i.dispose();
            this.f49518f.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49521i.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49521i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49522j) {
                return;
            }
            this.f49522j = true;
            this.f49518f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49522j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49522j = true;
            this.f49518f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49522j) {
                return;
            }
            try {
                try {
                    this.f49518f.onNext(ObjectHelper.e(this.f49520h.apply(t7, ObjectHelper.e(this.f49519g.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (!this.f49519g.hasNext()) {
                            this.f49522j = true;
                            this.f49521i.dispose();
                            this.f49518f.onComplete();
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        a(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    a(th2);
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                a(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49521i, disposable)) {
                this.f49521i = disposable;
                this.f49518f.onSubscribe(this);
            }
        }
    }

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.f49515f = observable;
        this.f49516g = iterable;
        this.f49517h = biFunction;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator it = (Iterator) ObjectHelper.e(this.f49516g.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.e(observer);
                } else {
                    this.f49515f.subscribe(new ZipIterableObserver(observer, it, this.f49517h));
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.h(th2, observer);
        }
    }
}
