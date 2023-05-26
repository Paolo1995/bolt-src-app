package kotlin.random;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Random.kt */
/* loaded from: classes5.dex */
public final class RandomKt {
    public static final Random a(long j8) {
        return new XorWowRandom((int) j8, (int) (j8 >> 32));
    }

    public static final String b(Object from, Object until) {
        Intrinsics.f(from, "from");
        Intrinsics.f(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void c(int i8, int i9) {
        boolean z7;
        if (i9 > i8) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(b(Integer.valueOf(i8), Integer.valueOf(i9)).toString());
    }

    public static final void d(long j8, long j9) {
        boolean z7;
        if (j9 > j8) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(b(Long.valueOf(j8), Long.valueOf(j9)).toString());
    }

    public static final int e(int i8) {
        return 31 - Integer.numberOfLeadingZeros(i8);
    }

    public static final int f(int i8, int i9) {
        return (i8 >>> (32 - i9)) & ((-i9) >> 31);
    }
}
