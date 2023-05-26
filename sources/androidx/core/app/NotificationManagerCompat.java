package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class NotificationManagerCompat {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f5641c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static Set<String> f5642d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f5643e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f5644a;

    /* renamed from: b  reason: collision with root package name */
    private final NotificationManager f5645b;

    private NotificationManagerCompat(Context context) {
        this.f5644a = context;
        this.f5645b = (NotificationManager) context.getSystemService("notification");
    }

    @NonNull
    public static NotificationManagerCompat b(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    public boolean a() {
        boolean areNotificationsEnabled;
        if (Build.VERSION.SDK_INT >= 24) {
            areNotificationsEnabled = this.f5645b.areNotificationsEnabled();
            return areNotificationsEnabled;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f5644a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f5644a.getApplicationInfo();
        String packageName = this.f5644a.getApplicationContext().getPackageName();
        int i8 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i8), packageName)).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
