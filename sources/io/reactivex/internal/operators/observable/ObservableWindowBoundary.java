package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<B> f49384g;

    /* renamed from: h  reason: collision with root package name */
    final int f49385h;

    /* loaded from: classes5.dex */
    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: g  reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B> f49386g;

        /* renamed from: h  reason: collision with root package name */
        boolean f49387h;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f49386g = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49387h) {
                return;
            }
            this.f49387h = true;
            this.f49386g.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49387h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49387h = true;
            this.f49386g.c(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b8) {
            if (this.f49387h) {
                return;
            }
            this.f49386g.d();
        }
    }

    /* loaded from: classes5.dex */
    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: p  reason: collision with root package name */
        static final Object f49388p = new Object();

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Observable<T>> f49389f;

        /* renamed from: g  reason: collision with root package name */
        final int f49390g;

        /* renamed from: h  reason: collision with root package name */
        final WindowBoundaryInnerObserver<T, B> f49391h = new WindowBoundaryInnerObserver<>(this);

        /* renamed from: i  reason: collision with root package name */
        final AtomicReference<Disposable> f49392i = new AtomicReference<>();

        /* renamed from: j  reason: collision with root package name */
        final AtomicInteger f49393j = new AtomicInteger(1);

        /* renamed from: k  reason: collision with root package name */
        final MpscLinkedQueue<Object> f49394k = new MpscLinkedQueue<>();

        /* renamed from: l  reason: collision with root package name */
        final AtomicThrowable f49395l = new AtomicThrowable();

        /* renamed from: m  reason: collision with root package name */
        final AtomicBoolean f49396m = new AtomicBoolean();

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f49397n;

        /* renamed from: o  reason: collision with root package name */
        UnicastSubject<T> f49398o;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i8) {
            this.f49389f = observer;
            this.f49390g = i8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.f49389f;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.f49394k;
            AtomicThrowable atomicThrowable = this.f49395l;
            int i8 = 1;
            while (this.f49393j.get() != 0) {
                UnicastSubject<T> unicastSubject = this.f49398o;
                boolean z8 = this.f49397n;
                if (z8 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable b8 = atomicThrowable.b();
                    if (unicastSubject != 0) {
                        this.f49398o = null;
                        unicastSubject.onError(b8);
                    }
                    observer.onError(b8);
                    return;
                }
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z8 && z7) {
                    Throwable b9 = atomicThrowable.b();
                    if (b9 == null) {
                        if (unicastSubject != 0) {
                            this.f49398o = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.f49398o = null;
                        unicastSubject.onError(b9);
                    }
                    observer.onError(b9);
                    return;
                } else if (z7) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else if (poll != f49388p) {
                    unicastSubject.onNext(poll);
                } else {
                    if (unicastSubject != 0) {
                        this.f49398o = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.f49396m.get()) {
                        UnicastSubject<T> f8 = UnicastSubject.f(this.f49390g, this);
                        this.f49398o = f8;
                        this.f49393j.getAndIncrement();
                        observer.onNext(f8);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.f49398o = null;
        }

        void b() {
            DisposableHelper.a(this.f49392i);
            this.f49397n = true;
            a();
        }

        void c(Throwable th) {
            DisposableHelper.a(this.f49392i);
            if (this.f49395l.a(th)) {
                this.f49397n = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        void d() {
            this.f49394k.offer(f49388p);
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f49396m.compareAndSet(false, true)) {
                this.f49391h.dispose();
                if (this.f49393j.decrementAndGet() == 0) {
                    DisposableHelper.a(this.f49392i);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49396m.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49391h.dispose();
            this.f49397n = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49391h.dispose();
            if (this.f49395l.a(th)) {
                this.f49397n = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49394k.offer(t7);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.j(this.f49392i, disposable)) {
                d();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f49393j.decrementAndGet() == 0) {
                DisposableHelper.a(this.f49392i);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i8) {
        super(observableSource);
        this.f49384g = observableSource2;
        this.f49385h = i8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.f49385h);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.f49384g.subscribe(windowBoundaryMainObserver.f49391h);
        this.f48232f.subscribe(windowBoundaryMainObserver);
    }
}
