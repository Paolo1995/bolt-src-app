package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    private void e(@NonNull Resources.Theme theme, int i8) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i8, R$styleable.Y4);
        int i9 = i(getContext(), obtainStyledAttributes, R$styleable.f12501a5, R$styleable.f12510b5);
        obtainStyledAttributes.recycle();
        if (i9 >= 0) {
            setLineHeight(i9);
        }
    }

    private static boolean f(Context context) {
        return MaterialAttributes.b(context, R$attr.textAppearanceLineHeightEnabled, true);
    }

    private static int g(@NonNull Resources.Theme theme, AttributeSet attributeSet, int i8, int i9) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.f12519c5, i8, i9);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f12528d5, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private void h(AttributeSet attributeSet, int i8, int i9) {
        int g8;
        Context context = getContext();
        if (f(context)) {
            Resources.Theme theme = context.getTheme();
            if (!j(context, theme, attributeSet, i8, i9) && (g8 = g(theme, attributeSet, i8, i9)) != -1) {
                e(theme, g8);
            }
        }
    }

    private static int i(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull int... iArr) {
        int i8 = -1;
        for (int i9 = 0; i9 < iArr.length && i8 < 0; i9++) {
            i8 = MaterialResources.d(context, typedArray, iArr[i9], -1);
        }
        return i8;
    }

    private static boolean j(@NonNull Context context, @NonNull Resources.Theme theme, AttributeSet attributeSet, int i8, int i9) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.f12519c5, i8, i9);
        int i10 = i(context, obtainStyledAttributes, R$styleable.f12537e5, R$styleable.f12546f5);
        obtainStyledAttributes.recycle();
        if (i10 == -1) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i8) {
        super.setTextAppearance(context, i8);
        if (f(context)) {
            e(context.getTheme(), i8);
        }
    }

    public MaterialTextView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(MaterialThemeOverlay.c(context, attributeSet, i8, 0), attributeSet, i8);
        h(attributeSet, i8, 0);
    }
}
