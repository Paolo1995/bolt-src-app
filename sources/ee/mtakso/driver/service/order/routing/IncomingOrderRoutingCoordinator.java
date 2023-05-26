package ee.mtakso.driver.service.order.routing;

import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderRoutingCoordinator.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderRoutingCoordinator implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private final UiNotificationManager f25493f;

    /* renamed from: g  reason: collision with root package name */
    private final OrderTracker f25494g;

    /* renamed from: h  reason: collision with root package name */
    private AtomicInteger f25495h;

    @Inject
    public IncomingOrderRoutingCoordinator(UiNotificationManager uiNotificationManager, OrderTracker orderTracker) {
        Intrinsics.f(uiNotificationManager, "uiNotificationManager");
        Intrinsics.f(orderTracker, "orderTracker");
        this.f25493f = uiNotificationManager;
        this.f25494g = orderTracker;
        this.f25495h = new AtomicInteger(0);
    }

    public final void a() {
        this.f25495h.set(0);
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (!(command instanceof IncomingOrderCommand)) {
            return false;
        }
        int incrementAndGet = this.f25495h.incrementAndGet();
        if (incrementAndGet != 1 && incrementAndGet != 2) {
            if (incrementAndGet == 3) {
                this.f25493f.D();
                this.f25494g.A();
            }
        } else {
            this.f25494g.z();
            ((IncomingOrderCommand) command).c().send();
        }
        return true;
    }
}
