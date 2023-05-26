package com.hivemq.client.internal.rx;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

/* loaded from: classes3.dex */
public class CompletableFlow implements Disposable {

    /* renamed from: f  reason: collision with root package name */
    private final CompletableObserver f18641f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f18642g;

    public CompletableFlow(CompletableObserver completableObserver) {
        this.f18641f = completableObserver;
    }

    public boolean a() {
        return isDisposed();
    }

    public void b() {
        this.f18641f.onComplete();
    }

    public void c(Throwable th) {
        this.f18641f.onError(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f18642g = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f18642g;
    }
}
