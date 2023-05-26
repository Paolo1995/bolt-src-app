package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.em;
import eu.bolt.verification.sdk.internal.io;
import eu.bolt.verification.sdk.internal.sm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class rq {
    private final Set<String> c(em emVar) {
        String a8;
        Set<String> a9;
        Set<String> L0;
        if (emVar instanceof em.a) {
            L0 = CollectionsKt___CollectionsKt.L0(((em.a) emVar).b());
            return L0;
        }
        if (emVar instanceof em.b) {
            a8 = ((em.b) emVar).a();
        } else if (emVar instanceof em.c) {
            a8 = String.valueOf(((em.c) emVar).a());
        } else if (emVar instanceof em.d) {
            a8 = String.valueOf(((em.d) emVar).a());
        } else if (!(emVar instanceof em.f)) {
            if (emVar instanceof em.e) {
                return ((em.e) emVar).b();
            }
            throw new NoWhenBranchMatchedException();
        } else {
            a8 = ((em.f) emVar).a();
        }
        a9 = SetsKt__SetsJVMKt.a(a8);
        return a9;
    }

    public final em a(sm.g.b from) {
        Set b8;
        Intrinsics.f(from, "from");
        if (!from.b().isEmpty()) {
            return new em.e(from.a(), from.b());
        }
        String a8 = from.a();
        b8 = SetsKt__SetsKt.b();
        return new em.e(a8, b8);
    }

    public final List<io.a> b(Map<String, ? extends em> from) {
        int v7;
        Intrinsics.f(from, "from");
        Set<Map.Entry<String, ? extends em>> entrySet = from.entrySet();
        v7 = CollectionsKt__IterablesKt.v(entrySet, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new io.a((String) entry.getKey(), c((em) entry.getValue())));
        }
        return arrayList;
    }
}
