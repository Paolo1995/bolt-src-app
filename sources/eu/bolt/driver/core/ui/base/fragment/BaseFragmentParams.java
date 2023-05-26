package eu.bolt.driver.core.ui.base.fragment;

import eu.bolt.driver.core.permission.PermissionManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseFragmentParams.kt */
/* loaded from: classes5.dex */
public final class BaseFragmentParams {

    /* renamed from: a  reason: collision with root package name */
    private final PermissionManager f41039a;

    public BaseFragmentParams(PermissionManager permissionManager) {
        Intrinsics.f(permissionManager, "permissionManager");
        this.f41039a = permissionManager;
    }

    public final PermissionManager a() {
        return this.f41039a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BaseFragmentParams) && Intrinsics.a(this.f41039a, ((BaseFragmentParams) obj).f41039a);
    }

    public int hashCode() {
        return this.f41039a.hashCode();
    }

    public String toString() {
        PermissionManager permissionManager = this.f41039a;
        return "BaseFragmentParams(permissionManager=" + permissionManager + ")";
    }
}
