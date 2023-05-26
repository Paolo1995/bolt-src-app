package eu.bolt.driver.core.ui.routing.coordinator;

import android.app.Activity;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityIntentCoordinator.kt */
/* loaded from: classes5.dex */
public final class ActivityIntentCoordinator extends DefaultActivityLifecycleCallback implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private Activity f41169f;

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (!(command instanceof RoutingCommand.ActivityIntent)) {
            return false;
        }
        Activity activity = this.f41169f;
        if (activity != null) {
            activity.startActivity(((RoutingCommand.ActivityIntent) command).c());
            return true;
        }
        Kalev.e(new IllegalStateException("There are no activity to execute command"), "There are no activity to execute command");
        return false;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityPaused(activity);
        this.f41169f = null;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityResumed(activity);
        this.f41169f = activity;
    }
}
