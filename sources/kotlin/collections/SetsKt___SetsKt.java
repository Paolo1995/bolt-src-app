package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sets.kt */
/* loaded from: classes5.dex */
public class SetsKt___SetsKt extends SetsKt__SetsKt {
    public static <T> Set<T> g(Set<? extends T> set, T t7) {
        int b8;
        Intrinsics.f(set, "<this>");
        b8 = MapsKt__MapsJVMKt.b(set.size());
        LinkedHashSet linkedHashSet = new LinkedHashSet(b8);
        boolean z7 = false;
        for (T t8 : set) {
            boolean z8 = true;
            if (!z7 && Intrinsics.a(t8, t7)) {
                z7 = true;
                z8 = false;
            }
            if (z8) {
                linkedHashSet.add(t8);
            }
        }
        return linkedHashSet;
    }

    public static <T> Set<T> h(Set<? extends T> set, Iterable<? extends T> elements) {
        int size;
        int b8;
        Intrinsics.f(set, "<this>");
        Intrinsics.f(elements, "elements");
        Integer w7 = CollectionsKt__IterablesKt.w(elements);
        if (w7 != null) {
            size = set.size() + w7.intValue();
        } else {
            size = set.size() * 2;
        }
        b8 = MapsKt__MapsJVMKt.b(size);
        LinkedHashSet linkedHashSet = new LinkedHashSet(b8);
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.A(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static <T> Set<T> i(Set<? extends T> set, T t7) {
        int b8;
        Intrinsics.f(set, "<this>");
        b8 = MapsKt__MapsJVMKt.b(set.size() + 1);
        LinkedHashSet linkedHashSet = new LinkedHashSet(b8);
        linkedHashSet.addAll(set);
        linkedHashSet.add(t7);
        return linkedHashSet;
    }
}
