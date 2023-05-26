package dagger.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    private MapBuilder(int i8) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i8);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i8) {
        return new MapBuilder<>(i8);
    }

    public Map<K, V> build() {
        if (this.contributions.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(this.contributions);
    }

    public MapBuilder<K, V> put(K k8, V v7) {
        this.contributions.put(k8, v7);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }
}
