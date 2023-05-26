package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.support.SupportFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: SupportTicketDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class SupportTicketDeeplinkMapper {
    public RoutingCommand.ActivityClass a(DeeplinkCall.SupportTicket deeplink) {
        boolean y7;
        Intrinsics.f(deeplink, "deeplink");
        String b8 = deeplink.b();
        y7 = StringsKt__StringsJVMKt.y(b8);
        if (!(!y7)) {
            b8 = null;
        }
        if (b8 == null) {
            return null;
        }
        return SupportFragment.Companion.b(SupportFragment.f33440u, null, b8, 1, null);
    }
}
