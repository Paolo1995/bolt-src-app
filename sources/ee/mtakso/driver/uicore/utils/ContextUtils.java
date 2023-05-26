package ee.mtakso.driver.uicore.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextExt.kt */
/* loaded from: classes5.dex */
public final class ContextUtils {
    public static final DisplayMetrics a(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        Intrinsics.f(context, "<this>");
        Object systemService = context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            windowManager = (WindowManager) systemService;
        } else {
            windowManager = null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static final boolean b(Context context) {
        Intrinsics.f(context, "<this>");
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }
}
