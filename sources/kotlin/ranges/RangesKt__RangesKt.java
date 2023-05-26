package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Ranges.kt */
/* loaded from: classes5.dex */
public class RangesKt__RangesKt {
    public static final void a(boolean z7, Number step) {
        Intrinsics.f(step, "step");
        if (z7) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    public static ClosedFloatingPointRange<Float> b(float f8, float f9) {
        return new ClosedFloatRange(f8, f9);
    }
}
