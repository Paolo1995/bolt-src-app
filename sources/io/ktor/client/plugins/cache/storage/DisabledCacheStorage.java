package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisabledCacheStorage.kt */
/* loaded from: classes5.dex */
public final class DisabledCacheStorage extends HttpCacheStorage {

    /* renamed from: d  reason: collision with root package name */
    public static final DisabledCacheStorage f46455d = new DisabledCacheStorage();

    private DisabledCacheStorage() {
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public HttpCacheEntry c(Url url, Map<String, String> varyKeys) {
        Intrinsics.f(url, "url");
        Intrinsics.f(varyKeys, "varyKeys");
        return null;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public Set<HttpCacheEntry> d(Url url) {
        Set<HttpCacheEntry> b8;
        Intrinsics.f(url, "url");
        b8 = SetsKt__SetsKt.b();
        return b8;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public void e(Url url, HttpCacheEntry value) {
        Intrinsics.f(url, "url");
        Intrinsics.f(value, "value");
    }
}
