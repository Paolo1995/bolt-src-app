package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes.dex */
public class MotionUtils {
    private MotionUtils() {
    }

    private static float a(String[] strArr, int i8) {
        float parseFloat = Float.parseFloat(strArr[i8]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static TimeInterpolator c(String str) {
        if (e(str, "cubic-bezier")) {
            String[] split = b(str, "cubic-bezier").split(",");
            if (split.length == 4) {
                return PathInterpolatorCompat.a(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
        } else if (e(str, "path")) {
            return PathInterpolatorCompat.b(PathParser.e(b(str, "path")));
        } else {
            throw new IllegalArgumentException("Invalid motion easing type: " + str);
        }
    }

    private static boolean d(String str) {
        if (!e(str, "cubic-bezier") && !e(str, "path")) {
            return false;
        }
        return true;
    }

    private static boolean e(String str, String str2) {
        if (str.startsWith(str2 + "(") && str.endsWith(")")) {
            return true;
        }
        return false;
    }

    public static int f(@NonNull Context context, int i8, int i9) {
        return MaterialAttributes.c(context, i8, i9);
    }

    @NonNull
    public static TimeInterpolator g(@NonNull Context context, int i8, @NonNull TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i8, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (d(valueOf)) {
                return c(valueOf);
            }
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }
}
