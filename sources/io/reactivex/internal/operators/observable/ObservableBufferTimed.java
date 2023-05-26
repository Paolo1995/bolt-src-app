package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final long f48341g;

    /* renamed from: h  reason: collision with root package name */
    final long f48342h;

    /* renamed from: i  reason: collision with root package name */
    final TimeUnit f48343i;

    /* renamed from: j  reason: collision with root package name */
    final Scheduler f48344j;

    /* renamed from: k  reason: collision with root package name */
    final Callable<U> f48345k;

    /* renamed from: l  reason: collision with root package name */
    final int f48346l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f48347m;

    /* loaded from: classes5.dex */
    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: l  reason: collision with root package name */
        final Callable<U> f48348l;

        /* renamed from: m  reason: collision with root package name */
        final long f48349m;

        /* renamed from: n  reason: collision with root package name */
        final TimeUnit f48350n;

        /* renamed from: o  reason: collision with root package name */
        final int f48351o;

        /* renamed from: p  reason: collision with root package name */
        final boolean f48352p;

        /* renamed from: q  reason: collision with root package name */
        final Scheduler.Worker f48353q;

        /* renamed from: r  reason: collision with root package name */
        U f48354r;

        /* renamed from: s  reason: collision with root package name */
        Disposable f48355s;

        /* renamed from: t  reason: collision with root package name */
        Disposable f48356t;

        /* renamed from: u  reason: collision with root package name */
        long f48357u;

        /* renamed from: v  reason: collision with root package name */
        long f48358v;

        BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j8, TimeUnit timeUnit, int i8, boolean z7, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f48348l = callable;
            this.f48349m = j8;
            this.f48350n = timeUnit;
            this.f48351o = i8;
            this.f48352p = z7;
            this.f48353q = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f47703i) {
                this.f47703i = true;
                this.f48356t.dispose();
                this.f48353q.dispose();
                synchronized (this) {
                    this.f48354r = null;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47703i;
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* renamed from: j */
        public void a(Observer<? super U> observer, U u7) {
            observer.onNext(u7);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u7;
            this.f48353q.dispose();
            synchronized (this) {
                u7 = this.f48354r;
                this.f48354r = null;
            }
            if (u7 != null) {
                this.f47702h.offer(u7);
                this.f47704j = true;
                if (e()) {
                    QueueDrainHelper.c(this.f47702h, this.f47701g, false, this, this);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.f48354r = null;
            }
            this.f47701g.onError(th);
            this.f48353q.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            synchronized (this) {
                U u7 = this.f48354r;
                if (u7 == null) {
                    return;
                }
                u7.add(t7);
                if (u7.size() < this.f48351o) {
                    return;
                }
                this.f48354r = null;
                this.f48357u++;
                if (this.f48352p) {
                    this.f48355s.dispose();
                }
                h(u7, false, this);
                try {
                    U u8 = (U) ObjectHelper.e(this.f48348l.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.f48354r = u8;
                        this.f48358v++;
                    }
                    if (this.f48352p) {
                        Scheduler.Worker worker = this.f48353q;
                        long j8 = this.f48349m;
                        this.f48355s = worker.d(this, j8, j8, this.f48350n);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f47701g.onError(th);
                    dispose();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48356t, disposable)) {
                this.f48356t = disposable;
                try {
                    this.f48354r = (U) ObjectHelper.e(this.f48348l.call(), "The buffer supplied is null");
                    this.f47701g.onSubscribe(this);
                    Scheduler.Worker worker = this.f48353q;
                    long j8 = this.f48349m;
                    this.f48355s = worker.d(this, j8, j8, this.f48350n);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.dispose();
                    EmptyDisposable.h(th, this.f47701g);
                    this.f48353q.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u7 = (U) ObjectHelper.e(this.f48348l.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u8 = this.f48354r;
                    if (u8 != null && this.f48357u == this.f48358v) {
                        this.f48354r = u7;
                        h(u8, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                this.f47701g.onError(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: l  reason: collision with root package name */
        final Callable<U> f48359l;

        /* renamed from: m  reason: collision with root package name */
        final long f48360m;

        /* renamed from: n  reason: collision with root package name */
        final TimeUnit f48361n;

        /* renamed from: o  reason: collision with root package name */
        final Scheduler f48362o;

        /* renamed from: p  reason: collision with root package name */
        Disposable f48363p;

        /* renamed from: q  reason: collision with root package name */
        U f48364q;

        /* renamed from: r  reason: collision with root package name */
        final AtomicReference<Disposable> f48365r;

        BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long j8, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.f48365r = new AtomicReference<>();
            this.f48359l = callable;
            this.f48360m = j8;
            this.f48361n = timeUnit;
            this.f48362o = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f48365r);
            this.f48363p.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.f48365r.get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* renamed from: j */
        public void a(Observer<? super U> observer, U u7) {
            this.f47701g.onNext(u7);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u7;
            synchronized (this) {
                u7 = this.f48364q;
                this.f48364q = null;
            }
            if (u7 != null) {
                this.f47702h.offer(u7);
                this.f47704j = true;
                if (e()) {
                    QueueDrainHelper.c(this.f47702h, this.f47701g, false, null, this);
                }
            }
            DisposableHelper.a(this.f48365r);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.f48364q = null;
            }
            this.f47701g.onError(th);
            DisposableHelper.a(this.f48365r);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            synchronized (this) {
                U u7 = this.f48364q;
                if (u7 == null) {
                    return;
                }
                u7.add(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48363p, disposable)) {
                this.f48363p = disposable;
                try {
                    this.f48364q = (U) ObjectHelper.e(this.f48359l.call(), "The buffer supplied is null");
                    this.f47701g.onSubscribe(this);
                    if (!this.f47703i) {
                        Scheduler scheduler = this.f48362o;
                        long j8 = this.f48360m;
                        Disposable f8 = scheduler.f(this, j8, j8, this.f48361n);
                        if (!e.a(this.f48365r, null, f8)) {
                            f8.dispose();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    dispose();
                    EmptyDisposable.h(th, this.f47701g);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u7;
            try {
                U u8 = (U) ObjectHelper.e(this.f48359l.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u7 = this.f48364q;
                    if (u7 != null) {
                        this.f48364q = u8;
                    }
                }
                if (u7 == null) {
                    DisposableHelper.a(this.f48365r);
                } else {
                    g(u7, false, this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f47701g.onError(th);
                dispose();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: l  reason: collision with root package name */
        final Callable<U> f48366l;

        /* renamed from: m  reason: collision with root package name */
        final long f48367m;

        /* renamed from: n  reason: collision with root package name */
        final long f48368n;

        /* renamed from: o  reason: collision with root package name */
        final TimeUnit f48369o;

        /* renamed from: p  reason: collision with root package name */
        final Scheduler.Worker f48370p;

        /* renamed from: q  reason: collision with root package name */
        final List<U> f48371q;

        /* renamed from: r  reason: collision with root package name */
        Disposable f48372r;

        /* loaded from: classes5.dex */
        final class RemoveFromBuffer implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private final U f48373f;

            RemoveFromBuffer(U u7) {
                this.f48373f = u7;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f48371q.remove(this.f48373f);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.h(this.f48373f, false, bufferSkipBoundedObserver.f48370p);
            }
        }

        /* loaded from: classes5.dex */
        final class RemoveFromBufferEmit implements Runnable {

            /* renamed from: f  reason: collision with root package name */
            private final U f48375f;

            RemoveFromBufferEmit(U u7) {
                this.f48375f = u7;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f48371q.remove(this.f48375f);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.h(this.f48375f, false, bufferSkipBoundedObserver.f48370p);
            }
        }

        BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j8, long j9, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f48366l = callable;
            this.f48367m = j8;
            this.f48368n = j9;
            this.f48369o = timeUnit;
            this.f48370p = worker;
            this.f48371q = new LinkedList();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f47703i) {
                this.f47703i = true;
                m();
                this.f48372r.dispose();
                this.f48370p.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f47703i;
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* renamed from: j */
        public void a(Observer<? super U> observer, U u7) {
            observer.onNext(u7);
        }

        void m() {
            synchronized (this) {
                this.f48371q.clear();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f48371q);
                this.f48371q.clear();
            }
            for (Collection collection : arrayList) {
                this.f47702h.offer(collection);
            }
            this.f47704j = true;
            if (e()) {
                QueueDrainHelper.c(this.f47702h, this.f47701g, false, this.f48370p, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f47704j = true;
            m();
            this.f47701g.onError(th);
            this.f48370p.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            synchronized (this) {
                for (U u7 : this.f48371q) {
                    u7.add(t7);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48372r, disposable)) {
                this.f48372r = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.e(this.f48366l.call(), "The buffer supplied is null");
                    this.f48371q.add(collection);
                    this.f47701g.onSubscribe(this);
                    Scheduler.Worker worker = this.f48370p;
                    long j8 = this.f48368n;
                    worker.d(this, j8, j8, this.f48369o);
                    this.f48370p.c(new RemoveFromBufferEmit(collection), this.f48367m, this.f48369o);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.dispose();
                    EmptyDisposable.h(th, this.f47701g);
                    this.f48370p.dispose();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f47703i) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.e(this.f48366l.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.f47703i) {
                        return;
                    }
                    this.f48371q.add(collection);
                    this.f48370p.c(new RemoveFromBuffer(collection), this.f48367m, this.f48369o);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f47701g.onError(th);
                dispose();
            }
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j8, long j9, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i8, boolean z7) {
        super(observableSource);
        this.f48341g = j8;
        this.f48342h = j9;
        this.f48343i = timeUnit;
        this.f48344j = scheduler;
        this.f48345k = callable;
        this.f48346l = i8;
        this.f48347m = z7;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        if (this.f48341g == this.f48342h && this.f48346l == Integer.MAX_VALUE) {
            this.f48232f.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.f48345k, this.f48341g, this.f48343i, this.f48344j));
            return;
        }
        Scheduler.Worker b8 = this.f48344j.b();
        if (this.f48341g == this.f48342h) {
            this.f48232f.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.f48345k, this.f48341g, this.f48343i, this.f48346l, this.f48347m, b8));
        } else {
            this.f48232f.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.f48345k, this.f48341g, this.f48342h, this.f48343i, b8));
        }
    }
}
