package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes.dex */
public final class ThemeEnforcement {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f13679a = {R$attr.f12486p};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f13680b = {R$attr.colorPrimaryVariant};

    private ThemeEnforcement() {
    }

    public static void a(@NonNull Context context) {
        e(context, f13679a, "Theme.AppCompat");
    }

    private static void b(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.W8, i8, i9);
        boolean z7 = obtainStyledAttributes.getBoolean(R$styleable.Y8, false);
        obtainStyledAttributes.recycle();
        if (z7) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R$attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(@NonNull Context context) {
        e(context, f13680b, "Theme.MaterialComponents");
    }

    private static void d(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i8, int i9, int... iArr2) {
        boolean z7;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.W8, i8, i9);
        boolean z8 = false;
        if (!obtainStyledAttributes.getBoolean(R$styleable.Z8, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            z7 = f(context, attributeSet, iArr, i8, i9, iArr2);
        } else {
            if (obtainStyledAttributes.getResourceId(R$styleable.X8, -1) != -1) {
                z8 = true;
            }
            z7 = z8;
        }
        obtainStyledAttributes.recycle();
        if (z7) {
            return;
        }
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }

    private static void e(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (h(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i8, int i9, @NonNull int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i8, i9);
        for (int i10 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i10, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean g(@NonNull Context context) {
        return MaterialAttributes.b(context, R$attr.isMaterial3Theme, false);
    }

    private static boolean h(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i8 = 0; i8 < iArr.length; i8++) {
            if (!obtainStyledAttributes.hasValue(i8)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    @NonNull
    public static TypedArray i(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i8, int i9, int... iArr2) {
        b(context, attributeSet, i8, i9);
        d(context, attributeSet, iArr, i8, i9, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i8, i9);
    }

    public static TintTypedArray j(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i8, int i9, int... iArr2) {
        b(context, attributeSet, i8, i9);
        d(context, attributeSet, iArr, i8, i9, iArr2);
        return TintTypedArray.v(context, attributeSet, iArr, i8, i9);
    }
}
