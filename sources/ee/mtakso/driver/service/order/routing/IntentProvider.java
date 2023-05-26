package ee.mtakso.driver.service.order.routing;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderActivity;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.driver.core.util.PendingIntentFactory;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntentProvider.kt */
/* loaded from: classes3.dex */
public final class IntentProvider {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f25498b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f25499a;

    /* compiled from: IntentProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public IntentProvider(Context context) {
        Intrinsics.f(context, "context");
        this.f25499a = context;
    }

    private final Intent b(OrderHandle orderHandle) {
        return IncomingOrderActivity.f31356i.a(this.f25499a, orderHandle);
    }

    public final RoutingCommand a(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return new IncomingOrderCommand(new RoutingState(IncomingOrderActivity.class, null, 2, null), c(orderHandle));
    }

    public final PendingIntent c(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return PendingIntentFactory.b(new PendingIntentFactory(this.f25499a), b(orderHandle), 998, 134217728, null, 8, null);
    }
}
