package com.google.android.material.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.RectF;
import androidx.transition.Transition;
import com.google.android.material.motion.MotionUtils;

/* loaded from: classes.dex */
class TransitionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final RectF f14576a = new RectF();

    private TransitionUtils() {
    }

    static float a(float f8, float f9, float f10) {
        return f8 + (f10 * (f9 - f8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f8, float f9, float f10, float f11, float f12) {
        return c(f8, f9, f10, f11, f12, false);
    }

    static float c(float f8, float f9, float f10, float f11, float f12, boolean z7) {
        if (z7 && (f12 < 0.0f || f12 > 1.0f)) {
            return a(f8, f9, f12);
        }
        if (f12 < f10) {
            return f8;
        }
        if (f12 > f11) {
            return f9;
        }
        return a(f8, f9, (f12 - f10) / (f11 - f10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Transition transition, Context context, int i8) {
        int f8;
        if (i8 != 0 && transition.u() == -1 && (f8 = MotionUtils.f(context, i8, -1)) != -1) {
            transition.c0(f8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Transition transition, Context context, int i8, TimeInterpolator timeInterpolator) {
        if (i8 != 0 && transition.x() == null) {
            transition.e0(MotionUtils.g(context, i8, timeInterpolator));
            return true;
        }
        return false;
    }
}
