package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignOptInDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class CampaignOptInDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.CampaignOptIn deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return OptInCampaignFragment.f27598v.b(deeplink.b());
    }
}
