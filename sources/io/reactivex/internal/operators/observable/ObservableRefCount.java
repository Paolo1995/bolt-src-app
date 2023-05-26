package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableRefCount<T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final ConnectableObservable<T> f48975f;

    /* renamed from: g  reason: collision with root package name */
    final int f48976g;

    /* renamed from: h  reason: collision with root package name */
    final long f48977h;

    /* renamed from: i  reason: collision with root package name */
    final TimeUnit f48978i;

    /* renamed from: j  reason: collision with root package name */
    final Scheduler f48979j;

    /* renamed from: k  reason: collision with root package name */
    RefConnection f48980k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {

        /* renamed from: f  reason: collision with root package name */
        final ObservableRefCount<?> f48981f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f48982g;

        /* renamed from: h  reason: collision with root package name */
        long f48983h;

        /* renamed from: i  reason: collision with root package name */
        boolean f48984i;

        /* renamed from: j  reason: collision with root package name */
        boolean f48985j;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.f48981f = observableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.e(this, disposable);
            synchronized (this.f48981f) {
                if (this.f48985j) {
                    ((ResettableConnectable) this.f48981f.f48975f).b(disposable);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f48981f.g(this);
        }
    }

    /* loaded from: classes5.dex */
    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48986f;

        /* renamed from: g  reason: collision with root package name */
        final ObservableRefCount<T> f48987g;

        /* renamed from: h  reason: collision with root package name */
        final RefConnection f48988h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f48989i;

        RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.f48986f = observer;
            this.f48987g = observableRefCount;
            this.f48988h = refConnection;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f48989i.dispose();
            if (compareAndSet(false, true)) {
                this.f48987g.c(this.f48988h);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48989i.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f48987g.f(this.f48988h);
                this.f48986f.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f48987g.f(this.f48988h);
                this.f48986f.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            this.f48986f.onNext(t7);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f48989i, disposable)) {
                this.f48989i = disposable;
                this.f48986f.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    void c(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.f48980k;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j8 = refConnection.f48983h - 1;
                refConnection.f48983h = j8;
                if (j8 == 0 && refConnection.f48984i) {
                    if (this.f48977h == 0) {
                        g(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.f48982g = sequentialDisposable;
                    sequentialDisposable.a(this.f48979j.e(refConnection, this.f48977h, this.f48978i));
                }
            }
        }
    }

    void d(RefConnection refConnection) {
        Disposable disposable = refConnection.f48982g;
        if (disposable != null) {
            disposable.dispose();
            refConnection.f48982g = null;
        }
    }

    void e(RefConnection refConnection) {
        ConnectableObservable<T> connectableObservable = this.f48975f;
        if (connectableObservable instanceof Disposable) {
            ((Disposable) connectableObservable).dispose();
        } else if (connectableObservable instanceof ResettableConnectable) {
            ((ResettableConnectable) connectableObservable).b(refConnection.get());
        }
    }

    void f(RefConnection refConnection) {
        synchronized (this) {
            if (this.f48975f instanceof ObservablePublishClassic) {
                RefConnection refConnection2 = this.f48980k;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f48980k = null;
                    d(refConnection);
                }
                long j8 = refConnection.f48983h - 1;
                refConnection.f48983h = j8;
                if (j8 == 0) {
                    e(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.f48980k;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    d(refConnection);
                    long j9 = refConnection.f48983h - 1;
                    refConnection.f48983h = j9;
                    if (j9 == 0) {
                        this.f48980k = null;
                        e(refConnection);
                    }
                }
            }
        }
    }

    void g(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.f48983h == 0 && refConnection == this.f48980k) {
                this.f48980k = null;
                Disposable disposable = refConnection.get();
                DisposableHelper.a(refConnection);
                ConnectableObservable<T> connectableObservable = this.f48975f;
                if (connectableObservable instanceof Disposable) {
                    ((Disposable) connectableObservable).dispose();
                } else if (connectableObservable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.f48985j = true;
                    } else {
                        ((ResettableConnectable) connectableObservable).b(disposable);
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z7;
        Disposable disposable;
        synchronized (this) {
            refConnection = this.f48980k;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f48980k = refConnection;
            }
            long j8 = refConnection.f48983h;
            if (j8 == 0 && (disposable = refConnection.f48982g) != null) {
                disposable.dispose();
            }
            long j9 = j8 + 1;
            refConnection.f48983h = j9;
            z7 = true;
            if (!refConnection.f48984i && j9 == this.f48976g) {
                refConnection.f48984i = true;
            } else {
                z7 = false;
            }
        }
        this.f48975f.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z7) {
            this.f48975f.c(refConnection);
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i8, long j8, TimeUnit timeUnit, Scheduler scheduler) {
        this.f48975f = connectableObservable;
        this.f48976g = i8;
        this.f48977h = j8;
        this.f48978i = timeUnit;
        this.f48979j = scheduler;
    }
}
