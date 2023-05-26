package com.yalantis.ucrop.util;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* loaded from: classes3.dex */
public class SelectedStateListDrawable extends StateListDrawable {
    private int mSelectionColor;

    public SelectedStateListDrawable(Drawable drawable, int i8) {
        this.mSelectionColor = i8;
        addState(new int[]{16842913}, drawable);
        addState(new int[0], drawable);
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z7 = false;
        for (int i8 : iArr) {
            if (i8 == 16842913) {
                z7 = true;
            }
        }
        if (z7) {
            super.setColorFilter(this.mSelectionColor, PorterDuff.Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
