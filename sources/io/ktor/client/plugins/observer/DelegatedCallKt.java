package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
/* loaded from: classes5.dex */
public final class DelegatedCallKt {
    public static final HttpClientCall a(HttpClientCall httpClientCall, ByteReadChannel content) {
        Intrinsics.f(httpClientCall, "<this>");
        Intrinsics.f(content, "content");
        return new DelegatedCall(httpClientCall.c(), content, httpClientCall);
    }

    public static final HttpResponse b(HttpResponse httpResponse, ByteReadChannel content) {
        Intrinsics.f(httpResponse, "<this>");
        Intrinsics.f(content, "content");
        return new DelegatedResponse(httpResponse.Y(), content, httpResponse);
    }
}
