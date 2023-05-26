package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.collections.ConcurrentSetKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnlimitedCacheStorage.kt */
/* loaded from: classes5.dex */
public final class UnlimitedCacheStorage extends HttpCacheStorage {

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentMap<Url, Set<HttpCacheEntry>> f46464d = new ConcurrentMap<>(0, 1, null);

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public HttpCacheEntry c(Url url, Map<String, String> varyKeys) {
        Object obj;
        Intrinsics.f(url, "url");
        Intrinsics.f(varyKeys, "varyKeys");
        Iterator<T> it = this.f46464d.b(url, new Function0<Set<HttpCacheEntry>>() { // from class: io.ktor.client.plugins.cache.storage.UnlimitedCacheStorage$find$data$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Set<HttpCacheEntry> invoke() {
                return ConcurrentSetKt.a();
            }
        }).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.a(((HttpCacheEntry) obj).e(), varyKeys)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (HttpCacheEntry) obj;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public Set<HttpCacheEntry> d(Url url) {
        Set<HttpCacheEntry> b8;
        Intrinsics.f(url, "url");
        Set<HttpCacheEntry> set = this.f46464d.get(url);
        if (set == null) {
            b8 = SetsKt__SetsKt.b();
            return b8;
        }
        return set;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public void e(Url url, HttpCacheEntry value) {
        Intrinsics.f(url, "url");
        Intrinsics.f(value, "value");
        Set<HttpCacheEntry> b8 = this.f46464d.b(url, new Function0<Set<HttpCacheEntry>>() { // from class: io.ktor.client.plugins.cache.storage.UnlimitedCacheStorage$store$data$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Set<HttpCacheEntry> invoke() {
                return ConcurrentSetKt.a();
            }
        });
        if (!b8.add(value)) {
            b8.remove(value);
            b8.add(value);
        }
    }
}
