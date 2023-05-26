package kotlin.text;

import kotlin.ranges.CharRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Char.kt */
/* loaded from: classes5.dex */
public class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static final boolean d(char c8, char c9, boolean z7) {
        if (c8 == c9) {
            return true;
        }
        if (!z7) {
            return false;
        }
        char upperCase = Character.toUpperCase(c8);
        char upperCase2 = Character.toUpperCase(c9);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static boolean e(char c8) {
        return new CharRange((char) 55296, (char) 57343).m(c8);
    }

    public static String f(char c8) {
        return _OneToManyTitlecaseMappingsKt.a(c8);
    }
}
