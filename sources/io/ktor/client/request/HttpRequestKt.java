package io.ktor.client.request;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequest.kt */
/* loaded from: classes5.dex */
public final class HttpRequestKt {
    public static final boolean a(HttpRequestData httpRequestData) {
        Intrinsics.f(httpRequestData, "<this>");
        return httpRequestData.b() instanceof ClientUpgradeContent;
    }
}
