package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLProtocol.kt */
/* loaded from: classes5.dex */
public final class URLProtocolKt {
    public static final boolean a(URLProtocol uRLProtocol) {
        Intrinsics.f(uRLProtocol, "<this>");
        if (!Intrinsics.a(uRLProtocol.e(), "https") && !Intrinsics.a(uRLProtocol.e(), "wss")) {
            return false;
        }
        return true;
    }

    public static final boolean b(URLProtocol uRLProtocol) {
        Intrinsics.f(uRLProtocol, "<this>");
        if (!Intrinsics.a(uRLProtocol.e(), "ws") && !Intrinsics.a(uRLProtocol.e(), "wss")) {
            return false;
        }
        return true;
    }
}
