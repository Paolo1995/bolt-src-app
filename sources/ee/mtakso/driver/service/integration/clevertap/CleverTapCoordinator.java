package ee.mtakso.driver.service.integration.clevertap;

import ee.mtakso.App;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CleverTapCoordinator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class CleverTapCoordinator implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private final CleverTapManager f24526f;

    @Inject
    public CleverTapCoordinator(CleverTapManager cleverTapManager) {
        Intrinsics.f(cleverTapManager, "cleverTapManager");
        this.f24526f = cleverTapManager;
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (!(command instanceof CleverTapInboxRoutingCommand)) {
            return false;
        }
        CleverTapManager cleverTapManager = this.f24526f;
        App app = App.getInstance();
        Intrinsics.e(app, "getInstance()");
        cleverTapManager.r(app);
        return true;
    }
}
