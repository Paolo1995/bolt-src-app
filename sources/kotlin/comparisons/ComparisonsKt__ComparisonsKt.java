package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
/* loaded from: classes5.dex */
public class ComparisonsKt__ComparisonsKt {
    public static <T extends Comparable<?>> int a(T t7, T t8) {
        if (t7 == t8) {
            return 0;
        }
        if (t7 == null) {
            return -1;
        }
        if (t8 == null) {
            return 1;
        }
        return t7.compareTo(t8);
    }

    public static <T extends Comparable<? super T>> Comparator<T> b() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.f50901f;
        Intrinsics.d(naturalOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return naturalOrderComparator;
    }
}
