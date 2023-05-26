package io.ktor.http;

import kotlin.text.StringsKt__StringsKt;

/* compiled from: HttpHeaders.kt */
/* loaded from: classes5.dex */
public final class HttpHeadersKt {
    public static final /* synthetic */ boolean a(char c8) {
        return b(c8);
    }

    public static final boolean b(char c8) {
        boolean P;
        P = StringsKt__StringsKt.P("\"(),/:;<=>?@[\\]{}", c8, false, 2, null);
        return P;
    }
}
