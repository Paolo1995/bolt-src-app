package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class MaterialAttributes {
    public static TypedValue a(@NonNull Context context, int i8) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i8, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(@NonNull Context context, int i8, boolean z7) {
        TypedValue a8 = a(context, i8);
        if (a8 != null && a8.type == 18) {
            if (a8.data != 0) {
                return true;
            }
            return false;
        }
        return z7;
    }

    public static int c(@NonNull Context context, int i8, int i9) {
        TypedValue a8 = a(context, i8);
        if (a8 != null && a8.type == 16) {
            return a8.data;
        }
        return i9;
    }

    public static int d(@NonNull Context context, int i8, @NonNull String str) {
        return e(context, i8, str).data;
    }

    @NonNull
    public static TypedValue e(@NonNull Context context, int i8, @NonNull String str) {
        TypedValue a8 = a(context, i8);
        if (a8 != null) {
            return a8;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i8)));
    }

    @NonNull
    public static TypedValue f(@NonNull View view, int i8) {
        return e(view.getContext(), i8, view.getClass().getCanonicalName());
    }
}
