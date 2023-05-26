package androidx.collection;

import androidx.annotation.NonNull;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V>, j$.util.Map {

    /* renamed from: m  reason: collision with root package name */
    MapCollections<K, V> f4238m;

    public ArrayMap() {
    }

    private MapCollections<K, V> o() {
        if (this.f4238m == null) {
            this.f4238m = new MapCollections<K, V>() { // from class: androidx.collection.ArrayMap.1
                @Override // androidx.collection.MapCollections
                protected void a() {
                    ArrayMap.this.clear();
                }

                @Override // androidx.collection.MapCollections
                protected Object b(int i8, int i9) {
                    return ArrayMap.this.f4279g[(i8 << 1) + i9];
                }

                @Override // androidx.collection.MapCollections
                protected Map<K, V> c() {
                    return ArrayMap.this;
                }

                @Override // androidx.collection.MapCollections
                protected int d() {
                    return ArrayMap.this.f4280h;
                }

                @Override // androidx.collection.MapCollections
                protected int e(Object obj) {
                    return ArrayMap.this.g(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int f(Object obj) {
                    return ArrayMap.this.i(obj);
                }

                @Override // androidx.collection.MapCollections
                protected void g(K k8, V v7) {
                    ArrayMap.this.put(k8, v7);
                }

                @Override // androidx.collection.MapCollections
                protected void h(int i8) {
                    ArrayMap.this.l(i8);
                }

                @Override // androidx.collection.MapCollections
                protected V i(int i8, V v7) {
                    return ArrayMap.this.m(i8, v7);
                }
            };
        }
        return this.f4238m;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map, j$.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return o().l();
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map
    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.Map, j$.util.Map
    public Set<K> keySet() {
        return o().m();
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    public boolean p(@NonNull Collection<?> collection) {
        return MapCollections.p(this, collection);
    }

    @Override // java.util.Map, j$.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        c(this.f4280h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    @Override // java.util.Map
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.Map, j$.util.Map
    public Collection<V> values() {
        return o().n();
    }

    public ArrayMap(int i8) {
        super(i8);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
