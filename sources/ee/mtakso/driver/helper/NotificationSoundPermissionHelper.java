package ee.mtakso.driver.helper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: NotificationSoundPermissionHelper.kt */
/* loaded from: classes3.dex */
public final class NotificationSoundPermissionHelper {

    /* renamed from: a  reason: collision with root package name */
    private final AppResolver f20955a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f20956b;

    @Inject
    public NotificationSoundPermissionHelper(AppResolver appResolver, Context context) {
        Intrinsics.f(appResolver, "appResolver");
        Intrinsics.f(context, "context");
        this.f20955a = appResolver;
        this.f20956b = context;
    }

    private final Intent a(Context context) {
        Intent putExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").addFlags(268435456).putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        Intrinsics.e(putExtra, "Intent(Settings.ACTION_A…AGE, context.packageName)");
        return putExtra;
    }

    private final boolean c(AppResolver appResolver) {
        Intent addCategory = new Intent("miui.intent.action.OP_AUTO_START").addCategory("android.intent.category.DEFAULT");
        Intrinsics.e(addCategory, "Intent(\"miui.intent.acti…(Intent.CATEGORY_DEFAULT)");
        if (!appResolver.c(addCategory)) {
            Intent component = new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            Intrinsics.e(component, "Intent().setComponent(Co…tartManagementActivity\"))");
            if (!appResolver.c(component)) {
                Intent addCategory2 = new Intent("miui.intent.action.POWER_HIDE_MODE_APP_LIST").addCategory("android.intent.category.DEFAULT");
                Intrinsics.e(addCategory2, "Intent(\"miui.intent.acti…(Intent.CATEGORY_DEFAULT)");
                if (!appResolver.c(addCategory2)) {
                    Intent component2 = new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.powercenter.PowerSettings"));
                    Intrinsics.e(component2, "Intent().setComponent(Co…ercenter.PowerSettings\"))");
                    if (!appResolver.c(component2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final Intent b() {
        if (d()) {
            return a(this.f20956b);
        }
        return null;
    }

    public final boolean d() {
        boolean w7;
        w7 = StringsKt__StringsJVMKt.w(Build.BRAND, "xiaomi", true);
        if (w7 && c(this.f20955a) && Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }
}
