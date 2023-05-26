package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: g  reason: collision with root package name */
    final long f49364g;

    /* renamed from: h  reason: collision with root package name */
    final long f49365h;

    /* renamed from: i  reason: collision with root package name */
    final int f49366i;

    /* loaded from: classes5.dex */
    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Observable<T>> f49367f;

        /* renamed from: g  reason: collision with root package name */
        final long f49368g;

        /* renamed from: h  reason: collision with root package name */
        final int f49369h;

        /* renamed from: i  reason: collision with root package name */
        long f49370i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f49371j;

        /* renamed from: k  reason: collision with root package name */
        UnicastSubject<T> f49372k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f49373l;

        WindowExactObserver(Observer<? super Observable<T>> observer, long j8, int i8) {
            this.f49367f = observer;
            this.f49368g = j8;
            this.f49369h = i8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49373l = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49373l;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.f49372k;
            if (unicastSubject != null) {
                this.f49372k = null;
                unicastSubject.onComplete();
            }
            this.f49367f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.f49372k;
            if (unicastSubject != null) {
                this.f49372k = null;
                unicastSubject.onError(th);
            }
            this.f49367f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            UnicastSubject<T> unicastSubject = this.f49372k;
            if (unicastSubject == null && !this.f49373l) {
                unicastSubject = UnicastSubject.f(this.f49369h, this);
                this.f49372k = unicastSubject;
                this.f49367f.onNext(unicastSubject);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t7);
                long j8 = this.f49370i + 1;
                this.f49370i = j8;
                if (j8 >= this.f49368g) {
                    this.f49370i = 0L;
                    this.f49372k = null;
                    unicastSubject.onComplete();
                    if (this.f49373l) {
                        this.f49371j.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49371j, disposable)) {
                this.f49371j = disposable;
                this.f49367f.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f49373l) {
                this.f49371j.dispose();
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super Observable<T>> f49374f;

        /* renamed from: g  reason: collision with root package name */
        final long f49375g;

        /* renamed from: h  reason: collision with root package name */
        final long f49376h;

        /* renamed from: i  reason: collision with root package name */
        final int f49377i;

        /* renamed from: k  reason: collision with root package name */
        long f49379k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f49380l;

        /* renamed from: m  reason: collision with root package name */
        long f49381m;

        /* renamed from: n  reason: collision with root package name */
        Disposable f49382n;

        /* renamed from: o  reason: collision with root package name */
        final AtomicInteger f49383o = new AtomicInteger();

        /* renamed from: j  reason: collision with root package name */
        final ArrayDeque<UnicastSubject<T>> f49378j = new ArrayDeque<>();

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j8, long j9, int i8) {
            this.f49374f = observer;
            this.f49375g = j8;
            this.f49376h = j9;
            this.f49377i = i8;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f49380l = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49380l;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f49378j;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.f49374f.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f49378j;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.f49374f.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t7) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.f49378j;
            long j8 = this.f49379k;
            long j9 = this.f49376h;
            if (j8 % j9 == 0 && !this.f49380l) {
                this.f49383o.getAndIncrement();
                UnicastSubject<T> f8 = UnicastSubject.f(this.f49377i, this);
                arrayDeque.offer(f8);
                this.f49374f.onNext(f8);
            }
            long j10 = this.f49381m + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t7);
            }
            if (j10 >= this.f49375g) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.f49380l) {
                    this.f49382n.dispose();
                    return;
                }
                this.f49381m = j10 - j9;
            } else {
                this.f49381m = j10;
            }
            this.f49379k = j8 + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.l(this.f49382n, disposable)) {
                this.f49382n = disposable;
                this.f49374f.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f49383o.decrementAndGet() == 0 && this.f49380l) {
                this.f49382n.dispose();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j8, long j9, int i8) {
        super(observableSource);
        this.f49364g = j8;
        this.f49365h = j9;
        this.f49366i = i8;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.f49364g == this.f49365h) {
            this.f48232f.subscribe(new WindowExactObserver(observer, this.f49364g, this.f49366i));
        } else {
            this.f48232f.subscribe(new WindowSkipObserver(observer, this.f49364g, this.f49365h, this.f49366i));
        }
    }
}
