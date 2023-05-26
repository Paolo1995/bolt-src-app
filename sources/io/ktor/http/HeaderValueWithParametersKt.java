package io.ktor.http;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: HeaderValueWithParameters.kt */
/* loaded from: classes5.dex */
public final class HeaderValueWithParametersKt {

    /* renamed from: a */
    private static final Set<Character> f46776a;

    static {
        Set<Character> f8;
        f8 = SetsKt__SetsKt.f('(', ')', '<', '>', '@', ',', ';', ':', '\\', '\"', '/', '[', ']', '?', '=', '{', '}', ' ', '\t', '\n', '\r');
        f46776a = f8;
    }

    public static final /* synthetic */ boolean a(String str) {
        return c(str);
    }

    private static final boolean b(String str) {
        char b12;
        char c12;
        int a02;
        int V;
        if (str.length() < 2) {
            return false;
        }
        b12 = StringsKt___StringsKt.b1(str);
        if (b12 == '\"') {
            c12 = StringsKt___StringsKt.c1(str);
            if (c12 == '\"') {
                int i8 = 1;
                do {
                    a02 = StringsKt__StringsKt.a0(str, '\"', i8, false, 4, null);
                    V = StringsKt__StringsKt.V(str);
                    if (a02 == V) {
                        break;
                    }
                    int i9 = 0;
                    for (int i10 = a02 - 1; str.charAt(i10) == '\\'; i10--) {
                        i9++;
                    }
                    if (i9 % 2 == 0) {
                        return false;
                    }
                    i8 = a02 + 1;
                } while (i8 < str.length());
                return true;
            }
        }
        return false;
    }

    public static final boolean c(String str) {
        boolean z7;
        if (str.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return true;
        }
        if (b(str)) {
            return false;
        }
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (f46776a.contains(Character.valueOf(str.charAt(i8)))) {
                return true;
            }
        }
        return false;
    }

    public static final String d(String str) {
        Intrinsics.f(str, "<this>");
        StringBuilder sb = new StringBuilder();
        e(str, sb);
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final void e(String str, StringBuilder sb) {
        sb.append("\"");
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char charAt = str.charAt(i8);
            if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == '\n') {
                sb.append("\\n");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\t') {
                sb.append("\\t");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(charAt);
            }
        }
        sb.append("\"");
    }
}
