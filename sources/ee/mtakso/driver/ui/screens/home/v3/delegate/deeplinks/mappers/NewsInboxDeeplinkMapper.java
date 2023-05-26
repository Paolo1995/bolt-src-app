package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.service.integration.clevertap.CleverTapInboxRoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewsInboxDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class NewsInboxDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.NewsInbox deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return new CleverTapInboxRoutingCommand();
    }
}
