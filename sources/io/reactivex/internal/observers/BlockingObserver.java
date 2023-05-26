package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* renamed from: g  reason: collision with root package name */
    public static final Object f47673g = new Object();

    /* renamed from: f  reason: collision with root package name */
    final Queue<Object> f47674f;

    public BlockingObserver(Queue<Object> queue) {
        this.f47674f = queue;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (DisposableHelper.a(this)) {
            this.f47674f.offer(f47673g);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f47674f.offer(NotificationLite.f());
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.f47674f.offer(NotificationLite.j(th));
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        this.f47674f.offer(NotificationLite.q(t7));
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.j(this, disposable);
    }
}
