package io.ktor.client.engine;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.util.AttributeKey;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;

/* compiled from: HttpClientEngineCapability.kt */
/* loaded from: classes5.dex */
public final class HttpClientEngineCapabilityKt {

    /* renamed from: a  reason: collision with root package name */
    private static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> f46128a = new AttributeKey<>("EngineCapabilities");

    /* renamed from: b  reason: collision with root package name */
    private static final Set<HttpTimeout.Plugin> f46129b;

    static {
        Set<HttpTimeout.Plugin> a8;
        a8 = SetsKt__SetsJVMKt.a(HttpTimeout.f46390d);
        f46129b = a8;
    }

    public static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> a() {
        return f46128a;
    }
}
