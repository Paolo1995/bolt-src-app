package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class SerializedObserver<T> implements Observer<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    final Observer<? super T> f49836f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f49837g;

    /* renamed from: h  reason: collision with root package name */
    Disposable f49838h;

    /* renamed from: i  reason: collision with root package name */
    boolean f49839i;

    /* renamed from: j  reason: collision with root package name */
    AppendOnlyLinkedArrayList<Object> f49840j;

    /* renamed from: k  reason: collision with root package name */
    volatile boolean f49841k;

    public SerializedObserver(Observer<? super T> observer) {
        this(observer, false);
    }

    void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f49840j;
                if (appendOnlyLinkedArrayList == null) {
                    this.f49839i = false;
                    return;
                }
                this.f49840j = null;
            }
        } while (!appendOnlyLinkedArrayList.a((Observer<? super T>) this.f49836f));
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f49838h.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f49838h.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f49841k) {
            return;
        }
        synchronized (this) {
            if (this.f49841k) {
                return;
            }
            if (this.f49839i) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49840j;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f49840j = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.f());
                return;
            }
            this.f49841k = true;
            this.f49839i = true;
            this.f49836f.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f49841k) {
            RxJavaPlugins.s(th);
            return;
        }
        synchronized (this) {
            boolean z7 = true;
            if (!this.f49841k) {
                if (this.f49839i) {
                    this.f49841k = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49840j;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.f49840j = appendOnlyLinkedArrayList;
                    }
                    Object j8 = NotificationLite.j(th);
                    if (this.f49837g) {
                        appendOnlyLinkedArrayList.c(j8);
                    } else {
                        appendOnlyLinkedArrayList.e(j8);
                    }
                    return;
                }
                this.f49841k = true;
                this.f49839i = true;
                z7 = false;
            }
            if (z7) {
                RxJavaPlugins.s(th);
            } else {
                this.f49836f.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (this.f49841k) {
            return;
        }
        if (t7 == null) {
            this.f49838h.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f49841k) {
                return;
            }
            if (this.f49839i) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49840j;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f49840j = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.q(t7));
                return;
            }
            this.f49839i = true;
            this.f49836f.onNext(t7);
            a();
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.l(this.f49838h, disposable)) {
            this.f49838h = disposable;
            this.f49836f.onSubscribe(this);
        }
    }

    public SerializedObserver(Observer<? super T> observer, boolean z7) {
        this.f49836f = observer;
        this.f49837g = z7;
    }
}
