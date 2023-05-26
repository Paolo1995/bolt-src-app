package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt__AppendableKt;

/* compiled from: _Collections.kt */
/* loaded from: classes5.dex */
public class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static <T> List<T> A0(Iterable<? extends T> iterable, int i8) {
        boolean z7;
        List<T> r7;
        Object V;
        List<T> e8;
        List<T> H0;
        List<T> k8;
        Intrinsics.f(iterable, "<this>");
        int i9 = 0;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 == 0) {
                k8 = CollectionsKt__CollectionsKt.k();
                return k8;
            }
            if (iterable instanceof Collection) {
                if (i8 >= ((Collection) iterable).size()) {
                    H0 = H0(iterable);
                    return H0;
                } else if (i8 == 1) {
                    V = V(iterable);
                    e8 = CollectionsKt__CollectionsJVMKt.e(V);
                    return e8;
                }
            }
            ArrayList arrayList = new ArrayList(i8);
            for (T t7 : iterable) {
                arrayList.add(t7);
                i9++;
                if (i9 == i8) {
                    break;
                }
            }
            r7 = CollectionsKt__CollectionsKt.r(arrayList);
            return r7;
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static <T> List<T> B0(List<? extends T> list, int i8) {
        boolean z7;
        Object h02;
        List<T> e8;
        List<T> H0;
        List<T> k8;
        Intrinsics.f(list, "<this>");
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 == 0) {
                k8 = CollectionsKt__CollectionsKt.k();
                return k8;
            }
            int size = list.size();
            if (i8 >= size) {
                H0 = H0(list);
                return H0;
            } else if (i8 == 1) {
                h02 = h0(list);
                e8 = CollectionsKt__CollectionsJVMKt.e(h02);
                return e8;
            } else {
                ArrayList arrayList = new ArrayList(i8);
                if (list instanceof RandomAccess) {
                    for (int i9 = size - i8; i9 < size; i9++) {
                        arrayList.add(list.get(i9));
                    }
                } else {
                    ListIterator<? extends T> listIterator = list.listIterator(size - i8);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static boolean[] C0(Collection<Boolean> collection) {
        Intrinsics.f(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        int i8 = 0;
        for (Boolean bool : collection) {
            zArr[i8] = bool.booleanValue();
            i8++;
        }
        return zArr;
    }

    public static final <T, C extends Collection<? super T>> C D0(Iterable<? extends T> iterable, C destination) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(destination, "destination");
        for (T t7 : iterable) {
            destination.add(t7);
        }
        return destination;
    }

    public static float[] E0(Collection<Float> collection) {
        Intrinsics.f(collection, "<this>");
        float[] fArr = new float[collection.size()];
        int i8 = 0;
        for (Float f8 : collection) {
            fArr[i8] = f8.floatValue();
            i8++;
        }
        return fArr;
    }

    public static <T> HashSet<T> F0(Iterable<? extends T> iterable) {
        int v7;
        int b8;
        Intrinsics.f(iterable, "<this>");
        v7 = CollectionsKt__IterablesKt.v(iterable, 12);
        b8 = MapsKt__MapsJVMKt.b(v7);
        return (HashSet) D0(iterable, new HashSet(b8));
    }

    public static int[] G0(Collection<Integer> collection) {
        Intrinsics.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        int i8 = 0;
        for (Integer num : collection) {
            iArr[i8] = num.intValue();
            i8++;
        }
        return iArr;
    }

    public static <T> List<T> H0(Iterable<? extends T> iterable) {
        List<T> r7;
        List<T> k8;
        Object next;
        List<T> e8;
        List<T> J0;
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    J0 = J0(collection);
                    return J0;
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                e8 = CollectionsKt__CollectionsJVMKt.e(next);
                return e8;
            }
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        r7 = CollectionsKt__CollectionsKt.r(I0(iterable));
        return r7;
    }

    public static final <T> List<T> I0(Iterable<? extends T> iterable) {
        List<T> J0;
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            J0 = J0((Collection) iterable);
            return J0;
        }
        return (List) D0(iterable, new ArrayList());
    }

    public static <T> List<T> J0(Collection<? extends T> collection) {
        Intrinsics.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> K0(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) D0(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> L0(Iterable<? extends T> iterable) {
        Set<T> e8;
        Set<T> b8;
        Object next;
        Set<T> a8;
        int b9;
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    b9 = MapsKt__MapsJVMKt.b(collection.size());
                    return (Set) D0(iterable, new LinkedHashSet(b9));
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                a8 = SetsKt__SetsJVMKt.a(next);
                return a8;
            }
            b8 = SetsKt__SetsKt.b();
            return b8;
        }
        e8 = SetsKt__SetsKt.e((Set) D0(iterable, new LinkedHashSet()));
        return e8;
    }

    public static <T, R> List<Pair<T, R>> M0(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        int v7;
        int v8;
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        v7 = CollectionsKt__IterablesKt.v(iterable, 10);
        v8 = CollectionsKt__IterablesKt.v(other, 10);
        ArrayList arrayList = new ArrayList(Math.min(v7, v8));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> Sequence<T> O(final Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        return new Sequence<T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }

    public static <T> boolean P(Iterable<? extends T> iterable, T t7) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t7);
        }
        if (a0(iterable, t7) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> int Q(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int i8 = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            it.next();
            i8++;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
        }
        return i8;
    }

    public static <T> List<T> R(Iterable<? extends T> iterable, int i8) {
        boolean z7;
        ArrayList arrayList;
        List<T> r7;
        List<T> e8;
        List<T> k8;
        List<T> H0;
        Intrinsics.f(iterable, "<this>");
        int i9 = 0;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 == 0) {
                H0 = H0(iterable);
                return H0;
            }
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i8;
                if (size <= 0) {
                    k8 = CollectionsKt__CollectionsKt.k();
                    return k8;
                } else if (size == 1) {
                    e8 = CollectionsKt__CollectionsJVMKt.e(g0(iterable));
                    return e8;
                } else {
                    arrayList = new ArrayList(size);
                    if (iterable instanceof List) {
                        if (iterable instanceof RandomAccess) {
                            int size2 = collection.size();
                            while (i8 < size2) {
                                arrayList.add(((List) iterable).get(i8));
                                i8++;
                            }
                        } else {
                            ListIterator listIterator = ((List) iterable).listIterator(i8);
                            while (listIterator.hasNext()) {
                                arrayList.add(listIterator.next());
                            }
                        }
                        return arrayList;
                    }
                }
            } else {
                arrayList = new ArrayList();
            }
            for (T t7 : iterable) {
                if (i9 >= i8) {
                    arrayList.add(t7);
                } else {
                    i9++;
                }
            }
            r7 = CollectionsKt__CollectionsKt.r(arrayList);
            return r7;
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static <T> List<T> S(List<? extends T> list, int i8) {
        boolean z7;
        int d8;
        List<T> A0;
        Intrinsics.f(list, "<this>");
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            d8 = RangesKt___RangesKt.d(list.size() - i8, 0);
            A0 = A0(list, d8);
            return A0;
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static <T> List<T> T(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        return (List) U(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C U(Iterable<? extends T> iterable, C destination) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(destination, "destination");
        for (T t7 : iterable) {
            if (t7 != null) {
                destination.add(t7);
            }
        }
        return destination;
    }

    public static <T> T V(Iterable<? extends T> iterable) {
        Object W;
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof List) {
            W = W((List) iterable);
            return (T) W;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T W(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T X(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static <T> T Y(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T Z(List<? extends T> list, int i8) {
        int m8;
        Intrinsics.f(list, "<this>");
        if (i8 >= 0) {
            m8 = CollectionsKt__CollectionsKt.m(list);
            if (i8 <= m8) {
                return list.get(i8);
            }
        }
        return null;
    }

    public static final <T> int a0(Iterable<? extends T> iterable, T t7) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t7);
        }
        int i8 = 0;
        for (T t8 : iterable) {
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            if (Intrinsics.a(t7, t8)) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static <T> int b0(List<? extends T> list, T t7) {
        Intrinsics.f(list, "<this>");
        return list.indexOf(t7);
    }

    public static final <T, A extends Appendable> A c0(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(buffer, "buffer");
        Intrinsics.f(separator, "separator");
        Intrinsics.f(prefix, "prefix");
        Intrinsics.f(postfix, "postfix");
        Intrinsics.f(truncated, "truncated");
        buffer.append(prefix);
        int i9 = 0;
        for (T t7 : iterable) {
            i9++;
            if (i9 > 1) {
                buffer.append(separator);
            }
            if (i8 >= 0 && i9 > i8) {
                break;
            }
            StringsKt__AppendableKt.a(buffer, t7, function1);
        }
        if (i8 >= 0 && i9 > i8) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable d0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i8, CharSequence charSequence4, Function1 function1, int i9, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i10;
        CharSequence charSequence7;
        Function1 function12;
        if ((i9 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i9 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i9 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i9 & 16) != 0) {
            i10 = -1;
        } else {
            i10 = i8;
        }
        if ((i9 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i9 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return c0(iterable, appendable, charSequence5, charSequence6, charSequence8, i10, charSequence7, function12);
    }

    public static final <T> String e0(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i8, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(separator, "separator");
        Intrinsics.f(prefix, "prefix");
        Intrinsics.f(postfix, "postfix");
        Intrinsics.f(truncated, "truncated");
        String sb = ((StringBuilder) c0(iterable, new StringBuilder(), separator, prefix, postfix, i8, truncated, function1)).toString();
        Intrinsics.e(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String f0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i8, CharSequence charSequence4, Function1 function1, int i9, Object obj) {
        CharSequence charSequence5;
        int i10;
        if ((i9 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i9 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i9 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i9 & 8) != 0) {
            i10 = -1;
        } else {
            i10 = i8;
        }
        if ((i9 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i9 & 32) != 0) {
            function1 = null;
        }
        return e0(iterable, charSequence, charSequence5, charSequence6, i10, charSequence7, function1);
    }

    public static final <T> T g0(Iterable<? extends T> iterable) {
        Object h02;
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof List) {
            h02 = h0((List) iterable);
            return (T) h02;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T h0(List<? extends T> list) {
        int m8;
        Intrinsics.f(list, "<this>");
        if (!list.isEmpty()) {
            m8 = CollectionsKt__CollectionsKt.m(list);
            return list.get(m8);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T i0(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T extends Comparable<? super T>> T j0(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T extends Comparable<? super T>> T k0(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> l0(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        List<T> H0;
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(elements, "elements");
        Collection D = CollectionsKt__MutableCollectionsKt.D(elements);
        if (D.isEmpty()) {
            H0 = H0(iterable);
            return H0;
        }
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            if (!D.contains(t7)) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    public static <T> List<T> m0(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        List<T> n02;
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(elements, "elements");
        if (iterable instanceof Collection) {
            n02 = n0((Collection) iterable, elements);
            return n02;
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.A(arrayList, iterable);
        CollectionsKt__MutableCollectionsKt.A(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> n0(Collection<? extends T> collection, Iterable<? extends T> elements) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        CollectionsKt__MutableCollectionsKt.A(arrayList2, elements);
        return arrayList2;
    }

    public static <T> List<T> o0(Collection<? extends T> collection, T t7) {
        Intrinsics.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t7);
        return arrayList;
    }

    public static <T> List<T> p0(Collection<? extends T> collection, Sequence<? extends T> elements) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        CollectionsKt__MutableCollectionsKt.B(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> q0(Collection<? extends T> collection, T[] elements) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        CollectionsKt__MutableCollectionsKt.C(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> r0(Iterable<? extends T> iterable) {
        List<T> H0;
        Intrinsics.f(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            H0 = H0(iterable);
            return H0;
        }
        List<T> I0 = I0(iterable);
        CollectionsKt___CollectionsJvmKt.N(I0);
        return I0;
    }

    public static <T> T s0(Iterable<? extends T> iterable) {
        Object t02;
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof List) {
            t02 = t0((List) iterable);
            return (T) t02;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T t0(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T u0(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> v0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        List<T> e8;
        List<T> H0;
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                H0 = H0(iterable);
                return H0;
            }
            Object[] array = collection.toArray(new Object[0]);
            ArraysKt___ArraysJvmKt.t(array, comparator);
            e8 = ArraysKt___ArraysJvmKt.e(array);
            return e8;
        }
        List<T> I0 = I0(iterable);
        CollectionsKt__MutableCollectionsJVMKt.z(I0, comparator);
        return I0;
    }

    public static <T> Set<T> w0(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        Set<T> K0;
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(other, "other");
        K0 = K0(iterable);
        CollectionsKt__MutableCollectionsKt.H(K0, other);
        return K0;
    }

    public static float x0(Iterable<Float> iterable) {
        Intrinsics.f(iterable, "<this>");
        float f8 = 0.0f;
        for (Float f9 : iterable) {
            f8 += f9.floatValue();
        }
        return f8;
    }

    public static int y0(Iterable<Integer> iterable) {
        Intrinsics.f(iterable, "<this>");
        int i8 = 0;
        for (Integer num : iterable) {
            i8 += num.intValue();
        }
        return i8;
    }

    public static long z0(Iterable<Long> iterable) {
        Intrinsics.f(iterable, "<this>");
        long j8 = 0;
        for (Long l8 : iterable) {
            j8 += l8.longValue();
        }
        return j8;
    }
}
