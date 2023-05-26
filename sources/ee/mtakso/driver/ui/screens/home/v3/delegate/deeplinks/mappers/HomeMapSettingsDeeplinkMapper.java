package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeMapSettingsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class HomeMapSettingsDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.HomeMapSettings deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return MapSettingsFragment.f34136w.a();
    }
}
