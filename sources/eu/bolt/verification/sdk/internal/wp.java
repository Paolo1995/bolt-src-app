package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.k7;
import eu.bolt.verification.sdk.internal.nh;
import eu.bolt.verification.sdk.internal.yp;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class wp {

    /* renamed from: a  reason: collision with root package name */
    private final zp f45579a;

    /* renamed from: b  reason: collision with root package name */
    private final up f45580b;

    /* renamed from: c  reason: collision with root package name */
    private final sp f45581c;

    /* renamed from: d  reason: collision with root package name */
    private final qp f45582d;

    /* renamed from: e  reason: collision with root package name */
    private final op f45583e;

    /* renamed from: f  reason: collision with root package name */
    private final fm f45584f;

    @Inject
    public wp(zp titleMapper, up formLayoutMapper, sp cameraLayoutMapper, qp backNavigationMapper, op stepAnalyticsMapper, fm actionAnalyticsMapper) {
        Intrinsics.f(titleMapper, "titleMapper");
        Intrinsics.f(formLayoutMapper, "formLayoutMapper");
        Intrinsics.f(cameraLayoutMapper, "cameraLayoutMapper");
        Intrinsics.f(backNavigationMapper, "backNavigationMapper");
        Intrinsics.f(stepAnalyticsMapper, "stepAnalyticsMapper");
        Intrinsics.f(actionAnalyticsMapper, "actionAnalyticsMapper");
        this.f45579a = titleMapper;
        this.f45580b = formLayoutMapper;
        this.f45581c = cameraLayoutMapper;
        this.f45582d = backNavigationMapper;
        this.f45583e = stepAnalyticsMapper;
        this.f45584f = actionAnalyticsMapper;
    }

    public final k7 a(yp from) {
        Intrinsics.f(from, "from");
        if (from instanceof yp.b) {
            String d8 = from.d();
            k7.c a8 = this.f45579a.a(from.f());
            nh.b a9 = this.f45580b.a((yp.b) from);
            k7.a a10 = this.f45582d.a(from.b());
            yp.c a11 = from.a();
            k7.b a12 = a11 != null ? this.f45583e.a(a11) : null;
            hm c8 = from.c();
            return new k7(d8, a8, a9, a10, a12, c8 != null ? this.f45584f.a(c8) : null);
        } else if (from instanceof yp.a) {
            String d9 = from.d();
            k7.c a13 = this.f45579a.a(from.f());
            nh.a b8 = this.f45581c.b((yp.a) from);
            k7.a a14 = this.f45582d.a(from.b());
            yp.c a15 = from.a();
            k7.b a16 = a15 != null ? this.f45583e.a(a15) : null;
            hm c9 = from.c();
            return new k7(d9, a13, b8, a14, a16, c9 != null ? this.f45584f.a(c9) : null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
