package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* loaded from: classes5.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static float c(float f8, float f9) {
        return f8 < f9 ? f9 : f8;
    }

    public static int d(int i8, int i9) {
        return i8 < i9 ? i9 : i8;
    }

    public static long e(long j8, long j9) {
        return j8 < j9 ? j9 : j8;
    }

    public static float f(float f8, float f9) {
        return f8 > f9 ? f9 : f8;
    }

    public static int g(int i8, int i9) {
        return i8 > i9 ? i9 : i8;
    }

    public static long h(long j8, long j9) {
        return j8 > j9 ? j9 : j8;
    }

    public static float i(float f8, float f9, float f10) {
        if (f9 <= f10) {
            if (f8 < f9) {
                return f9;
            }
            if (f8 > f10) {
                return f10;
            }
            return f8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f10 + " is less than minimum " + f9 + '.');
    }

    public static int j(int i8, int i9, int i10) {
        if (i9 <= i10) {
            if (i8 < i9) {
                return i9;
            }
            if (i8 > i10) {
                return i10;
            }
            return i8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i10 + " is less than minimum " + i9 + '.');
    }

    public static long k(long j8, long j9, long j10) {
        if (j9 <= j10) {
            if (j8 < j9) {
                return j9;
            }
            if (j8 > j10) {
                return j10;
            }
            return j8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j10 + " is less than minimum " + j9 + '.');
    }

    public static IntProgression l(int i8, int i9) {
        return IntProgression.f51051i.a(i8, i9, -1);
    }

    public static IntProgression m(IntProgression intProgression) {
        Intrinsics.f(intProgression, "<this>");
        return IntProgression.f51051i.a(intProgression.i(), intProgression.g(), -intProgression.k());
    }

    public static IntProgression n(IntProgression intProgression, int i8) {
        boolean z7;
        Intrinsics.f(intProgression, "<this>");
        if (i8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        RangesKt__RangesKt.a(z7, Integer.valueOf(i8));
        IntProgression.Companion companion = IntProgression.f51051i;
        int g8 = intProgression.g();
        int i9 = intProgression.i();
        if (intProgression.k() <= 0) {
            i8 = -i8;
        }
        return companion.a(g8, i9, i8);
    }

    public static IntRange o(int i8, int i9) {
        if (i9 <= Integer.MIN_VALUE) {
            return IntRange.f51059j.a();
        }
        return new IntRange(i8, i9 - 1);
    }
}
