package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final Callable<? extends ObservableSource<B>> f48324g;

    /* renamed from: h  reason: collision with root package name */
    final Callable<U> f48325h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* renamed from: g  reason: collision with root package name */
        final BufferBoundarySupplierObserver<T, U, B> f48326g;

        /* renamed from: h  reason: collision with root package name */
        boolean f48327h;

        BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.f48326g = bufferBoundarySupplierObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f48327h) {
                return;
            }
            this.f48327h = true;
            this.f48326g.l();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f48327h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f48327h = true;
            this.f48326g.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b8) {
            if (this.f48327h) {
                return;
            }
            this.f48327h = true;
            dispose();
            this.f48326g.l();
        }
    }

    /* loaded from: classes5.dex */
    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Disposable {

        /* renamed from: l  reason: collision with root package name */
        final Callable<U> f48328l;

        /* renamed from: m  reason: collision with root package name */
        final Callable<? extends ObservableSource<B>> f48329m;

        /* renamed from: n  reason: collision with root package name */
        Disposable f48330n;

        /* renamed from: o  reason: collision with root package name */
        final AtomicReference<Disposable> f48331o;

        /* renamed from: p  reason: collision with root package name */
        U f48332p;

        BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.f48331o = new AtomicReference<>();
            this.f48328l = callable;
            this.f48329m = callable2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f47703i) {
                this.f47703i = true;
                this.f48330n.dispose();
                k();
                if (e()) {
                    this.f47702h.clear();
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
            this.f47701g.onNext(u7);
        }

        void k() {
            DisposableHelper.a(this.f48331o);
        }

        void l() {
            try {
                U u7 = (U) ObjectHelper.e(this.f48328l.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48329m.call(), "The boundary ObservableSource supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (DisposableHelper.e(this.f48331o, bufferBoundaryObserver)) {
                        synchronized (this) {
                            U u8 = this.f48332p;
                            if (u8 == null) {
                                return;
                            }
                            this.f48332p = u7;
                            observableSource.subscribe(bufferBoundaryObserver);
                            g(u8, false, this);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f47703i = true;
                    this.f48330n.dispose();
                    this.f47701g.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                dispose();
                this.f47701g.onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            synchronized (this) {
                U u7 = this.f48332p;
                if (u7 == null) {
                    return;
                }
                this.f48332p = null;
                this.f47702h.offer(u7);
                this.f47704j = true;
                if (e()) {
                    QueueDrainHelper.c(this.f47702h, this.f47701g, false, this, this);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dispose();
            this.f47701g.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            synchronized (this) {
                U u7 = this.f48332p;
                if (u7 == null) {
                    return;
                }
                u7.add(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48330n, disposable)) {
                this.f48330n = disposable;
                Observer<? super V> observer = this.f47701g;
                try {
                    this.f48332p = (U) ObjectHelper.e(this.f48328l.call(), "The buffer supplied is null");
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f48329m.call(), "The boundary ObservableSource supplied is null");
                        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                        this.f48331o.set(bufferBoundaryObserver);
                        observer.onSubscribe(this);
                        if (!this.f47703i) {
                            observableSource.subscribe(bufferBoundaryObserver);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f47703i = true;
                        disposable.dispose();
                        EmptyDisposable.h(th, observer);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f47703i = true;
                    disposable.dispose();
                    EmptyDisposable.h(th2, observer);
                }
            }
        }
    }

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.f48324g = callable;
        this.f48325h = callable2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        this.f48232f.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.f48325h, this.f48324g));
    }
}
