package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks;

import ee.mtakso.driver.deeplink.DeepLinkManager;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeeplinkCoordinator.kt */
/* loaded from: classes3.dex */
public final class DeeplinkCoordinator implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private final DeeplinkActivityMapper f29955f;

    /* renamed from: g  reason: collision with root package name */
    private final DeepLinkManager f29956g;

    /* renamed from: h  reason: collision with root package name */
    private final RoutingManager f29957h;

    @Inject
    public DeeplinkCoordinator(DeeplinkActivityMapper deeplinkActivityRouter, DeepLinkManager deepLinkManager, RoutingManager routingManager) {
        Intrinsics.f(deeplinkActivityRouter, "deeplinkActivityRouter");
        Intrinsics.f(deepLinkManager, "deepLinkManager");
        Intrinsics.f(routingManager, "routingManager");
        this.f29955f = deeplinkActivityRouter;
        this.f29956g = deepLinkManager;
        this.f29957h = routingManager;
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (!(command instanceof DeeplinkRoutingCommand)) {
            return false;
        }
        DeeplinkRoutingCommand deeplinkRoutingCommand = (DeeplinkRoutingCommand) command;
        RoutingCommand a8 = this.f29955f.a(deeplinkRoutingCommand.c());
        if (a8 == null) {
            return false;
        }
        this.f29956g.b(deeplinkRoutingCommand.c());
        this.f29957h.c(a8);
        return true;
    }
}
