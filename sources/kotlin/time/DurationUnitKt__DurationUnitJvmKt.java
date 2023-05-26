package kotlin.time;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DurationUnitJvm.kt */
/* loaded from: classes5.dex */
class DurationUnitKt__DurationUnitJvmKt {
    public static final double a(double d8, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.f(sourceUnit, "sourceUnit");
        Intrinsics.f(targetUnit, "targetUnit");
        long convert = targetUnit.c().convert(1L, sourceUnit.c());
        if (convert > 0) {
            return d8 * convert;
        }
        return d8 / sourceUnit.c().convert(1L, targetUnit.c());
    }

    public static final long b(long j8, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.f(sourceUnit, "sourceUnit");
        Intrinsics.f(targetUnit, "targetUnit");
        return targetUnit.c().convert(j8, sourceUnit.c());
    }

    public static final long c(long j8, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.f(sourceUnit, "sourceUnit");
        Intrinsics.f(targetUnit, "targetUnit");
        return targetUnit.c().convert(j8, sourceUnit.c());
    }
}
