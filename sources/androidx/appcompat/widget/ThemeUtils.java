package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public class ThemeUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2188a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f2189b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f2190c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f2191d = {16843518};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f2192e = {16842919};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f2193f = {16842912};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f2194g = {16842913};

    /* renamed from: h  reason: collision with root package name */
    static final int[] f2195h = {-16842919, -16842908};

    /* renamed from: i  reason: collision with root package name */
    static final int[] f2196i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f2197j = new int[1];

    private ThemeUtils() {
    }

    public static void a(@NonNull View view, @NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.f1077y0);
        try {
            if (!obtainStyledAttributes.hasValue(R$styleable.D0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(@NonNull Context context, int i8) {
        ColorStateList e8 = e(context, i8);
        if (e8 != null && e8.isStateful()) {
            return e8.getColorForState(f2189b, e8.getDefaultColor());
        }
        TypedValue f8 = f();
        context.getTheme().resolveAttribute(16842803, f8, true);
        return d(context, i8, f8.getFloat());
    }

    public static int c(@NonNull Context context, int i8) {
        int[] iArr = f2197j;
        iArr[0] = i8;
        TintTypedArray u7 = TintTypedArray.u(context, null, iArr);
        try {
            return u7.b(0, 0);
        } finally {
            u7.w();
        }
    }

    static int d(@NonNull Context context, int i8, float f8) {
        int c8 = c(context, i8);
        return ColorUtils.j(c8, Math.round(Color.alpha(c8) * f8));
    }

    public static ColorStateList e(@NonNull Context context, int i8) {
        int[] iArr = f2197j;
        iArr[0] = i8;
        TintTypedArray u7 = TintTypedArray.u(context, null, iArr);
        try {
            return u7.c(0);
        } finally {
            u7.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f2188a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}
