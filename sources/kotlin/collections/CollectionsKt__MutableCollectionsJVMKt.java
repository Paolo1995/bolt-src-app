package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes5.dex */
public class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public static <T extends Comparable<? super T>> void y(List<T> list) {
        Intrinsics.f(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static <T> void z(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.f(list, "<this>");
        Intrinsics.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
