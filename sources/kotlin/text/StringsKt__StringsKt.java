package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: Strings.kt */
/* loaded from: classes5.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    private static final List<String> A0(CharSequence charSequence, String str, boolean z7, int i8) {
        int X;
        List<String> e8;
        boolean z8;
        x0(i8);
        int i9 = 0;
        X = X(charSequence, str, 0, z7);
        if (X != -1 && i8 != 1) {
            if (i8 > 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            int i10 = 10;
            if (z8) {
                i10 = RangesKt___RangesKt.g(i8, 10);
            }
            ArrayList arrayList = new ArrayList(i10);
            do {
                arrayList.add(charSequence.subSequence(i9, X).toString());
                i9 = str.length() + X;
                if (z8 && arrayList.size() == i8 - 1) {
                    break;
                }
                X = X(charSequence, str, i9, z7);
            } while (X != -1);
            arrayList.add(charSequence.subSequence(i9, charSequence.length()).toString());
            return arrayList;
        }
        e8 = CollectionsKt__CollectionsJVMKt.e(charSequence.toString());
        return e8;
    }

    public static /* synthetic */ List B0(CharSequence charSequence, char[] cArr, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z7 = false;
        }
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        return y0(charSequence, cArr, z7, i8);
    }

    public static /* synthetic */ List C0(CharSequence charSequence, String[] strArr, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z7 = false;
        }
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        return z0(charSequence, strArr, z7, i8);
    }

    public static final Sequence<String> D0(final CharSequence charSequence, String[] delimiters, boolean z7, int i8) {
        Sequence<String> v7;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(delimiters, "delimiters");
        v7 = SequencesKt___SequencesKt.v(q0(charSequence, delimiters, 0, z7, i8, 2, null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(IntRange it) {
                Intrinsics.f(it, "it");
                return StringsKt__StringsKt.J0(charSequence, it);
            }
        });
        return v7;
    }

    public static /* synthetic */ Sequence E0(CharSequence charSequence, String[] strArr, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z7 = false;
        }
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        return D0(charSequence, strArr, z7, i8);
    }

    public static final boolean F0(CharSequence charSequence, char c8, boolean z7) {
        Intrinsics.f(charSequence, "<this>");
        if (charSequence.length() <= 0 || !CharsKt__CharKt.d(charSequence.charAt(0), c8, z7)) {
            return false;
        }
        return true;
    }

    public static final boolean G0(CharSequence charSequence, CharSequence prefix, boolean z7) {
        boolean L;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(prefix, "prefix");
        if (!z7 && (charSequence instanceof String) && (prefix instanceof String)) {
            L = StringsKt__StringsJVMKt.L((String) charSequence, (String) prefix, false, 2, null);
            return L;
        }
        return r0(charSequence, 0, prefix, 0, prefix.length(), z7);
    }

    public static /* synthetic */ boolean H0(CharSequence charSequence, char c8, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return F0(charSequence, c8, z7);
    }

    public static /* synthetic */ boolean I0(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return G0(charSequence, charSequence2, z7);
    }

    public static final String J0(CharSequence charSequence, IntRange range) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(range, "range");
        return charSequence.subSequence(range.r().intValue(), range.p().intValue() + 1).toString();
    }

    public static final String K0(String str, char c8, String missingDelimiterValue) {
        int a02;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(missingDelimiterValue, "missingDelimiterValue");
        a02 = a0(str, c8, 0, false, 6, null);
        if (a02 != -1) {
            String substring = str.substring(a02 + 1, str.length());
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static final String L0(String str, String delimiter, String missingDelimiterValue) {
        int b02;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(delimiter, "delimiter");
        Intrinsics.f(missingDelimiterValue, "missingDelimiterValue");
        b02 = b0(str, delimiter, 0, false, 6, null);
        if (b02 != -1) {
            String substring = str.substring(b02 + delimiter.length(), str.length());
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ String M0(String str, char c8, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = str;
        }
        return K0(str, c8, str2);
    }

    public static final boolean N(CharSequence charSequence, char c8, boolean z7) {
        int a02;
        Intrinsics.f(charSequence, "<this>");
        a02 = a0(charSequence, c8, 0, z7, 2, null);
        if (a02 >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ String N0(String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str3 = str;
        }
        return L0(str, str2, str3);
    }

    public static boolean O(CharSequence charSequence, CharSequence other, boolean z7) {
        int b02;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(other, "other");
        if (other instanceof String) {
            b02 = b0(charSequence, (String) other, 0, z7, 2, null);
            if (b02 >= 0) {
                return true;
            }
        } else if (Z(charSequence, other, 0, charSequence.length(), z7, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static final String O0(String str, char c8, String missingDelimiterValue) {
        int g02;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(missingDelimiterValue, "missingDelimiterValue");
        g02 = g0(str, c8, 0, false, 6, null);
        if (g02 != -1) {
            String substring = str.substring(g02 + 1, str.length());
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ boolean P(CharSequence charSequence, char c8, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return N(charSequence, c8, z7);
    }

    public static final String P0(String str, String delimiter, String missingDelimiterValue) {
        int h02;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(delimiter, "delimiter");
        Intrinsics.f(missingDelimiterValue, "missingDelimiterValue");
        h02 = h0(str, delimiter, 0, false, 6, null);
        if (h02 != -1) {
            String substring = str.substring(h02 + delimiter.length(), str.length());
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ boolean Q(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i8, Object obj) {
        boolean O;
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        O = O(charSequence, charSequence2, z7);
        return O;
    }

    public static /* synthetic */ String Q0(String str, char c8, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = str;
        }
        return O0(str, c8, str2);
    }

    public static final boolean R(CharSequence charSequence, CharSequence suffix, boolean z7) {
        boolean v7;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(suffix, "suffix");
        if (!z7 && (charSequence instanceof String) && (suffix instanceof String)) {
            v7 = StringsKt__StringsJVMKt.v((String) charSequence, (String) suffix, false, 2, null);
            return v7;
        }
        return r0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z7);
    }

    public static /* synthetic */ String R0(String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str3 = str;
        }
        return P0(str, str2, str3);
    }

    public static /* synthetic */ boolean S(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return R(charSequence, charSequence2, z7);
    }

    public static final String S0(String str, char c8, String missingDelimiterValue) {
        int a02;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(missingDelimiterValue, "missingDelimiterValue");
        a02 = a0(str, c8, 0, false, 6, null);
        if (a02 != -1) {
            String substring = str.substring(0, a02);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static final Pair<Integer, String> T(CharSequence charSequence, Collection<String> collection, int i8, boolean z7, boolean z8) {
        int V;
        int g8;
        IntProgression l8;
        Object obj;
        Object obj2;
        boolean z9;
        int d8;
        Object s02;
        int h02;
        if (!z7 && collection.size() == 1) {
            s02 = CollectionsKt___CollectionsKt.s0(collection);
            String str = (String) s02;
            if (!z8) {
                h02 = b0(charSequence, str, i8, false, 4, null);
            } else {
                h02 = h0(charSequence, str, i8, false, 4, null);
            }
            if (h02 < 0) {
                return null;
            }
            return TuplesKt.a(Integer.valueOf(h02), str);
        }
        if (!z8) {
            d8 = RangesKt___RangesKt.d(i8, 0);
            l8 = new IntRange(d8, charSequence.length());
        } else {
            V = V(charSequence);
            g8 = RangesKt___RangesKt.g(i8, V);
            l8 = RangesKt___RangesKt.l(g8, 0);
        }
        if (charSequence instanceof String) {
            int g9 = l8.g();
            int i9 = l8.i();
            int k8 = l8.k();
            if ((k8 > 0 && g9 <= i9) || (k8 < 0 && i9 <= g9)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            String str2 = (String) obj2;
                            z9 = StringsKt__StringsJVMKt.z(str2, 0, (String) charSequence, g9, str2.length(), z7);
                            if (z9) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 != null) {
                        return TuplesKt.a(Integer.valueOf(g9), str3);
                    }
                    if (g9 == i9) {
                        break;
                    }
                    g9 += k8;
                }
            }
        } else {
            int g10 = l8.g();
            int i10 = l8.i();
            int k9 = l8.k();
            if ((k9 > 0 && g10 <= i10) || (k9 < 0 && i10 <= g10)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            String str4 = (String) obj;
                            if (r0(str4, 0, charSequence, g10, str4.length(), z7)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 != null) {
                        return TuplesKt.a(Integer.valueOf(g10), str5);
                    }
                    if (g10 == i10) {
                        break;
                    }
                    g10 += k9;
                }
            }
        }
        return null;
    }

    public static final String T0(String str, String delimiter, String missingDelimiterValue) {
        int b02;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(delimiter, "delimiter");
        Intrinsics.f(missingDelimiterValue, "missingDelimiterValue");
        b02 = b0(str, delimiter, 0, false, 6, null);
        if (b02 != -1) {
            String substring = str.substring(0, b02);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static final IntRange U(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static /* synthetic */ String U0(String str, char c8, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = str;
        }
        return S0(str, c8, str2);
    }

    public static int V(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ String V0(String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str3 = str;
        }
        return T0(str, str2, str3);
    }

    public static final int W(CharSequence charSequence, char c8, int i8, boolean z7) {
        Intrinsics.f(charSequence, "<this>");
        if (!z7 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c8, i8);
        }
        return c0(charSequence, new char[]{c8}, i8, z7);
    }

    public static final String W0(String str, String delimiter, String missingDelimiterValue) {
        int h02;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(delimiter, "delimiter");
        Intrinsics.f(missingDelimiterValue, "missingDelimiterValue");
        h02 = h0(str, delimiter, 0, false, 6, null);
        if (h02 != -1) {
            String substring = str.substring(0, h02);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static int X(CharSequence charSequence, String string, int i8, boolean z7) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(string, "string");
        if (!z7 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i8);
        }
        return Z(charSequence, string, i8, charSequence.length(), z7, false, 16, null);
    }

    public static /* synthetic */ String X0(String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str3 = str;
        }
        return W0(str, str2, str3);
    }

    private static final int Y(CharSequence charSequence, CharSequence charSequence2, int i8, int i9, boolean z7, boolean z8) {
        int V;
        int g8;
        int d8;
        IntProgression l8;
        boolean z9;
        int d9;
        int g9;
        if (!z8) {
            d9 = RangesKt___RangesKt.d(i8, 0);
            g9 = RangesKt___RangesKt.g(i9, charSequence.length());
            l8 = new IntRange(d9, g9);
        } else {
            V = V(charSequence);
            g8 = RangesKt___RangesKt.g(i8, V);
            d8 = RangesKt___RangesKt.d(i9, 0);
            l8 = RangesKt___RangesKt.l(g8, d8);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int g10 = l8.g();
            int i10 = l8.i();
            int k8 = l8.k();
            if ((k8 <= 0 || g10 > i10) && (k8 >= 0 || i10 > g10)) {
                return -1;
            }
            while (true) {
                z9 = StringsKt__StringsJVMKt.z((String) charSequence2, 0, (String) charSequence, g10, charSequence2.length(), z7);
                if (z9) {
                    return g10;
                }
                if (g10 != i10) {
                    g10 += k8;
                } else {
                    return -1;
                }
            }
        } else {
            int g11 = l8.g();
            int i11 = l8.i();
            int k9 = l8.k();
            if ((k9 > 0 && g11 <= i11) || (k9 < 0 && i11 <= g11)) {
                while (!r0(charSequence2, 0, charSequence, g11, charSequence2.length(), z7)) {
                    if (g11 != i11) {
                        g11 += k9;
                    } else {
                        return -1;
                    }
                }
                return g11;
            }
            return -1;
        }
    }

    public static CharSequence Y0(CharSequence charSequence) {
        int i8;
        boolean c8;
        Intrinsics.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i9 = 0;
        boolean z7 = false;
        while (i9 <= length) {
            if (!z7) {
                i8 = i9;
            } else {
                i8 = length;
            }
            c8 = CharsKt__CharJVMKt.c(charSequence.charAt(i8));
            if (!z7) {
                if (!c8) {
                    z7 = true;
                } else {
                    i9++;
                }
            } else if (!c8) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i9, length + 1);
    }

    static /* synthetic */ int Z(CharSequence charSequence, CharSequence charSequence2, int i8, int i9, boolean z7, boolean z8, int i10, Object obj) {
        boolean z9;
        if ((i10 & 16) != 0) {
            z9 = false;
        } else {
            z9 = z8;
        }
        return Y(charSequence, charSequence2, i8, i9, z7, z9);
    }

    public static /* synthetic */ int a0(CharSequence charSequence, char c8, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return W(charSequence, c8, i8, z7);
    }

    public static /* synthetic */ int b0(CharSequence charSequence, String str, int i8, boolean z7, int i9, Object obj) {
        int X;
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        X = X(charSequence, str, i8, z7);
        return X;
    }

    public static final int c0(CharSequence charSequence, char[] chars, int i8, boolean z7) {
        int d8;
        int V;
        boolean z8;
        char Y;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(chars, "chars");
        if (!z7 && chars.length == 1 && (charSequence instanceof String)) {
            Y = ArraysKt___ArraysKt.Y(chars);
            return ((String) charSequence).indexOf(Y, i8);
        }
        d8 = RangesKt___RangesKt.d(i8, 0);
        V = V(charSequence);
        IntIterator it = new IntRange(d8, V).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = chars.length;
            int i9 = 0;
            while (true) {
                if (i9 < length) {
                    if (CharsKt__CharKt.d(chars[i9], charAt, z7)) {
                        z8 = true;
                        continue;
                        break;
                    }
                    i9++;
                } else {
                    z8 = false;
                    continue;
                    break;
                }
            }
            if (z8) {
                return nextInt;
            }
        }
        return -1;
    }

    public static /* synthetic */ int d0(CharSequence charSequence, char[] cArr, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return c0(charSequence, cArr, i8, z7);
    }

    public static final int e0(CharSequence charSequence, char c8, int i8, boolean z7) {
        Intrinsics.f(charSequence, "<this>");
        if (!z7 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c8, i8);
        }
        return i0(charSequence, new char[]{c8}, i8, z7);
    }

    public static final int f0(CharSequence charSequence, String string, int i8, boolean z7) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(string, "string");
        if (!z7 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i8);
        }
        return Y(charSequence, string, i8, 0, z7, true);
    }

    public static /* synthetic */ int g0(CharSequence charSequence, char c8, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = V(charSequence);
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return e0(charSequence, c8, i8, z7);
    }

    public static /* synthetic */ int h0(CharSequence charSequence, String str, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = V(charSequence);
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return f0(charSequence, str, i8, z7);
    }

    public static final int i0(CharSequence charSequence, char[] chars, int i8, boolean z7) {
        int V;
        int g8;
        char Y;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(chars, "chars");
        if (!z7 && chars.length == 1 && (charSequence instanceof String)) {
            Y = ArraysKt___ArraysKt.Y(chars);
            return ((String) charSequence).lastIndexOf(Y, i8);
        }
        V = V(charSequence);
        for (g8 = RangesKt___RangesKt.g(i8, V); -1 < g8; g8--) {
            char charAt = charSequence.charAt(g8);
            int length = chars.length;
            boolean z8 = false;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                } else if (CharsKt__CharKt.d(chars[i9], charAt, z7)) {
                    z8 = true;
                    break;
                } else {
                    i9++;
                }
            }
            if (z8) {
                return g8;
            }
        }
        return -1;
    }

    public static final Sequence<String> j0(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        return E0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> k0(CharSequence charSequence) {
        List<String> D;
        Intrinsics.f(charSequence, "<this>");
        D = SequencesKt___SequencesKt.D(j0(charSequence));
        return D;
    }

    public static final CharSequence l0(CharSequence charSequence, int i8, char c8) {
        Intrinsics.f(charSequence, "<this>");
        if (i8 >= 0) {
            if (i8 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i8);
            IntIterator it = new IntRange(1, i8 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb.append(c8);
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i8 + " is less than zero.");
    }

    public static String m0(String str, int i8, char c8) {
        Intrinsics.f(str, "<this>");
        return l0(str, i8, c8).toString();
    }

    private static final Sequence<IntRange> n0(CharSequence charSequence, final char[] cArr, int i8, final boolean z7, int i9) {
        x0(i9);
        return new DelimitedRangesSequence(charSequence, i8, i9, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Pair<Integer, Integer> b(CharSequence $receiver, int i10) {
                Intrinsics.f($receiver, "$this$$receiver");
                int c02 = StringsKt__StringsKt.c0($receiver, cArr, i10, z7);
                if (c02 < 0) {
                    return null;
                }
                return TuplesKt.a(Integer.valueOf(c02), 1);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> s(CharSequence charSequence2, Integer num) {
                return b(charSequence2, num.intValue());
            }
        });
    }

    private static final Sequence<IntRange> o0(CharSequence charSequence, String[] strArr, int i8, final boolean z7, int i9) {
        final List e8;
        x0(i9);
        e8 = ArraysKt___ArraysJvmKt.e(strArr);
        return new DelimitedRangesSequence(charSequence, i8, i9, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Pair<Integer, Integer> b(CharSequence $receiver, int i10) {
                Pair T;
                Intrinsics.f($receiver, "$this$$receiver");
                T = StringsKt__StringsKt.T($receiver, e8, i10, z7, false);
                if (T != null) {
                    return TuplesKt.a(T.d(), Integer.valueOf(((String) T.e()).length()));
                }
                return null;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> s(CharSequence charSequence2, Integer num) {
                return b(charSequence2, num.intValue());
            }
        });
    }

    static /* synthetic */ Sequence p0(CharSequence charSequence, char[] cArr, int i8, boolean z7, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            z7 = false;
        }
        if ((i10 & 8) != 0) {
            i9 = 0;
        }
        return n0(charSequence, cArr, i8, z7, i9);
    }

    static /* synthetic */ Sequence q0(CharSequence charSequence, String[] strArr, int i8, boolean z7, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            z7 = false;
        }
        if ((i10 & 8) != 0) {
            i9 = 0;
        }
        return o0(charSequence, strArr, i8, z7, i9);
    }

    public static final boolean r0(CharSequence charSequence, int i8, CharSequence other, int i9, int i10, boolean z7) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(other, "other");
        if (i9 < 0 || i8 < 0 || i8 > charSequence.length() - i10 || i9 > other.length() - i10) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!CharsKt__CharKt.d(charSequence.charAt(i8 + i11), other.charAt(i9 + i11), z7)) {
                return false;
            }
        }
        return true;
    }

    public static String s0(String str, CharSequence prefix) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(prefix, "prefix");
        if (I0(str, prefix, false, 2, null)) {
            String substring = str.substring(prefix.length());
            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str;
    }

    public static String t0(String str, CharSequence suffix) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(suffix, "suffix");
        if (S(str, suffix, false, 2, null)) {
            String substring = str.substring(0, str.length() - suffix.length());
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static String u0(String str, CharSequence delimiter) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(delimiter, "delimiter");
        return v0(str, delimiter, delimiter);
    }

    public static final String v0(String str, CharSequence prefix, CharSequence suffix) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(prefix, "prefix");
        Intrinsics.f(suffix, "suffix");
        if (str.length() >= prefix.length() + suffix.length() && I0(str, prefix, false, 2, null) && S(str, suffix, false, 2, null)) {
            String substring = str.substring(prefix.length(), str.length() - suffix.length());
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static final CharSequence w0(CharSequence charSequence, int i8, int i9, CharSequence replacement) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(replacement, "replacement");
        if (i9 >= i8) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i8);
            Intrinsics.e(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(charSequence, i9, charSequence.length());
            Intrinsics.e(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i9 + ") is less than start index (" + i8 + ").");
    }

    public static final void x0(int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i8).toString());
    }

    public static final List<String> y0(CharSequence charSequence, char[] delimiters, boolean z7, int i8) {
        Iterable<IntRange> k8;
        int v7;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return A0(charSequence, String.valueOf(delimiters[0]), z7, i8);
        }
        k8 = SequencesKt___SequencesKt.k(p0(charSequence, delimiters, 0, z7, i8, 2, null));
        v7 = CollectionsKt__IterablesKt.v(k8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (IntRange intRange : k8) {
            arrayList.add(J0(charSequence, intRange));
        }
        return arrayList;
    }

    public static final List<String> z0(CharSequence charSequence, String[] delimiters, boolean z7, int i8) {
        Iterable<IntRange> k8;
        int v7;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(delimiters, "delimiters");
        boolean z8 = true;
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                z8 = false;
            }
            if (!z8) {
                return A0(charSequence, str, z7, i8);
            }
        }
        k8 = SequencesKt___SequencesKt.k(q0(charSequence, delimiters, 0, z7, i8, 2, null));
        v7 = CollectionsKt__IterablesKt.v(k8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (IntRange intRange : k8) {
            arrayList.add(J0(charSequence, intRange));
        }
        return arrayList;
    }
}
