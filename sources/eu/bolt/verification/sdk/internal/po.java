package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.o9;
import eu.bolt.verification.sdk.internal.r1;
import eu.bolt.verification.sdk.internal.ro;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class po {

    /* renamed from: a  reason: collision with root package name */
    private final iq f44560a;

    /* renamed from: b  reason: collision with root package name */
    private final um f44561b;

    /* renamed from: c  reason: collision with root package name */
    private final so f44562c;

    /* renamed from: d  reason: collision with root package name */
    private final gq f44563d;

    /* renamed from: e  reason: collision with root package name */
    private final qm f44564e;

    @Inject
    public po(iq textInputMapper, um buttonMapper, so imageAlignmentMapper, gq textAlignmentMapper, qm actionMapper) {
        Intrinsics.f(textInputMapper, "textInputMapper");
        Intrinsics.f(buttonMapper, "buttonMapper");
        Intrinsics.f(imageAlignmentMapper, "imageAlignmentMapper");
        Intrinsics.f(textAlignmentMapper, "textAlignmentMapper");
        Intrinsics.f(actionMapper, "actionMapper");
        this.f44560a = textInputMapper;
        this.f44561b = buttonMapper;
        this.f44562c = imageAlignmentMapper;
        this.f44563d = textAlignmentMapper;
        this.f44564e = actionMapper;
    }

    public final ob a(ro from) {
        ob o9Var;
        hh hhVar;
        gh ghVar;
        int v7;
        List k8;
        ArrayList arrayList;
        int v8;
        Object W;
        Intrinsics.f(from, "from");
        if (from instanceof ro.g) {
            String a8 = from.a();
            ro.g gVar = (ro.g) from;
            String d8 = gVar.b().d();
            String b8 = gVar.b().b();
            fl a9 = this.f44563d.a(gVar.b().c());
            List<ro.g.b> e8 = gVar.b().e();
            if (e8 != null) {
                v8 = CollectionsKt__IterablesKt.v(e8, 10);
                ArrayList arrayList2 = new ArrayList(v8);
                for (ro.g.b bVar : e8) {
                    String b9 = bVar.b();
                    qm qmVar = this.f44564e;
                    W = CollectionsKt___CollectionsKt.W(bVar.a());
                    arrayList2.add(new cm(b9, qmVar.a((sm) W).a()));
                }
                arrayList = arrayList2;
            } else {
                k8 = CollectionsKt__CollectionsKt.k();
                arrayList = k8;
            }
            return new be(a8, d8, b8, a9, arrayList, gVar.b().a());
        }
        if (from instanceof ro.e) {
            String a10 = from.a();
            ro.e eVar = (ro.e) from;
            o9Var = new o9(a10, new o9.b.C0081b(eVar.b().b()), this.f44562c.a(eVar.b().a()));
        } else if (from instanceof ro.h) {
            return this.f44560a.b((ro.h) from);
        } else {
            if (from instanceof ro.d) {
                o9Var = new r3(from.a(), ((ro.d) from).b().a());
            } else {
                ArrayList arrayList3 = null;
                if (from instanceof ro.b) {
                    String a11 = from.a();
                    ro.b bVar2 = (ro.b) from;
                    List<ro.b.C0087b> b10 = bVar2.b().b();
                    v7 = CollectionsKt__IterablesKt.v(b10, 10);
                    ArrayList arrayList4 = new ArrayList(v7);
                    for (ro.b.C0087b c0087b : b10) {
                        arrayList4.add(new r1.a(c0087b.b(), c0087b.d(), c0087b.c(), c0087b.a()));
                    }
                    return new r1(a11, arrayList4, bVar2.b().a(), null);
                } else if (!(from instanceof ro.f)) {
                    if (from instanceof ro.a) {
                        return this.f44561b.b((ro.a) from);
                    }
                    if (from instanceof ro.c) {
                        String a12 = from.a();
                        ro.c cVar = (ro.c) from;
                        h2 a13 = h2.f43225j.a(cVar.b().b());
                        if (a13 == null) {
                            a13 = h2.f43301y0;
                        }
                        List<ro.c.b> a14 = cVar.b().a();
                        if (a14 != null) {
                            arrayList3 = new ArrayList();
                            for (ro.c.b bVar3 : a14) {
                                h2 a15 = h2.f43225j.a(bVar3.a());
                                if (a15 != null) {
                                    arrayList3.add(a15);
                                }
                            }
                        }
                        return new k2(a12, a13, arrayList3);
                    }
                    throw new NoWhenBranchMatchedException();
                } else {
                    String a16 = from.a();
                    ro.f fVar = (ro.f) from;
                    String c8 = fVar.b().c();
                    ro.f.b b11 = fVar.b().b();
                    if (b11 instanceof ro.f.b.a) {
                        hhVar = hh.OVAL;
                    } else if (!(b11 instanceof ro.f.b.C0089b)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        hhVar = hh.RECTANGLE;
                    }
                    ro.f.b b12 = fVar.b().b();
                    if (b12 instanceof ro.f.b.a) {
                        ghVar = new gh(((ro.f.b.a) fVar.b().b()).a().b(), ((ro.f.b.a) fVar.b().b()).a().a());
                    } else if (!(b12 instanceof ro.f.b.C0089b)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        ghVar = new gh(((ro.f.b.C0089b) fVar.b().b()).a().b(), ((ro.f.b.C0089b) fVar.b().b()).a().a());
                    }
                    o9Var = new o9(a16, new o9.b.a(c8, new ec(hhVar, ghVar)), this.f44562c.a(fVar.b().a()));
                }
            }
        }
        return o9Var;
    }
}
