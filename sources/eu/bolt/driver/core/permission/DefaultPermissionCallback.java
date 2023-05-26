package eu.bolt.driver.core.permission;

import eu.bolt.driver.core.permission.PermissionManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultPermissionCallback.kt */
/* loaded from: classes5.dex */
public final class DefaultPermissionCallback implements PermissionCallback {
    @Override // eu.bolt.driver.core.permission.PermissionCallback
    public void a(String permission, PermissionManager.DenyInitiator initiator, PermissionManager.RationalStatus rationalStatus) {
        Intrinsics.f(permission, "permission");
        Intrinsics.f(initiator, "initiator");
        Intrinsics.f(rationalStatus, "rationalStatus");
    }

    @Override // eu.bolt.driver.core.permission.PermissionCallback
    public void b(String permission) {
        Intrinsics.f(permission, "permission");
    }
}
