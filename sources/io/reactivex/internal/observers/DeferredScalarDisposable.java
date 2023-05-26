package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {

    /* renamed from: f  reason: collision with root package name */
    protected final Observer<? super T> f47679f;

    /* renamed from: g  reason: collision with root package name */
    protected T f47680g;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.f47679f = observer;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int a(int i8) {
        if ((i8 & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final void b() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.f47679f.onComplete();
    }

    public final void c(T t7) {
        int i8 = get();
        if ((i8 & 54) != 0) {
            return;
        }
        Observer<? super T> observer = this.f47679f;
        if (i8 == 8) {
            this.f47680g = t7;
            lazySet(16);
            observer.onNext(null);
        } else {
            lazySet(2);
            observer.onNext(t7);
        }
        if (get() != 4) {
            observer.onComplete();
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.f47680g = null;
    }

    public final void d(Throwable th) {
        if ((get() & 54) != 0) {
            RxJavaPlugins.s(th);
            return;
        }
        lazySet(2);
        this.f47679f.onError(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        set(4);
        this.f47680g = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t7 = this.f47680g;
        this.f47680g = null;
        lazySet(32);
        return t7;
    }
}
