package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class CornerTreatment {
    @Deprecated
    public void a(float f8, float f9, @NonNull ShapePath shapePath) {
    }

    public void b(@NonNull ShapePath shapePath, float f8, float f9, float f10) {
        a(f8, f9, shapePath);
    }

    public void c(@NonNull ShapePath shapePath, float f8, float f9, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        b(shapePath, f8, f9, cornerSize.a(rectF));
    }
}
