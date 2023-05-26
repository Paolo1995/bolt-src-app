package androidx.core.util;

import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void a(boolean z7) {
        if (z7) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void b(boolean z7, @NonNull Object obj) {
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static int c(int i8, int i9, int i10, @NonNull String str) {
        if (i8 >= i9) {
            if (i8 <= i10) {
                return i8;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i9), Integer.valueOf(i10)));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i9), Integer.valueOf(i10)));
    }

    public static int d(int i8) {
        if (i8 >= 0) {
            return i8;
        }
        throw new IllegalArgumentException();
    }

    public static int e(int i8, String str) {
        if (i8 >= 0) {
            return i8;
        }
        throw new IllegalArgumentException(str);
    }

    public static int f(int i8, int i9) {
        if ((i8 & i9) == i8) {
            return i8;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i8) + ", but only 0x" + Integer.toHexString(i9) + " are allowed");
    }

    @NonNull
    public static <T> T g(T t7) {
        t7.getClass();
        return t7;
    }

    @NonNull
    public static <T> T h(T t7, @NonNull Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void i(boolean z7) {
        j(z7, null);
    }

    public static void j(boolean z7, String str) {
        if (z7) {
            return;
        }
        throw new IllegalStateException(str);
    }
}
