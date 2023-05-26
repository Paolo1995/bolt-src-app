package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Url.kt */
/* loaded from: classes5.dex */
public final class UrlKt {
    public static final String a(Url url) {
        Intrinsics.f(url, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(b(url));
        if (url.l() != 0 && url.l() != url.k().d()) {
            sb.append(URLUtilsKt.g(url));
        } else {
            sb.append(url.g());
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String b(Url url) {
        Intrinsics.f(url, "<this>");
        StringBuilder sb = new StringBuilder();
        URLUtilsKt.f(sb, url.f(), url.c());
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
