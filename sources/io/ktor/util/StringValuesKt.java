package io.ktor.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
/* loaded from: classes5.dex */
public final class StringValuesKt {
    public static final StringValuesBuilder c(StringValuesBuilder stringValuesBuilder, StringValuesBuilder builder) {
        Intrinsics.f(stringValuesBuilder, "<this>");
        Intrinsics.f(builder, "builder");
        Iterator<T> it = builder.a().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            stringValuesBuilder.e((String) entry.getKey(), (List) entry.getValue());
        }
        return stringValuesBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Set<? extends Map.Entry<String, ? extends List<String>>> set, Set<? extends Map.Entry<String, ? extends List<String>>> set2) {
        return Intrinsics.a(set, set2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(Set<? extends Map.Entry<String, ? extends List<String>>> set, int i8) {
        return (i8 * 31) + set.hashCode();
    }

    public static final List<Pair<String, String>> f(StringValues stringValues) {
        int v7;
        Intrinsics.f(stringValues, "<this>");
        Set<Map.Entry<String, List<String>>> a8 = stringValues.a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a8.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable<String> iterable = (Iterable) entry.getValue();
            v7 = CollectionsKt__IterablesKt.v(iterable, 10);
            ArrayList arrayList2 = new ArrayList(v7);
            for (String str : iterable) {
                arrayList2.add(TuplesKt.a(entry.getKey(), str));
            }
            CollectionsKt__MutableCollectionsKt.A(arrayList, arrayList2);
        }
        return arrayList;
    }
}
