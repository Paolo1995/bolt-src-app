package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class AbsoluteCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final float f13975a;

    public AbsoluteCornerSize(float f8) {
        this.f13975a = f8;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float a(@NonNull RectF rectF) {
        return this.f13975a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AbsoluteCornerSize) && this.f13975a == ((AbsoluteCornerSize) obj).f13975a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13975a)});
    }
}
