package kotlinx.coroutines;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;

/* compiled from: Await.kt */
/* loaded from: classes5.dex */
public final class AwaitKt {
    public static final <T> Object a(Collection<? extends Deferred<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        List k8;
        if (collection.isEmpty()) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        Object[] array = collection.toArray(new Deferred[0]);
        if (array != null) {
            return new AwaitAll((Deferred[]) array).b(continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
