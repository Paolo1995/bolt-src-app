package kotlinx.serialization.json.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* compiled from: createMapForCache.kt */
/* loaded from: classes5.dex */
public final class CreateMapForCacheKt {
    public static final <K, V> Map<K, V> a(int i8) {
        return new ConcurrentHashMap(i8);
    }
}
