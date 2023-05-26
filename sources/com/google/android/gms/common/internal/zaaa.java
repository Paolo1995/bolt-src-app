package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R;
import com.google.android.gms.common.util.DeviceProperties;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, 16842824);
    }

    private static final int zab(int i8, int i9, int i10, int i11) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    return i11;
                }
                throw new IllegalStateException("Unknown color scheme: " + i8);
            }
            return i10;
        }
        return i9;
    }

    public final void zaa(Resources resources, int i8, int i9) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i10 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i10);
        setMinWidth(i10);
        int i11 = R.drawable.common_google_signin_btn_icon_dark;
        int i12 = R.drawable.common_google_signin_btn_icon_light;
        int zab = zab(i9, i11, i12, i12);
        int i13 = R.drawable.common_google_signin_btn_text_dark;
        int i14 = R.drawable.common_google_signin_btn_text_light;
        int zab2 = zab(i9, i13, i14, i14);
        if (i8 != 0 && i8 != 1) {
            if (i8 != 2) {
                throw new IllegalStateException("Unknown button size: " + i8);
            }
        } else {
            zab = zab2;
        }
        Drawable r7 = DrawableCompat.r(resources.getDrawable(zab));
        DrawableCompat.o(r7, resources.getColorStateList(R.color.common_google_signin_btn_tint));
        DrawableCompat.p(r7, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(r7);
        int i15 = R.color.common_google_signin_btn_text_dark;
        int i16 = R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zab(i9, i15, i16, i16))));
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    setText((CharSequence) null);
                } else {
                    throw new IllegalStateException("Unknown button size: " + i8);
                }
            } else {
                setText(resources.getString(R.string.common_signin_button_text_long));
            }
        } else {
            setText(resources.getString(R.string.common_signin_button_text));
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
