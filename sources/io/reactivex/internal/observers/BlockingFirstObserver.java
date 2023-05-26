package io.reactivex.internal.observers;

/* loaded from: classes5.dex */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f47665f == null) {
            this.f47666g = th;
        }
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t7) {
        if (this.f47665f == null) {
            this.f47665f = t7;
            this.f47667h.dispose();
            countDown();
        }
    }
}
