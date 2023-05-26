package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: Collections.kt */
/* loaded from: classes5.dex */
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static final <T> Collection<T> f(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T> int g(List<? extends T> list, int i8, int i9, Function1<? super T, Integer> comparison) {
        Intrinsics.f(list, "<this>");
        Intrinsics.f(comparison, "comparison");
        s(list.size(), i8, i9);
        int i10 = i9 - 1;
        while (i8 <= i10) {
            int i11 = (i8 + i10) >>> 1;
            int intValue = comparison.invoke((T) list.get(i11)).intValue();
            if (intValue < 0) {
                i8 = i11 + 1;
            } else if (intValue > 0) {
                i10 = i11 - 1;
            } else {
                return i11;
            }
        }
        return -(i8 + 1);
    }

    public static final <T extends Comparable<? super T>> int h(List<? extends T> list, T t7, int i8, int i9) {
        int a8;
        Intrinsics.f(list, "<this>");
        s(list.size(), i8, i9);
        int i10 = i9 - 1;
        while (i8 <= i10) {
            int i11 = (i8 + i10) >>> 1;
            a8 = ComparisonsKt__ComparisonsKt.a(list.get(i11), t7);
            if (a8 < 0) {
                i8 = i11 + 1;
            } else if (a8 > 0) {
                i10 = i11 - 1;
            } else {
                return i11;
            }
        }
        return -(i8 + 1);
    }

    public static /* synthetic */ int i(List list, int i8, int i9, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = list.size();
        }
        return g(list, i8, i9, function1);
    }

    public static /* synthetic */ int j(List list, Comparable comparable, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = list.size();
        }
        return h(list, comparable, i8, i9);
    }

    public static <T> List<T> k() {
        return EmptyList.f50879f;
    }

    public static IntRange l(Collection<?> collection) {
        Intrinsics.f(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int m(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> n(T... elements) {
        List<T> k8;
        List<T> e8;
        Intrinsics.f(elements, "elements");
        if (elements.length > 0) {
            e8 = ArraysKt___ArraysJvmKt.e(elements);
            return e8;
        }
        k8 = k();
        return k8;
    }

    public static <T> List<T> o(T t7) {
        List<T> k8;
        List<T> e8;
        if (t7 != null) {
            e8 = CollectionsKt__CollectionsJVMKt.e(t7);
            return e8;
        }
        k8 = k();
        return k8;
    }

    public static <T> List<T> p(T... elements) {
        List<T> C;
        Intrinsics.f(elements, "elements");
        C = ArraysKt___ArraysKt.C(elements);
        return C;
    }

    public static <T> List<T> q(T... elements) {
        Intrinsics.f(elements, "elements");
        if (elements.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new ArrayAsCollection(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> r(List<? extends T> list) {
        List<T> k8;
        List<T> e8;
        Intrinsics.f(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                e8 = CollectionsKt__CollectionsJVMKt.e(list.get(0));
                return e8;
            }
            return list;
        }
        k8 = k();
        return k8;
    }

    private static final void s(int i8, int i9, int i10) {
        if (i9 <= i10) {
            if (i9 >= 0) {
                if (i10 <= i8) {
                    return;
                }
                throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i8 + ").");
            }
            throw new IndexOutOfBoundsException("fromIndex (" + i9 + ") is less than zero.");
        }
        throw new IllegalArgumentException("fromIndex (" + i9 + ") is greater than toIndex (" + i10 + ").");
    }

    public static void t() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void u() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
