package eu.bolt.verification.sdk.internal;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes5.dex */
public final class z1 {
    public static final int a(int i8, float f8) {
        return Color.argb((int) (f8 * 255), Color.red(i8), Color.green(i8), Color.blue(i8));
    }

    public static final boolean b(int i8) {
        return ColorUtils.c(i8) < 0.5d;
    }
}
