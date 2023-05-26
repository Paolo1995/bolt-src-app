package com.google.android.material.internal;

/* loaded from: classes.dex */
final class FadeThroughUtils {
    private FadeThroughUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f8, float[] fArr) {
        if (f8 <= 0.5f) {
            fArr[0] = 1.0f - (f8 * 2.0f);
            fArr[1] = 0.0f;
            return;
        }
        fArr[0] = 0.0f;
        fArr[1] = (f8 * 2.0f) - 1.0f;
    }
}
