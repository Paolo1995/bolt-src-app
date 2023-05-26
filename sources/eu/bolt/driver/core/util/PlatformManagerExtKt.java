package eu.bolt.driver.core.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformManagerExt.kt */
/* loaded from: classes5.dex */
public final class PlatformManagerExtKt {
    public static final PackageInfo a(PackageManager packageManager, String packageName, int i8) {
        Intrinsics.f(packageManager, "<this>");
        Intrinsics.f(packageName, "packageName");
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(i8));
            Intrinsics.e(packageInfo, "{\n        getPackageInfo…of(flags.toLong()))\n    }");
            return packageInfo;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(packageName, i8);
        Intrinsics.e(packageInfo2, "{\n        @Suppress(\"DEP…packageName, flags)\n    }");
        return packageInfo2;
    }

    public static final Long b(PackageManager packageManager, String packageName) {
        long j8;
        Intrinsics.f(packageManager, "<this>");
        Intrinsics.f(packageName, "packageName");
        try {
            PackageInfo a8 = a(packageManager, packageName, 0);
            if (Build.VERSION.SDK_INT >= 28) {
                j8 = a8.getLongVersionCode();
            } else {
                j8 = a8.versionCode;
            }
            return Long.valueOf(j8);
        } catch (PackageManager.NameNotFoundException e8) {
            Kalev.d("Package manager couldn't provide version code " + Build.VERSION.SDK_INT + " " + e8);
            return null;
        }
    }
}
