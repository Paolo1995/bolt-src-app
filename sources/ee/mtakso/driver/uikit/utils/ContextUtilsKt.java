package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextUtils.kt */
/* loaded from: classes5.dex */
public final class ContextUtilsKt {
    public static final boolean a(Context context, int i8) {
        Intrinsics.f(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i8, typedValue, true);
        if (typedValue.type == 18 && typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public static final int b(Context context, int i8) {
        Intrinsics.f(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i8, typedValue, true);
        return typedValue.data;
    }

    public static final ColorStateList c(Context context, int i8) {
        Intrinsics.f(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i8});
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttributes(intArrayOf(attr))");
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        obtainStyledAttributes.recycle();
        return colorStateList;
    }

    public static final int d(Context context, int i8) {
        Intrinsics.f(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i8, typedValue, true);
        return typedValue.resourceId;
    }
}
