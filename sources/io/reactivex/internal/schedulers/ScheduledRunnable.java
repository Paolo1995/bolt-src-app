package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes5.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {

    /* renamed from: g  reason: collision with root package name */
    static final Object f49729g = new Object();

    /* renamed from: h  reason: collision with root package name */
    static final Object f49730h = new Object();

    /* renamed from: i  reason: collision with root package name */
    static final Object f49731i = new Object();

    /* renamed from: j  reason: collision with root package name */
    static final Object f49732j = new Object();

    /* renamed from: f  reason: collision with root package name */
    final Runnable f49733f;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.f49733f = runnable;
        lazySet(0, disposableContainer);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f49732j) {
                return;
            }
            if (obj == f49730h) {
                future.cancel(false);
                return;
            } else if (obj == f49731i) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        boolean z7;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f49732j || obj5 == (obj3 = f49730h) || obj5 == (obj4 = f49731i)) {
                break;
            }
            if (get(2) != Thread.currentThread()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z7);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f49732j || obj == (obj2 = f49729g) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((DisposableContainer) obj).c(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Object obj = get(0);
        if (obj != f49729g && obj != f49732j) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.f49733f.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != f49729g) {
                    ((DisposableContainer) obj4).c(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != f49730h) {
                        return;
                    }
                    return;
                } while (!compareAndSet(1, obj5, f49732j));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != f49729g && compareAndSet(0, obj4, f49732j) && obj4 != null) {
            ((DisposableContainer) obj4).c(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != f49730h || obj5 == f49731i) {
                return;
            }
        } while (!compareAndSet(1, obj5, f49732j));
    }
}
