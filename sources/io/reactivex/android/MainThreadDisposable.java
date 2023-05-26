package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public abstract class MainThreadDisposable implements Disposable {

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f47588f = new AtomicBoolean();

    protected abstract void a();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f47588f.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                AndroidSchedulers.a().d(new Runnable() { // from class: io.reactivex.android.MainThreadDisposable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MainThreadDisposable.this.a();
                    }
                });
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f47588f.get();
    }
}
