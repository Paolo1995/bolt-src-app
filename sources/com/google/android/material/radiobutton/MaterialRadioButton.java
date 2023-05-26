package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: l  reason: collision with root package name */
    private static final int f13868l = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: m  reason: collision with root package name */
    private static final int[][] f13869m = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f13870j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13871k;

    public MaterialRadioButton(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.W);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f13870j == null) {
            int d8 = MaterialColors.d(this, R$attr.f12481k);
            int d9 = MaterialColors.d(this, R$attr.colorOnSurface);
            int d10 = MaterialColors.d(this, R$attr.colorSurface);
            int[][] iArr = f13869m;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = MaterialColors.j(d10, d8, 1.0f);
            iArr2[1] = MaterialColors.j(d10, d9, 0.54f);
            iArr2[2] = MaterialColors.j(d10, d9, 0.38f);
            iArr2[3] = MaterialColors.j(d10, d9, 0.38f);
            this.f13870j = new ColorStateList(iArr, iArr2);
        }
        return this.f13870j;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13871k && CompoundButtonCompat.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.f13871k = z7;
        if (z7) {
            CompoundButtonCompat.d(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.d(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialRadioButton(@androidx.annotation.NonNull android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.radiobutton.MaterialRadioButton.f13868l
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.R4
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.i(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.S4
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L28
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.a(r8, r9, r10)
            androidx.core.widget.CompoundButtonCompat.d(r7, r8)
        L28:
            int r8 = com.google.android.material.R$styleable.T4
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f13871k = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.radiobutton.MaterialRadioButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
