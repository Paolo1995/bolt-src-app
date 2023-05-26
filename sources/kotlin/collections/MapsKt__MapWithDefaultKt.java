package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapWithDefault.kt */
/* loaded from: classes5.dex */
class MapsKt__MapWithDefaultKt {
    public static final <K, V> V a(Map<K, ? extends V> map, K k8) {
        Intrinsics.f(map, "<this>");
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).f(k8);
        }
        V v7 = map.get(k8);
        if (v7 == null && !map.containsKey(k8)) {
            throw new NoSuchElementException("Key " + k8 + " is missing in the map.");
        }
        return v7;
    }
}
