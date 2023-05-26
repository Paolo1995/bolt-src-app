package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.internal.util.collections.ImmutableList;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: ImmutableList.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class b<E> {
    public static <E> ImmutableList<E> A(E e8) {
        return ImmutableElement.d(e8);
    }

    @Deprecated
    public static void a(ImmutableList immutableList, int i8, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static boolean b(ImmutableList immutableList, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static boolean c(ImmutableList immutableList, int i8, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static boolean d(ImmutableList immutableList, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static void e(ImmutableList immutableList) {
        throw new UnsupportedOperationException();
    }

    public static boolean f(ImmutableList immutableList, Object obj) {
        if (immutableList.indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean g(ImmutableList immutableList, Collection collection) {
        Checks.j(collection, "Collection");
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            if (!immutableList.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(ImmutableList immutableList) {
        if (immutableList.size() == 0) {
            return true;
        }
        return false;
    }

    public static ImmutableList.ImmutableListIterator i(ImmutableList immutableList) {
        return immutableList.listIterator();
    }

    public static /* bridge */ /* synthetic */ Iterator j(ImmutableList immutableList) {
        return immutableList.iterator();
    }

    public static ImmutableList.ImmutableListIterator k(ImmutableList immutableList) {
        return immutableList.listIterator(0);
    }

    public static /* bridge */ /* synthetic */ ListIterator l(ImmutableList immutableList) {
        return immutableList.listIterator();
    }

    @Deprecated
    public static Object m(ImmutableList immutableList, int i8) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static boolean n(ImmutableList immutableList, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static boolean o(ImmutableList immutableList, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static boolean p(ImmutableList immutableList, Predicate predicate) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static void q(ImmutableList immutableList, UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static boolean r(ImmutableList immutableList, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static Object s(ImmutableList immutableList, int i8, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static void t(ImmutableList immutableList, Comparator comparator) {
        throw new UnsupportedOperationException();
    }

    public static ImmutableList u(ImmutableList immutableList) {
        return immutableList;
    }

    public static <E> ImmutableList.Builder<E> v() {
        return new ImmutableList.Builder<>();
    }

    public static <E> ImmutableList.Builder<E> w(int i8) {
        return new ImmutableList.Builder<>(i8);
    }

    public static <E> ImmutableList<E> x(Collection<? extends E> collection) {
        return y(collection, "Immutable list");
    }

    public static <E> ImmutableList<E> y(Collection<? extends E> collection, String str) {
        Checks.j(collection, str);
        if (collection instanceof ImmutableList) {
            return ((ImmutableList) collection).P0();
        }
        int size = collection.size();
        if (size != 0) {
            if (size != 1) {
                return ImmutableArray.g(collection.toArray(), str);
            }
            return ImmutableElement.f(ImmutableList.Builder.d(collection), str);
        }
        return ImmutableEmptyList.b();
    }

    public static <E> ImmutableList<E> z() {
        return ImmutableEmptyList.b();
    }
}
