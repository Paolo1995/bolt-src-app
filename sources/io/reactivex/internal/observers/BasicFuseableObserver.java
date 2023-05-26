package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes5.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {

    /* renamed from: f  reason: collision with root package name */
    protected final Observer<? super R> f47660f;

    /* renamed from: g  reason: collision with root package name */
    protected Disposable f47661g;

    /* renamed from: h  reason: collision with root package name */
    protected QueueDisposable<T> f47662h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f47663i;

    /* renamed from: j  reason: collision with root package name */
    protected int f47664j;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.f47660f = observer;
    }

    protected void b() {
    }

    protected boolean c() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.f47662h.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(Throwable th) {
        Exceptions.b(th);
        this.f47661g.dispose();
        onError(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f47661g.dispose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e(int i8) {
        QueueDisposable<T> queueDisposable = this.f47662h;
        if (queueDisposable != null && (i8 & 4) == 0) {
            int a8 = queueDisposable.a(i8);
            if (a8 != 0) {
                this.f47664j = a8;
            }
            return a8;
        }
        return 0;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f47661g.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.f47662h.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r7) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f47663i) {
            return;
        }
        this.f47663i = true;
        this.f47660f.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f47663i) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f47663i = true;
        this.f47660f.onError(th);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.l(this.f47661g, disposable)) {
            this.f47661g = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f47662h = (QueueDisposable) disposable;
            }
            if (c()) {
                this.f47660f.onSubscribe(this);
                b();
            }
        }
    }
}
