package io.reactivex.subjects;

import androidx.camera.view.e;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes5.dex */
public final class BehaviorSubject<T> extends Subject<T> {

    /* renamed from: m  reason: collision with root package name */
    private static final Object[] f49898m = new Object[0];

    /* renamed from: n  reason: collision with root package name */
    static final BehaviorDisposable[] f49899n = new BehaviorDisposable[0];

    /* renamed from: o  reason: collision with root package name */
    static final BehaviorDisposable[] f49900o = new BehaviorDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<Object> f49901f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<BehaviorDisposable<T>[]> f49902g;

    /* renamed from: h  reason: collision with root package name */
    final ReadWriteLock f49903h;

    /* renamed from: i  reason: collision with root package name */
    final Lock f49904i;

    /* renamed from: j  reason: collision with root package name */
    final Lock f49905j;

    /* renamed from: k  reason: collision with root package name */
    final AtomicReference<Throwable> f49906k;

    /* renamed from: l  reason: collision with root package name */
    long f49907l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f49908f;

        /* renamed from: g  reason: collision with root package name */
        final BehaviorSubject<T> f49909g;

        /* renamed from: h  reason: collision with root package name */
        boolean f49910h;

        /* renamed from: i  reason: collision with root package name */
        boolean f49911i;

        /* renamed from: j  reason: collision with root package name */
        AppendOnlyLinkedArrayList<Object> f49912j;

        /* renamed from: k  reason: collision with root package name */
        boolean f49913k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f49914l;

        /* renamed from: m  reason: collision with root package name */
        long f49915m;

        BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.f49908f = observer;
            this.f49909g = behaviorSubject;
        }

        void a() {
            boolean z7;
            if (this.f49914l) {
                return;
            }
            synchronized (this) {
                if (this.f49914l) {
                    return;
                }
                if (this.f49910h) {
                    return;
                }
                BehaviorSubject<T> behaviorSubject = this.f49909g;
                Lock lock = behaviorSubject.f49904i;
                lock.lock();
                this.f49915m = behaviorSubject.f49907l;
                Object obj = behaviorSubject.f49901f.get();
                lock.unlock();
                if (obj != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.f49911i = z7;
                this.f49910h = true;
                if (obj == null || test(obj)) {
                    return;
                }
                b();
            }
        }

        void b() {
            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
            while (!this.f49914l) {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.f49912j;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f49911i = false;
                        return;
                    }
                    this.f49912j = null;
                }
                appendOnlyLinkedArrayList.d(this);
            }
        }

        void c(Object obj, long j8) {
            if (this.f49914l) {
                return;
            }
            if (!this.f49913k) {
                synchronized (this) {
                    if (this.f49914l) {
                        return;
                    }
                    if (this.f49915m == j8) {
                        return;
                    }
                    if (this.f49911i) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49912j;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f49912j = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.c(obj);
                        return;
                    }
                    this.f49910h = true;
                    this.f49913k = true;
                }
            }
            test(obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f49914l) {
                this.f49914l = true;
                this.f49909g.i(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f49914l;
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            if (!this.f49914l && !NotificationLite.a(obj, this.f49908f)) {
                return false;
            }
            return true;
        }
    }

    BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f49903h = reentrantReadWriteLock;
        this.f49904i = reentrantReadWriteLock.readLock();
        this.f49905j = reentrantReadWriteLock.writeLock();
        this.f49902g = new AtomicReference<>(f49899n);
        this.f49901f = new AtomicReference<>();
        this.f49906k = new AtomicReference<>();
    }

    public static <T> BehaviorSubject<T> e() {
        return new BehaviorSubject<>();
    }

    public static <T> BehaviorSubject<T> f(T t7) {
        return new BehaviorSubject<>(t7);
    }

    boolean d(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.f49902g.get();
            if (behaviorDisposableArr == f49900o) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[length + 1];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!e.a(this.f49902g, behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    public T g() {
        Object obj = this.f49901f.get();
        if (!NotificationLite.m(obj) && !NotificationLite.p(obj)) {
            return (T) NotificationLite.l(obj);
        }
        return null;
    }

    public boolean h() {
        Object obj = this.f49901f.get();
        if (obj != null && !NotificationLite.m(obj) && !NotificationLite.p(obj)) {
            return true;
        }
        return false;
    }

    void i(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.f49902g.get();
            int length = behaviorDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i8 = -1;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                } else if (behaviorDisposableArr[i9] == behaviorDisposable) {
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
                behaviorDisposableArr2 = f49899n;
            } else {
                BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i8);
                System.arraycopy(behaviorDisposableArr, i8 + 1, behaviorDisposableArr3, i8, (length - i8) - 1);
                behaviorDisposableArr2 = behaviorDisposableArr3;
            }
        } while (!e.a(this.f49902g, behaviorDisposableArr, behaviorDisposableArr2));
    }

    void j(Object obj) {
        this.f49905j.lock();
        this.f49907l++;
        this.f49901f.lazySet(obj);
        this.f49905j.unlock();
    }

    BehaviorDisposable<T>[] k(Object obj) {
        AtomicReference<BehaviorDisposable<T>[]> atomicReference = this.f49902g;
        BehaviorDisposable<T>[] behaviorDisposableArr = f49900o;
        BehaviorDisposable<T>[] andSet = atomicReference.getAndSet(behaviorDisposableArr);
        if (andSet != behaviorDisposableArr) {
            j(obj);
        }
        return andSet;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!e.a(this.f49906k, null, ExceptionHelper.f49808a)) {
            return;
        }
        Object f8 = NotificationLite.f();
        for (BehaviorDisposable<T> behaviorDisposable : k(f8)) {
            behaviorDisposable.c(f8, this.f49907l);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!e.a(this.f49906k, null, th)) {
            RxJavaPlugins.s(th);
            return;
        }
        Object j8 = NotificationLite.j(th);
        for (BehaviorDisposable<T> behaviorDisposable : k(j8)) {
            behaviorDisposable.c(j8, this.f49907l);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        ObjectHelper.e(t7, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f49906k.get() != null) {
            return;
        }
        Object q8 = NotificationLite.q(t7);
        j(q8);
        for (BehaviorDisposable<T> behaviorDisposable : this.f49902g.get()) {
            behaviorDisposable.c(q8, this.f49907l);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f49906k.get() != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable<T> behaviorDisposable = new BehaviorDisposable<>(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (d(behaviorDisposable)) {
            if (behaviorDisposable.f49914l) {
                i(behaviorDisposable);
                return;
            } else {
                behaviorDisposable.a();
                return;
            }
        }
        Throwable th = this.f49906k.get();
        if (th == ExceptionHelper.f49808a) {
            observer.onComplete();
        } else {
            observer.onError(th);
        }
    }

    BehaviorSubject(T t7) {
        this();
        this.f49901f.lazySet(ObjectHelper.e(t7, "defaultValue is null"));
    }
}
