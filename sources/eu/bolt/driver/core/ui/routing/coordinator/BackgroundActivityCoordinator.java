package eu.bolt.driver.core.ui.routing.coordinator;

import android.content.Context;
import android.content.Intent;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackgroundActivityCoordinator.kt */
/* loaded from: classes5.dex */
public final class BackgroundActivityCoordinator implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private final Context f41170f;

    @Inject
    public BackgroundActivityCoordinator(Context context) {
        Intrinsics.f(context, "context");
        this.f41170f = context;
    }

    private final void a(RoutingCommand.ActivityClassBackground activityClassBackground) {
        Intent intent = new Intent(this.f41170f, activityClassBackground.d());
        intent.putExtras(activityClassBackground.c());
        intent.addFlags(activityClassBackground.e());
        c(intent);
    }

    private final void c(Intent intent) {
        intent.addFlags(335577088);
        this.f41170f.startActivity(intent);
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(eu.bolt.driver.core.ui.routing.command.RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (command instanceof RoutingCommand.ActivityClassBackground) {
            a((RoutingCommand.ActivityClassBackground) command);
            return true;
        }
        return false;
    }
}
