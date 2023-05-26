package io.netty.util.internal.shaded.org.jctools.util;

/* loaded from: classes5.dex */
public final class Pow2 {
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
