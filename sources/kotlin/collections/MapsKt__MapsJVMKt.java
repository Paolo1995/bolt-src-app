package kotlin.collections;

import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* loaded from: classes5.dex */
public class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    public static int b(int i8) {
        return i8 < 0 ? i8 : i8 < 3 ? i8 + 1 : i8 < 1073741824 ? (int) ((i8 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static <K, V> Map<K, V> c(Pair<? extends K, ? extends V> pair) {
        Intrinsics.f(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.d(), pair.e());
        Intrinsics.e(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> d(Map<? extends K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.e(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static <K extends Comparable<? super K>, V> SortedMap<K, V> e(Map<? extends K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        return new TreeMap(map);
    }
}
