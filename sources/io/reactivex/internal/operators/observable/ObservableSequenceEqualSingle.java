package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: f  reason: collision with root package name */
    final ObservableSource<? extends T> f49124f;

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<? extends T> f49125g;

    /* renamed from: h  reason: collision with root package name */
    final BiPredicate<? super T, ? super T> f49126h;

    /* renamed from: i  reason: collision with root package name */
    final int f49127i;

    /* loaded from: classes5.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final SingleObserver<? super Boolean> f49128f;

        /* renamed from: g  reason: collision with root package name */
        final BiPredicate<? super T, ? super T> f49129g;

        /* renamed from: h  reason: collision with root package name */
        final ArrayCompositeDisposable f49130h;

        /* renamed from: i  reason: collision with root package name */
        final ObservableSource<? extends T> f49131i;

        /* renamed from: j  reason: collision with root package name */
        final ObservableSource<? extends T> f49132j;

        /* renamed from: k  reason: collision with root package name */
        final EqualObserver<T>[] f49133k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f49134l;

        /* renamed from: m  reason: collision with root package name */
        T f49135m;

        /* renamed from: n  reason: collision with root package name */
        T f49136n;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i8, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f49128f = singleObserver;
            this.f49131i = observableSource;
            this.f49132j = observableSource2;
            this.f49129g = biPredicate;
            this.f49133k = r3;
            EqualObserver<T>[] equalObserverArr = {new EqualObserver<>(this, 0, i8), new EqualObserver<>(this, 1, i8)};
            this.f49130h = new ArrayCompositeDisposable(2);
        }

        void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f49134l = true;
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
            EqualObserver<T>[] equalObserverArr = this.f49133k;
            EqualObserver<T> equalObserver = equalObserverArr[0];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.f49138g;
            EqualObserver<T> equalObserver2 = equalObserverArr[1];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.f49138g;
            int i8 = 1;
            while (!this.f49134l) {
                boolean z9 = equalObserver.f49140i;
                if (z9 && (th2 = equalObserver.f49141j) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f49128f.onError(th2);
                    return;
                }
                boolean z10 = equalObserver2.f49140i;
                if (z10 && (th = equalObserver2.f49141j) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f49128f.onError(th);
                    return;
                }
                if (this.f49135m == null) {
                    this.f49135m = spscLinkedArrayQueue.poll();
                }
                if (this.f49135m == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (this.f49136n == null) {
                    this.f49136n = spscLinkedArrayQueue2.poll();
                }
                T t7 = this.f49136n;
                if (t7 == null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z9 && z10 && z7 && z8) {
                    this.f49128f.onSuccess(Boolean.TRUE);
                    return;
                } else if (z9 && z10 && z7 != z8) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f49128f.onSuccess(Boolean.FALSE);
                    return;
                } else {
                    if (!z7 && !z8) {
                        try {
                            if (!this.f49129g.test((T) this.f49135m, t7)) {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f49128f.onSuccess(Boolean.FALSE);
                                return;
                            }
                            this.f49135m = null;
                            this.f49136n = null;
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f49128f.onError(th3);
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
            return this.f49130h.a(i8, disposable);
        }

        void d() {
            EqualObserver<T>[] equalObserverArr = this.f49133k;
            this.f49131i.subscribe(equalObserverArr[0]);
            this.f49132j.subscribe(equalObserverArr[1]);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49134l) {
                this.f49134l = true;
                this.f49130h.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.f49133k;
                    equalObserverArr[0].f49138g.clear();
                    equalObserverArr[1].f49138g.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49134l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class EqualObserver<T> implements Observer<T> {

        /* renamed from: f  reason: collision with root package name */
        final EqualCoordinator<T> f49137f;

        /* renamed from: g  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f49138g;

        /* renamed from: h  reason: collision with root package name */
        final int f49139h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f49140i;

        /* renamed from: j  reason: collision with root package name */
        Throwable f49141j;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i8, int i9) {
            this.f49137f = equalCoordinator;
            this.f49139h = i8;
            this.f49138g = new SpscLinkedArrayQueue<>(i9);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49140i = true;
            this.f49137f.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49141j = th;
            this.f49140i = true;
            this.f49137f.b();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49138g.offer(t7);
            this.f49137f.b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f49137f.c(disposable, this.f49139h);
        }
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i8) {
        this.f49124f = observableSource;
        this.f49125g = observableSource2;
        this.f49126h = biPredicate;
        this.f49127i = i8;
    }

    @Override // io.reactivex.Single
    public void J(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f49127i, this.f49124f, this.f49125g, this.f49126h);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Boolean> b() {
        return RxJavaPlugins.n(new ObservableSequenceEqual(this.f49124f, this.f49125g, this.f49126h, this.f49127i));
    }
}
