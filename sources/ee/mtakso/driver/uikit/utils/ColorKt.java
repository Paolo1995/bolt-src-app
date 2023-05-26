package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.uikit.R$attr;
import ee.mtakso.driver.uikit.utils.Color;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Color.kt */
/* loaded from: classes5.dex */
public final class ColorKt {
    public static final int a(Color color, Context context) {
        Intrinsics.f(color, "<this>");
        Intrinsics.f(context, "context");
        if (color instanceof Color.Res) {
            return ContextCompat.getColor(context, ((Color.Res) color).a());
        }
        if (color instanceof Color.Attr) {
            return ContextUtilsKt.b(context, ((Color.Attr) color).a());
        }
        if (color instanceof Color.Static) {
            return ((Color.Static) color).a();
        }
        if (color instanceof Color.DarkLight) {
            return a(c((Color.DarkLight) color, context), context);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ColorStateList b(Color color, Context context) {
        Intrinsics.f(color, "<this>");
        Intrinsics.f(context, "context");
        if (color instanceof Color.Res) {
            return ContextCompat.getColorStateList(context, ((Color.Res) color).a());
        }
        if (color instanceof Color.Attr) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{((Color.Attr) color).a()});
            Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttributes(intArrayOf(id))");
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            obtainStyledAttributes.recycle();
            return colorStateList;
        } else if (color instanceof Color.Static) {
            return ColorStateList.valueOf(((Color.Static) color).a());
        } else {
            if (color instanceof Color.DarkLight) {
                return b(c((Color.DarkLight) color, context), context);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final Color c(Color.DarkLight darkLight, Context context) {
        Intrinsics.f(darkLight, "<this>");
        Intrinsics.f(context, "context");
        if (ContextUtilsKt.a(context, R$attr.A)) {
            return darkLight.b();
        }
        return darkLight.a();
    }
}
