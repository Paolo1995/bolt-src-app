package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes.dex */
public class LPaint extends Paint {
    public LPaint() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i8) {
        if (Build.VERSION.SDK_INT < 30) {
            setColor((MiscUtils.c(i8, 0, 255) << 24) | (getColor() & 16777215));
            return;
        }
        super.setAlpha(MiscUtils.c(i8, 0, 255));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public LPaint(int i8) {
        super(i8);
    }

    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public LPaint(int i8, PorterDuff.Mode mode) {
        super(i8);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
