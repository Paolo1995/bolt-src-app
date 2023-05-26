package eu.bolt.driver.core.permission.watchdog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import eu.bolt.driver.core.permission.PermissionInitiatorTracker;
import eu.bolt.driver.core.permission.PermissionManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityPermissionWatchDog.kt */
/* loaded from: classes5.dex */
public final class ActivityPermissionWatchDog extends BasePermissionWatchDog<AppCompatActivity> {

    /* renamed from: f  reason: collision with root package name */
    private final ActivityPermissionWatchDog$lifecycleObserver$1 f40925f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.lifecycle.LifecycleObserver, eu.bolt.driver.core.permission.watchdog.ActivityPermissionWatchDog$lifecycleObserver$1] */
    public ActivityPermissionWatchDog(long j8, AppCompatActivity context, final PermissionManager permissionManager, PermissionInitiatorTracker permissionInitiatorTracker) {
        super(j8, context, permissionManager, permissionInitiatorTracker);
        Intrinsics.f(context, "context");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(permissionInitiatorTracker, "permissionInitiatorTracker");
        ?? r22 = new LifecycleObserver() { // from class: eu.bolt.driver.core.permission.watchdog.ActivityPermissionWatchDog$lifecycleObserver$1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void killMySelf() {
                PermissionManager.this.h(this);
            }
        };
        this.f40925f = r22;
        context.getLifecycle().a(r22);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.driver.core.permission.watchdog.BasePermissionWatchDog
    /* renamed from: i */
    public boolean f(AppCompatActivity context, String permission) {
        Intrinsics.f(context, "context");
        Intrinsics.f(permission, "permission");
        if (ContextCompat.checkSelfPermission(context, permission) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.driver.core.permission.watchdog.BasePermissionWatchDog
    /* renamed from: j */
    public void g(AppCompatActivity context, String[] permissions, int i8) {
        Intrinsics.f(context, "context");
        Intrinsics.f(permissions, "permissions");
        ActivityCompat.g(context, permissions, i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.driver.core.permission.watchdog.BasePermissionWatchDog
    /* renamed from: k */
    public boolean h(AppCompatActivity context, String permission) {
        Intrinsics.f(context, "context");
        Intrinsics.f(permission, "permission");
        return ActivityCompat.j(context, permission);
    }
}
