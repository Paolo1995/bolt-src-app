package eu.bolt.driver.core.ui.routing.coordinator;

import android.app.Activity;
import android.content.Intent;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassCommand;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassStackCommand;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivitiesStackClassCoordinator.kt */
/* loaded from: classes5.dex */
public final class ActivitiesStackClassCoordinator extends DefaultActivityLifecycleCallback implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private Activity f41167f;

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        int v7;
        Intrinsics.f(command, "command");
        if (!(command instanceof ActivityClassStackCommand)) {
            return false;
        }
        Activity activity = this.f41167f;
        if (activity != null) {
            List<ActivityClassCommand> c8 = ((ActivityClassStackCommand) command).c();
            v7 = CollectionsKt__IterablesKt.v(c8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (ActivityClassCommand activityClassCommand : c8) {
                Intent intent = new Intent(activity, activityClassCommand.e());
                intent.putExtras(activityClassCommand.d());
                intent.setFlags(activityClassCommand.f());
                arrayList.add(intent);
            }
            activity.startActivities((Intent[]) arrayList.toArray(new Intent[0]));
            return true;
        }
        Kalev.e(new IllegalStateException("There are no activity to execute command"), "There are no activity to execute command");
        return false;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityPaused(activity);
        this.f41167f = null;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityResumed(activity);
        this.f41167f = activity;
    }
}
