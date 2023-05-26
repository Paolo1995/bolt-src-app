package io.netty.util.internal;

import org.jctools.util.Pow2;

/* loaded from: classes5.dex */
public final class MathUtil {
    private MathUtil() {
    }

    public static int findNextPositivePowerOfTwo(int i8) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i8 - 1));
    }

    public static boolean isOutOfBounds(int i8, int i9, int i10) {
        int i11 = i8 | i9;
        int i12 = i8 + i9;
        return ((i11 | i12) | (i10 - i12)) < 0;
    }

    public static int safeFindNextPositivePowerOfTwo(int i8) {
        if (i8 <= 0) {
            return 1;
        }
        if (i8 >= 1073741824) {
            return Pow2.MAX_POW2;
        }
        return findNextPositivePowerOfTwo(i8);
    }
}
