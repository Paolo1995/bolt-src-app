package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollections.kt */
/* loaded from: classes5.dex */
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static <T> boolean A(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        boolean z7 = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    public static final <T> boolean B(Collection<? super T> collection, Sequence<? extends T> elements) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    public static <T> boolean C(Collection<? super T> collection, T[] elements) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(elements, "elements");
        return collection.addAll(ArraysKt.e(elements));
    }

    public static final <T> Collection<T> D(Iterable<? extends T> iterable) {
        List H0;
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        H0 = CollectionsKt___CollectionsKt.H0(iterable);
        return H0;
    }

    private static final <T> boolean E(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z7) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            if (function1.invoke((T) it.next()).booleanValue() == z7) {
                it.remove();
                z8 = true;
            }
        }
        return z8;
    }

    private static final <T> boolean F(List<T> list, Function1<? super T, Boolean> function1, boolean z7) {
        int m8;
        int m9;
        if (!(list instanceof RandomAccess)) {
            Intrinsics.d(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return E(TypeIntrinsics.b(list), function1, z7);
        }
        m8 = CollectionsKt__CollectionsKt.m(list);
        IntIterator it = new IntRange(0, m8).iterator();
        int i8 = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t7 = list.get(nextInt);
            if (function1.invoke(t7).booleanValue() != z7) {
                if (i8 != nextInt) {
                    list.set(i8, t7);
                }
                i8++;
            }
        }
        if (i8 >= list.size()) {
            return false;
        }
        m9 = CollectionsKt__CollectionsKt.m(list);
        if (i8 > m9) {
            return true;
        }
        while (true) {
            list.remove(m9);
            if (m9 != i8) {
                m9--;
            } else {
                return true;
            }
        }
    }

    public static <T> boolean G(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(predicate, "predicate");
        return E(iterable, predicate, true);
    }

    public static final <T> boolean H(Collection<? super T> collection, Iterable<? extends T> elements) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(elements, "elements");
        return collection.removeAll(D(elements));
    }

    public static <T> boolean I(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.f(list, "<this>");
        Intrinsics.f(predicate, "predicate");
        return F(list, predicate, true);
    }

    public static <T> T J(List<T> list) {
        int m8;
        Intrinsics.f(list, "<this>");
        if (!list.isEmpty()) {
            m8 = CollectionsKt__CollectionsKt.m(list);
            return list.remove(m8);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T K(List<T> list) {
        int m8;
        Intrinsics.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        m8 = CollectionsKt__CollectionsKt.m(list);
        return list.remove(m8);
    }
}
