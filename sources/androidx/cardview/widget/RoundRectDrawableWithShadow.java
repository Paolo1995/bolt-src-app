package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private static final double f4237a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f8, float f9, boolean z7) {
        if (z7) {
            return (float) (f8 + ((1.0d - f4237a) * f9));
        }
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f8, float f9, boolean z7) {
        if (z7) {
            return (float) ((f8 * 1.5f) + ((1.0d - f4237a) * f9));
        }
        return f8 * 1.5f;
    }
}
