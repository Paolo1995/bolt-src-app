package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes.dex */
public class MaterialColors {
    private MaterialColors() {
    }

    public static int a(int i8, int i9) {
        return ColorUtils.j(i8, (Color.alpha(i8) * i9) / 255);
    }

    public static int b(@NonNull Context context, int i8, int i9) {
        TypedValue a8 = MaterialAttributes.a(context, i8);
        if (a8 != null) {
            return l(context, a8);
        }
        return i9;
    }

    public static int c(Context context, int i8, String str) {
        return l(context, MaterialAttributes.e(context, i8, str));
    }

    public static int d(@NonNull View view, int i8) {
        return l(view.getContext(), MaterialAttributes.f(view, i8));
    }

    public static int e(@NonNull View view, int i8, int i9) {
        return b(view.getContext(), i8, i9);
    }

    @NonNull
    public static ColorStateList f(@NonNull Context context, int i8, @NonNull ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        TypedValue a8 = MaterialAttributes.a(context, i8);
        if (a8 != null) {
            colorStateList2 = m(context, a8);
        } else {
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        return colorStateList;
    }

    public static ColorStateList g(@NonNull Context context, int i8) {
        TypedValue a8 = MaterialAttributes.a(context, i8);
        if (a8 == null) {
            return null;
        }
        int i9 = a8.resourceId;
        if (i9 != 0) {
            return ContextCompat.getColorStateList(context, i9);
        }
        int i10 = a8.data;
        if (i10 == 0) {
            return null;
        }
        return ColorStateList.valueOf(i10);
    }

    public static boolean h(int i8) {
        if (i8 != 0 && ColorUtils.c(i8) > 0.5d) {
            return true;
        }
        return false;
    }

    public static int i(int i8, int i9) {
        return ColorUtils.f(i9, i8);
    }

    public static int j(int i8, int i9, float f8) {
        return i(i8, ColorUtils.j(i9, Math.round(Color.alpha(i9) * f8)));
    }

    public static int k(@NonNull View view, int i8, int i9, float f8) {
        return j(d(view, i8), d(view, i9), f8);
    }

    private static int l(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i8 = typedValue.resourceId;
        if (i8 != 0) {
            return ContextCompat.getColor(context, i8);
        }
        return typedValue.data;
    }

    private static ColorStateList m(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i8 = typedValue.resourceId;
        if (i8 != 0) {
            return ContextCompat.getColorStateList(context, i8);
        }
        return ColorStateList.valueOf(typedValue.data);
    }
}
