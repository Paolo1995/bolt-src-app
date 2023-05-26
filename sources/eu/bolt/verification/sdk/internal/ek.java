package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.bk;
import eu.bolt.verification.sdk.internal.jk;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ek {

    /* renamed from: a  reason: collision with root package name */
    private final ck f42802a;

    @Inject
    public ek(ck storySlideContentItemMapper) {
        Intrinsics.f(storySlideContentItemMapper, "storySlideContentItemMapper");
        this.f42802a = storySlideContentItemMapper;
    }

    private final bk.c a(jk.c cVar) {
        return new bk.c(cVar.d(), cVar.b(), cVar.a(), cVar.c());
    }

    public final bk b(jk.b from) {
        int v7;
        List T;
        Intrinsics.f(from, "from");
        bk.c a8 = a(from.d());
        int c8 = from.c();
        int a9 = from.a().a();
        List<jk.g> b8 = from.b();
        ck ckVar = this.f42802a;
        v7 = CollectionsKt__IterablesKt.v(b8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (jk.g gVar : b8) {
            arrayList.add(ckVar.b(gVar));
        }
        T = CollectionsKt___CollectionsKt.T(arrayList);
        return new bk(a8, c8, a9, T);
    }
}
