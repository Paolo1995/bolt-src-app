package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: f  reason: collision with root package name */
    final InnerQueuedObserverSupport<T> f47692f;

    /* renamed from: g  reason: collision with root package name */
    final int f47693g;

    /* renamed from: h  reason: collision with root package name */
    SimpleQueue<T> f47694h;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f47695i;

    /* renamed from: j  reason: collision with root package name */
    int f47696j;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i8) {
        this.f47692f = innerQueuedObserverSupport;
        this.f47693g = i8;
    }

    public boolean a() {
        return this.f47695i;
    }

    public SimpleQueue<T> b() {
        return this.f47694h;
    }

    public void c() {
        this.f47695i = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.c(get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f47692f.c(this);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.f47692f.b(this, th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (this.f47696j == 0) {
            this.f47692f.d(this, t7);
        } else {
            this.f47692f.a();
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.j(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int a8 = queueDisposable.a(3);
                if (a8 == 1) {
                    this.f47696j = a8;
                    this.f47694h = queueDisposable;
                    this.f47695i = true;
                    this.f47692f.c(this);
                    return;
                } else if (a8 == 2) {
                    this.f47696j = a8;
                    this.f47694h = queueDisposable;
                    return;
                }
            }
            this.f47694h = QueueDrainHelper.b(-this.f47693g);
        }
    }
}
