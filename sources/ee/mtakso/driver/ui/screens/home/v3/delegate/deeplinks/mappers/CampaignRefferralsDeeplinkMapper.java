package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import android.os.Bundle;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.shared.InviteDriversActivity;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignRefferralsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class CampaignRefferralsDeeplinkMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f29970a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverReferralCampaignManager f29971b;

    @Inject
    public CampaignRefferralsDeeplinkMapper(DriverProvider driverProvider, DriverReferralCampaignManager driverReferralCampaignManager) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverReferralCampaignManager, "driverReferralCampaignManager");
        this.f29970a = driverProvider;
        this.f29971b = driverReferralCampaignManager;
    }

    private final RoutingCommand.ActivityClass a() {
        return SimpleActivity.Companion.f(SimpleActivity.f27004l, ReferralCampaignDetailsFragment.class, null, false, 0, 14, null);
    }

    private final RoutingCommand.ActivityClass b() {
        RoutingState routingState = new RoutingState(InviteDriversActivity.class, null, 2, null);
        Bundle bundle = new Bundle();
        bundle.putString("extra_ref_code", this.f29970a.o().E());
        return new RoutingCommand.ActivityClass(routingState, InviteDriversActivity.class, bundle, 0, 8, null);
    }

    public RoutingCommand.ActivityClass c(DeeplinkCall.CampaignReferrals deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        if (this.f29971b.e()) {
            return a();
        }
        return b();
    }
}
