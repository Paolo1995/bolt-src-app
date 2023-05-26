package kotlinx.coroutines.scheduling;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Dispatcher.kt */
/* loaded from: classes5.dex */
final class UnlimitedIoScheduler extends CoroutineDispatcher {

    /* renamed from: h  reason: collision with root package name */
    public static final UnlimitedIoScheduler f51970h = new UnlimitedIoScheduler();

    private UnlimitedIoScheduler() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void G0(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.f51952n.S0(runnable, TasksKt.f51969g, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void I0(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.f51952n.S0(runnable, TasksKt.f51969g, true);
    }
}
