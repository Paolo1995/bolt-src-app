package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableSequenceEqual<T> extends Observable<Boolean> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T> f49106f;

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<? extends T> f49107g;

    /* renamed from: h  reason: collision with root package name */
    final BiPredicate<? super T, ? super T> f49108h;

    /* renamed from: i  reason: collision with root package name */
    final int f49109i;

    /* loaded from: classes5.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Boolean> f49110f;

        /* renamed from: g  reason: collision with root package name */
        final BiPredicate<? super T, ? super T> f49111g;

        /* renamed from: h  reason: collision with root package name */
        final ArrayCompositeDisposable f49112h;

        /* renamed from: i  reason: collision with root package name */
        final ObservableSource<? extends T> f49113i;

        /* renamed from: j  reason: collision with root package name */
        final ObservableSource<? extends T> f49114j;

        /* renamed from: k  reason: collision with root package name */
        final EqualObserver<T>[] f49115k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f49116l;

        /* renamed from: m  reason: collision with root package name */
        T f49117m;

        /* renamed from: n  reason: collision with root package name */
        T f49118n;

        EqualCoordinator(Observer<? super Boolean> observer, int i8, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f49110f = observer;
            this.f49113i = observableSource;
            this.f49114j = observableSource2;
            this.f49111g = biPredicate;
            this.f49115k = r3;
            EqualObserver<T>[] equalObserverArr = {new EqualObserver<>(this, 0, i8), new EqualObserver<>(this, 1, i8)};
            this.f49112h = new ArrayCompositeDisposable(2);
        }

        void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f49116l = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        void b() {
            boolean z7;
            boolean z8;
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            EqualObserver<T>[] equalObserverArr = this.f49115k;
            EqualObserver<T> equalObserver = equalObserverArr[0];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.f49120g;
            EqualObserver<T> equalObserver2 = equalObserverArr[1];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.f49120g;
            int i8 = 1;
            while (!this.f49116l) {
                boolean z9 = equalObserver.f49122i;
                if (z9 && (th2 = equalObserver.f49123j) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f49110f.onError(th2);
                    return;
                }
                boolean z10 = equalObserver2.f49122i;
                if (z10 && (th = equalObserver2.f49123j) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f49110f.onError(th);
                    return;
                }
                if (this.f49117m == null) {
                    this.f49117m = spscLinkedArrayQueue.poll();
                }
                if (this.f49117m == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (this.f49118n == null) {
                    this.f49118n = spscLinkedArrayQueue2.poll();
                }
                T t7 = this.f49118n;
                if (t7 == null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z9 && z10 && z7 && z8) {
                    this.f49110f.onNext(Boolean.TRUE);
                    this.f49110f.onComplete();
                    return;
                } else if (z9 && z10 && z7 != z8) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f49110f.onNext(Boolean.FALSE);
                    this.f49110f.onComplete();
                    return;
                } else {
                    if (!z7 && !z8) {
                        try {
                            if (!this.f49111g.test((T) this.f49117m, t7)) {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f49110f.onNext(Boolean.FALSE);
                                this.f49110f.onComplete();
                                return;
                            }
                            this.f49117m = null;
                            this.f49118n = null;
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f49110f.onError(th3);
                            return;
                        }
                    }
                    if (z7 || z8) {
                        i8 = addAndGet(-i8);
                        if (i8 == 0) {
                            return;
                        }
                    }
                }
            }
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        boolean c(Disposable disposable, int i8) {
            return this.f49112h.a(i8, disposable);
        }

        void d() {
            EqualObserver<T>[] equalObserverArr = this.f49115k;
            this.f49113i.subscribe(equalObserverArr[0]);
            this.f49114j.subscribe(equalObserverArr[1]);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49116l) {
                this.f49116l = true;
                this.f49112h.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.f49115k;
                    equalObserverArr[0].f49120g.clear();
                    equalObserverArr[1].f49120g.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49116l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class EqualObserver<T> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final EqualCoordinator<T> f49119f;

        /* renamed from: g  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f49120g;

        /* renamed from: h  reason: collision with root package name */
        final int f49121h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f49122i;

        /* renamed from: j  reason: collision with root package name */
        Throwable f49123j;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i8, int i9) {
            this.f49119f = equalCoordinator;
            this.f49121h = i8;
            this.f49120g = new SpscLinkedArrayQueue<>(i9);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49122i = true;
            this.f49119f.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49123j = th;
            this.f49122i = true;
            this.f49119f.b();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49120g.offer(t7);
            this.f49119f.b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f49119f.c(disposable, this.f49121h);
        }
    }

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i8) {
        this.f49106f = observableSource;
        this.f49107g = observableSource2;
        this.f49108h = biPredicate;
        this.f49109i = i8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Boolean> observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.f49109i, this.f49106f, this.f49107g, this.f49108h);
        observer.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
