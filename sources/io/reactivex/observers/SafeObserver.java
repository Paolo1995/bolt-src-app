package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public final class SafeObserver<T> implements Observer<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    final Observer<? super T> f49833f;

    /* renamed from: g  reason: collision with root package name */
    Disposable f49834g;

    /* renamed from: h  reason: collision with root package name */
    boolean f49835h;

    public SafeObserver(Observer<? super T> observer) {
        this.f49833f = observer;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f49833f.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f49833f.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(nullPointerException, th2));
        }
    }

    void b() {
        this.f49835h = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f49833f.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f49833f.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f49834g.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f49834g.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f49835h) {
            return;
        }
        this.f49835h = true;
        if (this.f49834g == null) {
            a();
            return;
        }
        try {
            this.f49833f.onComplete();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f49835h) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f49835h = true;
        if (this.f49834g == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f49833f.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f49833f.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.s(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(new CompositeException(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.f49833f.onError(th);
        } catch (Throwable th4) {
            Exceptions.b(th4);
            RxJavaPlugins.s(new CompositeException(th, th4));
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (this.f49835h) {
            return;
        }
        if (this.f49834g == null) {
            b();
        } else if (t7 == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f49834g.dispose();
                onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(new CompositeException(nullPointerException, th));
            }
        } else {
            try {
                this.f49833f.onNext(t7);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                try {
                    this.f49834g.dispose();
                    onError(th2);
                } catch (Throwable th3) {
                    Exceptions.b(th3);
                    onError(new CompositeException(th2, th3));
                }
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.l(this.f49834g, disposable)) {
            this.f49834g = disposable;
            try {
                this.f49833f.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f49835h = true;
                try {
                    disposable.dispose();
                    RxJavaPlugins.s(th);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.s(new CompositeException(th, th2));
                }
            }
        }
    }
}
