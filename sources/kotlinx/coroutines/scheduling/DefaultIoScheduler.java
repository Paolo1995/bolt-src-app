package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

/* compiled from: Dispatcher.kt */
/* loaded from: classes5.dex */
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {

    /* renamed from: i  reason: collision with root package name */
    public static final DefaultIoScheduler f51950i = new DefaultIoScheduler();

    /* renamed from: j  reason: collision with root package name */
    private static final CoroutineDispatcher f51951j;

    static {
        int d8;
        int d9;
        UnlimitedIoScheduler unlimitedIoScheduler = UnlimitedIoScheduler.f51970h;
        d8 = RangesKt___RangesKt.d(64, SystemPropsKt.a());
        d9 = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.io.parallelism", d8, 0, 0, 12, null);
        f51951j = unlimitedIoScheduler.P0(d9);
    }

    private DefaultIoScheduler() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void G0(CoroutineContext coroutineContext, Runnable runnable) {
        f51951j.G0(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void I0(CoroutineContext coroutineContext, Runnable runnable) {
        f51951j.I0(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher P0(int i8) {
        return UnlimitedIoScheduler.f51970h.P0(i8);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        G0(EmptyCoroutineContext.f50912f, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.IO";
    }
}
