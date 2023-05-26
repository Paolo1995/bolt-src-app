package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Charset.kt */
/* loaded from: classes5.dex */
public final class CharsetKt {
    public static final boolean a(char c8) {
        if (Character.toLowerCase(c8) == c8) {
            return true;
        }
        return false;
    }

    public static final char[] b(String str) {
        Intrinsics.f(str, "<this>");
        int length = str.length();
        char[] cArr = new char[length];
        for (int i8 = 0; i8 < length; i8++) {
            cArr[i8] = str.charAt(i8);
        }
        return cArr;
    }
}
