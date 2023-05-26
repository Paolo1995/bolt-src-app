package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Maps.kt */
/* loaded from: classes5.dex */
public class MapsKt___MapsKt extends MapsKt___MapsJvmKt {
    public static <K, V> List<Pair<K, V>> v(Map<? extends K, ? extends V> map) {
        List<Pair<K, V>> e8;
        List<Pair<K, V>> k8;
        List<Pair<K, V>> k9;
        Intrinsics.f(map, "<this>");
        if (map.size() == 0) {
            k9 = CollectionsKt__CollectionsKt.k();
            return k9;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            e8 = CollectionsKt__CollectionsJVMKt.e(new Pair(next.getKey(), next.getValue()));
            return e8;
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
