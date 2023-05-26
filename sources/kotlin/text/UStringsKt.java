package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Settings;

/* compiled from: UStrings.kt */
/* loaded from: classes5.dex */
public final class UStringsKt {
    public static final byte a(String str) {
        Intrinsics.f(str, "<this>");
        UByte b8 = b(str);
        if (b8 != null) {
            return b8.j();
        }
        StringsKt__StringNumberConversionsKt.l(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte b(String str) {
        Intrinsics.f(str, "<this>");
        return c(str, 10);
    }

    public static final UByte c(String str, int i8) {
        int compare;
        Intrinsics.f(str, "<this>");
        UInt f8 = f(str, i8);
        if (f8 == null) {
            return null;
        }
        int j8 = f8.j();
        compare = Integer.compare(j8 ^ Integer.MIN_VALUE, UInt.c(255) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return UByte.a(UByte.c((byte) j8));
    }

    public static final int d(String str) {
        Intrinsics.f(str, "<this>");
        UInt e8 = e(str);
        if (e8 != null) {
            return e8.j();
        }
        StringsKt__StringNumberConversionsKt.l(str);
        throw new KotlinNothingValueException();
    }

    public static final UInt e(String str) {
        Intrinsics.f(str, "<this>");
        return f(str, 10);
    }

    public static final UInt f(String str, int i8) {
        int compare;
        int compare2;
        int compare3;
        Intrinsics.f(str, "<this>");
        CharsKt__CharJVMKt.a(i8);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char charAt = str.charAt(0);
        int i10 = 1;
        if (Intrinsics.h(charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i10 = 0;
        }
        int c8 = UInt.c(i8);
        int i11 = 119304647;
        while (i10 < length) {
            int b8 = CharsKt__CharJVMKt.b(str.charAt(i10), i8);
            if (b8 < 0) {
                return null;
            }
            compare = Integer.compare(i9 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                if (i11 == 119304647) {
                    i11 = d.a(-1, c8);
                    compare3 = Integer.compare(i9 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            int c9 = UInt.c(i9 * c8);
            int c10 = UInt.c(UInt.c(b8) + c9);
            compare2 = Integer.compare(c10 ^ Integer.MIN_VALUE, c9 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i10++;
            i9 = c10;
        }
        return UInt.a(i9);
    }

    public static final long g(String str) {
        Intrinsics.f(str, "<this>");
        ULong h8 = h(str);
        if (h8 != null) {
            return h8.j();
        }
        StringsKt__StringNumberConversionsKt.l(str);
        throw new KotlinNothingValueException();
    }

    public static final ULong h(String str) {
        Intrinsics.f(str, "<this>");
        return i(str, 10);
    }

    public static final ULong i(String str, int i8) {
        int b8;
        int compare;
        int compare2;
        int compare3;
        Intrinsics.f(str, "<this>");
        CharsKt__CharJVMKt.a(i8);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        long j8 = -1;
        int i9 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.h(charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i9 = 1;
        }
        long c8 = ULong.c(i8);
        long j9 = 0;
        long j10 = 512409557603043100L;
        while (i9 < length) {
            if (CharsKt__CharJVMKt.b(str.charAt(i9), i8) < 0) {
                return null;
            }
            compare = Long.compare(j9 ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
            if (compare > 0) {
                if (j10 == 512409557603043100L) {
                    j10 = c.a(j8, c8);
                    compare3 = Long.compare(j9 ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            long c9 = ULong.c(j9 * c8);
            long c10 = ULong.c(ULong.c(UInt.c(b8) & 4294967295L) + c9);
            compare2 = Long.compare(c10 ^ Long.MIN_VALUE, c9 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i9++;
            j9 = c10;
            j8 = -1;
        }
        return ULong.a(j9);
    }

    public static final short j(String str) {
        Intrinsics.f(str, "<this>");
        UShort k8 = k(str);
        if (k8 != null) {
            return k8.j();
        }
        StringsKt__StringNumberConversionsKt.l(str);
        throw new KotlinNothingValueException();
    }

    public static final UShort k(String str) {
        Intrinsics.f(str, "<this>");
        return l(str, 10);
    }

    public static final UShort l(String str, int i8) {
        int compare;
        Intrinsics.f(str, "<this>");
        UInt f8 = f(str, i8);
        if (f8 == null) {
            return null;
        }
        int j8 = f8.j();
        compare = Integer.compare(j8 ^ Integer.MIN_VALUE, UInt.c(Settings.DEFAULT_INITIAL_WINDOW_SIZE) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return UShort.a(UShort.c((short) j8));
    }
}
