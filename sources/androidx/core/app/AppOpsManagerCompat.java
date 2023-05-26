package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class AppOpsManagerCompat {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static <T> T a(Context context, Class<T> cls) {
            Object systemService;
            systemService = context.getSystemService(cls);
            return (T) systemService;
        }

        static int b(AppOpsManager appOpsManager, String str, String str2) {
            int noteProxyOp;
            noteProxyOp = appOpsManager.noteProxyOp(str, str2);
            return noteProxyOp;
        }

        static int c(AppOpsManager appOpsManager, String str, String str2) {
            int noteProxyOpNoThrow;
            noteProxyOpNoThrow = appOpsManager.noteProxyOpNoThrow(str, str2);
            return noteProxyOpNoThrow;
        }

        static String d(String str) {
            String permissionToOp;
            permissionToOp = AppOpsManager.permissionToOp(str);
            return permissionToOp;
        }
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static int a(AppOpsManager appOpsManager, @NonNull String str, int i8, @NonNull String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i8, str2);
        }

        @NonNull
        static String b(@NonNull Context context) {
            String opPackageName;
            opPackageName = context.getOpPackageName();
            return opPackageName;
        }

        static AppOpsManager c(@NonNull Context context) {
            Object systemService;
            systemService = context.getSystemService(AppOpsManager.class);
            return (AppOpsManager) systemService;
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int a(@NonNull Context context, int i8, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            AppOpsManager c8 = Api29Impl.c(context);
            int a8 = Api29Impl.a(c8, str, Binder.getCallingUid(), str2);
            if (a8 != 0) {
                return a8;
            }
            return Api29Impl.a(c8, str, i8, Api29Impl.b(context));
        }
        return b(context, str, str2);
    }

    public static int b(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.c((AppOpsManager) Api23Impl.a(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    public static String c(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.d(str);
        }
        return null;
    }
}
