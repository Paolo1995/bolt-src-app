package io.netty.util.internal.shaded.org.jctools.util;

/* loaded from: classes5.dex */
public final class RangeUtil {
    public static int checkGreaterThanOrEqual(int i8, int i9, String str) {
        if (i8 >= i9) {
            return i8;
        }
        throw new IllegalArgumentException(str + ": " + i8 + " (expected: >= " + i9 + ')');
    }

    public static int checkLessThan(int i8, int i9, String str) {
        if (i8 < i9) {
            return i8;
        }
        throw new IllegalArgumentException(str + ": " + i8 + " (expected: < " + i9 + ')');
    }

    public static int checkLessThanOrEqual(int i8, long j8, String str) {
        if (i8 <= j8) {
            return i8;
        }
        throw new IllegalArgumentException(str + ": " + i8 + " (expected: <= " + j8 + ')');
    }

    public static long checkPositive(long j8, String str) {
        if (j8 > 0) {
            return j8;
        }
        throw new IllegalArgumentException(str + ": " + j8 + " (expected: > 0)");
    }
}
