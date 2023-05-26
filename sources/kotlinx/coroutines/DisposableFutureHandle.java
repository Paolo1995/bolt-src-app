package kotlinx.coroutines;

import java.util.concurrent.Future;

/* compiled from: Executors.kt */
/* loaded from: classes5.dex */
final class DisposableFutureHandle implements DisposableHandle {

    /* renamed from: f  reason: collision with root package name */
    private final Future<?> f51266f;

    public DisposableFutureHandle(Future<?> future) {
        this.f51266f = future;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.f51266f.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f51266f + ']';
    }
}
