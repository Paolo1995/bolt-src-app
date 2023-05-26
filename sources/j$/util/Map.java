package j$.util;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public interface Map<K, V> {

    /* renamed from: j$.util.Map$-CC */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$compute(java.util.Map map, Object obj, BiFunction biFunction) {
            biFunction.getClass();
            Object obj2 = map.get(obj);
            Object apply = biFunction.apply(obj, obj2);
            if (apply != null) {
                map.put(obj, apply);
                return apply;
            } else if (obj2 != null || map.containsKey(obj)) {
                map.remove(obj);
                return null;
            } else {
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$computeIfAbsent(java.util.Map map, Object obj, Function function) {
            Object apply;
            function.getClass();
            Object obj2 = map.get(obj);
            if (obj2 != null || (apply = function.apply(obj)) == null) {
                return obj2;
            }
            map.put(obj, apply);
            return apply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$computeIfPresent(java.util.Map map, Object obj, BiFunction biFunction) {
            biFunction.getClass();
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                Object apply = biFunction.apply(obj, obj2);
                if (apply != null) {
                    map.put(obj, apply);
                    return apply;
                }
                map.remove(obj);
            }
            return null;
        }

        public static void $default$forEach(java.util.Map map, BiConsumer biConsumer) {
            biConsumer.getClass();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                try {
                    biConsumer.accept(entry.getKey(), entry.getValue());
                } catch (IllegalStateException e8) {
                    throw new ConcurrentModificationException(e8);
                }
            }
        }

        public static Object $default$getOrDefault(java.util.Map map, Object obj, Object obj2) {
            Object obj3 = map.get(obj);
            return (obj3 != null || map.containsKey(obj)) ? obj3 : obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object $default$merge(java.util.Map map, Object obj, Object obj2, BiFunction biFunction) {
            biFunction.getClass();
            obj2.getClass();
            Object obj3 = map.get(obj);
            if (obj3 != null) {
                obj2 = biFunction.apply(obj3, obj2);
            }
            if (obj2 == null) {
                map.remove(obj);
            } else {
                map.put(obj, obj2);
            }
            return obj2;
        }

        public static void $default$replaceAll(java.util.Map map, BiFunction biFunction) {
            biFunction.getClass();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                try {
                    try {
                        entry.setValue((V) biFunction.apply(entry.getKey(), entry.getValue()));
                    } catch (IllegalStateException e8) {
                        throw new ConcurrentModificationException(e8);
                    }
                } catch (IllegalStateException e9) {
                    throw new ConcurrentModificationException(e9);
                }
            }
        }
    }

    /* renamed from: j$.util.Map$-EL */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class EL {
        public static Object a(java.util.Map map, Object obj, Object obj2) {
            if (map instanceof Map) {
                return ((Map) map).putIfAbsent(obj, obj2);
            }
            Object obj3 = map.get(obj);
            return obj3 == null ? map.put(obj, obj2) : obj3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object computeIfAbsent(java.util.Map map, Object obj, Function function) {
            Object apply;
            if (map instanceof Map) {
                return ((Map) map).computeIfAbsent(obj, function);
            }
            if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                function.getClass();
                Object obj2 = concurrentMap.get(obj);
                return (obj2 == null && (apply = function.apply(obj)) != null && (obj2 = concurrentMap.putIfAbsent(obj, apply)) == null) ? apply : obj2;
            }
            return CC.$default$computeIfAbsent(map, obj, function);
        }

        public static /* synthetic */ void forEach(java.util.Map map, BiConsumer biConsumer) {
            if (map instanceof Map) {
                ((Map) map).forEach(biConsumer);
            } else if (map instanceof ConcurrentMap) {
                j$.time.a.a((ConcurrentMap) map, biConsumer);
            } else {
                CC.$default$forEach(map, biConsumer);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface Entry<K, V> {
        boolean equals(Object obj);

        K getKey();

        V getValue();

        int hashCode();

        V setValue(V v7);
    }

    void clear();

    V compute(K k8, BiFunction<? super K, ? super V, ? extends V> biFunction);

    V computeIfAbsent(K k8, Function<? super K, ? extends V> function);

    V computeIfPresent(K k8, BiFunction<? super K, ? super V, ? extends V> biFunction);

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    Set<Map.Entry<K, V>> entrySet();

    boolean equals(Object obj);

    void forEach(BiConsumer<? super K, ? super V> biConsumer);

    V get(Object obj);

    V getOrDefault(Object obj, V v7);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    V merge(K k8, V v7, BiFunction<? super V, ? super V, ? extends V> biFunction);

    V put(K k8, V v7);

    void putAll(java.util.Map<? extends K, ? extends V> map);

    V putIfAbsent(K k8, V v7);

    V remove(Object obj);

    boolean remove(Object obj, Object obj2);

    V replace(K k8, V v7);

    boolean replace(K k8, V v7, V v8);

    void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction);

    int size();

    Collection<V> values();
}
