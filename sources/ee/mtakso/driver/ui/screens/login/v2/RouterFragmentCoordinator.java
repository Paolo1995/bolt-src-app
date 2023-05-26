package ee.mtakso.driver.ui.screens.login.v2;

import android.app.Activity;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouterFragmentCoordinator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class RouterFragmentCoordinator extends DefaultActivityLifecycleCallback implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private Router f30457f;

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        Router router;
        Intrinsics.f(command, "command");
        if (!(command instanceof RouterFragmentRoutingCommand) || (router = this.f30457f) == null) {
            return false;
        }
        RouterFragmentRoutingCommand routerFragmentRoutingCommand = (RouterFragmentRoutingCommand) command;
        RoutingCommand.FragmentClass d8 = routerFragmentRoutingCommand.d();
        router.d(d8.d(), d8.c(), routerFragmentRoutingCommand.c());
        return true;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityPaused(activity);
        this.f30457f = null;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Router router;
        Intrinsics.f(activity, "activity");
        super.onActivityResumed(activity);
        if (activity instanceof Router) {
            router = (Router) activity;
        } else {
            router = null;
        }
        this.f30457f = router;
    }
}
