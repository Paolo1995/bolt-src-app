package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.EndConsumerHelper;

/* loaded from: classes5.dex */
public abstract class DefaultObserver<T> implements Observer<T> {

    /* renamed from: f  reason: collision with root package name */
    private Disposable f49831f;

    protected void a() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.d(this.f49831f, disposable, getClass())) {
            this.f49831f = disposable;
            a();
        }
    }
}
