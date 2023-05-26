package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

    /* renamed from: f  reason: collision with root package name */
    final Subject<T> f49928f;

    /* renamed from: g  reason: collision with root package name */
    boolean f49929g;

    /* renamed from: h  reason: collision with root package name */
    AppendOnlyLinkedArrayList<Object> f49930h;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f49931i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SerializedSubject(Subject<T> subject) {
        this.f49928f = subject;
    }

    void d() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f49930h;
                if (appendOnlyLinkedArrayList == null) {
                    this.f49929g = false;
                    return;
                }
                this.f49930h = null;
            }
            appendOnlyLinkedArrayList.d(this);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f49931i) {
            return;
        }
        synchronized (this) {
            if (this.f49931i) {
                return;
            }
            this.f49931i = true;
            if (this.f49929g) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49930h;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f49930h = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.f());
                return;
            }
            this.f49929g = true;
            this.f49928f.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f49931i) {
            RxJavaPlugins.s(th);
            return;
        }
        synchronized (this) {
            boolean z7 = true;
            if (!this.f49931i) {
                this.f49931i = true;
                if (this.f49929g) {
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49930h;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.f49930h = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.e(NotificationLite.j(th));
                    return;
                }
                this.f49929g = true;
                z7 = false;
            }
            if (z7) {
                RxJavaPlugins.s(th);
            } else {
                this.f49928f.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (this.f49931i) {
            return;
        }
        synchronized (this) {
            if (this.f49931i) {
                return;
            }
            if (this.f49929g) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49930h;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f49930h = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.c(NotificationLite.q(t7));
                return;
            }
            this.f49929g = true;
            this.f49928f.onNext(t7);
            d();
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        boolean z7 = true;
        if (!this.f49931i) {
            synchronized (this) {
                if (!this.f49931i) {
                    if (this.f49929g) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f49930h;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f49930h = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.c(NotificationLite.h(disposable));
                        return;
                    }
                    this.f49929g = true;
                    z7 = false;
                }
            }
        }
        if (z7) {
            disposable.dispose();
            return;
        }
        this.f49928f.onSubscribe(disposable);
        d();
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f49928f.subscribe(observer);
    }

    @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        return NotificationLite.c(obj, this.f49928f);
    }
}
