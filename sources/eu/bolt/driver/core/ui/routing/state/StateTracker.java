package eu.bolt.driver.core.ui.routing.state;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateTracker.kt */
/* loaded from: classes5.dex */
public final class StateTracker extends DefaultActivityLifecycleCallback {

    /* renamed from: f  reason: collision with root package name */
    private final RoutingManager f41178f;

    /* renamed from: g  reason: collision with root package name */
    private final FragmentStateTracker f41179g;

    @Inject
    public StateTracker(RoutingManager routingManager) {
        Intrinsics.f(routingManager, "routingManager");
        this.f41178f = routingManager;
        this.f41179g = new FragmentStateTracker(routingManager);
    }

    private final RoutingState c(Activity activity) {
        List k8;
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Calculating state: " + activity, null, 2, null);
        }
        Class<?> cls = activity.getClass();
        k8 = CollectionsKt__CollectionsKt.k();
        return new RoutingState(cls, k8);
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.f(activity, "activity");
        super.onActivityCreated(activity, bundle);
        if (activity instanceof AppCompatActivity) {
            ((AppCompatActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.f41179g, true);
            return;
        }
        Kalev.d("Activity " + activity + " is not app compat activity");
    }

    @Override // eu.bolt.driver.core.ui.common.activity.DefaultActivityLifecycleCallback, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.f(activity, "activity");
        super.onActivityResumed(activity);
        this.f41178f.e(c(activity));
    }
}
