package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import androidx.collection.LruCache;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkerCache.kt */
/* loaded from: classes3.dex */
public final class MarkerCache {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<Object, MarkerParams> f30228a = new LruCache<>(64);

    public final <K> MarkerParams a(K key, Function1<? super K, MarkerParams> create) {
        MarkerParams markerParams;
        Intrinsics.f(key, "key");
        Intrinsics.f(create, "create");
        MarkerParams markerParams2 = this.f30228a.get(key);
        if (markerParams2 == null) {
            synchronized (this.f30228a) {
                MarkerParams markerParams3 = this.f30228a.get(key);
                if (markerParams3 == null) {
                    MarkerParams invoke = create.invoke(key);
                    this.f30228a.put(key, invoke);
                    markerParams = invoke;
                } else {
                    markerParams = markerParams3;
                }
                Intrinsics.e(markerParams, "cache.get(key) ?: create…so { cache.put(key, it) }");
            }
            return markerParams;
        }
        return markerParams2;
    }
}
