package eu.bolt.driver.core.permission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import eu.bolt.driver.core.permission.watchdog.ActivityPermissionWatchDog;
import eu.bolt.driver.core.permission.watchdog.FragmentPermissionWatchDog;
import eu.bolt.driver.core.permission.watchdog.PermissionWatchDog;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionWatchDogFactory.kt */
/* loaded from: classes5.dex */
public final class PermissionWatchDogFactory {

    /* renamed from: a  reason: collision with root package name */
    private final PermissionManager f40921a;

    /* renamed from: b  reason: collision with root package name */
    private final PermissionInitiatorTracker f40922b;

    /* renamed from: c  reason: collision with root package name */
    private final IdProvider f40923c;

    /* compiled from: PermissionWatchDogFactory.kt */
    /* loaded from: classes5.dex */
    private static final class IdProvider {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicLong f40924a = new AtomicLong(0);

        public final long a() {
            return this.f40924a.incrementAndGet();
        }
    }

    public PermissionWatchDogFactory(PermissionManager permissionManager, PermissionInitiatorTracker permissionInitiatorTracker) {
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(permissionInitiatorTracker, "permissionInitiatorTracker");
        this.f40921a = permissionManager;
        this.f40922b = permissionInitiatorTracker;
        this.f40923c = new IdProvider();
    }

    public final PermissionWatchDog a(AppCompatActivity activity) {
        Intrinsics.f(activity, "activity");
        return new ActivityPermissionWatchDog(this.f40923c.a(), activity, this.f40921a, this.f40922b);
    }

    public final PermissionWatchDog b(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        return new FragmentPermissionWatchDog(this.f40923c.a(), fragment, this.f40921a, this.f40922b);
    }
}
