package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* loaded from: classes.dex */
public class AnimationUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f12720a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f12721b = new FastOutSlowInInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f12722c = new FastOutLinearInInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f12723d = new LinearOutSlowInInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f12724e = new DecelerateInterpolator();

    public static float a(float f8, float f9, float f10) {
        return f8 + (f10 * (f9 - f8));
    }

    public static float b(float f8, float f9, float f10, float f11, float f12) {
        if (f12 <= f10) {
            return f8;
        }
        if (f12 >= f11) {
            return f9;
        }
        return a(f8, f9, (f12 - f10) / (f11 - f10));
    }

    public static int c(int i8, int i9, float f8) {
        return i8 + Math.round(f8 * (i9 - i8));
    }
}
