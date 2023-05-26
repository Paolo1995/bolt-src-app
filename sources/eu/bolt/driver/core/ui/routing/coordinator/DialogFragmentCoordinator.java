package eu.bolt.driver.core.ui.routing.coordinator;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogFragmentCoordinator.kt */
/* loaded from: classes5.dex */
public final class DialogFragmentCoordinator extends DefaultActivityLifecycleCallback implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private FragmentActivity f41171f;

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    public boolean b(RoutingCommand command) {
        DialogFragment dialogFragment;
        Intrinsics.f(command, "command");
        if (!(command instanceof RoutingCommand.DialogFragmentClass)) {
            return false;
        }
        FragmentActivity fragmentActivity = this.f41171f;
        if (fragmentActivity != null) {
            RoutingCommand.DialogFragmentClass dialogFragmentClass = (RoutingCommand.DialogFragmentClass) command;
            Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(dialogFragmentClass.e());
            if (findFragmentByTag instanceof DialogFragment) {
                dialogFragment = (DialogFragment) findFragmentByTag;
            } else {
                dialogFragment = null;
            }
            if (dialogFragment != null) {
                dialogFragment.dismissAllowingStateLoss();
            }
            Fragment instantiate = fragmentActivity.getSupportFragmentManager().getFragmentFactory().instantiate(fragmentActivity.getClassLoader(), dialogFragmentClass.d().getName());
            Intrinsics.d(instantiate, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
            DialogFragment dialogFragment2 = (DialogFragment) instantiate;
            dialogFragment2.setArguments(dialogFragmentClass.c());
            FragmentUtils.c(dialogFragment2, fragmentActivity, dialogFragmentClass.e());
            return true;
        }
        Kalev.e(new IllegalStateException("There are no activity to execute command"), "There are no activity to execute command");
        return false;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityPaused(activity);
        this.f41171f = null;
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        FragmentActivity fragmentActivity;
        Intrinsics.f(activity, "activity");
        super.onActivityResumed(activity);
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        this.f41171f = fragmentActivity;
    }
}
