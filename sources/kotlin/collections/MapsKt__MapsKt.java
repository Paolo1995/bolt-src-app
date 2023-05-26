package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
/* loaded from: classes5.dex */
public class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static <K, V> Map<K, V> f() {
        EmptyMap emptyMap = EmptyMap.f50880f;
        Intrinsics.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static <K, V> V g(Map<K, ? extends V> map, K k8) {
        Intrinsics.f(map, "<this>");
        return (V) MapsKt__MapWithDefaultKt.a(map, k8);
    }

    public static <K, V> HashMap<K, V> h(Pair<? extends K, ? extends V>... pairs) {
        int b8;
        Intrinsics.f(pairs, "pairs");
        b8 = MapsKt__MapsJVMKt.b(pairs.length);
        HashMap<K, V> hashMap = new HashMap<>(b8);
        p(hashMap, pairs);
        return hashMap;
    }

    public static <K, V> Map<K, V> i(Pair<? extends K, ? extends V>... pairs) {
        Map<K, V> f8;
        int b8;
        Intrinsics.f(pairs, "pairs");
        if (pairs.length > 0) {
            b8 = MapsKt__MapsJVMKt.b(pairs.length);
            return t(pairs, new LinkedHashMap(b8));
        }
        f8 = f();
        return f8;
    }

    public static <K, V> Map<K, V> j(Map<? extends K, ? extends V> map, K k8) {
        Map u7;
        Intrinsics.f(map, "<this>");
        u7 = u(map);
        u7.remove(k8);
        return l(u7);
    }

    public static <K, V> Map<K, V> k(Pair<? extends K, ? extends V>... pairs) {
        int b8;
        Intrinsics.f(pairs, "pairs");
        b8 = MapsKt__MapsJVMKt.b(pairs.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b8);
        p(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> l(Map<K, ? extends V> map) {
        Map<K, V> f8;
        Intrinsics.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            if (size == 1) {
                return MapsKt__MapsJVMKt.d(map);
            }
            return map;
        }
        f8 = f();
        return f8;
    }

    public static <K, V> Map<K, V> m(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        Intrinsics.f(map, "<this>");
        Intrinsics.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> n(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        Map<K, V> c8;
        Intrinsics.f(map, "<this>");
        Intrinsics.f(pair, "pair");
        if (map.isEmpty()) {
            c8 = MapsKt__MapsJVMKt.c(pair);
            return c8;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.d(), pair.e());
        return linkedHashMap;
    }

    public static final <K, V> void o(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.f(map, "<this>");
        Intrinsics.f(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put((K) pair.a(), (V) pair.b());
        }
    }

    public static final <K, V> void p(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.f(map, "<this>");
        Intrinsics.f(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put((K) pair.a(), (V) pair.b());
        }
    }

    public static <K, V> Map<K, V> q(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Map r7;
        Map<K, V> f8;
        Pair<? extends K, ? extends V> next;
        Map<K, V> c8;
        int b8;
        Map<K, V> r8;
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    b8 = MapsKt__MapsJVMKt.b(collection.size());
                    r8 = r(iterable, new LinkedHashMap(b8));
                    return r8;
                }
                if (iterable instanceof List) {
                    next = (Pair<? extends K, ? extends V>) ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                c8 = MapsKt__MapsJVMKt.c(next);
                return c8;
            }
            f8 = f();
            return f8;
        }
        r7 = r(iterable, new LinkedHashMap());
        return l(r7);
    }

    public static <K, V, M extends Map<? super K, ? super V>> M r(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M destination) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(destination, "destination");
        o(destination, iterable);
        return destination;
    }

    public static <K, V> Map<K, V> s(Map<? extends K, ? extends V> map) {
        Map<K, V> f8;
        Map<K, V> u7;
        Intrinsics.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            if (size != 1) {
                u7 = u(map);
                return u7;
            }
            return MapsKt__MapsJVMKt.d(map);
        }
        f8 = f();
        return f8;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M t(Pair<? extends K, ? extends V>[] pairArr, M destination) {
        Intrinsics.f(pairArr, "<this>");
        Intrinsics.f(destination, "destination");
        p(destination, pairArr);
        return destination;
    }

    public static <K, V> Map<K, V> u(Map<? extends K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
