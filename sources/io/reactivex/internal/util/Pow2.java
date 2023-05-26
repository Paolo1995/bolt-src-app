package io.reactivex.internal.util;

/* loaded from: classes5.dex */
public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static int a(int i8) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i8 - 1));
    }
}
