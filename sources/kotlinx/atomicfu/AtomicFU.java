package kotlinx.atomicfu;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.TraceBase;

/* compiled from: AtomicFU.kt */
/* loaded from: classes5.dex */
public final class AtomicFU {
    public static final AtomicBoolean a(boolean z7) {
        return b(z7, TraceBase.None.f51204a);
    }

    public static final AtomicBoolean b(boolean z7, TraceBase trace) {
        Intrinsics.f(trace, "trace");
        return new AtomicBoolean(z7, trace);
    }

    public static final AtomicInt c(int i8) {
        return d(i8, TraceBase.None.f51204a);
    }

    public static final AtomicInt d(int i8, TraceBase trace) {
        Intrinsics.f(trace, "trace");
        return new AtomicInt(i8, trace);
    }

    public static final <T> AtomicRef<T> e(T t7) {
        return f(t7, TraceBase.None.f51204a);
    }

    public static final <T> AtomicRef<T> f(T t7, TraceBase trace) {
        Intrinsics.f(trace, "trace");
        return new AtomicRef<>(t7, trace);
    }
}
