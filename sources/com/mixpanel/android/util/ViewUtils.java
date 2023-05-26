package com.mixpanel.android.util;

import android.content.Context;
import android.graphics.Color;

/* loaded from: classes3.dex */
public class ViewUtils {
    public static float a(float f8, Context context) {
        return f8 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static int b(int i8, int i9) {
        return Color.rgb((Color.red(i8) / 2) + (Color.red(i9) / 2), (Color.green(i8) / 2) + (Color.green(i9) / 2), (Color.blue(i8) / 2) + (Color.blue(i9) / 2));
    }
}
