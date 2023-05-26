package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewExt.kt */
/* loaded from: classes5.dex */
public final class ViewExtKt {
    public static final void a(View view, Color color) {
        Intrinsics.f(view, "<this>");
        if (color != null) {
            Context context = view.getContext();
            Intrinsics.e(context, "context");
            view.setBackgroundColor(ColorKt.a(color, context));
        }
    }

    public static final void b(View view, Color color) {
        ColorStateList colorStateList;
        Intrinsics.f(view, "<this>");
        if (color != null) {
            Context context = view.getContext();
            Intrinsics.e(context, "context");
            colorStateList = ColorKt.b(color, context);
        } else {
            colorStateList = null;
        }
        ViewCompat.x0(view, colorStateList);
    }

    public static final void c(View view, boolean z7, int i8) {
        Intrinsics.f(view, "<this>");
        if (z7) {
            view.setVisibility(0);
        } else {
            view.setVisibility(i8);
        }
    }

    public static /* synthetic */ void d(View view, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            z7 = true;
        }
        if ((i9 & 2) != 0) {
            i8 = 8;
        }
        c(view, z7, i8);
    }

    public static final void e(View view, Integer num, Integer num2, Integer num3, Integer num4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i8;
        int i9;
        int i10;
        int i11;
        Intrinsics.f(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            if (num != null) {
                i8 = num.intValue();
            } else {
                i8 = marginLayoutParams.leftMargin;
            }
            if (num2 != null) {
                i9 = num2.intValue();
            } else {
                i9 = marginLayoutParams.topMargin;
            }
            if (num3 != null) {
                i10 = num3.intValue();
            } else {
                i10 = marginLayoutParams.rightMargin;
            }
            if (num4 != null) {
                i11 = num4.intValue();
            } else {
                i11 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i8, i9, i10, i11);
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        throw new IllegalArgumentException("View should have MarginLayoutParams to apply margins");
    }

    public static /* synthetic */ void f(View view, Integer num, Integer num2, Integer num3, Integer num4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            num = null;
        }
        if ((i8 & 2) != 0) {
            num2 = null;
        }
        if ((i8 & 4) != 0) {
            num3 = null;
        }
        if ((i8 & 8) != 0) {
            num4 = null;
        }
        e(view, num, num2, num3, num4);
    }

    public static final void g(View view, Integer num, Integer num2, Integer num3, Integer num4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i8;
        int i9;
        int marginStart;
        int marginEnd;
        Intrinsics.f(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            int i10 = marginLayoutParams.leftMargin;
            if (num2 != null) {
                i8 = num2.intValue();
            } else {
                i8 = marginLayoutParams.topMargin;
            }
            int i11 = marginLayoutParams.rightMargin;
            if (num4 != null) {
                i9 = num4.intValue();
            } else {
                i9 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i10, i8, i11, i9);
            if (num3 != null) {
                marginStart = num3.intValue();
            } else {
                marginStart = marginLayoutParams.getMarginStart();
            }
            marginLayoutParams.setMarginStart(marginStart);
            if (num != null) {
                marginEnd = num.intValue();
            } else {
                marginEnd = marginLayoutParams.getMarginEnd();
            }
            marginLayoutParams.setMarginEnd(marginEnd);
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        throw new IllegalArgumentException("View should have MarginLayoutParams to apply margins");
    }

    public static /* synthetic */ void h(View view, Integer num, Integer num2, Integer num3, Integer num4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            num = null;
        }
        if ((i8 & 2) != 0) {
            num2 = null;
        }
        if ((i8 & 4) != 0) {
            num3 = null;
        }
        if ((i8 & 8) != 0) {
            num4 = null;
        }
        g(view, num, num2, num3, num4);
    }
}
