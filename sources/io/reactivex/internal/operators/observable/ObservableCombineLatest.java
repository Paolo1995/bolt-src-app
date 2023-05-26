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
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableCombineLatest<T, R> extends Observable<R> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T>[] f48411f;

    /* renamed from: g  reason: collision with root package name */
    final Iterable<? extends ObservableSource<? extends T>> f48412g;

    /* renamed from: h  reason: collision with root package name */
    final Function<? super Object[], ? extends R> f48413h;

    /* renamed from: i  reason: collision with root package name */
    final int f48414i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f48415j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final LatestCoordinator<T, R> f48416f;

        /* renamed from: g  reason: collision with root package name */
        final int f48417g;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i8) {
            this.f48416f = latestCoordinator;
            this.f48417g = i8;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48416f.d(this.f48417g);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48416f.e(this.f48417g, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48416f.f(this.f48417g, t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.j(this, disposable);
        }
    }

    /* loaded from: classes5.dex */
    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48418f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super Object[], ? extends R> f48419g;

        /* renamed from: h  reason: collision with root package name */
        final CombinerObserver<T, R>[] f48420h;

        /* renamed from: i  reason: collision with root package name */
        Object[] f48421i;

        /* renamed from: j  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object[]> f48422j;

        /* renamed from: k  reason: collision with root package name */
        final boolean f48423k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f48424l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48425m;

        /* renamed from: n  reason: collision with root package name */
        final AtomicThrowable f48426n = new AtomicThrowable();

        /* renamed from: o  reason: collision with root package name */
        int f48427o;

        /* renamed from: p  reason: collision with root package name */
        int f48428p;

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i8, int i9, boolean z7) {
            this.f48418f = observer;
            this.f48419g = function;
            this.f48423k = z7;
            this.f48421i = new Object[i8];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i8];
            for (int i10 = 0; i10 < i8; i10++) {
                combinerObserverArr[i10] = new CombinerObserver<>(this, i10);
            }
            this.f48420h = combinerObserverArr;
            this.f48422j = new SpscLinkedArrayQueue<>(i9);
        }

        void a() {
            for (CombinerObserver<T, R> combinerObserver : this.f48420h) {
                combinerObserver.a();
            }
        }

        void b(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.f48421i = null;
            }
            spscLinkedArrayQueue.clear();
        }

        void c() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object[]> spscLinkedArrayQueue = this.f48422j;
            Observer<? super R> observer = this.f48418f;
            boolean z8 = this.f48423k;
            int i8 = 1;
            while (!this.f48424l) {
                if (!z8 && this.f48426n.get() != null) {
                    a();
                    b(spscLinkedArrayQueue);
                    observer.onError(this.f48426n.b());
                    return;
                }
                boolean z9 = this.f48425m;
                Object[] poll = spscLinkedArrayQueue.poll();
                if (poll == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z9 && z7) {
                    b(spscLinkedArrayQueue);
                    Throwable b8 = this.f48426n.b();
                    if (b8 == null) {
                        observer.onComplete();
                        return;
                    } else {
                        observer.onError(b8);
                        return;
                    }
                } else if (z7) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.onNext((Object) ObjectHelper.e(this.f48419g.apply(poll), "The combiner returned a null value"));
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f48426n.a(th);
                        a();
                        b(spscLinkedArrayQueue);
                        observer.onError(this.f48426n.b());
                        return;
                    }
                }
            }
            b(spscLinkedArrayQueue);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
            if (r2 == r0.length) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void d(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.f48421i     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = 1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.f48428p     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.f48428p = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.f48425m = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.a()
            L21:
                r3.c()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.d(int):void");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f48424l) {
                this.f48424l = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.f48422j);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
            if (r1 == r4.length) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void e(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.f48426n
                boolean r0 = r0.a(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.f48423k
                r0 = 1
                if (r4 == 0) goto L2d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.f48421i     // Catch: java.lang.Throwable -> L2a
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L2a
                if (r3 != 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.f48428p     // Catch: java.lang.Throwable -> L2a
                int r1 = r1 + r0
                r2.f48428p = r1     // Catch: java.lang.Throwable -> L2a
                int r4 = r4.length     // Catch: java.lang.Throwable -> L2a
                if (r1 != r4) goto L27
            L25:
                r2.f48425m = r0     // Catch: java.lang.Throwable -> L2a
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                r0 = r3
                goto L2d
            L2a:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                throw r3
            L2d:
                if (r0 == 0) goto L32
                r2.a()
            L32:
                r2.c()
                goto L39
            L36:
                io.reactivex.plugins.RxJavaPlugins.s(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.e(int, java.lang.Throwable):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        void f(int i8, T t7) {
            boolean z7;
            synchronized (this) {
                Object[] objArr = this.f48421i;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i8];
                int i9 = this.f48427o;
                if (obj == null) {
                    i9++;
                    this.f48427o = i9;
                }
                objArr[i8] = t7;
                if (i9 == objArr.length) {
                    this.f48422j.offer(objArr.clone());
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    c();
                }
            }
        }

        public void g(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.f48420h;
            int length = combinerObserverArr.length;
            this.f48418f.onSubscribe(this);
            for (int i8 = 0; i8 < length && !this.f48425m && !this.f48424l; i8++) {
                observableSourceArr[i8].subscribe(combinerObserverArr[i8]);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48424l;
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i8, boolean z7) {
        this.f48411f = observableSourceArr;
        this.f48412g = iterable;
        this.f48413h = function;
        this.f48414i = i8;
        this.f48415j = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.f48411f;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            length = 0;
            for (ObservableSource<? extends T> observableSource : this.f48412g) {
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
        int i8 = length;
        if (i8 == 0) {
            EmptyDisposable.e(observer);
        } else {
            new LatestCoordinator(observer, this.f48413h, i8, this.f48414i, this.f48415j).g(observableSourceArr);
        }
    }
}
