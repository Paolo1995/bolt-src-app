package ee.mtakso.driver.uicore.utils;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowInsets$Type;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowExt.kt */
/* loaded from: classes5.dex */
public final class WindowExtKt {
    public static final ScreenSize a(WindowManager windowManager) {
        WindowMetrics currentWindowMetrics;
        Intrinsics.f(windowManager, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            Rect bounds = currentWindowMetrics.getBounds();
            Intrinsics.e(bounds, "currentWindowMetrics.bounds");
            return new ScreenSize(bounds.width(), bounds.height());
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return new ScreenSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static final ScreenSize b(Window window) {
        WindowMetrics currentWindowMetrics;
        WindowMetrics currentWindowMetrics2;
        Insets insetsIgnoringVisibility;
        Intrinsics.f(window, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            currentWindowMetrics = window.getWindowManager().getCurrentWindowMetrics();
            Rect bounds = currentWindowMetrics.getBounds();
            Intrinsics.e(bounds, "windowManager.currentWindowMetrics.bounds");
            currentWindowMetrics2 = window.getWindowManager().getCurrentWindowMetrics();
            insetsIgnoringVisibility = currentWindowMetrics2.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemBars());
            Intrinsics.e(insetsIgnoringVisibility, "windowManager\n          …Insets.Type.systemBars())");
            return new ScreenSize((bounds.width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right, (bounds.height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return new ScreenSize(displayMetrics.widthPixels, displayMetrics.heightPixels - c(window));
    }

    public static final int c(Window window) {
        WindowMetrics currentWindowMetrics;
        Insets insetsIgnoringVisibility;
        Intrinsics.f(window, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            currentWindowMetrics = window.getWindowManager().getCurrentWindowMetrics();
            insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets$Type.systemBars());
            Intrinsics.e(insetsIgnoringVisibility, "windowManager\n          …Insets.Type.systemBars())");
            return insetsIgnoringVisibility.top;
        }
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }
}
