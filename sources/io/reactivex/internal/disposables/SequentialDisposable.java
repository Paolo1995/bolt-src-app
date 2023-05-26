package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    public SequentialDisposable() {
    }

    public boolean a(Disposable disposable) {
        return DisposableHelper.e(this, disposable);
    }

    public boolean b(Disposable disposable) {
        return DisposableHelper.h(this, disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.c(get());
    }

    public SequentialDisposable(Disposable disposable) {
        lazySet(disposable);
    }
}
