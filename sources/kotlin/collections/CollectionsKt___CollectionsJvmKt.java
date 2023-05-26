package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _CollectionsJvm.kt */
/* loaded from: classes5.dex */
public class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static <R> List<R> L(Iterable<?> iterable, Class<R> klass) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(klass, "klass");
        return (List) M(iterable, new ArrayList(), klass);
    }

    public static final <C extends Collection<? super R>, R> C M(Iterable<?> iterable, C destination, Class<R> klass) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(destination, "destination");
        Intrinsics.f(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final <T> void N(List<T> list) {
        Intrinsics.f(list, "<this>");
        Collections.reverse(list);
    }
}
