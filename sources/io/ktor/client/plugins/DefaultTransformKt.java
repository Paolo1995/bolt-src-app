package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultTransform.kt */
/* loaded from: classes5.dex */
public final class DefaultTransformKt {
    public static final void a(HttpClient httpClient) {
        Intrinsics.f(httpClient, "<this>");
        httpClient.k().l(HttpRequestPipeline.f46627h.b(), new DefaultTransformKt$defaultTransformers$1(null));
        httpClient.l().l(HttpResponsePipeline.f46667h.a(), new DefaultTransformKt$defaultTransformers$2(null));
        DefaultTransformersJvmKt.b(httpClient);
    }
}
