package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableZip<T, R> extends Observable<R> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T>[] f49499f;

    /* renamed from: g  reason: collision with root package name */
    final Iterable<? extends ObservableSource<? extends T>> f49500g;

    /* renamed from: h  reason: collision with root package name */
    final Function<? super Object[], ? extends R> f49501h;

    /* renamed from: i  reason: collision with root package name */
    final int f49502i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f49503j;

    /* loaded from: classes5.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f49504f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Object[], ? extends R> f49505g;

        /* renamed from: h  reason: collision with root package name */
        final ZipObserver<T, R>[] f49506h;

        /* renamed from: i  reason: collision with root package name */
        final T[] f49507i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f49508j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f49509k;

        ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i8, boolean z7) {
            this.f49504f = observer;
            this.f49505g = function;
            this.f49506h = new ZipObserver[i8];
            this.f49507i = (T[]) new Object[i8];
            this.f49508j = z7;
        }

        void a() {
            d();
            b();
        }

        void b() {
            for (ZipObserver<T, R> zipObserver : this.f49506h) {
                zipObserver.a();
            }
        }

        boolean c(boolean z7, boolean z8, Observer<? super R> observer, boolean z9, ZipObserver<?, ?> zipObserver) {
            if (this.f49509k) {
                a();
                return true;
            } else if (z7) {
                if (z9) {
                    if (z8) {
                        Throwable th = zipObserver.f49513i;
                        this.f49509k = true;
                        a();
                        if (th != null) {
                            observer.onError(th);
                        } else {
                            observer.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = zipObserver.f49513i;
                if (th2 != null) {
                    this.f49509k = true;
                    a();
                    observer.onError(th2);
                    return true;
                } else if (z8) {
                    this.f49509k = true;
                    a();
                    observer.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void d() {
            for (ZipObserver<T, R> zipObserver : this.f49506h) {
                zipObserver.f49511g.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49509k) {
                this.f49509k = true;
                b();
                if (getAndIncrement() == 0) {
                    d();
                }
            }
        }

        public void e() {
            Throwable th;
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            ZipObserver<T, R>[] zipObserverArr = this.f49506h;
            Observer<? super R> observer = this.f49504f;
            T[] tArr = this.f49507i;
            boolean z8 = this.f49508j;
            int i8 = 1;
            while (true) {
                int i9 = 0;
                int i10 = 0;
                for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                    if (tArr[i10] == null) {
                        boolean z9 = zipObserver.f49512h;
                        T poll = zipObserver.f49511g.poll();
                        if (poll == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (c(z9, z7, observer, z8, zipObserver)) {
                            return;
                        }
                        if (!z7) {
                            tArr[i10] = poll;
                        } else {
                            i9++;
                        }
                    } else if (zipObserver.f49512h && !z8 && (th = zipObserver.f49513i) != null) {
                        this.f49509k = true;
                        a();
                        observer.onError(th);
                        return;
                    }
                    i10++;
                }
                if (i9 != 0) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.onNext((Object) ObjectHelper.e(this.f49505g.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        a();
                        observer.onError(th2);
                        return;
                    }
                }
            }
        }

        public void f(ObservableSource<? extends T>[] observableSourceArr, int i8) {
            ZipObserver<T, R>[] zipObserverArr = this.f49506h;
            int length = zipObserverArr.length;
            for (int i9 = 0; i9 < length; i9++) {
                zipObserverArr[i9] = new ZipObserver<>(this, i8);
            }
            lazySet(0);
            this.f49504f.onSubscribe(this);
            for (int i10 = 0; i10 < length && !this.f49509k; i10++) {
                observableSourceArr[i10].subscribe(zipObserverArr[i10]);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49509k;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ZipObserver<T, R> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final ZipCoordinator<T, R> f49510f;

        /* renamed from: g  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f49511g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f49512h;

        /* renamed from: i  reason: collision with root package name */
        Throwable f49513i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<Disposable> f49514j = new AtomicReference<>();

        ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i8) {
            this.f49510f = zipCoordinator;
            this.f49511g = new SpscLinkedArrayQueue<>(i8);
        }

        public void a() {
            DisposableHelper.a(this.f49514j);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49512h = true;
            this.f49510f.e();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49513i = th;
            this.f49512h = true;
            this.f49510f.e();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49511g.offer(t7);
            this.f49510f.e();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this.f49514j, disposable);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i8, boolean z7) {
        this.f49499f = observableSourceArr;
        this.f49500g = iterable;
        this.f49501h = function;
        this.f49502i = i8;
        this.f49503j = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.f49499f;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            length = 0;
            for (ObservableSource<? extends T> observableSource : this.f49500g) {
                if (length == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.e(observer);
        } else {
            new ZipCoordinator(observer, this.f49501h, length, this.f49503j).f(observableSourceArr, this.f49502i);
        }
    }
}
