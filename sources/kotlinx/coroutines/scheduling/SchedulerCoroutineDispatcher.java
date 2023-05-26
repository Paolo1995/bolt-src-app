package kotlinx.coroutines.scheduling;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: Dispatcher.kt */
/* loaded from: classes5.dex */
public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    /* renamed from: i  reason: collision with root package name */
    private final int f51954i;

    /* renamed from: j  reason: collision with root package name */
    private final int f51955j;

    /* renamed from: k  reason: collision with root package name */
    private final long f51956k;

    /* renamed from: l  reason: collision with root package name */
    private final String f51957l;

    /* renamed from: m  reason: collision with root package name */
    private CoroutineScheduler f51958m;

    public SchedulerCoroutineDispatcher() {
        this(0, 0, 0L, null, 15, null);
    }

    public /* synthetic */ SchedulerCoroutineDispatcher(int i8, int i9, long j8, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? TasksKt.f51964b : i8, (i10 & 2) != 0 ? TasksKt.f51965c : i9, (i10 & 4) != 0 ? TasksKt.f51966d : j8, (i10 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    private final CoroutineScheduler R0() {
        return new CoroutineScheduler(this.f51954i, this.f51955j, this.f51956k, this.f51957l);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void G0(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.j(this.f51958m, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void I0(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.j(this.f51958m, runnable, null, true, 2, null);
    }

    public final void S0(Runnable runnable, TaskContext taskContext, boolean z7) {
        this.f51958m.h(runnable, taskContext, z7);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f51958m.close();
    }

    public SchedulerCoroutineDispatcher(int i8, int i9, long j8, String str) {
        this.f51954i = i8;
        this.f51955j = i9;
        this.f51956k = j8;
        this.f51957l = str;
        this.f51958m = R0();
    }
}
