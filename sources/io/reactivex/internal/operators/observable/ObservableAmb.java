package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableAmb<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T>[] f48270f;

    /* renamed from: g  reason: collision with root package name */
    final Iterable<? extends ObservableSource<? extends T>> f48271g;

    /* loaded from: classes5.dex */
    static final class AmbCoordinator<T> implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48272f;

        /* renamed from: g  reason: collision with root package name */
        final AmbInnerObserver<T>[] f48273g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f48274h = new AtomicInteger();

        AmbCoordinator(Observer<? super T> observer, int i8) {
            this.f48272f = observer;
            this.f48273g = new AmbInnerObserver[i8];
        }

        public void a(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f48273g;
            int length = ambInnerObserverArr.length;
            int i8 = 0;
            while (i8 < length) {
                int i9 = i8 + 1;
                ambInnerObserverArr[i8] = new AmbInnerObserver<>(this, i9, this.f48272f);
                i8 = i9;
            }
            this.f48274h.lazySet(0);
            this.f48272f.onSubscribe(this);
            for (int i10 = 0; i10 < length && this.f48274h.get() == 0; i10++) {
                observableSourceArr[i10].subscribe(ambInnerObserverArr[i10]);
            }
        }

        public boolean b(int i8) {
            int i9 = this.f48274h.get();
            int i10 = 0;
            if (i9 == 0) {
                if (!this.f48274h.compareAndSet(0, i8)) {
                    return false;
                }
                AmbInnerObserver<T>[] ambInnerObserverArr = this.f48273g;
                int length = ambInnerObserverArr.length;
                while (i10 < length) {
                    int i11 = i10 + 1;
                    if (i11 != i8) {
                        ambInnerObserverArr[i10].a();
                    }
                    i10 = i11;
                }
                return true;
            } else if (i9 == i8) {
                return true;
            } else {
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f48274h.get() != -1) {
                this.f48274h.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.f48273g) {
                    ambInnerObserver.a();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f48274h.get() == -1) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final AmbCoordinator<T> f48275f;

        /* renamed from: g  reason: collision with root package name */
        final int f48276g;

        /* renamed from: h  reason: collision with root package name */
        final Observer<? super T> f48277h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48278i;

        AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i8, Observer<? super T> observer) {
            this.f48275f = ambCoordinator;
            this.f48276g = i8;
            this.f48277h = observer;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48278i) {
                this.f48277h.onComplete();
            } else if (this.f48275f.b(this.f48276g)) {
                this.f48278i = true;
                this.f48277h.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48278i) {
                this.f48277h.onError(th);
            } else if (this.f48275f.b(this.f48276g)) {
                this.f48278i = true;
                this.f48277h.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48278i) {
                this.f48277h.onNext(t7);
            } else if (this.f48275f.b(this.f48276g)) {
                this.f48278i = true;
                this.f48277h.onNext(t7);
            } else {
                get().dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.f48270f = observableSourceArr;
        this.f48271g = iterable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.f48270f;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<? extends T> observableSource : this.f48271g) {
                    if (observableSource == null) {
                        EmptyDisposable.h(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (length == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i8 = length + 1;
                    observableSourceArr[length] = observableSource;
                    length = i8;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.e(observer);
        } else if (length == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            new AmbCoordinator(observer, length).a(observableSourceArr);
        }
    }
}
