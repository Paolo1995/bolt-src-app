package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<B> f49399g;

    /* renamed from: h  reason: collision with root package name */
    final Function<? super B, ? extends ObservableSource<V>> f49400h;

    /* renamed from: i  reason: collision with root package name */
    final int f49401i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {

        /* renamed from: g  reason: collision with root package name */
        final WindowBoundaryMainObserver<T, ?, V> f49402g;

        /* renamed from: h  reason: collision with root package name */
        final UnicastSubject<T> f49403h;

        /* renamed from: i  reason: collision with root package name */
        boolean f49404i;

        OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
            this.f49402g = windowBoundaryMainObserver;
            this.f49403h = unicastSubject;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f49404i) {
                return;
            }
            this.f49404i = true;
            this.f49402g.j(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f49404i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f49404i = true;
            this.f49402g.m(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(V v7) {
            dispose();
            onComplete();
        }
    }

    /* loaded from: classes5.dex */
    static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {

        /* renamed from: g  reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B, ?> f49405g;

        OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver) {
            this.f49405g = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f49405g.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f49405g.m(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b8) {
            this.f49405g.n(b8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {

        /* renamed from: l  reason: collision with root package name */
        final ObservableSource<B> f49406l;

        /* renamed from: m  reason: collision with root package name */
        final Function<? super B, ? extends ObservableSource<V>> f49407m;

        /* renamed from: n  reason: collision with root package name */
        final int f49408n;

        /* renamed from: o  reason: collision with root package name */
        final CompositeDisposable f49409o;

        /* renamed from: p  reason: collision with root package name */
        Disposable f49410p;

        /* renamed from: q  reason: collision with root package name */
        final AtomicReference<Disposable> f49411q;

        /* renamed from: r  reason: collision with root package name */
        final List<UnicastSubject<T>> f49412r;

        /* renamed from: s  reason: collision with root package name */
        final AtomicLong f49413s;

        /* renamed from: t  reason: collision with root package name */
        final AtomicBoolean f49414t;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i8) {
            super(observer, new MpscLinkedQueue());
            this.f49411q = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.f49413s = atomicLong;
            this.f49414t = new AtomicBoolean();
            this.f49406l = observableSource;
            this.f49407m = function;
            this.f49408n = i8;
            this.f49409o = new CompositeDisposable();
            this.f49412r = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public void a(Observer<? super Observable<T>> observer, Object obj) {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f49414t.compareAndSet(false, true)) {
                DisposableHelper.a(this.f49411q);
                if (this.f49413s.decrementAndGet() == 0) {
                    this.f49410p.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49414t.get();
        }

        void j(OperatorWindowBoundaryCloseObserver<T, V> operatorWindowBoundaryCloseObserver) {
            this.f49409o.c(operatorWindowBoundaryCloseObserver);
            this.f47702h.offer(new WindowOperation(operatorWindowBoundaryCloseObserver.f49403h, null));
            if (e()) {
                l();
            }
        }

        void k() {
            this.f49409o.dispose();
            DisposableHelper.a(this.f49411q);
        }

        void l() {
            boolean z7;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f47702h;
            Observer<? super V> observer = this.f47701g;
            List<UnicastSubject<T>> list = this.f49412r;
            int i8 = 1;
            while (true) {
                boolean z8 = this.f47704j;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z8 && z7) {
                    k();
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
                    return;
                } else if (z7) {
                    i8 = b(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    UnicastSubject<T> unicastSubject3 = windowOperation.f49415a;
                    if (unicastSubject3 != null) {
                        if (list.remove(unicastSubject3)) {
                            windowOperation.f49415a.onComplete();
                            if (this.f49413s.decrementAndGet() == 0) {
                                k();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f49414t.get()) {
                        UnicastSubject<T> e8 = UnicastSubject.e(this.f49408n);
                        list.add(e8);
                        observer.onNext(e8);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f49407m.apply((B) windowOperation.f49416b), "The ObservableSource supplied is null");
                            OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver = new OperatorWindowBoundaryCloseObserver(this, e8);
                            if (this.f49409o.b(operatorWindowBoundaryCloseObserver)) {
                                this.f49413s.getAndIncrement();
                                observableSource.subscribe(operatorWindowBoundaryCloseObserver);
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            this.f49414t.set(true);
                            observer.onError(th2);
                        }
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject4 : list) {
                        unicastSubject4.onNext((T) NotificationLite.l(poll));
                    }
                }
            }
        }

        void m(Throwable th) {
            this.f49410p.dispose();
            this.f49409o.dispose();
            onError(th);
        }

        void n(B b8) {
            this.f47702h.offer(new WindowOperation(null, b8));
            if (e()) {
                l();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f47704j) {
                return;
            }
            this.f47704j = true;
            if (e()) {
                l();
            }
            if (this.f49413s.decrementAndGet() == 0) {
                this.f49409o.dispose();
            }
            this.f47701g.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f47704j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f47705k = th;
            this.f47704j = true;
            if (e()) {
                l();
            }
            if (this.f49413s.decrementAndGet() == 0) {
                this.f49409o.dispose();
            }
            this.f47701g.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            if (f()) {
                for (UnicastSubject<T> unicastSubject : this.f49412r) {
                    unicastSubject.onNext(t7);
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
            l();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49410p, disposable)) {
                this.f49410p = disposable;
                this.f47701g.onSubscribe(this);
                if (this.f49414t.get()) {
                    return;
                }
                OperatorWindowBoundaryOpenObserver operatorWindowBoundaryOpenObserver = new OperatorWindowBoundaryOpenObserver(this);
                if (e.a(this.f49411q, null, operatorWindowBoundaryOpenObserver)) {
                    this.f49406l.subscribe(operatorWindowBoundaryOpenObserver);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WindowOperation<T, B> {

        /* renamed from: a  reason: collision with root package name */
        final UnicastSubject<T> f49415a;

        /* renamed from: b  reason: collision with root package name */
        final B f49416b;

        WindowOperation(UnicastSubject<T> unicastSubject, B b8) {
            this.f49415a = unicastSubject;
            this.f49416b = b8;
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i8) {
        super(observableSource);
        this.f49399g = observableSource2;
        this.f49400h = function;
        this.f49401i = i8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.f48232f.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.f49399g, this.f49400h, this.f49401i));
    }
}
