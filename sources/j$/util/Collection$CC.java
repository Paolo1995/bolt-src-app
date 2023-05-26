package j$.util;

import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.stream.AbstractC0254w0;
import j$.util.stream.Stream;
import java.util.Collection;

/* renamed from: j$.util.Collection$-CC  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class Collection$CC<E> {
    public static Stream $default$parallelStream(Collection collection) {
        return AbstractC0254w0.u1(Collection$EL.b(collection), true);
    }

    public static boolean $default$removeIf(Collection collection, Predicate predicate) {
        if (DesugarCollections.f50137a.isInstance(collection)) {
            return DesugarCollections.d(collection, predicate);
        }
        predicate.getClass();
        boolean z7 = false;
        java.util.Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            if (predicate.test(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    public static Stream $default$stream(Collection collection) {
        return AbstractC0254w0.u1(Collection$EL.b(collection), false);
    }

    public static Object[] $default$toArray(Collection collection, IntFunction intFunction) {
        return collection.toArray((Object[]) intFunction.apply(0));
    }
}
