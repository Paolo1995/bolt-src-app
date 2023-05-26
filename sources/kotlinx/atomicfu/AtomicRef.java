package kotlinx.atomicfu;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.TraceBase;

/* compiled from: AtomicFU.kt */
/* loaded from: classes5.dex */
public final class AtomicRef<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile T f51202a;

    /* renamed from: b  reason: collision with root package name */
    private final TraceBase f51203b;

    /* renamed from: d  reason: collision with root package name */
    private static final Companion f51201d = new Companion(null);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<AtomicRef<?>, Object> f51200c = AtomicReferenceFieldUpdater.newUpdater(AtomicRef.class, Object.class, "a");

    /* compiled from: AtomicFU.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AtomicRef(T t7, TraceBase trace) {
        Intrinsics.f(trace, "trace");
        this.f51203b = trace;
        this.f51202a = t7;
    }

    public final T a(T t7) {
        T t8 = (T) f51200c.getAndSet(this, t7);
        TraceBase traceBase = this.f51203b;
        if (traceBase != TraceBase.None.f51204a) {
            traceBase.a("getAndSet(" + t7 + "):" + t8);
        }
        return t8;
    }

    public final T b() {
        return this.f51202a;
    }

    public final void c(T t7) {
        this.f51202a = t7;
        TraceBase traceBase = this.f51203b;
        if (traceBase != TraceBase.None.f51204a) {
            traceBase.a("set(" + t7 + ')');
        }
    }

    public String toString() {
        return String.valueOf(this.f51202a);
    }
}
