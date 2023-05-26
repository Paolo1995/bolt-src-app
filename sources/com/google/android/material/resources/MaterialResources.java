package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$styleable;
import x.a;

/* loaded from: classes.dex */
public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList a(@NonNull Context context, @NonNull TypedArray typedArray, int i8) {
        int resourceId;
        ColorStateList a8;
        if (typedArray.hasValue(i8) && (resourceId = typedArray.getResourceId(i8, 0)) != 0 && (a8 = AppCompatResources.a(context, resourceId)) != null) {
            return a8;
        }
        return typedArray.getColorStateList(i8);
    }

    public static ColorStateList b(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, int i8) {
        int n8;
        ColorStateList a8;
        if (tintTypedArray.s(i8) && (n8 = tintTypedArray.n(i8, 0)) != 0 && (a8 = AppCompatResources.a(context, n8)) != null) {
            return a8;
        }
        return tintTypedArray.c(i8);
    }

    private static int c(TypedValue typedValue) {
        if (Build.VERSION.SDK_INT >= 22) {
            return a.a(typedValue);
        }
        return (typedValue.data >> 0) & 15;
    }

    public static int d(@NonNull Context context, @NonNull TypedArray typedArray, int i8, int i9) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i8, typedValue) && typedValue.type == 2) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i9);
            obtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i8, i9);
    }

    public static Drawable e(@NonNull Context context, @NonNull TypedArray typedArray, int i8) {
        int resourceId;
        Drawable b8;
        if (typedArray.hasValue(i8) && (resourceId = typedArray.getResourceId(i8, 0)) != 0 && (b8 = AppCompatResources.b(context, resourceId)) != null) {
            return b8;
        }
        return typedArray.getDrawable(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(@NonNull TypedArray typedArray, int i8, int i9) {
        if (typedArray.hasValue(i8)) {
            return i8;
        }
        return i9;
    }

    public static TextAppearance g(@NonNull Context context, @NonNull TypedArray typedArray, int i8) {
        int resourceId;
        if (typedArray.hasValue(i8) && (resourceId = typedArray.getResourceId(i8, 0)) != 0) {
            return new TextAppearance(context, resourceId);
        }
        return null;
    }

    public static int h(@NonNull Context context, int i8, int i9) {
        if (i8 == 0) {
            return i9;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i8, R$styleable.f12620n7);
        TypedValue typedValue = new TypedValue();
        boolean value = obtainStyledAttributes.getValue(R$styleable.f12629o7, typedValue);
        obtainStyledAttributes.recycle();
        if (!value) {
            return i9;
        }
        if (c(typedValue) == 2) {
            return Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density);
        }
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    public static boolean i(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= 1.3f) {
            return true;
        }
        return false;
    }

    public static boolean j(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= 2.0f) {
            return true;
        }
        return false;
    }
}
