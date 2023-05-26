package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: g  reason: collision with root package name */
    final long f49235g;

    /* renamed from: h  reason: collision with root package name */
    final long f49236h;

    /* renamed from: i  reason: collision with root package name */
    final TimeUnit f49237i;

    /* renamed from: j  reason: collision with root package name */
    final Scheduler f49238j;

    /* renamed from: k  reason: collision with root package name */
    final int f49239k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f49240l;

    /* loaded from: classes5.dex */
    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49241f;

        /* renamed from: g  reason: collision with root package name */
        final long f49242g;

        /* renamed from: h  reason: collision with root package name */
        final long f49243h;

        /* renamed from: i  reason: collision with root package name */
        final TimeUnit f49244i;

        /* renamed from: j  reason: collision with root package name */
        final Scheduler f49245j;

        /* renamed from: k  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f49246k;

        /* renamed from: l  reason: collision with root package name */
        final boolean f49247l;

        /* renamed from: m  reason: collision with root package name */
        Disposable f49248m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f49249n;

        /* renamed from: o  reason: collision with root package name */
        Throwable f49250o;

        TakeLastTimedObserver(Observer<? super T> observer, long j8, long j9, TimeUnit timeUnit, Scheduler scheduler, int i8, boolean z7) {
            this.f49241f = observer;
            this.f49242g = j8;
            this.f49243h = j9;
            this.f49244i = timeUnit;
            this.f49245j = scheduler;
            this.f49246k = new SpscLinkedArrayQueue<>(i8);
            this.f49247l = z7;
        }

        void a() {
            boolean z7;
            Throwable th;
            if (!compareAndSet(false, true)) {
                return;
            }
            Observer<? super T> observer = this.f49241f;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f49246k;
            boolean z8 = this.f49247l;
            long c8 = this.f49245j.c(this.f49244i) - this.f49243h;
            while (!this.f49249n) {
                if (!z8 && (th = this.f49250o) != null) {
                    spscLinkedArrayQueue.clear();
                    observer.onError(th);
                    return;
                }
                Object poll = spscLinkedArrayQueue.poll();
                if (poll == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    Throwable th2 = this.f49250o;
                    if (th2 != null) {
                        observer.onError(th2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                Object poll2 = spscLinkedArrayQueue.poll();
                if (((Long) poll).longValue() >= c8) {
                    observer.onNext(poll2);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49249n) {
                this.f49249n = true;
                this.f49248m.dispose();
                if (compareAndSet(false, true)) {
                    this.f49246k.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49249n;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49250o = th;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            boolean z7;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f49246k;
            long c8 = this.f49245j.c(this.f49244i);
            long j8 = this.f49243h;
            long j9 = this.f49242g;
            if (j9 == Long.MAX_VALUE) {
                z7 = true;
            } else {
                z7 = false;
            }
            spscLinkedArrayQueue.m(Long.valueOf(c8), t7);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.n()).longValue() <= c8 - j8 || (!z7 && (spscLinkedArrayQueue.p() >> 1) > j9)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49248m, disposable)) {
                this.f49248m = disposable;
                this.f49241f.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j8, long j9, TimeUnit timeUnit, Scheduler scheduler, int i8, boolean z7) {
        super(observableSource);
        this.f49235g = j8;
        this.f49236h = j9;
        this.f49237i = timeUnit;
        this.f49238j = scheduler;
        this.f49239k = i8;
        this.f49240l = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f48232f.subscribe(new TakeLastTimedObserver(observer, this.f49235g, this.f49236h, this.f49237i, this.f49238j, this.f49239k, this.f49240l));
    }
}
