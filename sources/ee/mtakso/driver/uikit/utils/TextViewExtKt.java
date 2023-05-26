package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewExt.kt */
/* loaded from: classes5.dex */
public final class TextViewExtKt {
    public static final void a(TextView textView, Color color) {
        ColorStateList colorStateList;
        Intrinsics.f(textView, "<this>");
        if (color != null) {
            Context context = textView.getContext();
            Intrinsics.e(context, "context");
            colorStateList = ColorStateList.valueOf(ColorKt.a(color, context));
        } else {
            colorStateList = null;
        }
        TextViewCompat.h(textView, colorStateList);
    }

    public static final void b(TextView textView, Drawable resource, Integer num, Integer num2) {
        int intrinsicWidth;
        int intrinsicHeight;
        Intrinsics.f(textView, "<this>");
        Intrinsics.f(resource, "resource");
        if (num != null) {
            intrinsicWidth = num.intValue();
        } else {
            intrinsicWidth = resource.getIntrinsicWidth();
        }
        if (num2 != null) {
            intrinsicHeight = num2.intValue();
        } else {
            intrinsicHeight = resource.getIntrinsicHeight();
        }
        Drawable mutate = resource.mutate();
        mutate.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        Intrinsics.e(mutate, "resource.mutate().apply …dth, desiredHeight)\n    }");
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        if (LocaleExtKt.b(locale)) {
            textView.setCompoundDrawables(null, null, mutate, null);
        } else {
            textView.setCompoundDrawables(mutate, null, null, null);
        }
    }

    public static /* synthetic */ void c(TextView textView, Drawable drawable, Integer num, Integer num2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            num = null;
        }
        if ((i8 & 4) != 0) {
            num2 = null;
        }
        b(textView, drawable, num, num2);
    }

    public static final void d(TextView textView, int i8) {
        Intrinsics.f(textView, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        if (LocaleExtKt.b(locale)) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i8, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(i8, 0, 0, 0);
        }
    }

    public static final void e(TextView textView, Color color) {
        Intrinsics.f(textView, "<this>");
        if (color != null) {
            Context context = textView.getContext();
            Intrinsics.e(context, "context");
            textView.setLinkTextColor(ColorKt.a(color, context));
        }
    }

    public static final void f(TextView textView, Drawable resource, Integer num, Integer num2) {
        int intrinsicWidth;
        int intrinsicHeight;
        Intrinsics.f(textView, "<this>");
        Intrinsics.f(resource, "resource");
        if (num != null) {
            intrinsicWidth = num.intValue();
        } else {
            intrinsicWidth = resource.getIntrinsicWidth();
        }
        if (num2 != null) {
            intrinsicHeight = num2.intValue();
        } else {
            intrinsicHeight = resource.getIntrinsicHeight();
        }
        Drawable mutate = resource.mutate();
        mutate.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        Intrinsics.e(mutate, "resource.mutate().apply …dth, desiredHeight)\n    }");
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        if (LocaleExtKt.b(locale)) {
            textView.setCompoundDrawables(mutate, null, null, null);
        } else {
            textView.setCompoundDrawables(null, null, mutate, null);
        }
    }

    public static final void g(TextView textView, int i8) {
        Intrinsics.f(textView, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        if (LocaleExtKt.b(locale)) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i8, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i8, 0);
        }
    }

    public static final void h(TextView textView, Text text) {
        CharSequence charSequence;
        Intrinsics.f(textView, "<this>");
        if (text != null) {
            Context context = textView.getContext();
            Intrinsics.e(context, "context");
            charSequence = TextKt.a(text, context);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
    }

    public static final void i(TextView textView, Color color) {
        Intrinsics.f(textView, "<this>");
        if (color != null) {
            Context context = textView.getContext();
            Intrinsics.e(context, "context");
            textView.setTextColor(ColorKt.a(color, context));
        }
    }
}
