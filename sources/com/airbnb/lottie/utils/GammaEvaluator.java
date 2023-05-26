package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public class GammaEvaluator {
    private static float a(float f8) {
        if (f8 <= 0.04045f) {
            return f8 / 12.92f;
        }
        return (float) Math.pow((f8 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float b(float f8) {
        if (f8 <= 0.0031308f) {
            return f8 * 12.92f;
        }
        return (float) ((Math.pow(f8, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f8, int i8, int i9) {
        if (i8 == i9) {
            return i8;
        }
        float f9 = ((i8 >> 24) & 255) / 255.0f;
        float a8 = a(((i8 >> 16) & 255) / 255.0f);
        float a9 = a(((i8 >> 8) & 255) / 255.0f);
        float a10 = a((i8 & 255) / 255.0f);
        float a11 = a(((i9 >> 16) & 255) / 255.0f);
        float a12 = a(((i9 >> 8) & 255) / 255.0f);
        float a13 = a10 + (f8 * (a((i9 & 255) / 255.0f) - a10));
        return (Math.round(b(a8 + ((a11 - a8) * f8)) * 255.0f) << 16) | (Math.round((f9 + (((((i9 >> 24) & 255) / 255.0f) - f9) * f8)) * 255.0f) << 24) | (Math.round(b(a9 + ((a12 - a9) * f8)) * 255.0f) << 8) | Math.round(b(a13) * 255.0f);
    }
}
