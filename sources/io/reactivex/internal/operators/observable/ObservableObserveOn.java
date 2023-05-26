package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final Scheduler f48895g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f48896h;

    /* renamed from: i  reason: collision with root package name */
    final int f48897i;

    /* loaded from: classes5.dex */
    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48898f;

        /* renamed from: g  reason: collision with root package name */
        final Scheduler.Worker f48899g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f48900h;

        /* renamed from: i  reason: collision with root package name */
        final int f48901i;

        /* renamed from: j  reason: collision with root package name */
        SimpleQueue<T> f48902j;

        /* renamed from: k  reason: collision with root package name */
        Disposable f48903k;

        /* renamed from: l  reason: collision with root package name */
        Throwable f48904l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f48905m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f48906n;

        /* renamed from: o  reason: collision with root package name */
        int f48907o;

        /* renamed from: p  reason: collision with root package name */
        boolean f48908p;

        ObserveOnObserver(Observer<? super T> observer, Scheduler.Worker worker, boolean z7, int i8) {
            this.f48898f = observer;
            this.f48899g = worker;
            this.f48900h = z7;
            this.f48901i = i8;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int a(int i8) {
            if ((i8 & 2) != 0) {
                this.f48908p = true;
                return 2;
            }
            return 0;
        }

        boolean b(boolean z7, boolean z8, Observer<? super T> observer) {
            if (this.f48906n) {
                this.f48902j.clear();
                return true;
            } else if (z7) {
                Throwable th = this.f48904l;
                if (this.f48900h) {
                    if (z8) {
                        this.f48906n = true;
                        if (th != null) {
                            observer.onError(th);
                        } else {
                            observer.onComplete();
                        }
                        this.f48899g.dispose();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.f48906n = true;
                    this.f48902j.clear();
                    observer.onError(th);
                    this.f48899g.dispose();
                    return true;
                } else if (z8) {
                    this.f48906n = true;
                    observer.onComplete();
                    this.f48899g.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void c() {
            int i8 = 1;
            while (!this.f48906n) {
                boolean z7 = this.f48905m;
                Throwable th = this.f48904l;
                if (!this.f48900h && z7 && th != null) {
                    this.f48906n = true;
                    this.f48898f.onError(this.f48904l);
                    this.f48899g.dispose();
                    return;
                }
                this.f48898f.onNext(null);
                if (z7) {
                    this.f48906n = true;
                    Throwable th2 = this.f48904l;
                    if (th2 != null) {
                        this.f48898f.onError(th2);
                    } else {
                        this.f48898f.onComplete();
                    }
                    this.f48899g.dispose();
                    return;
                }
                i8 = addAndGet(-i8);
                if (i8 == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f48902j.clear();
        }

        void d() {
            boolean z7;
            SimpleQueue<T> simpleQueue = this.f48902j;
            Observer<? super T> observer = this.f48898f;
            int i8 = 1;
            while (!b(this.f48905m, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z8 = this.f48905m;
                    try {
                        Object obj = (T) simpleQueue.poll();
                        if (obj == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (b(z8, z7, observer)) {
                            return;
                        }
                        if (z7) {
                            i8 = addAndGet(-i8);
                            if (i8 == 0) {
                                return;
                            }
                        } else {
                            observer.onNext(obj);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f48906n = true;
                        this.f48903k.dispose();
                        simpleQueue.clear();
                        observer.onError(th);
                        this.f48899g.dispose();
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f48906n) {
                this.f48906n = true;
                this.f48903k.dispose();
                this.f48899g.dispose();
                if (!this.f48908p && getAndIncrement() == 0) {
                    this.f48902j.clear();
                }
            }
        }

        void e() {
            if (getAndIncrement() == 0) {
                this.f48899g.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48906n;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f48902j.isEmpty();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48905m) {
                return;
            }
            this.f48905m = true;
            e();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48905m) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48904l = th;
            this.f48905m = true;
            e();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f48905m) {
                return;
            }
            if (this.f48907o != 2) {
                this.f48902j.offer(t7);
            }
            e();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48903k, disposable)) {
                this.f48903k = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a8 = queueDisposable.a(7);
                    if (a8 == 1) {
                        this.f48907o = a8;
                        this.f48902j = queueDisposable;
                        this.f48905m = true;
                        this.f48898f.onSubscribe(this);
                        e();
                        return;
                    } else if (a8 == 2) {
                        this.f48907o = a8;
                        this.f48902j = queueDisposable;
                        this.f48898f.onSubscribe(this);
                        return;
                    }
                }
                this.f48902j = new SpscLinkedArrayQueue(this.f48901i);
                this.f48898f.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.f48902j.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f48908p) {
                c();
            } else {
                d();
            }
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z7, int i8) {
        super(observableSource);
        this.f48895g = scheduler;
        this.f48896h = z7;
        this.f48897i = i8;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler = this.f48895g;
        if (scheduler instanceof TrampolineScheduler) {
            this.f48232f.subscribe(observer);
            return;
        }
        this.f48232f.subscribe(new ObserveOnObserver(observer, scheduler.b(), this.f48896h, this.f48897i));
    }
}
