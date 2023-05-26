package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;

/* loaded from: classes.dex */
public final class PermissionChecker {
    private PermissionChecker() {
    }

    public static int a(@NonNull Context context, @NonNull String str, int i8, int i9, String str2) {
        boolean z7;
        int b8;
        if (context.checkPermission(str, i8, i9) == -1) {
            return -1;
        }
        String c8 = AppOpsManagerCompat.c(str);
        if (c8 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i9);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (myUid == i9 && ObjectsCompat.a(packageName, str2)) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            b8 = AppOpsManagerCompat.a(context, i9, c8, str2);
        } else {
            b8 = AppOpsManagerCompat.b(context, c8, str2);
        }
        if (b8 == 0) {
            return 0;
        }
        return -2;
    }

    public static int b(@NonNull Context context, @NonNull String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
