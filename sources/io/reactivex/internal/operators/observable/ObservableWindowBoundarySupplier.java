package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: g  reason: collision with root package name */
    final Callable<? extends ObservableSource<B>> f49417g;

    /* renamed from: h  reason: collision with root package name */
    final int f49418h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: g  reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B> f49419g;

        /* renamed from: h  reason: collision with root package name */
        boolean f49420h;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f49419g = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49420h) {
                return;
            }
            this.f49420h = true;
            this.f49419g.c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49420h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49420h = true;
            this.f49419g.d(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b8) {
            if (this.f49420h) {
                return;
            }
            this.f49420h = true;
            dispose();
            this.f49419g.e(this);
        }
    }

    /* loaded from: classes5.dex */
    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: q  reason: collision with root package name */
        static final WindowBoundaryInnerObserver<Object, Object> f49421q = new WindowBoundaryInnerObserver<>(null);

        /* renamed from: r  reason: collision with root package name */
        static final Object f49422r = new Object();

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Observable<T>> f49423f;

        /* renamed from: g  reason: collision with root package name */
        final int f49424g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<WindowBoundaryInnerObserver<T, B>> f49425h = new AtomicReference<>();

        /* renamed from: i  reason: collision with root package name */
        final AtomicInteger f49426i = new AtomicInteger(1);

        /* renamed from: j  reason: collision with root package name */
        final MpscLinkedQueue<Object> f49427j = new MpscLinkedQueue<>();

        /* renamed from: k  reason: collision with root package name */
        final AtomicThrowable f49428k = new AtomicThrowable();

        /* renamed from: l  reason: collision with root package name */
        final AtomicBoolean f49429l = new AtomicBoolean();

        /* renamed from: m  reason: collision with root package name */
        final Callable<? extends ObservableSource<B>> f49430m;

        /* renamed from: n  reason: collision with root package name */
        Disposable f49431n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f49432o;

        /* renamed from: p  reason: collision with root package name */
        UnicastSubject<T> f49433p;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i8, Callable<? extends ObservableSource<B>> callable) {
            this.f49423f = observer;
            this.f49424g = i8;
            this.f49430m = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            WindowBoundaryInnerObserver<Object, Object> windowBoundaryInnerObserver = f49421q;
            Disposable disposable = (Disposable) this.f49425h.getAndSet(windowBoundaryInnerObserver);
            if (disposable != null && disposable != windowBoundaryInnerObserver) {
                disposable.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.f49423f;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.f49427j;
            AtomicThrowable atomicThrowable = this.f49428k;
            int i8 = 1;
            while (this.f49426i.get() != 0) {
                UnicastSubject<T> unicastSubject = this.f49433p;
                boolean z8 = this.f49432o;
                if (z8 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable b8 = atomicThrowable.b();
                    if (unicastSubject != 0) {
                        this.f49433p = null;
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
                            this.f49433p = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.f49433p = null;
                        unicastSubject.onError(b9);
                    }
                    observer.onError(b9);
                    return;
                } else if (z7) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else if (poll != f49422r) {
                    unicastSubject.onNext(poll);
                } else {
                    if (unicastSubject != 0) {
                        this.f49433p = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.f49429l.get()) {
                        UnicastSubject<T> f8 = UnicastSubject.f(this.f49424g, this);
                        this.f49433p = f8;
                        this.f49426i.getAndIncrement();
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49430m.call(), "The other Callable returned a null ObservableSource");
                            WindowBoundaryInnerObserver windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                            if (e.a(this.f49425h, null, windowBoundaryInnerObserver)) {
                                observableSource.subscribe(windowBoundaryInnerObserver);
                                observer.onNext(f8);
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            atomicThrowable.a(th);
                            this.f49432o = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.f49433p = null;
        }

        void c() {
            this.f49431n.dispose();
            this.f49432o = true;
            b();
        }

        void d(Throwable th) {
            this.f49431n.dispose();
            if (this.f49428k.a(th)) {
                this.f49432o = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f49429l.compareAndSet(false, true)) {
                a();
                if (this.f49426i.decrementAndGet() == 0) {
                    this.f49431n.dispose();
                }
            }
        }

        void e(WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver) {
            e.a(this.f49425h, windowBoundaryInnerObserver, null);
            this.f49427j.offer(f49422r);
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49429l.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
            this.f49432o = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            a();
            if (this.f49428k.a(th)) {
                this.f49432o = true;
                b();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49427j.offer(t7);
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49431n, disposable)) {
                this.f49431n = disposable;
                this.f49423f.onSubscribe(this);
                this.f49427j.offer(f49422r);
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f49426i.decrementAndGet() == 0) {
                this.f49431n.dispose();
            }
        }
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i8) {
        super(observableSource);
        this.f49417g = callable;
        this.f49418h = i8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.f48232f.subscribe(new WindowBoundaryMainObserver(observer, this.f49418h, this.f49417g));
    }
}
