package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class NavUtils {

    /* loaded from: classes.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static Intent a(Activity activity) {
            return activity.getParentActivityIntent();
        }

        static boolean b(Activity activity, Intent intent) {
            return activity.navigateUpTo(intent);
        }

        static boolean c(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }
    }

    private NavUtils() {
    }

    public static Intent a(@NonNull Activity activity) {
        Intent a8 = Api16Impl.a(activity);
        if (a8 != null) {
            return a8;
        }
        String c8 = c(activity);
        if (c8 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, c8);
        try {
            if (d(activity, componentName) == null) {
                return Intent.makeMainActivity(componentName);
            }
            return new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + c8 + "' in manifest");
            return null;
        }
    }

    public static Intent b(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String d8 = d(context, componentName);
        if (d8 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), d8);
        if (d(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String c(@NonNull Activity activity) {
        try {
            return d(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    public static String d(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i8 = Build.VERSION.SDK_INT;
        int i9 = 640;
        if (i8 >= 29) {
            i9 = 269222528;
        } else if (i8 >= 24) {
            i9 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i9);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        return string;
    }

    public static void e(@NonNull Activity activity, @NonNull Intent intent) {
        Api16Impl.b(activity, intent);
    }

    public static boolean f(@NonNull Activity activity, @NonNull Intent intent) {
        return Api16Impl.c(activity, intent);
    }
}
