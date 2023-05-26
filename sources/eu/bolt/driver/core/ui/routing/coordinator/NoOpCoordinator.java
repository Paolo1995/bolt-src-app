package eu.bolt.driver.core.ui.routing.coordinator;

import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoOpCoordinator.kt */
/* loaded from: classes5.dex */
public final class NoOpCoordinator implements Coordinator {
    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        Kalev.e(new IllegalStateException("NO-OP coordinator reached. Command: " + command), "Boo");
        return false;
    }
}
