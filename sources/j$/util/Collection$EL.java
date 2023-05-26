package j$.util;

import j$.util.List;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: j$.util.Collection$-EL */
/* loaded from: classes2.dex */
public final /* synthetic */ class Collection$EL {
    public static void a(Collection collection, Consumer consumer) {
        if (collection instanceof InterfaceC0106a) {
            ((InterfaceC0106a) collection).forEach(consumer);
            return;
        }
        consumer.getClass();
        for (Object obj : collection) {
            consumer.accept(obj);
        }
    }

    public static Spliterator b(Collection collection) {
        if (collection instanceof InterfaceC0106a) {
            return ((InterfaceC0106a) collection).spliterator();
        }
        if (collection instanceof LinkedHashSet) {
            LinkedHashSet linkedHashSet = (LinkedHashSet) collection;
            linkedHashSet.getClass();
            return new a0(17, linkedHashSet);
        } else if (collection instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) collection;
            return new A(sortedSet, sortedSet);
        } else if (collection instanceof Set) {
            Set set = (Set) collection;
            set.getClass();
            return new a0(1, set);
        } else if (collection instanceof java.util.List) {
            return List.CC.$default$spliterator((java.util.List) collection);
        } else {
            collection.getClass();
            return new a0(0, collection);
        }
    }

    public static /* synthetic */ boolean removeIf(Collection collection, Predicate predicate) {
        return collection instanceof InterfaceC0106a ? ((InterfaceC0106a) collection).removeIf(predicate) : Collection$CC.$default$removeIf(collection, predicate);
    }
}
