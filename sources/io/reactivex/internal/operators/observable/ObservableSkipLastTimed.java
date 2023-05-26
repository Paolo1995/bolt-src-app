package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f49162g;

    /* renamed from: h  reason: collision with root package name */
    final TimeUnit f49163h;

    /* renamed from: i  reason: collision with root package name */
    final Scheduler f49164i;

    /* renamed from: j  reason: collision with root package name */
    final int f49165j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f49166k;

    /* loaded from: classes5.dex */
    static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49167f;

        /* renamed from: g  reason: collision with root package name */
        final long f49168g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f49169h;

        /* renamed from: i  reason: collision with root package name */
        final Scheduler f49170i;

        /* renamed from: j  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f49171j;

        /* renamed from: k  reason: collision with root package name */
        final boolean f49172k;

        /* renamed from: l  reason: collision with root package name */
        Disposable f49173l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f49174m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f49175n;

        /* renamed from: o  reason: collision with root package name */
        Throwable f49176o;

        SkipLastTimedObserver(Observer<? super T> observer, long j8, TimeUnit timeUnit, Scheduler scheduler, int i8, boolean z7) {
            this.f49167f = observer;
            this.f49168g = j8;
            this.f49169h = timeUnit;
            this.f49170i = scheduler;
            this.f49171j = new SpscLinkedArrayQueue<>(i8);
            this.f49172k = z7;
        }

        void a() {
            boolean z7;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = this.f49167f;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f49171j;
            boolean z8 = this.f49172k;
            TimeUnit timeUnit = this.f49169h;
            Scheduler scheduler = this.f49170i;
            long j8 = this.f49168g;
            int i8 = 1;
            while (!this.f49174m) {
                boolean z9 = this.f49175n;
                Long l8 = (Long) spscLinkedArrayQueue.n();
                if (l8 == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                long c8 = scheduler.c(timeUnit);
                if (!z7 && l8.longValue() > c8 - j8) {
                    z7 = true;
                }
                if (z9) {
                    if (z8) {
                        if (z7) {
                            Throwable th = this.f49176o;
                            if (th != null) {
                                observer.onError(th);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    } else {
                        Throwable th2 = this.f49176o;
                        if (th2 != null) {
                            this.f49171j.clear();
                            observer.onError(th2);
                            return;
                        } else if (z7) {
                            observer.onComplete();
                            return;
                        }
                    }
                }
                if (z7) {
                    i8 = addAndGet(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    spscLinkedArrayQueue.poll();
                    observer.onNext(spscLinkedArrayQueue.poll());
                }
            }
            this.f49171j.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49174m) {
                this.f49174m = true;
                this.f49173l.dispose();
                if (getAndIncrement() == 0) {
                    this.f49171j.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49174m;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49175n = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49176o = th;
            this.f49175n = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f49171j.m(Long.valueOf(this.f49170i.c(this.f49169h)), t7);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49173l, disposable)) {
                this.f49173l = disposable;
                this.f49167f.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j8, TimeUnit timeUnit, Scheduler scheduler, int i8, boolean z7) {
        super(observableSource);
        this.f49162g = j8;
        this.f49163h = timeUnit;
        this.f49164i = scheduler;
        this.f49165j = i8;
        this.f49166k = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new SkipLastTimedObserver(observer, this.f49162g, this.f49163h, this.f49164i, this.f49165j, this.f49166k));
    }
}
