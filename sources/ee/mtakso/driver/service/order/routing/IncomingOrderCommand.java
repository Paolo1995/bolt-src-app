package ee.mtakso.driver.service.order.routing;

import android.app.PendingIntent;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderCommand.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderCommand extends RoutingCommand.ActivityPendingIntent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncomingOrderCommand(RoutingState newState, PendingIntent intent) {
        super(newState, intent);
        Intrinsics.f(newState, "newState");
        Intrinsics.f(intent, "intent");
    }
}
