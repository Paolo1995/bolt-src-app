package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R$attr;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes.dex */
public class RippleUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f13902a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f13903b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f13904c = {16843623, 16842908};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f13905d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f13906e = {16843623};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f13907f = {16842913, 16842919};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f13908g = {16842913, 16843623, 16842908};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f13909h = {16842913, 16842908};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f13910i = {16842913, 16843623};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f13911j = {16842913};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f13912k = {16842910, 16842919};

    /* renamed from: l  reason: collision with root package name */
    static final String f13913l = RippleUtils.class.getSimpleName();

    /* loaded from: classes.dex */
    private static class RippleUtilsLollipop {
        private RippleUtilsLollipop() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable b(@NonNull Context context, int i8) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(MaterialColors.f(context, R$attr.f12482l, ColorStateList.valueOf(0)), null, new InsetDrawable((Drawable) gradientDrawable, i8, i8, i8, i8));
        }
    }

    private RippleUtils() {
    }

    @NonNull
    public static ColorStateList a(ColorStateList colorStateList) {
        if (f13902a) {
            int[] iArr = f13905d;
            return new ColorStateList(new int[][]{f13911j, iArr, StateSet.NOTHING}, new int[]{d(colorStateList, f13907f), d(colorStateList, iArr), d(colorStateList, f13903b)});
        }
        int[] iArr2 = f13907f;
        int[] iArr3 = f13908g;
        int[] iArr4 = f13909h;
        int[] iArr5 = f13910i;
        int[] iArr6 = f13903b;
        int[] iArr7 = f13904c;
        int[] iArr8 = f13905d;
        int[] iArr9 = f13906e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f13911j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{d(colorStateList, iArr2), d(colorStateList, iArr3), d(colorStateList, iArr4), d(colorStateList, iArr5), 0, d(colorStateList, iArr6), d(colorStateList, iArr7), d(colorStateList, iArr8), d(colorStateList, iArr9), 0});
    }

    @NonNull
    public static Drawable b(@NonNull Context context, int i8) {
        return RippleUtilsLollipop.b(context, i8);
    }

    @TargetApi(21)
    private static int c(int i8) {
        return ColorUtils.j(i8, Math.min(Color.alpha(i8) * 2, 255));
    }

    private static int d(ColorStateList colorStateList, int[] iArr) {
        int i8;
        if (colorStateList != null) {
            i8 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i8 = 0;
        }
        if (f13902a) {
            return c(i8);
        }
        return i8;
    }

    @NonNull
    public static ColorStateList e(ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 22 && i8 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f13912k, 0)) != 0) {
                Log.w(f13913l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean f(@NonNull int[] iArr) {
        boolean z7 = false;
        boolean z8 = false;
        for (int i8 : iArr) {
            if (i8 == 16842910) {
                z7 = true;
            } else if (i8 == 16842908 || i8 == 16842919 || i8 == 16843623) {
                z8 = true;
            }
        }
        if (!z7 || !z8) {
            return false;
        }
        return true;
    }
}
