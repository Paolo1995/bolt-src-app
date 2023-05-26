package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlFragment;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestWebUrlDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class RequestWebUrlDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.RequestWebUrl deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return RequestWebUrlFragment.f29410r.a(deeplink.b());
    }
}
