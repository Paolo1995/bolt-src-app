package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBreakdownDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownDeeplinkMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f29984a;

    @Inject
    public EarningsBreakdownDeeplinkMapper(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f29984a = driverProvider;
    }

    public RoutingCommand a(DeeplinkCall.EarningsBreakdown deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        if (this.f29984a.q().t()) {
            return EarningsBreakdownFragment.f28891w.a();
        }
        return EarningsActivity.D.a(EarningsScreenType.EARNINGS);
    }
}
