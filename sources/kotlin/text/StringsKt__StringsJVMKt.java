package kotlin.text;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.AbstractList;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: StringsJVM.kt */
/* loaded from: classes5.dex */
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static /* synthetic */ boolean A(String str, int i8, String str2, int i9, int i10, boolean z7, int i11, Object obj) {
        boolean z8;
        boolean z9;
        if ((i11 & 16) != 0) {
            z8 = false;
        } else {
            z8 = z7;
        }
        z9 = z(str, i8, str2, i9, i10, z8);
        return z9;
    }

    public static String B(CharSequence charSequence, int i8) {
        boolean z7;
        Intrinsics.f(charSequence, "<this>");
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 == 0) {
                return "";
            }
            if (i8 != 1) {
                int length = charSequence.length();
                if (length == 0) {
                    return "";
                }
                if (length != 1) {
                    StringBuilder sb = new StringBuilder(charSequence.length() * i8);
                    IntIterator it = new IntRange(1, i8).iterator();
                    while (it.hasNext()) {
                        it.nextInt();
                        sb.append(charSequence);
                    }
                    String sb2 = sb.toString();
                    Intrinsics.e(sb2, "{\n                    va…tring()\n                }");
                    return sb2;
                }
                char charAt = charSequence.charAt(0);
                char[] cArr = new char[i8];
                for (int i9 = 0; i9 < i8; i9++) {
                    cArr[i9] = charAt;
                }
                return new String(cArr);
            }
            return charSequence.toString();
        }
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i8 + '.').toString());
    }

    public static final String C(String str, char c8, char c9, boolean z7) {
        Intrinsics.f(str, "<this>");
        if (!z7) {
            String replace = str.replace(c8, c9);
            Intrinsics.e(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i8 = 0; i8 < str.length(); i8++) {
            char charAt = str.charAt(i8);
            if (CharsKt__CharKt.d(charAt, c8, z7)) {
                charAt = c9;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final String D(String str, String oldValue, String newValue, boolean z7) {
        int X;
        int d8;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(oldValue, "oldValue");
        Intrinsics.f(newValue, "newValue");
        int i8 = 0;
        X = StringsKt__StringsKt.X(str, oldValue, 0, z7);
        if (X < 0) {
            return str;
        }
        int length = oldValue.length();
        d8 = RangesKt___RangesKt.d(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i8, X);
                sb.append(newValue);
                i8 = X + length;
                if (X >= str.length()) {
                    break;
                }
                X = StringsKt__StringsKt.X(str, oldValue, X + d8, z7);
            } while (X > 0);
            sb.append((CharSequence) str, i8, str.length());
            String sb2 = sb.toString();
            Intrinsics.e(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String E(String str, char c8, char c9, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return C(str, c8, c9, z7);
    }

    public static /* synthetic */ String F(String str, String str2, String str3, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return D(str, str2, str3, z7);
    }

    public static final String G(String str, String oldValue, String newValue, boolean z7) {
        int b02;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(oldValue, "oldValue");
        Intrinsics.f(newValue, "newValue");
        b02 = StringsKt__StringsKt.b0(str, oldValue, 0, z7, 2, null);
        if (b02 >= 0) {
            return StringsKt__StringsKt.w0(str, b02, oldValue.length() + b02, newValue).toString();
        }
        return str;
    }

    public static /* synthetic */ String H(String str, String str2, String str3, boolean z7, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return G(str, str2, str3, z7);
    }

    public static boolean I(String str, String prefix, int i8, boolean z7) {
        boolean z8;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(prefix, "prefix");
        if (!z7) {
            return str.startsWith(prefix, i8);
        }
        z8 = z(str, i8, prefix, 0, prefix.length(), z7);
        return z8;
    }

    public static boolean J(String str, String prefix, boolean z7) {
        boolean z8;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(prefix, "prefix");
        if (!z7) {
            return str.startsWith(prefix);
        }
        z8 = z(str, 0, prefix, 0, prefix.length(), z7);
        return z8;
    }

    public static /* synthetic */ boolean K(String str, String str2, int i8, boolean z7, int i9, Object obj) {
        boolean I;
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        I = I(str, str2, i8, z7);
        return I;
    }

    public static /* synthetic */ boolean L(String str, String str2, boolean z7, int i8, Object obj) {
        boolean J;
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        J = J(str, str2, z7);
        return J;
    }

    public static String q(char[] cArr) {
        Intrinsics.f(cArr, "<this>");
        return new String(cArr);
    }

    public static String r(char[] cArr, int i8, int i9) {
        Intrinsics.f(cArr, "<this>");
        AbstractList.f50860f.a(i8, i9, cArr.length);
        return new String(cArr, i8, i9 - i8);
    }

    public static String s(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        return new String(bArr, Charsets.f51135b);
    }

    public static byte[] t(String str) {
        Intrinsics.f(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final boolean u(String str, String suffix, boolean z7) {
        boolean z8;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(suffix, "suffix");
        if (!z7) {
            return str.endsWith(suffix);
        }
        z8 = z(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
        return z8;
    }

    public static /* synthetic */ boolean v(String str, String str2, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return u(str, str2, z7);
    }

    public static boolean w(String str, String str2, boolean z7) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z7) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static Comparator<String> x(StringCompanionObject stringCompanionObject) {
        Intrinsics.f(stringCompanionObject, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static boolean y(CharSequence charSequence) {
        boolean c8;
        boolean z7;
        Intrinsics.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            IntRange U = StringsKt__StringsKt.U(charSequence);
            if (!(U instanceof Collection) || !((Collection) U).isEmpty()) {
                Iterator<Integer> it = U.iterator();
                while (it.hasNext()) {
                    c8 = CharsKt__CharJVMKt.c(charSequence.charAt(((IntIterator) it).nextInt()));
                    if (!c8) {
                        z7 = false;
                        break;
                    }
                }
            }
            z7 = true;
            if (!z7) {
                return false;
            }
        }
        return true;
    }

    public static boolean z(String str, int i8, String other, int i9, int i10, boolean z7) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(other, "other");
        if (!z7) {
            return str.regionMatches(i8, other, i9, i10);
        }
        return str.regionMatches(z7, i8, other, i9, i10);
    }
}
