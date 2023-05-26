package io.reactivex.internal.operators.observable;

import androidx.camera.view.e;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {

    /* renamed from: p  reason: collision with root package name */
    static final CacheDisposable[] f48377p = new CacheDisposable[0];

    /* renamed from: q  reason: collision with root package name */
    static final CacheDisposable[] f48378q = new CacheDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    final AtomicBoolean f48379g;

    /* renamed from: h  reason: collision with root package name */
    final int f48380h;

    /* renamed from: i  reason: collision with root package name */
    final AtomicReference<CacheDisposable<T>[]> f48381i;

    /* renamed from: j  reason: collision with root package name */
    volatile long f48382j;

    /* renamed from: k  reason: collision with root package name */
    final Node<T> f48383k;

    /* renamed from: l  reason: collision with root package name */
    Node<T> f48384l;

    /* renamed from: m  reason: collision with root package name */
    int f48385m;

    /* renamed from: n  reason: collision with root package name */
    Throwable f48386n;

    /* renamed from: o  reason: collision with root package name */
    volatile boolean f48387o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f48388f;

        /* renamed from: g  reason: collision with root package name */
        final ObservableCache<T> f48389g;

        /* renamed from: h  reason: collision with root package name */
        Node<T> f48390h;

        /* renamed from: i  reason: collision with root package name */
        int f48391i;

        /* renamed from: j  reason: collision with root package name */
        long f48392j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f48393k;

        CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.f48388f = observer;
            this.f48389g = observableCache;
            this.f48390h = observableCache.f48383k;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f48393k) {
                this.f48393k = true;
                this.f48389g.d(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f48393k;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Node<T> {

        /* renamed from: a  reason: collision with root package name */
        final T[] f48394a;

        /* renamed from: b  reason: collision with root package name */
        volatile Node<T> f48395b;

        Node(int i8) {
            this.f48394a = (T[]) new Object[i8];
        }
    }

    public ObservableCache(Observable<T> observable, int i8) {
        super(observable);
        this.f48380h = i8;
        this.f48379g = new AtomicBoolean();
        Node<T> node = new Node<>(i8);
        this.f48383k = node;
        this.f48384l = node;
        this.f48381i = new AtomicReference<>(f48377p);
    }

    void c(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f48381i.get();
            if (cacheDisposableArr == f48378q) {
                return;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!e.a(this.f48381i, cacheDisposableArr, cacheDisposableArr2));
    }

    void d(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f48381i.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i8 = -1;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                } else if (cacheDisposableArr[i9] == cacheDisposable) {
                    i8 = i9;
                    break;
                } else {
                    i9++;
                }
            }
            if (i8 < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = f48377p;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i8);
                System.arraycopy(cacheDisposableArr, i8 + 1, cacheDisposableArr3, i8, (length - i8) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!e.a(this.f48381i, cacheDisposableArr, cacheDisposableArr2));
    }

    void e(CacheDisposable<T> cacheDisposable) {
        boolean z7;
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j8 = cacheDisposable.f48392j;
        int i8 = cacheDisposable.f48391i;
        Node<T> node = cacheDisposable.f48390h;
        Observer<? super T> observer = cacheDisposable.f48388f;
        int i9 = this.f48380h;
        int i10 = 1;
        while (!cacheDisposable.f48393k) {
            boolean z8 = this.f48387o;
            if (this.f48382j == j8) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z8 && z7) {
                cacheDisposable.f48390h = null;
                Throwable th = this.f48386n;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            } else if (!z7) {
                if (i8 == i9) {
                    node = node.f48395b;
                    i8 = 0;
                }
                observer.onNext((Object) node.f48394a[i8]);
                i8++;
                j8++;
            } else {
                cacheDisposable.f48392j = j8;
                cacheDisposable.f48391i = i8;
                cacheDisposable.f48390h = node;
                i10 = cacheDisposable.addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }
        cacheDisposable.f48390h = null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f48387o = true;
        for (CacheDisposable<T> cacheDisposable : this.f48381i.getAndSet(f48378q)) {
            e(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.f48386n = th;
        this.f48387o = true;
        for (CacheDisposable<T> cacheDisposable : this.f48381i.getAndSet(f48378q)) {
            e(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        int i8 = this.f48385m;
        if (i8 == this.f48380h) {
            Node<T> node = new Node<>(i8);
            node.f48394a[0] = t7;
            this.f48385m = 1;
            this.f48384l.f48395b = node;
            this.f48384l = node;
        } else {
            this.f48384l.f48394a[i8] = t7;
            this.f48385m = i8 + 1;
        }
        this.f48382j++;
        for (CacheDisposable<T> cacheDisposable : this.f48381i.get()) {
            e(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(observer, this);
        observer.onSubscribe(cacheDisposable);
        c(cacheDisposable);
        if (!this.f48379g.get() && this.f48379g.compareAndSet(false, true)) {
            this.f48232f.subscribe(this);
        } else {
            e(cacheDisposable);
        }
    }
}
