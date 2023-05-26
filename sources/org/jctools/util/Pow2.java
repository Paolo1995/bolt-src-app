package org.jctools.util;

/* loaded from: classes5.dex */
public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    public static long align(long j8, int i8) {
        int i9;
        if (isPowerOfTwo(i8)) {
            return (j8 + (i8 - 1)) & (~i9);
        }
        throw new IllegalArgumentException("alignment must be a power of 2:" + i8);
    }

    public static boolean isPowerOfTwo(int i8) {
        return (i8 & (i8 + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i8) {
        if (i8 <= 1073741824) {
            if (i8 >= 0) {
                return 1 << (32 - Integer.numberOfLeadingZeros(i8 - 1));
            }
            throw new IllegalArgumentException("Given value:" + i8 + ". Expecting value >= 0.");
        }
        throw new IllegalArgumentException("There is no larger power of 2 int for value:" + i8 + " since it exceeds 2^31.");
    }
}
