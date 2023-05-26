package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;

/* compiled from: UnsignedUtils.kt */
/* loaded from: classes5.dex */
public final class UnsignedKt {
    public static final int a(int i8, int i9) {
        return Intrinsics.h(i8 ^ Integer.MIN_VALUE, i9 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j8, long j9) {
        return Intrinsics.i(j8 ^ Long.MIN_VALUE, j9 ^ Long.MIN_VALUE);
    }

    public static final String c(long j8) {
        return d(j8, 10);
    }

    public static final String d(long j8, int i8) {
        int a8;
        int a9;
        int a10;
        if (j8 >= 0) {
            a10 = CharsKt__CharJVMKt.a(i8);
            String l8 = Long.toString(j8, a10);
            Intrinsics.e(l8, "toString(this, checkRadix(radix))");
            return l8;
        }
        long j9 = i8;
        long j10 = ((j8 >>> 1) / j9) << 1;
        long j11 = j8 - (j10 * j9);
        if (j11 >= j9) {
            j11 -= j9;
            j10++;
        }
        StringBuilder sb = new StringBuilder();
        a8 = CharsKt__CharJVMKt.a(i8);
        String l9 = Long.toString(j10, a8);
        Intrinsics.e(l9, "toString(this, checkRadix(radix))");
        sb.append(l9);
        a9 = CharsKt__CharJVMKt.a(i8);
        String l10 = Long.toString(j11, a9);
        Intrinsics.e(l10, "toString(this, checkRadix(radix))");
        sb.append(l10);
        return sb.toString();
    }
}
