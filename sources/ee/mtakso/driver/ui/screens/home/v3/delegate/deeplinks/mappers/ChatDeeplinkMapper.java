package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class ChatDeeplinkMapper {
    public RoutingCommand a(DeeplinkCall.Chat deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        return DriverChatSdk.f40388a.a();
    }
}
