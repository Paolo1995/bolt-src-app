package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;

/* loaded from: classes.dex */
public class TypefaceUtils {
    private TypefaceUtils() {
    }

    public static Typeface a(@NonNull Context context, @NonNull Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(@NonNull Configuration configuration, @NonNull Typeface typeface) {
        int i8;
        int weight;
        Typeface create;
        if (Build.VERSION.SDK_INT >= 31 && (i8 = configuration.fontWeightAdjustment) != Integer.MAX_VALUE && i8 != 0 && typeface != null) {
            weight = typeface.getWeight();
            create = Typeface.create(typeface, MathUtils.b(weight + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
            return create;
        }
        return null;
    }
}
