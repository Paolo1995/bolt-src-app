package ee.mtakso.driver.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import eu.bolt.kalev.Kalev;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityLifecycleLoggingManager.kt */
@Singleton
/* loaded from: classes5.dex */
public final class ActivityLifecycleLoggingManager implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.f(activity, "activity");
        Kalev.n("activity", activity.getClass().getSimpleName()).n("action", "create").a("activity lifecycle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.f(activity, "activity");
        Kalev.n("activity", activity.getClass().getSimpleName()).n("action", "destroy").a("activity lifecycle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.f(activity, "activity");
        Kalev.n("activity", activity.getClass().getSimpleName()).n("action", "pause").a("activity lifecycle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.f(activity, "activity");
        Kalev.n("activity", activity.getClass().getSimpleName()).n("action", "resume").a("activity lifecycle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(outState, "outState");
        Kalev.n("activity", activity.getClass().getSimpleName()).n("action", "save_instance").a("activity lifecycle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.f(activity, "activity");
        Kalev.n("activity", activity.getClass().getSimpleName()).n("action", "start").a("activity lifecycle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.f(activity, "activity");
        Kalev.n("activity", activity.getClass().getSimpleName()).n("action", "stop").a("activity lifecycle");
    }
}
