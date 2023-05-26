package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: Executors.kt */
/* loaded from: classes5.dex */
final class DispatcherExecutor implements Executor {

    /* renamed from: f  reason: collision with root package name */
    public final CoroutineDispatcher f51261f;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f51261f.G0(EmptyCoroutineContext.f50912f, runnable);
    }

    public String toString() {
        return this.f51261f.toString();
    }
}
