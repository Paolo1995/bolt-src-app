package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutConfirmationDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class PayoutConfirmationDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.PayoutConfirmation deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return PayoutRequestFragment.f28731t.a();
    }
}
