package eu.bolt.driver.core.permission;

import eu.bolt.driver.core.permission.PermissionManager;

/* compiled from: PermissionCallback.kt */
/* loaded from: classes5.dex */
public interface PermissionCallback {
    void a(String str, PermissionManager.DenyInitiator denyInitiator, PermissionManager.RationalStatus rationalStatus);

    void b(String str);
}
