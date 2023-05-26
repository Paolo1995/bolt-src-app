package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsDeeplinkMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f29985a;

    @Inject
    public EarningsDeeplinkMapper(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f29985a = driverProvider;
    }

    public RoutingCommand a(DeeplinkCall.Earnings deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        if (this.f29985a.q().v()) {
            return SimpleActivity.Companion.f(SimpleActivity.f27004l, EarningsLandingFragment.class, null, false, 0, 14, null);
        }
        return EarningsActivity.D.a(EarningsScreenType.BALANCE);
    }
}
