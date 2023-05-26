package ee.mtakso.driver.utils.customtabs;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import eu.bolt.kalev.Kalev;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChromePackageHelper.kt */
/* loaded from: classes5.dex */
public final class ChromePackageHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ChromePackageHelper f36390a = new ChromePackageHelper();

    /* renamed from: b  reason: collision with root package name */
    private static String f36391b;

    private ChromePackageHelper() {
    }

    private final boolean b(Context context, Intent intent) {
        List<ResolveInfo> c8;
        try {
            PackageManager pm = context.getPackageManager();
            Intrinsics.e(pm, "pm");
            c8 = c(pm, intent, 64);
        } catch (RuntimeException e8) {
            Kalev.e(e8, "Runtime exception while getting specialized handlers");
        }
        if (c8.isEmpty()) {
            return false;
        }
        for (ResolveInfo resolveInfo : c8) {
            IntentFilter intentFilter = resolveInfo.filter;
            if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                return true;
            }
        }
        return false;
    }

    private final List<ResolveInfo> c(PackageManager packageManager, Intent intent, int i8) {
        List<ResolveInfo> queryIntentActivities;
        if (Build.VERSION.SDK_INT >= 33) {
            queryIntentActivities = packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(i8));
        } else {
            queryIntentActivities = packageManager.queryIntentActivities(intent, i8);
        }
        Intrinsics.e(queryIntentActivities, "if (Build.VERSION.SDK_IN…(intent, flags)\n        }");
        return queryIntentActivities;
    }

    private final ResolveInfo d(PackageManager packageManager, Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.resolveActivity(intent, PackageManager.ResolveInfoFlags.of(0L));
        }
        return packageManager.resolveActivity(intent, 0);
    }

    private final List<String> e(PackageManager packageManager, Intent intent) {
        List c8;
        List<String> a8;
        List<ResolveInfo> c9 = c(packageManager, intent, 0);
        c8 = CollectionsKt__CollectionsJVMKt.c();
        for (ResolveInfo resolveInfo : c9) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (f36390a.f(packageManager, intent2) != null) {
                String str = resolveInfo.activityInfo.packageName;
                Intrinsics.e(str, "info.activityInfo.packageName");
                c8.add(str);
            }
        }
        a8 = CollectionsKt__CollectionsJVMKt.a(c8);
        return a8;
    }

    private final ResolveInfo f(PackageManager packageManager, Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.resolveService(intent, PackageManager.ResolveInfoFlags.of(0L));
        }
        return packageManager.resolveService(intent, 0);
    }

    public final String a(Context context) {
        String str;
        Object W;
        ActivityInfo activityInfo;
        Intrinsics.f(context, "context");
        String str2 = f36391b;
        if (str2 != null) {
            return str2;
        }
        PackageManager pm = context.getPackageManager();
        String str3 = null;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.fromParts("http", "", null));
        Intrinsics.e(pm, "pm");
        ResolveInfo d8 = d(pm, intent);
        if (d8 != null && (activityInfo = d8.activityInfo) != null) {
            str = activityInfo.packageName;
        } else {
            str = null;
        }
        List<String> e8 = e(pm, intent);
        if (!e8.isEmpty()) {
            boolean z7 = true;
            if (e8.size() == 1) {
                W = CollectionsKt___CollectionsKt.W(e8);
                str3 = (String) W;
            } else {
                if (str != null && str.length() != 0) {
                    z7 = false;
                }
                if (!z7 && !b(context, intent) && e8.contains(str)) {
                    str3 = str;
                } else if (e8.contains("com.android.chrome")) {
                    str3 = "com.android.chrome";
                } else if (e8.contains("com.google.android.apps.chrome")) {
                    str3 = "com.google.android.apps.chrome";
                } else {
                    str3 = (String) CollectionsKt___CollectionsKt.Y(e8);
                }
            }
        }
        f36391b = str3;
        return str3;
    }
}
