package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: Executors.kt */
/* loaded from: classes5.dex */
final class ResumeUndispatchedRunnable implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineDispatcher f51328f;

    /* renamed from: g  reason: collision with root package name */
    private final CancellableContinuation<Unit> f51329g;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeUndispatchedRunnable(CoroutineDispatcher coroutineDispatcher, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f51328f = coroutineDispatcher;
        this.f51329g = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f51329g.C(this.f51328f, Unit.f50853a);
    }
}
