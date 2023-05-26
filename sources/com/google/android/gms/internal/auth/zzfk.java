package com.google.android.gms.internal.auth;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzfk<K, V> extends LinkedHashMap<K, V> {
    private static final zzfk zza;
    private boolean zzb;

    static {
        zzfk zzfkVar = new zzfk();
        zza = zzfkVar;
        zzfkVar.zzb = false;
    }

    private zzfk() {
        this.zzb = true;
    }

    public static <K, V> zzfk<K, V> zza() {
        return zza;
    }

    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            return zzev.zzb((byte[]) obj);
        }
        if (!(obj instanceof zzes)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zzg() {
        if (this.zzb) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzg();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    for (Map.Entry<K, V> entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            V value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                                equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            } else {
                                equals = value.equals(obj2);
                                continue;
                            }
                            if (!equals) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i8 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i8 += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i8;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k8, V v7) {
        zzg();
        zzev.zze(k8);
        zzev.zze(v7);
        return (V) super.put(k8, v7);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzg();
        for (K k8 : map.keySet()) {
            zzev.zze(k8);
            zzev.zze(map.get(k8));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzg();
        return (V) super.remove(obj);
    }

    public final zzfk<K, V> zzb() {
        if (isEmpty()) {
            return new zzfk<>();
        }
        return new zzfk<>(this);
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zzd(zzfk<K, V> zzfkVar) {
        zzg();
        if (!zzfkVar.isEmpty()) {
            putAll(zzfkVar);
        }
    }

    public final boolean zze() {
        return this.zzb;
    }

    private zzfk(Map<K, V> map) {
        super(map);
        this.zzb = true;
    }
}
