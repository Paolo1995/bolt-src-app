package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.utils.urlcomand.UrlRoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FallbackWebPageDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class FallbackWebPageDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.FallbackWebPage deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return new UrlRoutingCommand(deeplink.b(), null, 2, null);
    }
}
