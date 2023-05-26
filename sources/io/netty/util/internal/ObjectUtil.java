package io.netty.util.internal;

/* loaded from: classes5.dex */
public final class ObjectUtil {
    private ObjectUtil() {
    }

    public static <T> T checkNotNull(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }

    public static int checkPositive(int i8, String str) {
        if (i8 > 0) {
            return i8;
        }
        throw new IllegalArgumentException(str + ": " + i8 + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i8, String str) {
        if (i8 >= 0) {
            return i8;
        }
        throw new IllegalArgumentException(str + ": " + i8 + " (expected: >= 0)");
    }

    public static long checkPositiveOrZero(long j8, String str) {
        if (j8 >= 0) {
            return j8;
        }
        throw new IllegalArgumentException(str + ": " + j8 + " (expected: >= 0)");
    }
}
