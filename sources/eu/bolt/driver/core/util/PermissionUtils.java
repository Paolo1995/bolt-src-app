package eu.bolt.driver.core.util;

import eu.bolt.driver.core.permission.PermissionManager;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionUtils.kt */
/* loaded from: classes5.dex */
public final class PermissionUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final PermissionUtils f41314a = new PermissionUtils();

    private PermissionUtils() {
    }

    public final boolean a(PermissionManager permissionManager, List<String> permissions) {
        boolean z7;
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(permissions, "permissions");
        if (!(permissions instanceof Collection) || !permissions.isEmpty()) {
            for (String str : permissions) {
                if (permissionManager.o(str).d() == PermissionManager.PermissionStatus.GRANTED) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (!z7) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean b(PermissionManager permissionManager) {
        List<String> e8;
        Intrinsics.f(permissionManager, "permissionManager");
        e8 = CollectionsKt__CollectionsJVMKt.e("android.permission.RECORD_AUDIO");
        return a(permissionManager, e8);
    }
}
