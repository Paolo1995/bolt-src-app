package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes5.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<?>[] f49485g;

    /* renamed from: h  reason: collision with root package name */
    final Iterable<? extends ObservableSource<?>> f49486h;

    /* renamed from: i  reason: collision with root package name */
    final Function<? super Object[], R> f49487i;

    /* loaded from: classes5.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t7) throws Exception {
            return (R) ObjectHelper.e(ObservableWithLatestFromMany.this.f49487i.apply(new Object[]{t7}), "The combiner returned a null value");
        }
    }

    /* loaded from: classes5.dex */
    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f49489f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Object[], R> f49490g;

        /* renamed from: h  reason: collision with root package name */
        final WithLatestInnerObserver[] f49491h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicReferenceArray<Object> f49492i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<Disposable> f49493j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicThrowable f49494k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f49495l;

        WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i8) {
            this.f49489f = observer;
            this.f49490g = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                withLatestInnerObserverArr[i9] = new WithLatestInnerObserver(this, i9);
            }
            this.f49491h = withLatestInnerObserverArr;
            this.f49492i = new AtomicReferenceArray<>(i8);
            this.f49493j = new AtomicReference<>();
            this.f49494k = new AtomicThrowable();
        }

        void a(int i8) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f49491h;
            for (int i9 = 0; i9 < withLatestInnerObserverArr.length; i9++) {
                if (i9 != i8) {
                    withLatestInnerObserverArr[i9].a();
                }
            }
        }

        void b(int i8, boolean z7) {
            if (!z7) {
                this.f49495l = true;
                a(i8);
                HalfSerializer.a(this.f49489f, this, this.f49494k);
            }
        }

        void c(int i8, Throwable th) {
            this.f49495l = true;
            DisposableHelper.a(this.f49493j);
            a(i8);
            HalfSerializer.c(this.f49489f, th, this, this.f49494k);
        }

        void d(int i8, Object obj) {
            this.f49492i.set(i8, obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f49493j);
            for (WithLatestInnerObserver withLatestInnerObserver : this.f49491h) {
                withLatestInnerObserver.a();
            }
        }

        void e(ObservableSource<?>[] observableSourceArr, int i8) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f49491h;
            AtomicReference<Disposable> atomicReference = this.f49493j;
            for (int i9 = 0; i9 < i8 && !DisposableHelper.c(atomicReference.get()) && !this.f49495l; i9++) {
                observableSourceArr[i9].subscribe(withLatestInnerObserverArr[i9]);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.c(this.f49493j.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f49495l) {
                this.f49495l = true;
                a(-1);
                HalfSerializer.a(this.f49489f, this, this.f49494k);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49495l) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49495l = true;
            a(-1);
            HalfSerializer.c(this.f49489f, th, this, this.f49494k);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49495l) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.f49492i;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i8 = 0;
            objArr[0] = t7;
            while (i8 < length) {
                Object obj = atomicReferenceArray.get(i8);
                if (obj == null) {
                    return;
                }
                i8++;
                objArr[i8] = obj;
            }
            try {
                HalfSerializer.e(this.f49489f, ObjectHelper.e(this.f49490g.apply(objArr), "combiner returned a null value"), this, this.f49494k);
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49493j, disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {

        /* renamed from: f  reason: collision with root package name */
        final WithLatestFromObserver<?, ?> f49496f;

        /* renamed from: g  reason: collision with root package name */
        final int f49497g;

        /* renamed from: h  reason: collision with root package name */
        boolean f49498h;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i8) {
            this.f49496f = withLatestFromObserver;
            this.f49497g = i8;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49496f.b(this.f49497g, this.f49498h);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49496f.c(this.f49497g, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (!this.f49498h) {
                this.f49498h = true;
            }
            this.f49496f.d(this.f49497g, obj);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        super(observableSource);
        this.f49485g = observableSourceArr;
        this.f49486h = null;
        this.f49487i = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<?>[] observableSourceArr = this.f49485g;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<?> observableSource : this.f49486h) {
                    if (length == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (length >> 1) + length);
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
            new ObservableMap(this.f48232f, new SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.f49487i, length);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.e(observableSourceArr, length);
        this.f48232f.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(ObservableSource<T> observableSource, Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        super(observableSource);
        this.f49485g = null;
        this.f49486h = iterable;
        this.f49487i = function;
    }
}
