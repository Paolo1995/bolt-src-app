package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLParser.kt */
/* loaded from: classes5.dex */
public final class URLParserException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public URLParserException(String urlString, Throwable cause) {
        super("Fail to parse url: " + urlString, cause);
        Intrinsics.f(urlString, "urlString");
        Intrinsics.f(cause, "cause");
    }
}
