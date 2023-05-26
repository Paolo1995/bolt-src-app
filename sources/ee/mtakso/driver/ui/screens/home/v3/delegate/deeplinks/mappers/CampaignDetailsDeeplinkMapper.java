package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDetailsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class CampaignDetailsDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.CampaignDetails deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return SimpleActivity.Companion.f(SimpleActivity.f27004l, CampaignDetailsFragment.class, CampaignDetailsFragment.A.a(deeplink.b()), false, 0, 12, null);
    }
}
