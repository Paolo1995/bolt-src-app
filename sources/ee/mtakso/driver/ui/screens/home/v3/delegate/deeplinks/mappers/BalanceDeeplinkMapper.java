package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BalanceDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class BalanceDeeplinkMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f29969a;

    @Inject
    public BalanceDeeplinkMapper(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        this.f29969a = driverProvider;
    }

    public RoutingCommand a(DeeplinkCall.Balance deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        if (this.f29969a.q().j()) {
            return EarningsBalanceFragment.f28776w.a();
        }
        return EarningsActivity.D.a(EarningsScreenType.BALANCE);
    }
}
