package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: j  reason: collision with root package name */
    private HashMap<K, SafeIterableMap.Entry<K, V>> f2307j = new HashMap<>();

    public boolean contains(K k8) {
        return this.f2307j.containsKey(k8);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    protected SafeIterableMap.Entry<K, V> d(K k8) {
        return this.f2307j.get(k8);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V k(@NonNull K k8, @NonNull V v7) {
        SafeIterableMap.Entry<K, V> d8 = d(k8);
        if (d8 != null) {
            return d8.f2313g;
        }
        this.f2307j.put(k8, i(k8, v7));
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V m(@NonNull K k8) {
        V v7 = (V) super.m(k8);
        this.f2307j.remove(k8);
        return v7;
    }

    public Map.Entry<K, V> n(K k8) {
        if (contains(k8)) {
            return this.f2307j.get(k8).f2315i;
        }
        return null;
    }
}
