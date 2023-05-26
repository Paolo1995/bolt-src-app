package ee.mtakso.driver.utils.urlcomand;

import android.annotation.SuppressLint;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import ee.mtakso.driver.utils.customtabs.CustomTabsUrlLauncher;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlCoordinator.kt */
@Singleton
/* loaded from: classes5.dex */
public final class UrlCoordinator implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private final CustomTabsUrlLauncher f36478f;

    /* renamed from: g  reason: collision with root package name */
    private final SystemUrlLauncher f36479g;

    @Inject
    public UrlCoordinator(CustomTabsUrlLauncher customTabsUrlLauncher, SystemUrlLauncher systemUrlLauncher) {
        Intrinsics.f(customTabsUrlLauncher, "customTabsUrlLauncher");
        Intrinsics.f(systemUrlLauncher, "systemUrlLauncher");
        this.f36478f = customTabsUrlLauncher;
        this.f36479g = systemUrlLauncher;
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    @SuppressLint({"CheckResult"})
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (!(command instanceof UrlRoutingCommand)) {
            return false;
        }
        UrlRoutingCommand urlRoutingCommand = (UrlRoutingCommand) command;
        if (!this.f36478f.a(urlRoutingCommand.c()) && !this.f36479g.a(urlRoutingCommand.c())) {
            return false;
        }
        return true;
    }
}
