package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class AdjustedCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final CornerSize f13976a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13977b;

    public AdjustedCornerSize(float f8, @NonNull CornerSize cornerSize) {
        while (cornerSize instanceof AdjustedCornerSize) {
            cornerSize = ((AdjustedCornerSize) cornerSize).f13976a;
            f8 += ((AdjustedCornerSize) cornerSize).f13977b;
        }
        this.f13976a = cornerSize;
        this.f13977b = f8;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.f13976a.a(rectF) + this.f13977b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustedCornerSize)) {
            return false;
        }
        AdjustedCornerSize adjustedCornerSize = (AdjustedCornerSize) obj;
        if (this.f13976a.equals(adjustedCornerSize.f13976a) && this.f13977b == adjustedCornerSize.f13977b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13976a, Float.valueOf(this.f13977b)});
    }
}
