package com.jakewharton.rxrelay2;

import androidx.camera.view.e;
import com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes3.dex */
public final class BehaviorRelay<T> extends Relay<T> {

    /* renamed from: k  reason: collision with root package name */
    private static final Object[] f18940k = new Object[0];

    /* renamed from: l  reason: collision with root package name */
    static final BehaviorDisposable[] f18941l = new BehaviorDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<T> f18942f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<BehaviorDisposable<T>[]> f18943g;

    /* renamed from: h  reason: collision with root package name */
    final Lock f18944h;

    /* renamed from: i  reason: collision with root package name */
    final Lock f18945i;

    /* renamed from: j  reason: collision with root package name */
    long f18946j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<T> {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f18947f;

        /* renamed from: g  reason: collision with root package name */
        final BehaviorRelay<T> f18948g;

        /* renamed from: h  reason: collision with root package name */
        boolean f18949h;

        /* renamed from: i  reason: collision with root package name */
        boolean f18950i;

        /* renamed from: j  reason: collision with root package name */
        AppendOnlyLinkedArrayList<T> f18951j;

        /* renamed from: k  reason: collision with root package name */
        boolean f18952k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f18953l;

        /* renamed from: m  reason: collision with root package name */
        long f18954m;

        BehaviorDisposable(Observer<? super T> observer, BehaviorRelay<T> behaviorRelay) {
            this.f18947f = observer;
            this.f18948g = behaviorRelay;
        }

        void a() {
            boolean z7;
            if (this.f18953l) {
                return;
            }
            synchronized (this) {
                if (this.f18953l) {
                    return;
                }
                if (this.f18949h) {
                    return;
                }
                BehaviorRelay<T> behaviorRelay = this.f18948g;
                Lock lock = behaviorRelay.f18944h;
                lock.lock();
                this.f18954m = behaviorRelay.f18946j;
                T t7 = behaviorRelay.f18942f.get();
                lock.unlock();
                if (t7 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.f18950i = z7;
                this.f18949h = true;
                if (t7 != null) {
                    test(t7);
                    b();
                }
            }
        }

        void b() {
            AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList;
            while (!this.f18953l) {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.f18951j;
                    if (appendOnlyLinkedArrayList == null) {
                        this.f18950i = false;
                        return;
                    }
                    this.f18951j = null;
                }
                appendOnlyLinkedArrayList.c(this);
            }
        }

        void c(T t7, long j8) {
            if (this.f18953l) {
                return;
            }
            if (!this.f18952k) {
                synchronized (this) {
                    if (this.f18953l) {
                        return;
                    }
                    if (this.f18954m == j8) {
                        return;
                    }
                    if (this.f18950i) {
                        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList = this.f18951j;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f18951j = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.b(t7);
                        return;
                    }
                    this.f18949h = true;
                    this.f18952k = true;
                }
            }
            test(t7);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.f18953l) {
                this.f18953l = true;
                this.f18948g.h(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f18953l;
        }

        @Override // com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(T t7) {
            if (!this.f18953l) {
                this.f18947f.onNext(t7);
                return false;
            }
            return false;
        }
    }

    BehaviorRelay() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f18944h = reentrantReadWriteLock.readLock();
        this.f18945i = reentrantReadWriteLock.writeLock();
        this.f18943g = new AtomicReference<>(f18941l);
        this.f18942f = new AtomicReference<>();
    }

    public static <T> BehaviorRelay<T> e() {
        return new BehaviorRelay<>();
    }

    public static <T> BehaviorRelay<T> f(T t7) {
        return new BehaviorRelay<>(t7);
    }

    @Override // com.jakewharton.rxrelay2.Relay, io.reactivex.functions.Consumer
    public void accept(T t7) {
        if (t7 != null) {
            i(t7);
            for (BehaviorDisposable<T> behaviorDisposable : this.f18943g.get()) {
                behaviorDisposable.c(t7, this.f18946j);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    void d(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.f18943g.get();
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[length + 1];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!e.a(this.f18943g, behaviorDisposableArr, behaviorDisposableArr2));
    }

    public T g() {
        return this.f18942f.get();
    }

    void h(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.f18943g.get();
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
                behaviorDisposableArr2 = f18941l;
            } else {
                BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i8);
                System.arraycopy(behaviorDisposableArr, i8 + 1, behaviorDisposableArr3, i8, (length - i8) - 1);
                behaviorDisposableArr2 = behaviorDisposableArr3;
            }
        } while (!e.a(this.f18943g, behaviorDisposableArr, behaviorDisposableArr2));
    }

    void i(T t7) {
        this.f18945i.lock();
        this.f18946j++;
        this.f18942f.lazySet(t7);
        this.f18945i.unlock();
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable<T> behaviorDisposable = new BehaviorDisposable<>(observer, this);
        observer.onSubscribe(behaviorDisposable);
        d(behaviorDisposable);
        if (behaviorDisposable.f18953l) {
            h(behaviorDisposable);
        } else {
            behaviorDisposable.a();
        }
    }

    BehaviorRelay(T t7) {
        this();
        if (t7 != null) {
            this.f18942f.lazySet(t7);
            return;
        }
        throw new NullPointerException("defaultValue == null");
    }
}
