package kotlinx.atomicfu;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.TraceBase;

/* compiled from: AtomicFU.kt */
/* loaded from: classes5.dex */
public final class AtomicBoolean {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f51194a;

    /* renamed from: b  reason: collision with root package name */
    private final TraceBase f51195b;

    /* renamed from: d  reason: collision with root package name */
    private static final Companion f51193d = new Companion(null);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater<AtomicBoolean> f51192c = AtomicIntegerFieldUpdater.newUpdater(AtomicBoolean.class, "a");

    /* compiled from: AtomicFU.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AtomicBoolean(boolean z7, TraceBase trace) {
        Intrinsics.f(trace, "trace");
        this.f51195b = trace;
        this.f51194a = z7 ? 1 : 0;
    }

    public final boolean a(boolean z7, boolean z8) {
        TraceBase traceBase;
        boolean compareAndSet = f51192c.compareAndSet(this, z7 ? 1 : 0, z8 ? 1 : 0);
        if (compareAndSet && (traceBase = this.f51195b) != TraceBase.None.f51204a) {
            traceBase.a("CAS(" + z7 + ", " + z8 + ')');
        }
        return compareAndSet;
    }

    public final boolean b() {
        if (this.f51194a != 0) {
            return true;
        }
        return false;
    }

    public final void c(boolean z7) {
        this.f51194a = z7 ? 1 : 0;
        TraceBase traceBase = this.f51195b;
        if (traceBase != TraceBase.None.f51204a) {
            traceBase.a("set(" + z7 + ')');
        }
    }

    public String toString() {
        return String.valueOf(b());
    }
}
