package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

/* loaded from: classes5.dex */
public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {

    /* renamed from: g  reason: collision with root package name */
    protected final Observer<? super V> f47701g;

    /* renamed from: h  reason: collision with root package name */
    protected final SimplePlainQueue<U> f47702h;

    /* renamed from: i  reason: collision with root package name */
    protected volatile boolean f47703i;

    /* renamed from: j  reason: collision with root package name */
    protected volatile boolean f47704j;

    /* renamed from: k  reason: collision with root package name */
    protected Throwable f47705k;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.f47701g = observer;
        this.f47702h = simplePlainQueue;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void a(Observer<? super V> observer, U u7) {
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int b(int i8) {
        return this.f47706f.addAndGet(i8);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean c() {
        return this.f47704j;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean d() {
        return this.f47703i;
    }

    public final boolean e() {
        if (this.f47706f.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this.f47706f.get() == 0 && this.f47706f.compareAndSet(0, 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(U u7, boolean z7, Disposable disposable) {
        Observer<? super V> observer = this.f47701g;
        SimplePlainQueue<U> simplePlainQueue = this.f47702h;
        if (this.f47706f.get() == 0 && this.f47706f.compareAndSet(0, 1)) {
            a(observer, u7);
            if (b(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u7);
            if (!e()) {
                return;
            }
        }
        QueueDrainHelper.c(simplePlainQueue, observer, z7, disposable, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(U u7, boolean z7, Disposable disposable) {
        Observer<? super V> observer = this.f47701g;
        SimplePlainQueue<U> simplePlainQueue = this.f47702h;
        if (this.f47706f.get() == 0 && this.f47706f.compareAndSet(0, 1)) {
            if (simplePlainQueue.isEmpty()) {
                a(observer, u7);
                if (b(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u7);
            }
        } else {
            simplePlainQueue.offer(u7);
            if (!e()) {
                return;
            }
        }
        QueueDrainHelper.c(simplePlainQueue, observer, z7, disposable, this);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final Throwable i() {
        return this.f47705k;
    }
}
