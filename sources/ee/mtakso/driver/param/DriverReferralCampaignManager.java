package ee.mtakso.driver.param;

import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DriverReferralCampaignManager.kt */
/* loaded from: classes3.dex */
public final class DriverReferralCampaignManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f23157a;

    /* compiled from: DriverReferralCampaignManager.kt */
    /* loaded from: classes3.dex */
    public enum TileScreen {
        CAMPAIGNS("campaigns"),
        WORK("work");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f23161f;

        TileScreen(String str) {
            this.f23161f = str;
        }

        public final String c() {
            return this.f23161f;
        }
    }

    @Inject
    public DriverReferralCampaignManager(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f23157a = driverProvider;
    }

    private final DriverConfig b() {
        return this.f23157a.n();
    }

    public final Long a() {
        long b8 = b().a().b();
        if (b8 != 0) {
            return Long.valueOf(b8);
        }
        return null;
    }

    public final String c() {
        return b().a().a();
    }

    public final boolean d(TileScreen tileScreen) {
        Intrinsics.f(tileScreen, "tileScreen");
        return b().a().c(tileScreen);
    }

    public final boolean e() {
        return true;
    }

    public final void f(TileScreen tileScreen) {
        Intrinsics.f(tileScreen, "tileScreen");
        b().a().e(tileScreen, true);
    }

    public final boolean g(TileScreen tileScreen) {
        boolean z7;
        boolean y7;
        Intrinsics.f(tileScreen, "tileScreen");
        String E = b().E();
        if (E != null) {
            y7 = StringsKt__StringsJVMKt.y(E);
            if (!y7) {
                z7 = false;
                if (!z7 || !e() || d(tileScreen) || c() == null) {
                    return false;
                }
                return true;
            }
        }
        z7 = true;
        return !z7 ? false : false;
    }
}
