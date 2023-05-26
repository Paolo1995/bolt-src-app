package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class RelativeCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final float f14025a;

    public RelativeCornerSize(float f8) {
        this.f14025a = f8;
    }

    private static float b(@NonNull RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // com.google.android.material.shape.CornerSize
    public float a(@NonNull RectF rectF) {
        return this.f14025a * b(rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof RelativeCornerSize) && this.f14025a == ((RelativeCornerSize) obj).f14025a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f14025a)});
    }
}
