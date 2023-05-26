package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: StringOps.kt */
/* loaded from: classes5.dex */
public final class StringOpsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f52444a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f52445b;

    static {
        String[] strArr = new String[93];
        for (int i8 = 0; i8 < 32; i8++) {
            char e8 = e(i8 >> 12);
            char e9 = e(i8 >> 8);
            char e10 = e(i8 >> 4);
            char e11 = e(i8);
            strArr[i8] = "\\u" + e8 + e9 + e10 + e11;
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f52444a = strArr;
        byte[] bArr = new byte[93];
        for (int i9 = 0; i9 < 32; i9++) {
            bArr[i9] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f52445b = bArr;
    }

    public static final byte[] a() {
        return f52445b;
    }

    public static final String[] b() {
        return f52444a;
    }

    public static final void c(StringBuilder sb, String value) {
        Intrinsics.f(sb, "<this>");
        Intrinsics.f(value, "value");
        sb.append('\"');
        int length = value.length();
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            char charAt = value.charAt(i9);
            String[] strArr = f52444a;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb.append((CharSequence) value, i8, i9);
                sb.append(strArr[charAt]);
                i8 = i9 + 1;
            }
        }
        if (i8 != 0) {
            sb.append((CharSequence) value, i8, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    public static final Boolean d(String str) {
        boolean w7;
        boolean w8;
        Intrinsics.f(str, "<this>");
        w7 = StringsKt__StringsJVMKt.w(str, "true", true);
        if (w7) {
            return Boolean.TRUE;
        }
        w8 = StringsKt__StringsJVMKt.w(str, "false", true);
        if (w8) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final char e(int i8) {
        int i9 = i8 & 15;
        return (char) (i9 < 10 ? i9 + 48 : (i9 - 10) + 97);
    }
}
