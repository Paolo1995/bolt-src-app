package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CircleKDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class CircleKDeeplinkMapper {
    public RoutingCommand.ActivityClass a(DeeplinkCall.CircleK deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return SimpleActivity.Companion.f(SimpleActivity.f27004l, CircleKLoyaltyStarterFragment.class, null, false, 0, 10, null);
    }
}
