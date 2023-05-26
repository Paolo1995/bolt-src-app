package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes.dex */
public class EdgeToEdgeUtils {
    private EdgeToEdgeUtils() {
    }

    public static void a(@NonNull Window window, boolean z7, Integer num, Integer num2) {
        boolean z8;
        boolean z9 = false;
        if (num != null && num.intValue() != 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        z9 = (num2 == null || num2.intValue() == 0) ? true : true;
        if (z8 || z9) {
            int b8 = MaterialColors.b(window.getContext(), 16842801, -16777216);
            if (z8) {
                num = Integer.valueOf(b8);
            }
            if (z9) {
                num2 = Integer.valueOf(b8);
            }
        }
        WindowCompat.b(window, !z7);
        int c8 = c(window.getContext(), z7);
        int b9 = b(window.getContext(), z7);
        window.setStatusBarColor(c8);
        window.setNavigationBarColor(b9);
        f(window, d(c8, MaterialColors.h(num.intValue())));
        e(window, d(b9, MaterialColors.h(num2.intValue())));
    }

    @TargetApi(21)
    private static int b(Context context, boolean z7) {
        if (z7 && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.j(MaterialColors.b(context, 16843858, -16777216), 128);
        }
        if (z7) {
            return 0;
        }
        return MaterialColors.b(context, 16843858, -16777216);
    }

    @TargetApi(21)
    private static int c(Context context, boolean z7) {
        if (z7 && Build.VERSION.SDK_INT < 23) {
            return ColorUtils.j(MaterialColors.b(context, 16843857, -16777216), 128);
        }
        if (z7) {
            return 0;
        }
        return MaterialColors.b(context, 16843857, -16777216);
    }

    private static boolean d(int i8, boolean z7) {
        if (!MaterialColors.h(i8) && (i8 != 0 || !z7)) {
            return false;
        }
        return true;
    }

    public static void e(@NonNull Window window, boolean z7) {
        WindowCompat.a(window, window.getDecorView()).c(z7);
    }

    public static void f(@NonNull Window window, boolean z7) {
        WindowCompat.a(window, window.getDecorView()).d(z7);
    }
}
