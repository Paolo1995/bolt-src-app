package eu.bolt.driver.core.ui.routing.coordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassCommand;
import eu.bolt.driver.core.ui.routing.command.impl.AnimationResources;
import eu.bolt.kalev.Kalev;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityClassCoordinator.kt */
/* loaded from: classes5.dex */
public final class ActivityClassCoordinator extends DefaultActivityLifecycleCallback implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private Activity f41168f;

    private final boolean c(Class<? extends Activity> cls, Bundle bundle, int i8, AnimationResources animationResources) {
        Unit unit;
        Activity activity = this.f41168f;
        if (activity != null) {
            Intent intent = new Intent(activity, cls);
            intent.putExtras(bundle);
            intent.setFlags(i8);
            if (animationResources != null) {
                activity.overridePendingTransition(animationResources.a(), animationResources.b());
                unit = Unit.f50853a;
            } else {
                unit = null;
            }
            if (unit == null) {
                activity.overridePendingTransition(0, 0);
            }
            activity.startActivity(intent);
            return true;
        }
        Kalev.e(new IllegalStateException("There are no activity to execute command"), "There are no activity to execute command");
        return false;
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (command instanceof RoutingCommand.ActivityClass) {
            RoutingCommand.ActivityClass activityClass = (RoutingCommand.ActivityClass) command;
            return c(activityClass.d(), activityClass.c(), activityClass.e(), null);
        } else if (command instanceof ActivityClassCommand) {
            ActivityClassCommand activityClassCommand = (ActivityClassCommand) command;
            return c(activityClassCommand.e(), activityClassCommand.d(), activityClassCommand.f(), activityClassCommand.c());
        } else {
            return false;
        }
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityPaused(activity);
        this.f41168f = null;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityResumed(activity);
        this.f41168f = activity;
    }
}
