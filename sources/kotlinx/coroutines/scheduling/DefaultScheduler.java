package kotlinx.coroutines.scheduling;

/* compiled from: Dispatcher.kt */
/* loaded from: classes5.dex */
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {

    /* renamed from: n  reason: collision with root package name */
    public static final DefaultScheduler f51952n = new DefaultScheduler();

    private DefaultScheduler() {
        super(TasksKt.f51964b, TasksKt.f51965c, TasksKt.f51966d, "DefaultDispatcher");
    }

    @Override // kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
