package io.reactivex.subjects;

import androidx.camera.view.e;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class UnicastSubject<T> extends Subject<T> {

    /* renamed from: f  reason: collision with root package name */
    final SpscLinkedArrayQueue<T> f49939f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<Observer<? super T>> f49940g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicReference<Runnable> f49941h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f49942i;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f49943j;

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f49944k;

    /* renamed from: l  reason: collision with root package name */
    Throwable f49945l;

    /* renamed from: m  reason: collision with root package name */
    final AtomicBoolean f49946m;

    /* renamed from: n  reason: collision with root package name */
    final BasicIntQueueDisposable<T> f49947n;

    /* renamed from: o  reason: collision with root package name */
    boolean f49948o;

    /* loaded from: classes5.dex */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 2) != 0) {
                UnicastSubject.this.f49948o = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.f49939f.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!UnicastSubject.this.f49943j) {
                UnicastSubject.this.f49943j = true;
                UnicastSubject.this.g();
                UnicastSubject.this.f49940g.lazySet(null);
                if (UnicastSubject.this.f49947n.getAndIncrement() == 0) {
                    UnicastSubject.this.f49940g.lazySet(null);
                    UnicastSubject unicastSubject = UnicastSubject.this;
                    if (!unicastSubject.f49948o) {
                        unicastSubject.f49939f.clear();
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.f49943j;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.f49939f.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return UnicastSubject.this.f49939f.poll();
        }
    }

    UnicastSubject(int i8, boolean z7) {
        this.f49939f = new SpscLinkedArrayQueue<>(ObjectHelper.f(i8, "capacityHint"));
        this.f49941h = new AtomicReference<>();
        this.f49942i = z7;
        this.f49940g = new AtomicReference<>();
        this.f49946m = new AtomicBoolean();
        this.f49947n = new UnicastQueueDisposable();
    }

    public static <T> UnicastSubject<T> d() {
        return new UnicastSubject<>(Observable.bufferSize(), true);
    }

    public static <T> UnicastSubject<T> e(int i8) {
        return new UnicastSubject<>(i8, true);
    }

    public static <T> UnicastSubject<T> f(int i8, Runnable runnable) {
        return new UnicastSubject<>(i8, runnable, true);
    }

    void g() {
        Runnable runnable = this.f49941h.get();
        if (runnable != null && e.a(this.f49941h, runnable, null)) {
            runnable.run();
        }
    }

    void h() {
        if (this.f49947n.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.f49940g.get();
        int i8 = 1;
        while (observer == null) {
            i8 = this.f49947n.addAndGet(-i8);
            if (i8 == 0) {
                return;
            }
            observer = this.f49940g.get();
        }
        if (this.f49948o) {
            i(observer);
        } else {
            j(observer);
        }
    }

    void i(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f49939f;
        int i8 = 1;
        boolean z7 = !this.f49942i;
        while (!this.f49943j) {
            boolean z8 = this.f49944k;
            if (z7 && z8 && l(spscLinkedArrayQueue, observer)) {
                return;
            }
            observer.onNext(null);
            if (z8) {
                k(observer);
                return;
            }
            i8 = this.f49947n.addAndGet(-i8);
            if (i8 == 0) {
                return;
            }
        }
        this.f49940g.lazySet(null);
    }

    void j(Observer<? super T> observer) {
        boolean z7;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f49939f;
        boolean z8 = !this.f49942i;
        boolean z9 = true;
        int i8 = 1;
        while (!this.f49943j) {
            boolean z10 = this.f49944k;
            Object obj = (T) this.f49939f.poll();
            if (obj == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z10) {
                if (z8 && z9) {
                    if (l(spscLinkedArrayQueue, observer)) {
                        return;
                    }
                    z9 = false;
                }
                if (z7) {
                    k(observer);
                    return;
                }
            }
            if (z7) {
                i8 = this.f49947n.addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
            } else {
                observer.onNext(obj);
            }
        }
        this.f49940g.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    void k(Observer<? super T> observer) {
        this.f49940g.lazySet(null);
        Throwable th = this.f49945l;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    boolean l(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.f49945l;
        if (th != null) {
            this.f49940g.lazySet(null);
            simpleQueue.clear();
            observer.onError(th);
            return true;
        }
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.f49944k && !this.f49943j) {
            this.f49944k = true;
            g();
            h();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f49944k && !this.f49943j) {
            this.f49945l = th;
            this.f49944k = true;
            g();
            h();
            return;
        }
        RxJavaPlugins.s(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        ObjectHelper.e(t7, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f49944k && !this.f49943j) {
            this.f49939f.offer(t7);
            h();
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f49944k || this.f49943j) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        if (!this.f49946m.get() && this.f49946m.compareAndSet(false, true)) {
            observer.onSubscribe(this.f49947n);
            this.f49940g.lazySet(observer);
            if (this.f49943j) {
                this.f49940g.lazySet(null);
                return;
            } else {
                h();
                return;
            }
        }
        EmptyDisposable.h(new IllegalStateException("Only a single observer allowed."), observer);
    }

    UnicastSubject(int i8, Runnable runnable, boolean z7) {
        this.f49939f = new SpscLinkedArrayQueue<>(ObjectHelper.f(i8, "capacityHint"));
        this.f49941h = new AtomicReference<>(ObjectHelper.e(runnable, "onTerminate"));
        this.f49942i = z7;
        this.f49940g = new AtomicReference<>();
        this.f49946m = new AtomicBoolean();
        this.f49947n = new UnicastQueueDisposable();
    }
}
