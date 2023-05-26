package com.yalantis.ucrop.util;

/* loaded from: classes3.dex */
public final class CubicEasing {
    public static float easeIn(float f8, float f9, float f10, float f11) {
        float f12 = f8 / f11;
        return (f10 * f12 * f12 * f12) + f9;
    }

    public static float easeInOut(float f8, float f9, float f10, float f11) {
        float f12;
        float f13 = f8 / (f11 / 2.0f);
        float f14 = f10 / 2.0f;
        if (f13 < 1.0f) {
            f12 = f14 * f13 * f13 * f13;
        } else {
            float f15 = f13 - 2.0f;
            f12 = f14 * ((f15 * f15 * f15) + 2.0f);
        }
        return f12 + f9;
    }

    public static float easeOut(float f8, float f9, float f10, float f11) {
        float f12 = (f8 / f11) - 1.0f;
        return (f10 * ((f12 * f12 * f12) + 1.0f)) + f9;
    }
}
