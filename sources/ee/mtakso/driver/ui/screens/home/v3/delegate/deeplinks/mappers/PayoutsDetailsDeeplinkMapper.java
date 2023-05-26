package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsActivity;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassStackCommand;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutsDetailsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class PayoutsDetailsDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.PayoutDetails deeplink) {
        List n8;
        Intrinsics.f(deeplink, "deeplink");
        n8 = CollectionsKt__CollectionsKt.n(EarningsActivity.D.a(EarningsScreenType.BALANCE), SimpleActivity.Companion.b(SimpleActivity.f27004l, PayoutHistoryFragment.class, null, true, 0, 10, null), PayoutDetailsActivity.f28656r.a(deeplink.b()));
        return new ActivityClassStackCommand(n8);
    }
}
