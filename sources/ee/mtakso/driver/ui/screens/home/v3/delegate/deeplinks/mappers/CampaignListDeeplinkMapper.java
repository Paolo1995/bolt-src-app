package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignListDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class CampaignListDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.CampaignList deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return SimpleActivity.Companion.f(SimpleActivity.f27004l, ActiveCampaignsFragment.class, null, false, 0, 14, null);
    }
}
