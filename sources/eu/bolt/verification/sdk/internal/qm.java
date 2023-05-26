package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.d;
import eu.bolt.verification.sdk.internal.ro;
import eu.bolt.verification.sdk.internal.sm;
import eu.bolt.verification.sdk.internal.td;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class qm {

    /* renamed from: a  reason: collision with root package name */
    private final jr f44672a;

    /* renamed from: b  reason: collision with root package name */
    private final nm f44673b;

    /* renamed from: c  reason: collision with root package name */
    private final lm f44674c;

    /* renamed from: d  reason: collision with root package name */
    private final cq f44675d;

    /* renamed from: e  reason: collision with root package name */
    private final fm f44676e;

    /* renamed from: f  reason: collision with root package name */
    private final rq f44677f;

    @Inject
    public qm(jr webViewQueryParamsWrapper, nm conditionMapper, lm bottomSheetButtonMapper, cq supportWebViewMapper, fm actionAnalyticsMapper, rq userInputMapper) {
        Intrinsics.f(webViewQueryParamsWrapper, "webViewQueryParamsWrapper");
        Intrinsics.f(conditionMapper, "conditionMapper");
        Intrinsics.f(bottomSheetButtonMapper, "bottomSheetButtonMapper");
        Intrinsics.f(supportWebViewMapper, "supportWebViewMapper");
        Intrinsics.f(actionAnalyticsMapper, "actionAnalyticsMapper");
        Intrinsics.f(userInputMapper, "userInputMapper");
        this.f44672a = webViewQueryParamsWrapper;
        this.f44673b = conditionMapper;
        this.f44674c = bottomSheetButtonMapper;
        this.f44675d = supportWebViewMapper;
        this.f44676e = actionAnalyticsMapper;
        this.f44677f = userInputMapper;
    }

    public final b1.a a(sm from) {
        Object W;
        int v7;
        Intrinsics.f(from, "from");
        if (from instanceof sm.e) {
            kp kpVar = new kp(new td.b(((sm.e) from).c().a(), null, 2, null), null, null);
            hm a8 = from.a();
            return new b1.a(new d.e(kpVar, a8 != null ? this.f44676e.a(a8) : null), this.f44673b.a(from.b()));
        } else if (from instanceof sm.j) {
            kp a9 = this.f44675d.a(((sm.j) from).c());
            kp a10 = kp.a(a9, this.f44672a.a(a9.e()), null, null, 6, null);
            hm a11 = from.a();
            return new b1.a(new d.e(a10, a11 != null ? this.f44676e.a(a11) : null), this.f44673b.a(from.b()));
        } else if (from instanceof sm.d) {
            sm.d dVar = (sm.d) from;
            String c8 = dVar.c().c();
            String b8 = dVar.c().b();
            List<ro.a> a12 = dVar.c().a();
            v7 = CollectionsKt__IterablesKt.v(a12, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (ro.a aVar : a12) {
                arrayList.add(this.f44674c.b(aVar));
            }
            hm a13 = from.a();
            return new b1.a(new d.C0042d(c8, b8, arrayList, a13 != null ? this.f44676e.a(a13) : null), this.f44673b.a(from.b()));
        } else if (from instanceof sm.f) {
            sm.f fVar = (sm.f) from;
            String b9 = fVar.c().b();
            Map<String, String> a14 = fVar.c().a();
            hm a15 = from.a();
            return new b1.a(new d.f(b9, a14, a15 != null ? this.f44676e.a(a15) : null), this.f44673b.a(from.b()));
        } else if (from instanceof sm.c) {
            String a16 = ((sm.c) from).c().a();
            hm a17 = from.a();
            return new b1.a(new d.c(a16, a17 != null ? this.f44676e.a(a17) : null), this.f44673b.a(from.b()));
        } else if (from instanceof sm.l) {
            String a18 = ((sm.l) from).c().a();
            hm a19 = from.a();
            return new b1.a(new d.g(a18, a19 != null ? this.f44676e.a(a19) : null), this.f44673b.a(from.b()));
        } else if (from instanceof sm.a) {
            return new b1.a(d.b.f42549f, this.f44673b.a(from.b()));
        } else {
            if (from instanceof sm.b) {
                return new b1.a(d.a.f42547f, this.f44673b.a(from.b()));
            }
            if (from instanceof sm.k) {
                return new b1.a(d.k.f42570f, this.f44673b.a(from.b()));
            }
            if (from instanceof sm.h) {
                String a20 = ((sm.h) from).c().a();
                hm a21 = from.a();
                return new b1.a(new d.i(a20, a21 != null ? this.f44676e.a(a21) : null), this.f44673b.a(from.b()));
            } else if (from instanceof sm.g) {
                rq rqVar = this.f44677f;
                W = CollectionsKt___CollectionsKt.W(((sm.g) from).c().a());
                em a22 = rqVar.a((sm.g.b) W);
                hm a23 = from.a();
                return new b1.a(new d.h(a22, a23 != null ? this.f44676e.a(a23) : null), this.f44673b.a(from.b()));
            } else if (from instanceof sm.i) {
                String a24 = ((sm.i) from).c().a();
                hm a25 = from.a();
                return new b1.a(new d.j(a24, a25 != null ? this.f44676e.a(a25) : null), this.f44673b.a(from.b()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}
