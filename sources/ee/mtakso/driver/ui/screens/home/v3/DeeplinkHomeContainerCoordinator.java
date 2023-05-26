package ee.mtakso.driver.ui.screens.home.v3;

import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkHomeRouter;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkRoutingCommand;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeeplinkHomeContainerCoordinator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DeeplinkHomeContainerCoordinator implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private final DeeplinkHomeRouter f29743f;

    /* renamed from: g  reason: collision with root package name */
    private final DeepLinkManager f29744g;

    /* renamed from: h  reason: collision with root package name */
    private HomeContainer f29745h;

    @Inject
    public DeeplinkHomeContainerCoordinator(DeeplinkHomeRouter deeplinkHomeRouter, DeepLinkManager deepLinkManager) {
        Intrinsics.f(deeplinkHomeRouter, "deeplinkHomeRouter");
        Intrinsics.f(deepLinkManager, "deepLinkManager");
        this.f29743f = deeplinkHomeRouter;
        this.f29744g = deepLinkManager;
    }

    public final void a() {
        this.f29745h = null;
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        HomeContainer homeContainer;
        RoutingCommand.FragmentClass fragmentClass;
        Intrinsics.f(command, "command");
        if (!(command instanceof DeeplinkRoutingCommand) || (homeContainer = this.f29745h) == null) {
            return false;
        }
        DeeplinkRoutingCommand deeplinkRoutingCommand = (DeeplinkRoutingCommand) command;
        HomeContainerRoutingCommand a8 = this.f29743f.a(deeplinkRoutingCommand.c());
        if (a8 != null) {
            fragmentClass = a8.c();
        } else {
            fragmentClass = null;
        }
        if (fragmentClass == null) {
            return false;
        }
        this.f29744g.b(deeplinkRoutingCommand.c());
        homeContainer.a(fragmentClass.d(), fragmentClass.c());
        return true;
    }

    public final void c(HomeContainer container) {
        Intrinsics.f(container, "container");
        this.f29745h = container;
    }
}
