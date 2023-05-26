package io.reactivex.internal.observers;

/* loaded from: classes5.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.f47665f = null;
        this.f47666g = th;
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        this.f47665f = t7;
    }
}
