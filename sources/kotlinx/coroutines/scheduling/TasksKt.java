package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

/* compiled from: Tasks.kt */
/* loaded from: classes5.dex */
public final class TasksKt {

    /* renamed from: a  reason: collision with root package name */
    public static final long f51963a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f51964b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f51965c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f51966d;

    /* renamed from: e  reason: collision with root package name */
    public static SchedulerTimeSource f51967e;

    /* renamed from: f  reason: collision with root package name */
    public static final TaskContext f51968f;

    /* renamed from: g  reason: collision with root package name */
    public static final TaskContext f51969g;

    static {
        long e8;
        int d8;
        int d9;
        int d10;
        long e9;
        e8 = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f51963a = e8;
        d8 = RangesKt___RangesKt.d(SystemPropsKt.a(), 2);
        d9 = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.scheduler.core.pool.size", d8, 1, 0, 8, null);
        f51964b = d9;
        d10 = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f51965c = d10;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e9 = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f51966d = timeUnit.toNanos(e9);
        f51967e = NanoTimeSource.f51953a;
        f51968f = new TaskContextImpl(0);
        f51969g = new TaskContextImpl(1);
    }
}
