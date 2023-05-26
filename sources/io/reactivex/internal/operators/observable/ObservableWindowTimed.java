package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: g  reason: collision with root package name */
    final long f49434g;

    /* renamed from: h  reason: collision with root package name */
    final long f49435h;

    /* renamed from: i  reason: collision with root package name */
    final TimeUnit f49436i;

    /* renamed from: j  reason: collision with root package name */
    final Scheduler f49437j;

    /* renamed from: k  reason: collision with root package name */
    final long f49438k;

    /* renamed from: l  reason: collision with root package name */
    final int f49439l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f49440m;

    /* loaded from: classes5.dex */
    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {

        /* renamed from: l  reason: collision with root package name */
        final long f49441l;

        /* renamed from: m  reason: collision with root package name */
        final TimeUnit f49442m;

        /* renamed from: n  reason: collision with root package name */
        final Scheduler f49443n;

        /* renamed from: o  reason: collision with root package name */
        final int f49444o;

        /* renamed from: p  reason: collision with root package name */
        final boolean f49445p;

        /* renamed from: q  reason: collision with root package name */
        final long f49446q;

        /* renamed from: r  reason: collision with root package name */
        final Scheduler.Worker f49447r;

        /* renamed from: s  reason: collision with root package name */
        long f49448s;

        /* renamed from: t  reason: collision with root package name */
        long f49449t;

        /* renamed from: u  reason: collision with root package name */
        Disposable f49450u;

        /* renamed from: v  reason: collision with root package name */
        UnicastSubject<T> f49451v;

        /* renamed from: w  reason: collision with root package name */
        volatile boolean f49452w;

        /* renamed from: x  reason: collision with root package name */
        final SequentialDisposable f49453x;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class ConsumerIndexHolder implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            final long f49454f;

            /* renamed from: g  reason: collision with root package name */
            final WindowExactBoundedObserver<?> f49455g;

            ConsumerIndexHolder(long j8, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.f49454f = j8;
                this.f49455g = windowExactBoundedObserver;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.f49455g;
                if (!((QueueDrainObserver) windowExactBoundedObserver).f47703i) {
                    ((QueueDrainObserver) windowExactBoundedObserver).f47702h.offer(this);
                } else {
                    windowExactBoundedObserver.f49452w = true;
                }
                if (windowExactBoundedObserver.e()) {
                    windowExactBoundedObserver.m();
                }
            }
        }

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j8, TimeUnit timeUnit, Scheduler scheduler, int i8, long j9, boolean z7) {
            super(observer, new MpscLinkedQueue());
            this.f49453x = new SequentialDisposable();
            this.f49441l = j8;
            this.f49442m = timeUnit;
            this.f49443n = scheduler;
            this.f49444o = i8;
            this.f49446q = j9;
            this.f49445p = z7;
            if (z7) {
                this.f49447r = scheduler.b();
            } else {
                this.f49447r = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47703i = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47703i;
        }

        void l() {
            DisposableHelper.a(this.f49453x);
            Scheduler.Worker worker = this.f49447r;
            if (worker != null) {
                worker.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void m() {
            boolean z7;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f47702h;
            Observer<? super V> observer = this.f47701g;
            UnicastSubject<T> unicastSubject = this.f49451v;
            int i8 = 1;
            while (!this.f49452w) {
                boolean z8 = this.f47704j;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z9 = poll instanceof ConsumerIndexHolder;
                if (z8 && (z7 || z9)) {
                    this.f49451v = null;
                    mpscLinkedQueue.clear();
                    Throwable th = this.f47705k;
                    if (th != null) {
                        unicastSubject.onError(th);
                    } else {
                        unicastSubject.onComplete();
                    }
                    l();
                    return;
                } else if (z7) {
                    i8 = b(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else if (z9) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (!this.f49445p || this.f49449t == consumerIndexHolder.f49454f) {
                        unicastSubject.onComplete();
                        this.f49448s = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.e(this.f49444o);
                        this.f49451v = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.l(poll));
                    long j8 = this.f49448s + 1;
                    if (j8 >= this.f49446q) {
                        this.f49449t++;
                        this.f49448s = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.e(this.f49444o);
                        this.f49451v = unicastSubject;
                        this.f47701g.onNext(unicastSubject);
                        if (this.f49445p) {
                            Disposable disposable = this.f49453x.get();
                            disposable.dispose();
                            Scheduler.Worker worker = this.f49447r;
                            ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.f49449t, this);
                            long j9 = this.f49441l;
                            Disposable d8 = worker.d(consumerIndexHolder2, j9, j9, this.f49442m);
                            if (!this.f49453x.compareAndSet(disposable, d8)) {
                                d8.dispose();
                            }
                        }
                    } else {
                        this.f49448s = j8;
                    }
                }
            }
            this.f49450u.dispose();
            mpscLinkedQueue.clear();
            l();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f47704j = true;
            if (e()) {
                m();
            }
            this.f47701g.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f47705k = th;
            this.f47704j = true;
            if (e()) {
                m();
            }
            this.f47701g.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49452w) {
                return;
            }
            if (f()) {
                UnicastSubject<T> unicastSubject = this.f49451v;
                unicastSubject.onNext(t7);
                long j8 = this.f49448s + 1;
                if (j8 >= this.f49446q) {
                    this.f49449t++;
                    this.f49448s = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> e8 = UnicastSubject.e(this.f49444o);
                    this.f49451v = e8;
                    this.f47701g.onNext(e8);
                    if (this.f49445p) {
                        this.f49453x.get().dispose();
                        Scheduler.Worker worker = this.f49447r;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f49449t, this);
                        long j9 = this.f49441l;
                        DisposableHelper.e(this.f49453x, worker.d(consumerIndexHolder, j9, j9, this.f49442m));
                    }
                } else {
                    this.f49448s = j8;
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f47702h.offer(NotificationLite.q(t7));
                if (!e()) {
                    return;
                }
            }
            m();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Disposable f8;
            if (DisposableHelper.l(this.f49450u, disposable)) {
                this.f49450u = disposable;
                Observer<? super V> observer = this.f47701g;
                observer.onSubscribe(this);
                if (this.f47703i) {
                    return;
                }
                UnicastSubject<T> e8 = UnicastSubject.e(this.f49444o);
                this.f49451v = e8;
                observer.onNext(e8);
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f49449t, this);
                if (this.f49445p) {
                    Scheduler.Worker worker = this.f49447r;
                    long j8 = this.f49441l;
                    f8 = worker.d(consumerIndexHolder, j8, j8, this.f49442m);
                } else {
                    Scheduler scheduler = this.f49443n;
                    long j9 = this.f49441l;
                    f8 = scheduler.f(consumerIndexHolder, j9, j9, this.f49442m);
                }
                this.f49453x.a(f8);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {

        /* renamed from: t  reason: collision with root package name */
        static final Object f49456t = new Object();

        /* renamed from: l  reason: collision with root package name */
        final long f49457l;

        /* renamed from: m  reason: collision with root package name */
        final TimeUnit f49458m;

        /* renamed from: n  reason: collision with root package name */
        final Scheduler f49459n;

        /* renamed from: o  reason: collision with root package name */
        final int f49460o;

        /* renamed from: p  reason: collision with root package name */
        Disposable f49461p;

        /* renamed from: q  reason: collision with root package name */
        UnicastSubject<T> f49462q;

        /* renamed from: r  reason: collision with root package name */
        final SequentialDisposable f49463r;

        /* renamed from: s  reason: collision with root package name */
        volatile boolean f49464s;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j8, TimeUnit timeUnit, Scheduler scheduler, int i8) {
            super(observer, new MpscLinkedQueue());
            this.f49463r = new SequentialDisposable();
            this.f49457l = j8;
            this.f49458m = timeUnit;
            this.f49459n = scheduler;
            this.f49460o = i8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47703i = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47703i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
            r7.f49463r.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            r7.f49462q = null;
            r0.clear();
            r0 = r7.f47705k;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
            if (r0 == null) goto L14;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void j() {
            /*
                r7 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r7.f47702h
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                io.reactivex.Observer<? super V> r1 = r7.f47701g
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.f49462q
                r3 = 1
            L9:
                boolean r4 = r7.f49464s
                boolean r5 = r7.f47704j
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L30
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.f49456t
                if (r6 != r5) goto L30
            L19:
                r1 = 0
                r7.f49462q = r1
                r0.clear()
                java.lang.Throwable r0 = r7.f47705k
                if (r0 == 0) goto L27
                r2.onError(r0)
                goto L2a
            L27:
                r2.onComplete()
            L2a:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r7.f49463r
                r0.dispose()
                return
            L30:
                if (r6 != 0) goto L3a
                int r3 = -r3
                int r3 = r7.b(r3)
                if (r3 != 0) goto L9
                return
            L3a:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.f49456t
                if (r6 != r5) goto L55
                r2.onComplete()
                if (r4 != 0) goto L4f
                int r2 = r7.f49460o
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.e(r2)
                r7.f49462q = r2
                r1.onNext(r2)
                goto L9
            L4f:
                io.reactivex.disposables.Disposable r4 = r7.f49461p
                r4.dispose()
                goto L9
            L55:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.l(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.j():void");
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f47704j = true;
            if (e()) {
                j();
            }
            this.f47701g.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f47705k = th;
            this.f47704j = true;
            if (e()) {
                j();
            }
            this.f47701g.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (this.f49464s) {
                return;
            }
            if (f()) {
                this.f49462q.onNext(t7);
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f47702h.offer(NotificationLite.q(t7));
                if (!e()) {
                    return;
                }
            }
            j();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49461p, disposable)) {
                this.f49461p = disposable;
                this.f49462q = UnicastSubject.e(this.f49460o);
                Observer<? super V> observer = this.f47701g;
                observer.onSubscribe(this);
                observer.onNext(this.f49462q);
                if (!this.f47703i) {
                    Scheduler scheduler = this.f49459n;
                    long j8 = this.f49457l;
                    this.f49463r.a(scheduler.f(this, j8, j8, this.f49458m));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f47703i) {
                this.f49464s = true;
            }
            this.f47702h.offer(f49456t);
            if (e()) {
                j();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {

        /* renamed from: l  reason: collision with root package name */
        final long f49465l;

        /* renamed from: m  reason: collision with root package name */
        final long f49466m;

        /* renamed from: n  reason: collision with root package name */
        final TimeUnit f49467n;

        /* renamed from: o  reason: collision with root package name */
        final Scheduler.Worker f49468o;

        /* renamed from: p  reason: collision with root package name */
        final int f49469p;

        /* renamed from: q  reason: collision with root package name */
        final List<UnicastSubject<T>> f49470q;

        /* renamed from: r  reason: collision with root package name */
        Disposable f49471r;

        /* renamed from: s  reason: collision with root package name */
        volatile boolean f49472s;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public final class CompletionTask implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private final UnicastSubject<T> f49473f;

            CompletionTask(UnicastSubject<T> unicastSubject) {
                this.f49473f = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowSkipObserver.this.j(this.f49473f);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class SubjectWork<T> {

            /* renamed from: a  reason: collision with root package name */
            final UnicastSubject<T> f49475a;

            /* renamed from: b  reason: collision with root package name */
            final boolean f49476b;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z7) {
                this.f49475a = unicastSubject;
                this.f49476b = z7;
            }
        }

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j8, long j9, TimeUnit timeUnit, Scheduler.Worker worker, int i8) {
            super(observer, new MpscLinkedQueue());
            this.f49465l = j8;
            this.f49466m = j9;
            this.f49467n = timeUnit;
            this.f49468o = worker;
            this.f49469p = i8;
            this.f49470q = new LinkedList();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f47703i = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47703i;
        }

        void j(UnicastSubject<T> unicastSubject) {
            this.f47702h.offer(new SubjectWork(unicastSubject, false));
            if (e()) {
                k();
            }
        }

        void k() {
            boolean z7;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f47702h;
            Observer<? super V> observer = this.f47701g;
            List<UnicastSubject<T>> list = this.f49470q;
            int i8 = 1;
            while (!this.f49472s) {
                boolean z8 = this.f47704j;
                T t7 = (T) mpscLinkedQueue.poll();
                if (t7 == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z9 = t7 instanceof SubjectWork;
                if (z8 && (z7 || z9)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.f47705k;
                    if (th != null) {
                        for (UnicastSubject<T> unicastSubject : list) {
                            unicastSubject.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> unicastSubject2 : list) {
                            unicastSubject2.onComplete();
                        }
                    }
                    list.clear();
                    this.f49468o.dispose();
                    return;
                } else if (z7) {
                    i8 = b(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else if (z9) {
                    SubjectWork subjectWork = (SubjectWork) t7;
                    if (subjectWork.f49476b) {
                        if (!this.f47703i) {
                            UnicastSubject<T> e8 = UnicastSubject.e(this.f49469p);
                            list.add(e8);
                            observer.onNext(e8);
                            this.f49468o.c(new CompletionTask(e8), this.f49465l, this.f49467n);
                        }
                    } else {
                        list.remove(subjectWork.f49475a);
                        subjectWork.f49475a.onComplete();
                        if (list.isEmpty() && this.f47703i) {
                            this.f49472s = true;
                        }
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject3 : list) {
                        unicastSubject3.onNext(t7);
                    }
                }
            }
            this.f49471r.dispose();
            mpscLinkedQueue.clear();
            list.clear();
            this.f49468o.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f47704j = true;
            if (e()) {
                k();
            }
            this.f47701g.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f47705k = th;
            this.f47704j = true;
            if (e()) {
                k();
            }
            this.f47701g.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (f()) {
                for (UnicastSubject<T> unicastSubject : this.f49470q) {
                    unicastSubject.onNext(t7);
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f47702h.offer(t7);
                if (!e()) {
                    return;
                }
            }
            k();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49471r, disposable)) {
                this.f49471r = disposable;
                this.f47701g.onSubscribe(this);
                if (this.f47703i) {
                    return;
                }
                UnicastSubject<T> e8 = UnicastSubject.e(this.f49469p);
                this.f49470q.add(e8);
                this.f47701g.onNext(e8);
                this.f49468o.c(new CompletionTask(e8), this.f49465l, this.f49467n);
                Scheduler.Worker worker = this.f49468o;
                long j8 = this.f49466m;
                worker.d(this, j8, j8, this.f49467n);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.e(this.f49469p), true);
            if (!this.f47703i) {
                this.f47702h.offer(subjectWork);
            }
            if (e()) {
                k();
            }
        }
    }

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j8, long j9, TimeUnit timeUnit, Scheduler scheduler, long j10, int i8, boolean z7) {
        super(observableSource);
        this.f49434g = j8;
        this.f49435h = j9;
        this.f49436i = timeUnit;
        this.f49437j = scheduler;
        this.f49438k = j10;
        this.f49439l = i8;
        this.f49440m = z7;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        long j8 = this.f49434g;
        long j9 = this.f49435h;
        if (j8 == j9) {
            long j10 = this.f49438k;
            if (j10 == Long.MAX_VALUE) {
                this.f48232f.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.f49434g, this.f49436i, this.f49437j, this.f49439l));
                return;
            } else {
                this.f48232f.subscribe(new WindowExactBoundedObserver(serializedObserver, j8, this.f49436i, this.f49437j, this.f49439l, j10, this.f49440m));
                return;
            }
        }
        this.f48232f.subscribe(new WindowSkipObserver(serializedObserver, j8, j9, this.f49436i, this.f49437j.b(), this.f49439l));
    }
}
