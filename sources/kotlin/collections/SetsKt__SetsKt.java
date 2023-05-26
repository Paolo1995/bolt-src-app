package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
/* loaded from: classes5.dex */
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static <T> Set<T> b() {
        return EmptySet.f50881f;
    }

    public static <T> HashSet<T> c(T... elements) {
        int b8;
        Intrinsics.f(elements, "elements");
        b8 = MapsKt__MapsJVMKt.b(elements.length);
        return (HashSet) ArraysKt___ArraysKt.e0(elements, new HashSet(b8));
    }

    public static <T> Set<T> d(T... elements) {
        int b8;
        Intrinsics.f(elements, "elements");
        b8 = MapsKt__MapsJVMKt.b(elements.length);
        return (Set) ArraysKt___ArraysKt.e0(elements, new LinkedHashSet(b8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Set<T> e(Set<? extends T> set) {
        Set<T> b8;
        Set<T> a8;
        Intrinsics.f(set, "<this>");
        int size = set.size();
        if (size != 0) {
            if (size == 1) {
                a8 = SetsKt__SetsJVMKt.a(set.iterator().next());
                return a8;
            }
            return set;
        }
        b8 = b();
        return b8;
    }

    public static <T> Set<T> f(T... elements) {
        Set<T> b8;
        Intrinsics.f(elements, "elements");
        if (elements.length > 0) {
            return ArraysKt___ArraysKt.j0(elements);
        }
        b8 = b();
        return b8;
    }
}
