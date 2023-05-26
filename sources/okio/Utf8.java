package okio;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utf8.kt */
/* loaded from: classes5.dex */
public final class Utf8 {
    public static final long a(String str, int i8, int i9) {
        boolean z7;
        boolean z8;
        int i10;
        char c8;
        Intrinsics.f(str, "<this>");
        boolean z9 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i9 >= i8) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (i9 > str.length()) {
                    z9 = false;
                }
                if (z9) {
                    long j8 = 0;
                    while (i8 < i9) {
                        char charAt = str.charAt(i8);
                        if (charAt < 128) {
                            j8++;
                        } else {
                            if (charAt < 2048) {
                                i10 = 2;
                            } else if (charAt >= 55296 && charAt <= 57343) {
                                int i11 = i8 + 1;
                                if (i11 < i9) {
                                    c8 = str.charAt(i11);
                                } else {
                                    c8 = 0;
                                }
                                if (charAt <= 56319 && c8 >= 56320 && c8 <= 57343) {
                                    j8 += 4;
                                    i8 += 2;
                                } else {
                                    j8++;
                                    i8 = i11;
                                }
                            } else {
                                i10 = 3;
                            }
                            j8 += i10;
                        }
                        i8++;
                    }
                    return j8;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i9 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i9 + " < " + i8).toString());
        }
        throw new IllegalArgumentException(Intrinsics.n("beginIndex < 0: ", Integer.valueOf(i8)).toString());
    }

    public static /* synthetic */ long b(String str, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        return a(str, i8, i9);
    }
}
