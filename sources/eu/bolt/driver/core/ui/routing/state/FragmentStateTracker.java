package eu.bolt.driver.core.ui.routing.state;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentStateTracker.kt */
/* loaded from: classes5.dex */
public final class FragmentStateTracker extends FragmentManager.FragmentLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final RoutingManager f41172a;

    public FragmentStateTracker(RoutingManager manager) {
        Intrinsics.f(manager, "manager");
        this.f41172a = manager;
    }

    private final RoutingState a(Fragment fragment) {
        List e8;
        if (!(fragment instanceof Screen)) {
            return null;
        }
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FragmentActivity requireActivity = fragment.requireActivity();
            FastLog.DefaultImpls.a(g8, "Calculating state: " + fragment + " " + requireActivity, null, 2, null);
        }
        Class<?> cls = fragment.requireActivity().getClass();
        e8 = CollectionsKt__CollectionsJVMKt.e(fragment.getClass());
        return new RoutingState(cls, e8);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fm, Fragment fragment) {
        Intrinsics.f(fm, "fm");
        Intrinsics.f(fragment, "fragment");
        super.onFragmentResumed(fm, fragment);
        RoutingState a8 = a(fragment);
        if (a8 != null) {
            this.f41172a.e(a8);
        }
    }
}
