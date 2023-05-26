package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Text.kt */
/* loaded from: classes5.dex */
public final class TextKt {
    public static final CaseInsensitiveString a(String str) {
        Intrinsics.f(str, "<this>");
        return new CaseInsensitiveString(str);
    }

    private static final char b(char c8) {
        boolean z7;
        boolean z8 = true;
        if ('A' <= c8 && c8 < '[') {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return (char) (c8 + ' ');
        }
        if (!((c8 < 0 || c8 >= 128) ? false : false)) {
            return Character.toLowerCase(c8);
        }
        return c8;
    }

    public static final String c(String str) {
        int V;
        boolean z7;
        Intrinsics.f(str, "<this>");
        int length = str.length();
        int i8 = 0;
        while (true) {
            if (i8 < length) {
                char charAt = str.charAt(i8);
                if (b(charAt) != charAt) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        if (i8 == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append((CharSequence) str, 0, i8);
        V = StringsKt__StringsKt.V(str);
        if (i8 <= V) {
            while (true) {
                sb.append(b(str.charAt(i8)));
                if (i8 == V) {
                    break;
                }
                i8++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
