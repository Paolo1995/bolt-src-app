package j$.util;

import j$.util.Comparator;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0123e0;
import j$.util.function.InterfaceC0135l;
import java.util.Arrays;
import java.util.ListIterator;

/* renamed from: j$.util.n  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0156n {
    public static void e(D d8, Consumer consumer) {
        if (consumer instanceof InterfaceC0135l) {
            d8.c((InterfaceC0135l) consumer);
        } else if (d0.f50257a) {
            d0.a(d8.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            throw null;
        } else {
            consumer.getClass();
            d8.c(new C0155m(consumer));
        }
    }

    public static void f(G g8, Consumer consumer) {
        if (consumer instanceof j$.util.function.J) {
            g8.b((j$.util.function.J) consumer);
        } else if (d0.f50257a) {
            d0.a(g8.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            throw null;
        } else {
            consumer.getClass();
            g8.b(new r(consumer));
        }
    }

    public static void g(J j8, Consumer consumer) {
        if (consumer instanceof InterfaceC0123e0) {
            j8.a((InterfaceC0123e0) consumer);
        } else if (d0.f50257a) {
            d0.a(j8.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            throw null;
        } else {
            consumer.getClass();
            j8.a(new C0271v(consumer));
        }
    }

    public static boolean h(D d8, Consumer consumer) {
        if (consumer instanceof InterfaceC0135l) {
            return d8.n((InterfaceC0135l) consumer);
        }
        if (d0.f50257a) {
            d0.a(d8.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        consumer.getClass();
        return d8.n(new C0155m(consumer));
    }

    public static boolean j(G g8, Consumer consumer) {
        if (consumer instanceof j$.util.function.J) {
            return g8.i((j$.util.function.J) consumer);
        }
        if (d0.f50257a) {
            d0.a(g8.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        consumer.getClass();
        return g8.i(new r(consumer));
    }

    public static boolean k(J j8, Consumer consumer) {
        if (consumer instanceof InterfaceC0123e0) {
            return j8.d((InterfaceC0123e0) consumer);
        }
        if (d0.f50257a) {
            d0.a(j8.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        consumer.getClass();
        return j8.d(new C0271v(consumer));
    }

    public static boolean l(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void m(java.util.List list, java.util.Comparator comparator) {
        if (list instanceof List) {
            ((List) list).sort(comparator);
        } else if (DesugarCollections.f50138b.isInstance(list)) {
            DesugarCollections.e(list, comparator);
        } else {
            Object[] array = list.toArray();
            Arrays.sort(array, comparator);
            ListIterator listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        }
    }

    public static /* synthetic */ java.util.Comparator o(java.util.Comparator comparator, java.util.Comparator comparator2) {
        return comparator instanceof Comparator ? ((Comparator) comparator).thenComparing(comparator2) : Comparator.CC.$default$thenComparing(comparator, comparator2);
    }

    public int characteristics() {
        return 16448;
    }

    public long estimateSize() {
        return 0L;
    }

    public void forEachRemaining(Object obj) {
        obj.getClass();
    }

    public boolean tryAdvance(Object obj) {
        obj.getClass();
        return false;
    }

    public Spliterator trySplit() {
        return null;
    }
}
