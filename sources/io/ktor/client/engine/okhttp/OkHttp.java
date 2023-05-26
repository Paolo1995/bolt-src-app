package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OkHttp.kt */
/* loaded from: classes5.dex */
public final class OkHttp implements HttpClientEngineFactory<OkHttpConfig> {

    /* renamed from: a  reason: collision with root package name */
    public static final OkHttp f46144a = new OkHttp();

    private OkHttp() {
    }

    @Override // io.ktor.client.engine.HttpClientEngineFactory
    public HttpClientEngine a(Function1<? super OkHttpConfig, Unit> block) {
        Intrinsics.f(block, "block");
        OkHttpConfig okHttpConfig = new OkHttpConfig();
        block.invoke(okHttpConfig);
        return new OkHttpEngine(okHttpConfig);
    }
}
