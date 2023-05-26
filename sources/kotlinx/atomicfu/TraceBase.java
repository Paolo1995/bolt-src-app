package kotlinx.atomicfu;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Trace.common.kt */
/* loaded from: classes5.dex */
public class TraceBase {

    /* compiled from: Trace.common.kt */
    /* loaded from: classes5.dex */
    public static final class None extends TraceBase {

        /* renamed from: a  reason: collision with root package name */
        public static final None f51204a = new None();

        private None() {
        }
    }

    public void a(Object event) {
        Intrinsics.f(event, "event");
    }
}
