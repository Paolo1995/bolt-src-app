package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: g  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends R>> f48458g;

    /* renamed from: h  reason: collision with root package name */
    final ErrorMode f48459h;

    /* renamed from: i  reason: collision with root package name */
    final int f48460i;

    /* renamed from: j  reason: collision with root package name */
    final int f48461j;

    /* loaded from: classes5.dex */
    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super R> f48462f;

        /* renamed from: g  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f48463g;

        /* renamed from: h  reason: collision with root package name */
        final int f48464h;

        /* renamed from: i  reason: collision with root package name */
        final int f48465i;

        /* renamed from: j  reason: collision with root package name */
        final ErrorMode f48466j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicThrowable f48467k = new AtomicThrowable();

        /* renamed from: l  reason: collision with root package name */
        final ArrayDeque<InnerQueuedObserver<R>> f48468l = new ArrayDeque<>();

        /* renamed from: m  reason: collision with root package name */
        SimpleQueue<T> f48469m;

        /* renamed from: n  reason: collision with root package name */
        Disposable f48470n;

        /* renamed from: o  reason: collision with root package name */
        volatile boolean f48471o;

        /* renamed from: p  reason: collision with root package name */
        int f48472p;

        /* renamed from: q  reason: collision with root package name */
        volatile boolean f48473q;

        /* renamed from: r  reason: collision with root package name */
        InnerQueuedObserver<R> f48474r;

        /* renamed from: s  reason: collision with root package name */
        int f48475s;

        ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i8, int i9, ErrorMode errorMode) {
            this.f48462f = observer;
            this.f48463g = function;
            this.f48464h = i8;
            this.f48465i = i9;
            this.f48466j = errorMode;
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void a() {
            R poll;
            boolean z7;
            boolean z8;
            if (getAndIncrement() != 0) {
                return;
            }
            SimpleQueue<T> simpleQueue = this.f48469m;
            ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.f48468l;
            Observer<? super R> observer = this.f48462f;
            ErrorMode errorMode = this.f48466j;
            int i8 = 1;
            while (true) {
                int i9 = this.f48475s;
                while (i9 != this.f48464h) {
                    if (this.f48473q) {
                        simpleQueue.clear();
                        e();
                        return;
                    } else if (errorMode == ErrorMode.IMMEDIATE && this.f48467k.get() != null) {
                        simpleQueue.clear();
                        e();
                        observer.onError(this.f48467k.b());
                        return;
                    } else {
                        try {
                            T poll2 = simpleQueue.poll();
                            if (poll2 == null) {
                                break;
                            }
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48463g.apply(poll2), "The mapper returned a null ObservableSource");
                            InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.f48465i);
                            arrayDeque.offer(innerQueuedObserver);
                            observableSource.subscribe(innerQueuedObserver);
                            i9++;
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.f48470n.dispose();
                            simpleQueue.clear();
                            e();
                            this.f48467k.a(th);
                            observer.onError(this.f48467k.b());
                            return;
                        }
                    }
                }
                this.f48475s = i9;
                if (this.f48473q) {
                    simpleQueue.clear();
                    e();
                    return;
                } else if (errorMode == ErrorMode.IMMEDIATE && this.f48467k.get() != null) {
                    simpleQueue.clear();
                    e();
                    observer.onError(this.f48467k.b());
                    return;
                } else {
                    InnerQueuedObserver<R> innerQueuedObserver2 = this.f48474r;
                    if (innerQueuedObserver2 == null) {
                        if (errorMode == ErrorMode.BOUNDARY && this.f48467k.get() != null) {
                            simpleQueue.clear();
                            e();
                            observer.onError(this.f48467k.b());
                            return;
                        }
                        boolean z9 = this.f48471o;
                        InnerQueuedObserver<R> poll3 = arrayDeque.poll();
                        if (poll3 == null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (z9 && z8) {
                            if (this.f48467k.get() != null) {
                                simpleQueue.clear();
                                e();
                                observer.onError(this.f48467k.b());
                                return;
                            }
                            observer.onComplete();
                            return;
                        }
                        if (!z8) {
                            this.f48474r = poll3;
                        }
                        innerQueuedObserver2 = poll3;
                    }
                    if (innerQueuedObserver2 != null) {
                        SimpleQueue<R> b8 = innerQueuedObserver2.b();
                        while (!this.f48473q) {
                            boolean a8 = innerQueuedObserver2.a();
                            if (errorMode == ErrorMode.IMMEDIATE && this.f48467k.get() != null) {
                                simpleQueue.clear();
                                e();
                                observer.onError(this.f48467k.b());
                                return;
                            }
                            try {
                                poll = b8.poll();
                                if (poll == null) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                            } catch (Throwable th2) {
                                Exceptions.b(th2);
                                this.f48467k.a(th2);
                                this.f48474r = null;
                                this.f48475s--;
                            }
                            if (a8 && z7) {
                                this.f48474r = null;
                                this.f48475s--;
                            } else if (!z7) {
                                observer.onNext(poll);
                            }
                        }
                        simpleQueue.clear();
                        e();
                        return;
                    }
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void b(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (this.f48467k.a(th)) {
                if (this.f48466j == ErrorMode.IMMEDIATE) {
                    this.f48470n.dispose();
                }
                innerQueuedObserver.c();
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void c(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.c();
            a();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void d(InnerQueuedObserver<R> innerQueuedObserver, R r7) {
            innerQueuedObserver.b().offer(r7);
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f48473q) {
                return;
            }
            this.f48473q = true;
            this.f48470n.dispose();
            f();
        }

        void e() {
            InnerQueuedObserver<R> innerQueuedObserver = this.f48474r;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> poll = this.f48468l.poll();
                if (poll == null) {
                    return;
                }
                poll.dispose();
            }
        }

        void f() {
            if (getAndIncrement() == 0) {
                do {
                    this.f48469m.clear();
                    e();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48473q;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48471o = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48467k.a(th)) {
                this.f48471o = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48472p == 0) {
                this.f48469m.offer(t7);
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48470n, disposable)) {
                this.f48470n = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a8 = queueDisposable.a(3);
                    if (a8 == 1) {
                        this.f48472p = a8;
                        this.f48469m = queueDisposable;
                        this.f48471o = true;
                        this.f48462f.onSubscribe(this);
                        a();
                        return;
                    } else if (a8 == 2) {
                        this.f48472p = a8;
                        this.f48469m = queueDisposable;
                        this.f48462f.onSubscribe(this);
                        return;
                    }
                }
                this.f48469m = new SpscLinkedArrayQueue(this.f48465i);
                this.f48462f.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i8, int i9) {
        super(observableSource);
        this.f48458g = function;
        this.f48459h = errorMode;
        this.f48460i = i8;
        this.f48461j = i9;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.f48232f.subscribe(new ConcatMapEagerMainObserver(observer, this.f48458g, this.f48460i, this.f48461j, this.f48459h));
    }
}
