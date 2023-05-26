package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Strings.kt */
/* loaded from: classes5.dex */
public class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static List<String> Z0(CharSequence charSequence, int i8) {
        Intrinsics.f(charSequence, "<this>");
        return g1(charSequence, i8, i8, true);
    }

    public static String a1(String str, int i8) {
        boolean z7;
        int g8;
        Intrinsics.f(str, "<this>");
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            g8 = RangesKt___RangesKt.g(i8, str.length());
            String substring = str.substring(g8);
            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i8 + " is less than zero.").toString());
    }

    public static char b1(CharSequence charSequence) {
        boolean z7;
        Intrinsics.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char c1(CharSequence charSequence) {
        boolean z7;
        int V;
        Intrinsics.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            V = StringsKt__StringsKt.V(charSequence);
            return charSequence.charAt(V);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character d1(CharSequence charSequence) {
        boolean z7;
        Intrinsics.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static char e1(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length != 0) {
            if (length == 1) {
                return charSequence.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String f1(String str, int i8) {
        boolean z7;
        int g8;
        Intrinsics.f(str, "<this>");
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            g8 = RangesKt___RangesKt.g(i8, str.length());
            String substring = str.substring(0, g8);
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i8 + " is less than zero.").toString());
    }

    public static final List<String> g1(CharSequence charSequence, int i8, int i9, boolean z7) {
        Intrinsics.f(charSequence, "<this>");
        return h1(charSequence, i8, i9, z7, new Function1<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$windowed$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(CharSequence it) {
                Intrinsics.f(it, "it");
                return it.toString();
            }
        });
    }

    public static final <R> List<R> h1(CharSequence charSequence, int i8, int i9, boolean z7, Function1<? super CharSequence, ? extends R> transform) {
        int i10;
        boolean z8;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(transform, "transform");
        SlidingWindowKt.a(i8, i9);
        int length = charSequence.length();
        int i11 = length / i9;
        if (length % i9 == 0) {
            i10 = 0;
        } else {
            i10 = 1;
        }
        ArrayList arrayList = new ArrayList(i11 + i10);
        int i12 = 0;
        while (true) {
            if (i12 >= 0 && i12 < length) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (!z8) {
                break;
            }
            int i13 = i12 + i8;
            if (i13 < 0 || i13 > length) {
                if (!z7) {
                    break;
                }
                i13 = length;
            }
            arrayList.add(transform.invoke(charSequence.subSequence(i12, i13)));
            i12 += i9;
        }
        return arrayList;
    }
}
