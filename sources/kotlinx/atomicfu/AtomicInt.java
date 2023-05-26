package kotlinx.atomicfu;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.TraceBase;

/* compiled from: AtomicFU.kt */
/* loaded from: classes5.dex */
public final class AtomicInt {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f51198a;

    /* renamed from: b  reason: collision with root package name */
    private final TraceBase f51199b;

    /* renamed from: d  reason: collision with root package name */
    private static final Companion f51197d = new Companion(null);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater<AtomicInt> f51196c = AtomicIntegerFieldUpdater.newUpdater(AtomicInt.class, "a");

    /* compiled from: AtomicFU.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AtomicInt(int i8, TraceBase trace) {
        Intrinsics.f(trace, "trace");
        this.f51199b = trace;
        this.f51198a = i8;
    }

    public final int a() {
        int decrementAndGet = f51196c.decrementAndGet(this);
        TraceBase traceBase = this.f51199b;
        if (traceBase != TraceBase.None.f51204a) {
            traceBase.a("decAndGet():" + decrementAndGet);
        }
        return decrementAndGet;
    }

    public final int b() {
        int incrementAndGet = f51196c.incrementAndGet(this);
        TraceBase traceBase = this.f51199b;
        if (traceBase != TraceBase.None.f51204a) {
            traceBase.a("incAndGet():" + incrementAndGet);
        }
        return incrementAndGet;
    }

    public final void c(int i8) {
        this.f51198a = i8;
        TraceBase traceBase = this.f51199b;
        if (traceBase != TraceBase.None.f51204a) {
            traceBase.a("set(" + i8 + ')');
        }
    }

    public String toString() {
        return String.valueOf(this.f51198a);
    }
}
