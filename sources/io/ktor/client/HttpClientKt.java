package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClient.kt */
/* loaded from: classes5.dex */
public final class HttpClientKt {
    public static final HttpClient a(HttpClientEngine engine, Function1<? super HttpClientConfig<?>, Unit> block) {
        Intrinsics.f(engine, "engine");
        Intrinsics.f(block, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        block.invoke(httpClientConfig);
        return new HttpClient(engine, httpClientConfig, false);
    }
}
