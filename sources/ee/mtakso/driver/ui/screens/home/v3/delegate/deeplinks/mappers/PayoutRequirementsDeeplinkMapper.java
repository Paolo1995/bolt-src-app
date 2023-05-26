package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutRequirementsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class PayoutRequirementsDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.PayoutRequirements deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return HowToRequestPayoutFragment.f28720q.a();
    }
}
