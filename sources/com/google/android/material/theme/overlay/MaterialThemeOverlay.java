package com.google.android.material.theme.overlay;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.R$attr;

/* loaded from: classes.dex */
public class MaterialThemeOverlay {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14480a = {16842752, R$attr.f12484m0};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14481b = {R$attr.materialThemeOverlay};

    private MaterialThemeOverlay() {
    }

    private static int a(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f14480a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            return resourceId2;
        }
        return resourceId;
    }

    private static int b(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f14481b, i8, i9);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @NonNull
    public static Context c(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        boolean z7;
        int b8 = b(context, attributeSet, i8, i9);
        if ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).c() == b8) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (b8 != 0 && !z7) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, b8);
            int a8 = a(context, attributeSet);
            if (a8 != 0) {
                contextThemeWrapper.getTheme().applyStyle(a8, true);
            }
            return contextThemeWrapper;
        }
        return context;
    }
}
