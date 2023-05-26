package ee.mtakso.driver.identity.verification;

import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityVerificationCoordinator.kt */
/* loaded from: classes3.dex */
public final class IdentityVerificationCoordinator implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private final IdentityVerificationManager f20971f;

    @Inject
    public IdentityVerificationCoordinator(IdentityVerificationManager identityVerificationManager) {
        Intrinsics.f(identityVerificationManager, "identityVerificationManager");
        this.f20971f = identityVerificationManager;
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (!(command instanceof IdentityVerificationRoutingCommand)) {
            return false;
        }
        this.f20971f.d(((IdentityVerificationRoutingCommand) command).c());
        return true;
    }
}
