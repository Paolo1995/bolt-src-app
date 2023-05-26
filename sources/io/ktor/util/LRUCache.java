package io.ktor.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Cache.kt */
/* loaded from: classes5.dex */
public final class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: f  reason: collision with root package name */
    private final Function1<K, V> f47046f;

    /* renamed from: g  reason: collision with root package name */
    private final Function1<V, Unit> f47047g;

    /* renamed from: h  reason: collision with root package name */
    private final int f47048h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LRUCache(Function1<? super K, ? extends V> supplier, Function1<? super V, Unit> close, int i8) {
        super(10, 0.75f, true);
        Intrinsics.f(supplier, "supplier");
        Intrinsics.f(close, "close");
        this.f47046f = supplier;
        this.f47047g = close;
        this.f47048h = i8;
    }

    public /* bridge */ Set<Map.Entry<Object, Object>> a() {
        return super.entrySet();
    }

    public /* bridge */ Set<Object> b() {
        return super.keySet();
    }

    public /* bridge */ int c() {
        return super.size();
    }

    public /* bridge */ Collection<Object> d() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return (Set<Map.Entry<K, V>>) a();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (this.f47048h == 0) {
            return this.f47046f.invoke(obj);
        }
        synchronized (this) {
            V v7 = (V) super.get(obj);
            if (v7 != null) {
                return v7;
            }
            V invoke = this.f47046f.invoke(obj);
            put(obj, invoke);
            return invoke;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) b();
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<? extends K, ? extends V> eldest) {
        boolean z7;
        Intrinsics.f(eldest, "eldest");
        if (size() > this.f47048h) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f47047g.invoke(eldest.getValue());
        }
        return z7;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return c();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) d();
    }
}
