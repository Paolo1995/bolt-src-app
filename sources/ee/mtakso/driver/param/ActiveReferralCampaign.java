package ee.mtakso.driver.param;

import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.param.field.LongSettingsField;
import ee.mtakso.driver.param.field.StringSettingsField;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveReferralCampaign.kt */
/* loaded from: classes3.dex */
public final class ActiveReferralCampaign {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f23066d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f23067a;

    /* renamed from: b  reason: collision with root package name */
    private final LongSettingsField f23068b;

    /* renamed from: c  reason: collision with root package name */
    private final StringSettingsField f23069c;

    /* compiled from: ActiveReferralCampaign.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ActiveReferralCampaign(BoltPrefsStorage driverStorage) {
        Intrinsics.f(driverStorage, "driverStorage");
        this.f23067a = driverStorage;
        this.f23068b = new LongSettingsField("referrals_campaign_id", 0L, driverStorage);
        this.f23069c = new StringSettingsField("referrals_earned_amount", null, driverStorage);
    }

    public final String a() {
        return this.f23069c.a();
    }

    public final long b() {
        return this.f23068b.a();
    }

    public final boolean c(DriverReferralCampaignManager.TileScreen tileScreen) {
        Intrinsics.f(tileScreen, "tileScreen");
        BoltPrefsStorage boltPrefsStorage = this.f23067a;
        String c8 = tileScreen.c();
        return boltPrefsStorage.getBoolean("is_referrals_dismissed_before_in" + c8, false);
    }

    public final void d(DriverAppConfig.Referral referral) {
        String str;
        boolean z7;
        long b8 = b();
        if (b8 != 0) {
            if (referral != null && b8 == referral.b()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                for (DriverReferralCampaignManager.TileScreen tileScreen : DriverReferralCampaignManager.TileScreen.values()) {
                    e(tileScreen, false);
                }
            }
        }
        StringSettingsField stringSettingsField = this.f23069c;
        if (referral != null) {
            str = referral.a();
        } else {
            str = null;
        }
        stringSettingsField.b(str);
    }

    public final void e(DriverReferralCampaignManager.TileScreen tileScreen, boolean z7) {
        Intrinsics.f(tileScreen, "tileScreen");
        BoltPrefsStorage boltPrefsStorage = this.f23067a;
        String c8 = tileScreen.c();
        boltPrefsStorage.h("is_referrals_dismissed_before_in" + c8, Boolean.valueOf(z7));
    }
}
