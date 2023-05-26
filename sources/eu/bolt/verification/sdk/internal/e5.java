package eu.bolt.verification.sdk.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes5.dex */
public final class e5 extends GradientDrawable {
    public e5(int i8) {
        setShape(0);
        setColor(ColorStateList.valueOf(i8));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i8, int i9, int i10, int i11) {
        super.setBounds(i8, i9, i10, i11);
        setCornerRadius((i11 - i9) / 2.0f);
    }
}
