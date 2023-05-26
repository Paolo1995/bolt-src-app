package com.google.android.material.math;

/* loaded from: classes.dex */
public final class MathUtils {
    private MathUtils() {
    }

    public static float a(float f8, float f9, float f10, float f11) {
        return (float) Math.hypot(f10 - f8, f11 - f9);
    }

    public static float b(float f8, float f9, float f10, float f11, float f12, float f13) {
        return d(a(f8, f9, f10, f11), a(f8, f9, f12, f11), a(f8, f9, f12, f13), a(f8, f9, f10, f13));
    }

    public static float c(float f8, float f9, float f10) {
        return ((1.0f - f10) * f8) + (f10 * f9);
    }

    private static float d(float f8, float f9, float f10, float f11) {
        return (f8 <= f9 || f8 <= f10 || f8 <= f11) ? (f9 <= f10 || f9 <= f11) ? f10 > f11 ? f10 : f11 : f9 : f8;
    }
}
