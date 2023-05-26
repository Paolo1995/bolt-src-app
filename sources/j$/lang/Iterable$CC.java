package j$.lang;

import j$.util.DesugarCollections;
import j$.util.function.Consumer;
import java.util.Iterator;

/* renamed from: j$.lang.Iterable$-CC  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class Iterable$CC<T> {
    public static void $default$forEach(Iterable iterable, Consumer consumer) {
        if (DesugarCollections.f50137a.isInstance(iterable)) {
            DesugarCollections.c(iterable, consumer);
            return;
        }
        consumer.getClass();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }
}
