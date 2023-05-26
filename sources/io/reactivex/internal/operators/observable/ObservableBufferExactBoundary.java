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
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: g  reason: collision with root package name */
    final ObservableSource<B> f48333g;

    /* renamed from: h  reason: collision with root package name */
    final Callable<U> f48334h;

    /* loaded from: classes5.dex */
    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* renamed from: g  reason: collision with root package name */
        final BufferExactBoundaryObserver<T, U, B> f48335g;

        BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.f48335g = bufferExactBoundaryObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f48335g.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f48335g.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b8) {
            this.f48335g.k();
        }
    }

    /* loaded from: classes5.dex */
    static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Disposable {

        /* renamed from: l  reason: collision with root package name */
        final Callable<U> f48336l;

        /* renamed from: m  reason: collision with root package name */
        final ObservableSource<B> f48337m;

        /* renamed from: n  reason: collision with root package name */
        Disposable f48338n;

        /* renamed from: o  reason: collision with root package name */
        Disposable f48339o;

        /* renamed from: p  reason: collision with root package name */
        U f48340p;

        BufferExactBoundaryObserver(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.f48336l = callable;
            this.f48337m = observableSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f47703i) {
                this.f47703i = true;
                this.f48339o.dispose();
                this.f48338n.dispose();
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
            try {
                U u7 = (U) ObjectHelper.e(this.f48336l.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u8 = this.f48340p;
                    if (u8 == null) {
                        return;
                    }
                    this.f48340p = u7;
                    g(u8, false, this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                this.f47701g.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            synchronized (this) {
                U u7 = this.f48340p;
                if (u7 == null) {
                    return;
                }
                this.f48340p = null;
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
                U u7 = this.f48340p;
                if (u7 == null) {
                    return;
                }
                u7.add(t7);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48338n, disposable)) {
                this.f48338n = disposable;
                try {
                    this.f48340p = (U) ObjectHelper.e(this.f48336l.call(), "The buffer supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.f48339o = bufferBoundaryObserver;
                    this.f47701g.onSubscribe(this);
                    if (!this.f47703i) {
                        this.f48337m.subscribe(bufferBoundaryObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f47703i = true;
                    disposable.dispose();
                    EmptyDisposable.h(th, this.f47701g);
                }
            }
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.f48333g = observableSource2;
        this.f48334h = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        this.f48232f.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.f48334h, this.f48333g));
    }
}
