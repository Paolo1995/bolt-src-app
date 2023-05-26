package kotlin.text;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _OneToManyTitlecaseMappings.kt */
/* loaded from: classes5.dex */
public final class _OneToManyTitlecaseMappingsKt {
    public static final String a(char c8) {
        String valueOf = String.valueOf(c8);
        Intrinsics.d(valueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() > 1) {
            if (c8 != 329) {
                char charAt = upperCase.charAt(0);
                Intrinsics.d(upperCase, "null cannot be cast to non-null type java.lang.String");
                String substring = upperCase.substring(1);
                Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
                Intrinsics.d(substring, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = substring.toLowerCase(locale);
                Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                return charAt + lowerCase;
            }
            return upperCase;
        }
        return String.valueOf(Character.toTitleCase(c8));
    }
}
