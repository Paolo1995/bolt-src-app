package okio;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: -JvmPlatform.kt */
/* loaded from: classes5.dex */
public final class _JvmPlatformKt {
    public static final byte[] a(String str) {
        Intrinsics.f(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        Intrinsics.f(bArr, "<this>");
        return new String(bArr, Charsets.f51135b);
    }
}
