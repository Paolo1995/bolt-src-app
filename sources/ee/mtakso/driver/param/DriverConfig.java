package ee.mtakso.driver.param;

import ee.mtakso.driver.service.auth.AppVersionState;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverConfig.kt */
/* loaded from: classes3.dex */
public final class DriverConfig {

    /* renamed from: a  reason: collision with root package name */
    private final MutableDriverConfig f23112a;

    /* renamed from: b  reason: collision with root package name */
    private final ActiveReferralCampaign f23113b;

    public DriverConfig(MutableDriverConfig mutableDriverConfig) {
        Intrinsics.f(mutableDriverConfig, "mutableDriverConfig");
        this.f23112a = mutableDriverConfig;
        this.f23113b = mutableDriverConfig.a();
    }

    public final String A() {
        return this.f23112a.B().a();
    }

    public final String B() {
        return this.f23112a.C().a();
    }

    public final String C() {
        String a8 = this.f23112a.D().a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final String D() {
        String a8 = this.f23112a.E().a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final String E() {
        return this.f23112a.F().a();
    }

    public final String F() {
        return this.f23112a.G().a();
    }

    public final long G() {
        return this.f23112a.H().a();
    }

    public final boolean H() {
        return this.f23112a.I();
    }

    public final boolean I() {
        return this.f23112a.J().a();
    }

    public final boolean J() {
        return this.f23112a.K().a();
    }

    public final int K() {
        return this.f23112a.L().a();
    }

    public final List<DriverAppConfig.MaxClientDistance> L() {
        return this.f23112a.M();
    }

    public final DriverFeaturesConfig.WorkingTimeMode M() {
        return this.f23112a.N();
    }

    public final boolean N() {
        if (n() == 0) {
            return true;
        }
        return false;
    }

    public final boolean O() {
        if (n() > 0) {
            return true;
        }
        return false;
    }

    public final boolean P() {
        return this.f23112a.O();
    }

    public final boolean Q() {
        return this.f23112a.P();
    }

    public final boolean R() {
        if (L().size() > 1) {
            return true;
        }
        return false;
    }

    public final ActiveReferralCampaign a() {
        return this.f23113b;
    }

    public final DriverAppConfig.Activity b() {
        return this.f23112a.b();
    }

    public final String c() {
        return this.f23112a.c().a();
    }

    public final AppVersionState d() {
        return this.f23112a.d();
    }

    public final boolean e() {
        return this.f23112a.e();
    }

    public final DriverFeaturesConfig.CircleKLoyaltyCampaignStatus f() {
        return this.f23112a.h();
    }

    public final String g() {
        String a8 = this.f23112a.i().a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final boolean h() {
        return this.f23112a.j().a();
    }

    public final long i() {
        return this.f23112a.k().a();
    }

    public final String j() {
        String a8 = this.f23112a.l().a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final long k() {
        return this.f23112a.f().a();
    }

    public final String l() {
        String a8 = this.f23112a.g().a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final boolean m() {
        return this.f23112a.m().a();
    }

    public final int n() {
        return this.f23112a.n().a();
    }

    public final int o() {
        return this.f23112a.o().a();
    }

    public final boolean p() {
        return this.f23112a.p().a();
    }

    public final String q() {
        String a8 = this.f23112a.q().a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final boolean r() {
        return this.f23112a.r().a();
    }

    public final String s() {
        String a8 = this.f23112a.s().a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final long t() {
        return this.f23112a.u().b().a().longValue();
    }

    public final int u() {
        return this.f23112a.v().a();
    }

    public final int v() {
        return this.f23112a.w().a();
    }

    public final int w() {
        return this.f23112a.x().a();
    }

    public final boolean x() {
        return this.f23112a.y();
    }

    public final String y() {
        String a8 = this.f23112a.z().a();
        if (a8 != null) {
            return a8;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final boolean z() {
        return this.f23112a.A().a();
    }
}
